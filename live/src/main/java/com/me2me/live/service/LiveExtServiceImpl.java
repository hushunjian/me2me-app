package com.me2me.live.service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.me2me.common.Constant;
import com.me2me.common.utils.DateUtil;
import com.me2me.common.utils.ImageUtil;
import com.me2me.common.web.Response;
import com.me2me.common.web.ResponseStatus;
import com.me2me.content.dto.NewKingdom;
import com.me2me.content.service.ContentService;
import com.me2me.core.QRCodeUtil;
import com.me2me.live.dao.LiveExtDao;
import com.me2me.live.dao.LiveMybatisDao;
import com.me2me.live.dto.CategoryKingdomsDto;
import com.me2me.live.dto.GetKingdomImageDTO;
import com.me2me.live.dto.ImageInfoDTO;
import com.me2me.live.dto.KingdomImageListDTO;
import com.me2me.live.dto.KingdomImageMonthDTO;
import com.me2me.live.dto.ShareImgInfoDTO;
import com.me2me.live.dto.TopicCategoryDto;
import com.me2me.live.dto.TopicCategoryDto.Category;
import com.me2me.live.mapper.TopicCategoryMapper;
import com.me2me.live.model.Topic;
import com.me2me.live.model.TopicCategory;
import com.me2me.live.model.TopicFragmentLikeHis;
import com.me2me.live.model.TopicImage;
import com.me2me.user.model.UserProfile;
import com.me2me.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * liveService 扩展服务。
 * @author zhangjiwei
 * @date Sep 19, 2017
 */
@Slf4j
@Service
public class LiveExtServiceImpl implements LiveExtService {
	@Autowired
	private LiveExtDao extDao;
	private static final int PAGE_SIZE= 20;
	@Autowired
	private ContentService contentService;
	@Autowired
	private UserService userService;
	@Autowired
	private TopicCategoryMapper categoryMapper;
	@Autowired
    private LiveMybatisDao liveMybatisDao;
	
	@Value("#{app.live_web}")
    private String live_web;
	
	@Value("#{app.emojiFileDirPath}")
	private String emojiFileDirPath;
	
	private Map<String, File> emojiFileMap = new HashMap<String, File>();
	
	@PostConstruct
    public void init(){
		//加载emoji图片相关信息
		File emojiFileDir = new File(emojiFileDirPath);
		if(emojiFileDir.exists()){
			File[] files = emojiFileDir.listFiles();
			if(null != files && files.length > 0){
				String fileName = null;
				for(File emojiFile : files){
					fileName = emojiFile.getName();
					emojiFileMap.put(fileName.split("\\.")[0], emojiFile);
				}
			}
		}
	}
	
	@Override
	public Response category() {
		List<TopicCategory> cats = extDao.getAllCategory();
		TopicCategoryDto dto = new TopicCategoryDto();
		for(TopicCategory tc:cats){
			Category ct = new Category();
			ct.setKcIcon(Constant.QINIU_DOMAIN+"/"+tc.getIcon());
			ct.setKcid(tc.getId());
			ct.setKcImage(Constant.QINIU_DOMAIN+"/"+tc.getCoverImg());
			ct.setKcName(tc.getName());
			dto.getCategories().add(ct);
		}
		return Response.success(dto);
	}

	@Override
	public Response kingdomByCategory(long uid, int kcid, int page) {
		CategoryKingdomsDto dto = new CategoryKingdomsDto();
		if(page==1){
			TopicCategory tc=  extDao.getCategoryById(kcid);
			Category ct= new Category();
			ct.setKcIcon(tc.getIcon());
			ct.setKcid(tc.getId());
			ct.setKcImage(tc.getCoverImg());
			ct.setKcName(tc.getName());
			dto.setCategory(ct);
			String v = userService.getAppConfigByKey("KINGDOM_OUT_MINUTE");
	        int limitMinute = 3;
	        if(!StringUtils.isEmpty(v)){
	        	limitMinute = Integer.valueOf(v).intValue();
	        }
	        Map<String,Object> data= extDao.getCategoryCoverKingdom(kcid,limitMinute);
	        if(data!=null){
		        NewKingdom coverKingdom= new NewKingdom();
		        coverKingdom.setUid((Long)data.get("uid"));
		        coverKingdom.setAvatar(Constant.QINIU_DOMAIN+"/"+data.get("avatar"));
		        coverKingdom.setCoverImage(Constant.QINIU_DOMAIN+"/"+data.get("live_image"));
		        coverKingdom.setNickName(data.get("nick_name").toString());
		        coverKingdom.setTitle(data.get("title").toString());
		        coverKingdom.setTopicId((Long)data.get("id"));
				dto.setCoverKingdom(coverKingdom);
	        }
		}
   
		List<Map<String,Object>> topicList =extDao.getCategoryKingdom(kcid,page,PAGE_SIZE);
		List<NewKingdom> kingdoms = contentService.buildFullNewKingdom(uid, topicList, 1);
		if(page==1 && dto.getCoverKingdom()==null && kingdoms.size()>0){
			dto.setCoverKingdom(kingdoms.get(0));
		}
		dto.setKingdoms(kingdoms);
		return Response.success(dto);
	}

	@Override
	public void addCategory(TopicCategory category) {
		categoryMapper.insertSelective(category);
	}

	@Override
	public void updateCategory(TopicCategory category) {
		categoryMapper.updateByPrimaryKeySelective(category);
	}

	@Override
	public TopicCategory getCategoryById(int id) {
		return categoryMapper.selectByPrimaryKey(id);
	}

	@Override
	public Response getKingdomImage(long uid,long topicId,long fid,String imageName,int type){
		if(imageName.startsWith("http")){//兼容前端不愿意转换传递整串图片路径
			imageName = imageName.substring(imageName.indexOf("/", 9)+1);
		}
		
		GetKingdomImageDTO result = new GetKingdomImageDTO();
		
		int pageSize = 10;
		
		int totalCount = liveMybatisDao.getTotalTopicImageByTopic(topicId, 1);//目前只要图片
		result.setTotalCount(totalCount);
		
		List<TopicImage> currList = liveMybatisDao.getTopicImageByTopicIdAndFidAndImageName(topicId, fid, null, 1);//目前只要图片
		if(null == currList){
			currList = new ArrayList<>();
		}
		//该fid前有多少个图片
		int beforeCount = liveMybatisDao.countTopicImageBefore(topicId, fid, 1);//目前只要图片
		
		TopicImage topicImage = null;
		GetKingdomImageDTO.ImageElement e = null;
		String image = null;
		if(type == 0){//向后拉取
			boolean flag = false;
			for(int i=0;i<currList.size();i++){
				beforeCount++;
				topicImage = currList.get(i);
				if(flag){//可以取数据了
					e = new GetKingdomImageDTO.ImageElement();
					e.setIndex(beforeCount);
					e.setFid(topicImage.getFid());
					image = topicImage.getImage();
					if(image.startsWith("http")){
						
						e.setImageName(image.substring(image.indexOf("/", 9)+1));
						e.setFragmentImage(image);
					}else{
						e.setImageName(image);
						e.setFragmentImage(Constant.QINIU_DOMAIN+"/"+image);
					}
					e.setExtra(topicImage.getExtra());
					e.setLikeCount(topicImage.getLikeCount());
					e.setImageId(topicImage.getId());
					result.getImageDatas().add(e);
					if(result.getImageDatas().size() >= pageSize){
						break;
					}
				}else{
					if(imageName.equals(topicImage.getImage())){
						flag = true;
					}
				}
			}
			
			if(result.getImageDatas().size() < pageSize){//还需要补充
				List<TopicImage> list = liveMybatisDao.searchTopicImage(topicId, fid, 1, 0, pageSize-result.getImageDatas().size());
				if(null != list && list.size() > 0){
					for(int i=0;i<list.size();i++){
						beforeCount++;
						topicImage = list.get(i);
						e = new GetKingdomImageDTO.ImageElement();
						e.setIndex(beforeCount);
						e.setFid(topicImage.getFid());
						image = topicImage.getImage();
						if(image.startsWith("http")){
							e.setImageName(image.substring(image.indexOf("/", 9)+1));
							e.setFragmentImage(image);
						}else{
							e.setImageName(image);
							e.setFragmentImage(Constant.QINIU_DOMAIN+"/"+image);
						}
						e.setExtra(topicImage.getExtra());
						e.setLikeCount(topicImage.getLikeCount());
						e.setImageId(topicImage.getId());
						result.getImageDatas().add(e);
					}
				}
			}
		}else if(type == 1){//向前拉取
			beforeCount = beforeCount + currList.size() + 1;
			boolean flag = false;
			for(int i=currList.size()-1;i>=0;i--){
				topicImage = currList.get(i);
				beforeCount--;
				if(flag){
					e = new GetKingdomImageDTO.ImageElement();
					e.setIndex(beforeCount);
					e.setFid(topicImage.getFid());
					image = topicImage.getImage();
					if(image.startsWith("http")){
						e.setImageName(image.substring(image.indexOf("/", 9)+1));
						e.setFragmentImage(image);
					}else{
						e.setImageName(image);
						e.setFragmentImage(Constant.QINIU_DOMAIN+"/"+image);
					}
					e.setExtra(topicImage.getExtra());
					e.setLikeCount(topicImage.getLikeCount());
					e.setImageId(topicImage.getId());
					result.getImageDatas().add(0, e);//往前插入
					if(result.getImageDatas().size() >= pageSize){
						break;
					}
				}else{
					if(imageName.equals(topicImage.getImage())){
						flag = true;
					}
				}
			}
			if(result.getImageDatas().size() < pageSize){//还需要补充
				List<TopicImage> list = liveMybatisDao.searchTopicImage(topicId, fid, 1, 1, pageSize-result.getImageDatas().size());
				for(int i=0;i<list.size();i++){
					beforeCount--;
					topicImage = list.get(i);
					e = new GetKingdomImageDTO.ImageElement();
					e.setIndex(beforeCount);
					e.setFid(topicImage.getFid());
					image = topicImage.getImage();
					if(image.startsWith("http")){
						e.setImageName(image.substring(image.indexOf("/", 9)+1));
						e.setFragmentImage(image);
					}else{
						e.setImageName(image);
						e.setFragmentImage(Constant.QINIU_DOMAIN+"/"+image);
					}
					e.setExtra(topicImage.getExtra());
					e.setLikeCount(topicImage.getLikeCount());
					e.setImageId(topicImage.getId());
					result.getImageDatas().add(0, e);
				}
			}
		}else if(type == 2){//前后都要
			int currStartCount = beforeCount+1;
			//前5
			int needBefore = 5;
			int needAfter = 5;
			for(int i=0;i<currList.size();i++){
				topicImage = currList.get(i);
				if(imageName.equals(topicImage.getImage())){
					needBefore = 5-result.getImageDatas().size();
					needAfter = 5-(currList.size()-i-1);
				}
				
				e = new GetKingdomImageDTO.ImageElement();
				e.setIndex(currStartCount);
				e.setFid(topicImage.getFid());
				image = topicImage.getImage();
				if(image.startsWith("http")){
					e.setImageName(image.substring(image.indexOf("/", 9)+1));
					e.setFragmentImage(image);
				}else{
					e.setImageName(image);
					e.setFragmentImage(Constant.QINIU_DOMAIN+"/"+image);
				}
				e.setExtra(topicImage.getExtra());
				e.setLikeCount(topicImage.getLikeCount());
				e.setImageId(topicImage.getId());
				result.getImageDatas().add(e);
				currStartCount++;
			}
			
			if(needBefore > 0){//向前需要额外的
				List<TopicImage> list = liveMybatisDao.searchTopicImage(topicId, fid, 1, 1, needBefore);
				for(int i=0;i<list.size();i++){
					topicImage = list.get(i);
					e = new GetKingdomImageDTO.ImageElement();
					e.setIndex(beforeCount);
					e.setFid(topicImage.getFid());
					image = topicImage.getImage();
					if(image.startsWith("http")){
						e.setImageName(image.substring(image.indexOf("/", 9)+1));
						e.setFragmentImage(image);
					}else{
						e.setImageName(image);
						e.setFragmentImage(Constant.QINIU_DOMAIN+"/"+image);
					}
					e.setExtra(topicImage.getExtra());
					e.setLikeCount(topicImage.getLikeCount());
					e.setImageId(topicImage.getId());
					result.getImageDatas().add(0, e);
					beforeCount--;
				}
			}
			if(needAfter > 0){//向后需要额外的
				List<TopicImage> list = liveMybatisDao.searchTopicImage(topicId, fid, 1, 0, needAfter);
				for(int i=0;i<list.size();i++){
					topicImage = list.get(i);
					e = new GetKingdomImageDTO.ImageElement();
					e.setIndex(currStartCount);
					e.setFid(topicImage.getFid());
					image = topicImage.getImage();
					if(image.startsWith("http")){
						e.setImageName(image.substring(image.indexOf("/", 9)+1));
						e.setFragmentImage(image);
					}else{
						e.setImageName(image);
						e.setFragmentImage(Constant.QINIU_DOMAIN+"/"+image);
					}
					e.setExtra(topicImage.getExtra());
					e.setLikeCount(topicImage.getLikeCount());
					e.setImageId(topicImage.getId());
					result.getImageDatas().add(e);
					currStartCount++;
				}
			}
		}else{
			return Response.failure(ResponseStatus.ILLEGAL_REQUEST.status, ResponseStatus.ILLEGAL_REQUEST.message);
		}
		
		if(result.getImageDatas().size() > 0){
			List<Long> imageIds = new ArrayList<Long>();
			for(GetKingdomImageDTO.ImageElement ie : result.getImageDatas()){
				imageIds.add(ie.getImageId());
			}
			Map<String, String> likeMap = new HashMap<String, String>();
			List<TopicFragmentLikeHis> list = liveMybatisDao.getTopicFragmentLikeHisListByUidAndImageIds(uid, imageIds);
			if(null != list && list.size() > 0){
				for(TopicFragmentLikeHis his : list){
					likeMap.put(his.getImageId().toString(), "1");
				}
			}
			for(GetKingdomImageDTO.ImageElement ie : result.getImageDatas()){
				if(null != likeMap.get(String.valueOf(ie.getImageId()))){
					ie.setIsLike(1);//当前用户点赞过
				}
			}
		}
		
		return Response.success(result);
	}
	
	@Override
	public Response kingdomImageMonth(long uid, long topicId, long fid){
		KingdomImageMonthDTO result = new KingdomImageMonthDTO();
		
		int monthCount = 0;
		String showMonth = null;
		List<Map<String, Object>> list = extDao.getKingdomImageMonth(topicId, 1);//目前只要图片
		if(null != list && list.size() > 0){
			monthCount = list.size();
			Map<String, Object> m = null;
			KingdomImageMonthDTO.MonthElement e = null;
			for(int i=0;i<list.size();i++){
				m = list.get(i);
				if(i == 0){
					showMonth = (String)m.get("mm");
				}else{
					long minFid = (Long)m.get("minfid");
					long maxFid = (Long)m.get("maxfid");
					if(fid>=minFid && fid<=maxFid){
						showMonth = (String)m.get("mm");
					}
				}
				
				e = new KingdomImageMonthDTO.MonthElement();
				e.setMonth((String)m.get("mm"));
				e.setImageCount(((Long)m.get("cc")).intValue());
				result.getMonthData().add(e);
			}
		}
		
		result.setMonthCount(monthCount);
		result.setShowMonth(showMonth);
		
		return Response.success(result);
	}
	
	@Override
	public Response kingdomImageList(long uid, long topicId, String month){
		KingdomImageListDTO result = new KingdomImageListDTO();
		
		List<Map<String, Object>> list = extDao.getKingdomImageList(topicId, month, 1);//目前只要图片
		if(null != list && list.size() > 0){
			KingdomImageListDTO.ImageElement e = null;
			String image = null;
			for(Map<String, Object> m : list){
				e = new KingdomImageListDTO.ImageElement();
				e.setFid((Long)m.get("fid"));
				image = (String)m.get("image");
				if(image.startsWith("http")){
					e.setImageName(image.substring(image.indexOf("/", 9)+1));
					e.setFragmentImage(image);
				}else{
					e.setImageName(image);
					e.setFragmentImage(Constant.QINIU_DOMAIN+"/"+image);
				}
				e.setExtra((String)m.get("extra"));
				result.getImageDatas().add(e);
			}
		}
		
		return Response.success(result);
	}
	
	@Override
	public Response shareImgInfo(long uid, long targetUid, long topicId, long fid){
		ShareImgInfoDTO result = new ShareImgInfoDTO();
		//获取昵称
		String nickName = "";
		UserProfile targetUser = userService.getUserProfileByUid(targetUid);
		if(null != targetUser){
			nickName = targetUser.getNickName();
		}
		if(nickName.length() > 8){
			String sub = null;
			int realLength = 0;
			for(int i=0;i<nickName.length();i++){
				sub = nickName.substring(i, i+1);
				if(isLetterOrDigit(sub)){
					realLength = realLength + 1;
				}else{
					realLength = realLength + 2;
				}
			}
			if(realLength>16){
				int rl = 0;
				StringBuilder str = new StringBuilder();
				for(int i=0;i<nickName.length();i++){
					sub = nickName.substring(i, i+1);
					if(isLetterOrDigit(sub)){
						rl = rl + 1;
					}else{
						rl = rl + 2;
					}
					if(rl > 14){
						break;
					}
					str.append(sub);
				}
				nickName = str.toString() + "...";
			}
		}
		
		//获取王国名
		Topic topic = liveMybatisDao.getTopicById(topicId);
		if(null == topic){
			return Response.success(result);
		}
		String title = topic.getTitle();

		//获取更新次数和更新时间
		int count = 0;
		Date updateTime = null;
		Map<String, Object> fragmentInfo = extDao.getTopicFragmentInfo(topicId, targetUid, fid);
		if(null != fragmentInfo && fragmentInfo.size() > 0){
			if(null != fragmentInfo.get("cc")){
				count = ((Long)fragmentInfo.get("cc")).intValue();
			}
			if(null != fragmentInfo.get("maxtime")){
				updateTime = (Date)fragmentInfo.get("maxtime");
			}
		}
		if(null == updateTime){
			updateTime = new Date();
		}
		String timeStr = DateUtil.date2string(updateTime, "dd MMM", Locale.ENGLISH);
		
		//开始画头部图
		BufferedImage image = new BufferedImage(1125, 498, BufferedImage.TYPE_INT_RGB);
		Graphics2D main = image.createGraphics();
		main.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//锯齿处理
		//设置整体背景
		main.setColor(Color.white);
		main.fillRect(0, 0, 375*3, 498);
		
		main.setColor(new Color(50,51,51));
		main.setFont(new Font("苹方 细体", Font.PLAIN, 40*3));
		if(title.length() > 7){
			String sub = null;
			int realLength = 0;
			for(int i=0;i<title.length();i++){
				sub = title.substring(i, i+1);
				if(isLetterOrDigit(sub)){
					realLength = realLength + 1;
				}else{
					realLength = realLength + 2;
				}
			}
			if(realLength>14){
				int rl = 0;
				StringBuilder str = new StringBuilder();
				for(int i=0;i<title.length();i++){
					sub = title.substring(i, i+1);
					if(isLetterOrDigit(sub)){
						rl = rl + 1;
					}else{
						rl = rl + 2;
					}
					if(rl > 12){
						break;
					}
					str.append(sub);
				}
				title = str.toString() + "...";
			}
		}
		
		int drawY = 270-main.getFontMetrics().getHeight()/3;
		int drawX = 50*3;
		String emojiKey = null;
		String s = null;
		for(int j=0;j<title.length();j++){
			int cp = title.codePointAt(j);
			if(cp >= 127462 && cp <= 127487 && j<title.length()-1){//有可能是国旗，双拼的
				int cp2 = title.codePointAt(j+1);
				emojiKey = Integer.toHexString(cp) + "-" + Integer.toHexString(cp2);
				if(emojiFileMap.containsKey(emojiKey)){
					this.drawImage(image, drawX, drawY, emojiFileMap.get(emojiKey));
					j++;
					drawX = drawX + 24*3;
					continue;
				}
			}else if((cp == 42 || cp == 35) && j<title.length()-2){//有可能是#号和*号，3拼的
				int cp2 = title.codePointAt(j+1);
				int cp3 = title.codePointAt(j+2);
				emojiKey = Integer.toHexString(cp) + "-" + Integer.toHexString(cp2) + "-" + Integer.toHexString(cp3);
				if(emojiFileMap.containsKey(emojiKey)){
					this.drawImage(image, drawX, drawY, emojiFileMap.get(emojiKey));
					j++;
					j++;
					drawX = drawX + 24*3;
					continue;
				}
			}
			emojiKey = Integer.toHexString(cp);
			if(emojiFileMap.containsKey(emojiKey)){
				this.drawImage(image, drawX, drawY, emojiFileMap.get(emojiKey));
				drawX = drawX + 24*3;
				continue;
			}
			
			//其他的都是文字了
			s = title.substring(j, j+1);
			main.drawString(s, drawX, 270+main.getFontMetrics().getHeight()/4);
			drawX = drawX + main.getFontMetrics().stringWidth(s);
		}
		
		main.setColor(new Color(185,185,185));
		main.setFont(new Font("PingFang SC Regular", Font.PLAIN, 14*3));
		main.drawString(nickName + " | 第"+count+"次更新", 150, 468+main.getFontMetrics().getHeight()/3);
		
		main.setColor(new Color(50,51,51));
		main.setFont(new Font("PingFang SC Regular", Font.PLAIN, 12*3));
		main.drawString(timeStr, (375-30)*3-main.getFontMetrics().stringWidth(timeStr), 472+main.getFontMetrics().getHeight()/3);
		
		main.setColor(new Color(50,51,51)); 
		main.setFont(new Font("PingFang SC Regular", Font.PLAIN, 6*3));
		String logoStr = "M E T O M E";
		int x = (375-30)*3-main.getFontMetrics().stringWidth(logoStr);
		int y = 429+main.getFontMetrics().getHeight()/3;
		main.drawString(logoStr, x, y);
		
		ShareImgInfoDTO.ImageInfoElement e = new ShareImgInfoDTO.ImageInfoElement();
		e.setType(0);//封面
		e.setImageUrl(ImageUtil.getImageBase64String(image));
		result.getImageInfos().add(e);
		
		//获取需要的信息
		int size = 3;
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		List<Map<String, Object>> fList = extDao.getTopicCardImageInfo(topicId, fid);
		if(null != fList && fList.size() > 0){
			for(Map<String, Object> f : fList){
				long fuid = (Long)f.get("uid");
				int ftype = (Integer)f.get("type");
				int fcontentType = (Integer)f.get("content_type");
				if(fuid == targetUid){
					if(((ftype == 0 || ftype == 52) && (fcontentType==0 || fcontentType==1))//主播发言或发图
							|| fcontentType == 12 //视频
							|| fcontentType == 23 //UGC
							|| fcontentType == 25 //图组
							){
						list.add(f);
						continue;
					}
				}
				break;
			}
		}
		
		if(null != list && list.size() > 0){
			int contentType = 0;
			String extra = null;
			JSONArray imagesArray = null;
			JSONObject extraJson = null;
			for(Map<String, Object> m : list){
				if(result.getImageInfos().size() >= size+1){//这里要+1，因为封面也算一张
					break;
				}
				contentType = (Integer)m.get("content_type");
				if(contentType == 0){//文字
					result.getImageInfos().add(this.drawText((String)m.get("fragment"), main));
				}else if(contentType == 1){//图片
					e = new ShareImgInfoDTO.ImageInfoElement();
					e.setType(2);
					e.setImageUrl(Constant.QINIU_DOMAIN+"/"+(String)m.get("fragment_image"));
					result.getImageInfos().add(e);
				}else if(contentType == 12){//视频
					e = new ShareImgInfoDTO.ImageInfoElement();
					e.setType(3);
					e.setImageUrl(Constant.QINIU_DOMAIN+"/"+(String)m.get("fragment_image"));
					result.getImageInfos().add(e);
				}else if(contentType == 23 || contentType == 25){//UGC or 图组 （因为结构是一样的，所以一起处理了）
					extra = (String)m.get("extra");
					if(!StringUtils.isEmpty(extra)){
						try{
							extraJson = JSONObject.parseObject(extra.replaceAll("\n", "").replaceAll("\\\\", "\\\\\\\\"));
						}catch(Exception ignore){
						}
						if(null != extraJson){
							imagesArray = extraJson.getJSONArray("images");
							
							//如果是UGC，则需要将content先已文字形式列出
							if(null != extraJson.get("content")){
								String content = extraJson.getString("content");
								if(!StringUtils.isEmpty(content)){
									result.getImageInfos().add(this.drawText(content, main));
									if(result.getImageInfos().size() >= size+1){
										break;
									}
								}
							}
						}
						
						if(null != imagesArray && imagesArray.size() > 0){
							for (int i = 0; i < imagesArray.size(); i++) {
								e = new ShareImgInfoDTO.ImageInfoElement();
								e.setType(2);
								e.setImageUrl(imagesArray.getString(i));
								result.getImageInfos().add(e);
								if(result.getImageInfos().size() >= size+1){
									break;
								}
							}
						}
					}
				}
			}
		}
		
		//最后再给一张王国的二维码
		String webUrl = live_web + topicId;
		byte[] qrBytes = QRCodeUtil.getTopicShareCardQrCode(webUrl, 135, 135);
		if(null != qrBytes){
			result.setQrCode(new sun.misc.BASE64Encoder().encodeBuffer(qrBytes).trim());
		}
		
		return Response.success(result);
	}
	


	private boolean isLetterOrDigit(String str) {
		String regex = "^[a-z0-9A-Z]+$";
		return str.matches(regex);
	}

	private ShareImgInfoDTO.ImageInfoElement drawText(String fragment, Graphics2D main){
		ShareImgInfoDTO.ImageInfoElement e = new ShareImgInfoDTO.ImageInfoElement();
		e.setType(1);
		
		main.setFont(new Font("苹方 细体", Font.PLAIN, 24*3));//算宽度参考用的，不作为画图实体
		List<String> list = new ArrayList<String>();
		StringBuilder str = new StringBuilder();
		String tmp = null;
		for(int i=0;i<fragment.length();i++){
			tmp = fragment.substring(i, i+1);
			if("\n".equals(tmp)){
				list.add(str.toString());
				str = new StringBuilder();
				if(list.size() >= 11){
					break;
				}
				continue;
			}
			str.append(tmp);
			if(main.getFontMetrics().stringWidth(str.toString()) > 305*3){
				list.add(str.toString().substring(0,str.toString().length()-1));
				str = new StringBuilder();
				if(list.size() >= 11){
					break;
				}
				str.append(tmp);
				continue;
			}
		}
		if(!"".equals(str.toString())){
			list.add(str.toString());
		}
		if(list.size() > 10){
			String s = list.get(9);//拿出第10条
			list = list.subList(0, 9);//把前9条拿出来
			int le = s.length();
			if(le > 0){
				for(int i=0;i<le;i++){
					if(main.getFontMetrics().stringWidth(s + "...") <= 305*3){
						break;
					}else{
						s = s.substring(0, le-1-i);
					}
				}
			}
			list.add(9, s+"...");//插入处理后的第10条记录
		}
		
		int height = 3*33*list.size();
		
		BufferedImage image = new BufferedImage(375*3, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D text = image.createGraphics();
		text.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//锯齿处理
		text.setColor(Color.white);
		text.fillRect(0, 0, 375*3, height);
		
		text.setColor(new Color(50,51,51));
		text.setFont(new Font("苹方 细体", Font.PLAIN, 24*3));
		
		String emojiKey = null;
		String line = null;
		String s = null;
		for(int i=0;i<list.size();i++){
			line = list.get(i);
			int drawY = (int)((i+0.5)*33*3-(double)main.getFontMetrics().getHeight()/3);
			int drawX = 40*3;
			for(int j=0;j<line.length();j++){
				int cp = line.codePointAt(j);
				if((cp >= 0xD800 && cp <= 0xDFFF)// 高低位替代符保留区域
						||(cp >= 0xFE00 && cp <= 0xFE0F)// 变异选择器
						){//这些都是emoji中的一些链接啊，控制啊之类的，可以忽略的
					continue;
				}
				if(cp >= 127462 && cp <= 127487 && j<line.length()-1){//有可能是国旗，双拼的
					int cp2 = line.codePointAt(j+1);
					emojiKey = Integer.toHexString(cp) + "-" + Integer.toHexString(cp2);
					if(emojiFileMap.containsKey(emojiKey)){
						this.drawImage(image, drawX, drawY, emojiFileMap.get(emojiKey));
						j++;
						drawX = drawX + 24*3;
						continue;
					}
				}else if((cp == 42 || cp == 35 || (cp >= 48 && cp <= 57)) && j<line.length()-2){//有可能是#号和*号，3拼的
					int cp2 = line.codePointAt(j+1);
					int cp3 = line.codePointAt(j+2);
					emojiKey = Integer.toHexString(cp) + "-" + Integer.toHexString(cp2) + "-" + Integer.toHexString(cp3);
					if(emojiFileMap.containsKey(emojiKey)){
						this.drawImage(image, drawX, drawY, emojiFileMap.get(emojiKey));
						j++;
						j++;
						drawX = drawX + 24*3;
						continue;
					}
				}
				emojiKey = Integer.toHexString(cp);
				if(emojiFileMap.containsKey(emojiKey)){
					this.drawImage(image, drawX, drawY, emojiFileMap.get(emojiKey));
					drawX = drawX + 24*3;
					continue;
				}
				
				//其他的都是文字了
				s = line.substring(j, j+1);
				text.drawString(s, drawX, (int)((i+0.5)*33*3+(double)main.getFontMetrics().getHeight()/4));
				drawX = drawX + main.getFontMetrics().stringWidth(s);
			}
		}
		e.setImageUrl(ImageUtil.getImageBase64String(image));
		
		return e;
	}

	private void drawImage(BufferedImage image, int x, int y, File emojiFile){
		Graphics pic = image.getGraphics();
		BufferedImage bimg = null;
		try {
			bimg = ImageIO.read(emojiFile);
		} catch (Exception e) {
		}
		if(bimg!=null){
			pic.drawImage(bimg, x, y, 24*3, 24*3, null);
			pic.dispose();
		}
	}
	
	@Override
	public Response fragmentLike(long uid, long topicId, long fid, String imageName, int action){
		if(!StringUtils.isEmpty(imageName) && imageName.startsWith("http")){//兼容前端不愿意转换传递整串图片路径
			imageName = imageName.substring(imageName.indexOf("/", 9)+1);
		}
		
		List<TopicImage> topicImageList = liveMybatisDao.getTopicImageByTopicIdAndFidAndImageName(topicId, fid, imageName, 0);//图片视频的都要
		if(null == topicImageList || topicImageList.size() == 0){
			return Response.failure(ResponseStatus.CONTENT_NOT_EXISTS.status, ResponseStatus.CONTENT_NOT_EXISTS.message);
		}

		TopicImage topicImage = topicImageList.get(0);
		
		TopicFragmentLikeHis his = liveMybatisDao.getTopicFragmentLikeHisByUidAndImageId(uid, topicImage.getId());
		if(action == 1){//点赞
			if(null == his){
				extDao.updateTopicImageLikeCount(topicImage.getId(), 0);//+1
				his = new TopicFragmentLikeHis();
				his.setCreateTime(new Date());
//				his.setFid();//暂不需要本字段，先预留
				his.setImageId(topicImage.getId());
				his.setUid(uid);
				liveMybatisDao.saveTopicFragmentLikeHis(his);
			}//else已经点赞过的就直接成功了
		}else if(action == 2){//取消点赞
			if(null != his){
				extDao.updateTopicImageLikeCount(topicImage.getId(), 1);//-1
				liveMybatisDao.deleteTopicFragmentLikeHisById(his.getId());
			}//else未点赞的也直接成功算
		}else{
			return Response.failure(ResponseStatus.ILLEGAL_REQUEST.status, ResponseStatus.ILLEGAL_REQUEST.message);
		}
		
		return Response.success(ResponseStatus.OPERATION_SUCCESS.status, ResponseStatus.OPERATION_SUCCESS.message);
	}
	
	@Override
	public Response imageInfo(long uid, long topicId, long fid, String imageName){
		ImageInfoDTO result = new ImageInfoDTO();
		
		List<TopicImage> topicImageList = liveMybatisDao.getTopicImageByTopicIdAndFidAndImageName(topicId, fid, imageName, 0);//图片视屏的都要
		if(null != topicImageList && topicImageList.size() > 0){
			TopicImage topicImage = topicImageList.get(0);
			result.setLikeCount(topicImage.getLikeCount());
			TopicFragmentLikeHis his = liveMybatisDao.getTopicFragmentLikeHisByUidAndImageId(uid, topicImage.getId());
			if(null != his){
				result.setIsLike(1);
			}
		}
		
		return Response.success(result);
	}
}
