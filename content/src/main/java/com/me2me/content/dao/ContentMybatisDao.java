package com.me2me.content.dao;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.me2me.common.web.Specification;
import com.me2me.content.dto.*;
import com.me2me.content.mapper.*;
import com.me2me.content.model.*;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 上海拙心网络科技有限公司出品
 * Author: 赵朋扬
 * Date: 2016/3/22.
 */
@Repository
public class ContentMybatisDao {

    @Autowired
    private ContentMapper contentMapper;

    @Autowired
    private ContentImageMapper contentImageMapper;

    @Autowired
    private ContentTagsMapper contentTagsMapper;

    @Autowired
    private HighQualityContentMapper highQualityContentMapper;

    @Autowired
    private ContentTagsDetailsMapper contentTagsDetailsMapper;

    @Autowired
    private ContentReviewMapper contentReviewMapper;

    @Autowired
    private ContentLikesDetailsMapper contentLikesDetailsMapper;

    @Autowired
    private ArticleLikesDetailsMapper articleLikesDetailsMapper;

    @Autowired
    private ArticleReviewMapper articleReviewMapper;

    @Autowired
    private ArticleTagsDetailsMapper articleTagsDetailsMapper;

    @Autowired
    private AtReviewMapper atReviewMapper;

    @Autowired
    private BillBoardMapper billBoardMapper;
    
    @Autowired
    private BillBoardDetailsMapper billBoardDetailsMapper;

    @Autowired
    private BillBoardRelationMapper billBoardRelationMapper;
    
    @Autowired
    private BillBoardListMapper billBoardListMapper;
    
    @Autowired
    private BillBoardDetailsMapper  billBoardDetailMapper;
    
    @Autowired
    private ContentShareHistoryMapper contentShareHistoryMapper;
    
    @Autowired
    private AdBannerMapper adBannerMapper;
    
    @Autowired
    private AdInfoMapper adInfoMapper;
    
    @Autowired
    private AdRecordMapper adRecordMapper;

    public List<Content> loadSquareData(int sinceId){
        return contentMapper.loadSquareData(sinceId);
    }

    public List<Content>highQuality(int sinceId){
        return contentMapper.loadHighQualityData(sinceId);
    }

    public void createContent(Content content){
        contentMapper.insertSelective(content);
    }

    public void createContentImage(ContentImage contentImage){
        contentImageMapper.insertSelective(contentImage);
    }

    public Content getContentById(long id){
        return contentMapper.selectByPrimaryKey(id);
    }

    public void updateContentById(Content content){
        contentMapper.updateByPrimaryKeySelective(content);
    }

    public void updateContent(Content content){
        contentMapper.updateByPrimaryKey(content);
    }

    public void createTag(ContentTags contentTags){
        ContentTagsExample example = new ContentTagsExample();
        ContentTagsExample.Criteria criteria = example.createCriteria();
        criteria.andTagEqualTo(contentTags.getTag());
        List<ContentTags> list = contentTagsMapper.selectByExample(example);
        if(list == null ||list.size() ==0) {
            contentTagsMapper.insertSelective(contentTags);
        }else{
            contentTags.setId(list.get(0).getId());
        }
    }

    //获取所有（包括UGC和直播等）
    public List<Content>myPublish(long uid,int sinceId) {
        Map<String,Object> map = Maps.newHashMap();
        map.put("uid",uid);
        map.put("sinceId",sinceId);
        return contentMapper.loadMyPublishData(map);
    }

    public List<Content>myPublishUgc(long uid,int sinceId,int flag) {
        Map<String,Object> map = Maps.newHashMap();
        map.put("uid",uid);
        map.put("sinceId",sinceId);
        map.put("flag", flag);
        return contentMapper.loadMyPublishUgcData(map);
    }

    public List<Content>myPublishLive(long uid,long updateTime) {
        Map<String,Object> map = Maps.newHashMap();
        map.put("uid",uid);
        map.put("updateTime",updateTime);
        return contentMapper.loadMyPublishLiveData(map);
    }

    public List<Content>myPublishLive2(long uid,int sinceId) {
        Map<String,Object> map = Maps.newHashMap();
        map.put("uid",uid);
        map.put("sinceId",sinceId);
        return contentMapper.loadMyPublishLiveData2(map);
    }

    public void modifyPGCById(Content content){
        contentMapper.updateByPrimaryKeySelective(content);
    }

    public List<ContentTagsDetails> getContentTagsDetails(long cid , Date createTime, long sinceId) {
        ContentTagsDetailsExample example = new ContentTagsDetailsExample();
        ContentTagsDetailsExample.Criteria criteria = example.createCriteria();
        criteria.andCidEqualTo(cid);
        criteria.andIdLessThan(sinceId);
        //由于自己的feeling也是感受，两个表存储有可能会有时间差，故这里想自己的去除。
        Calendar cal = Calendar.getInstance();
		cal.setTime(createTime);
		cal.add(Calendar.SECOND, 2);
		criteria.andCreateTimeGreaterThan(cal.getTime());
        example.setOrderByClause(" create_time desc ");
        return contentTagsDetailsMapper.selectByExample(example);
    }

    public List<ContentImage> getContentImages(long cid){
        ContentImageExample example = new ContentImageExample();
        ContentImageExample.Criteria criteria = example.createCriteria();
        criteria.andCidEqualTo(cid);
        return contentImageMapper.selectByExample(example);
    }

    public ContentImage getCoverImages(long cid){
        ContentImageExample example = new ContentImageExample();
        ContentImageExample.Criteria criteria = example.createCriteria();
        criteria.andCidEqualTo(cid);
        List<ContentImage> list =  contentImageMapper.selectByExample(example);
        for (ContentImage contentImage : list){
            if(contentImage.getCover() ==1){
                return contentImage;
            }
        }
        return null;
    }
    public ContentTags getContentTags(String feeling){
        ContentTagsExample example = new ContentTagsExample();
        ContentTagsExample.Criteria criteria = example.createCriteria();
        criteria.andTagEqualTo(feeling);
        List<ContentTags> list = contentTagsMapper.selectByExample(example);
        return (list !=null && list.size() >0 ) ? list.get(0) : null;
    }

    public ContentTags getContentTagsById(long tid){
       return contentTagsMapper.selectByPrimaryKey(tid);
    }


    public void createHighQualityContent(HighQualityContent highQualityContent){
        highQualityContentMapper.insertSelective(highQualityContent);
    }

    public void removeHighQualityContent(long id){
        highQualityContentMapper.deleteByPrimaryKey(id);
    }

    public HighQualityContent getHQuantityByCid(long cid){
        HighQualityContentExample example = new HighQualityContentExample();
        HighQualityContentExample.Criteria criteria = example.createCriteria();
        criteria.andCidEqualTo(cid);
        List<HighQualityContent> list = highQualityContentMapper.selectByExample(example);
        return list!=null&&list.size()>0?list.get(0):null;
    }

    public List<Content> loadSelectedData(int sinceId){
        return contentMapper.loadSelectedData(sinceId);
    }

    public List<Content> loadActivityData(int sinceId){
        return contentMapper.loadActivityData(sinceId);
    }

    public List<Content> showContentsByPage(EditorContentDto editorContentDto){
        ContentExample example = new ContentExample();
        ContentExample.Criteria criteria = example.createCriteria();
        queryCondition(editorContentDto, example, criteria);
        example.setOrderByClause("create_time desc limit "+((editorContentDto.getPage()-1)*editorContentDto.getPageSize())+","+editorContentDto.getPageSize()+"");
        return contentMapper.selectByExampleWithBLOBs(example);
    }

    private void queryCondition(EditorContentDto editorContentDto, ContentExample example, ContentExample.Criteria criteria) {
        if(editorContentDto.getArticleType()==1){
            // PGC
            criteria.andTypeEqualTo(Specification.ArticleType.EDITOR.index);
//            ContentExample.Criteria criteria2 = example.createCriteria();
            if(StringUtils.isNotBlank(editorContentDto.getKeyword())){
            	criteria.andTitleLike("%"+editorContentDto.getKeyword()+"%");
            }
//            criteria2.andTypeEqualTo(Specification.ArticleType.ACTIVITY.index);
            criteria.andStatusNotEqualTo(1);
//            example.or(criteria2);
        }else{
            // UGC
            criteria.andTypeEqualTo(Specification.ArticleType.ORIGIN.index);

            ContentExample.Criteria criteria2 = example.createCriteria();
            if(StringUtils.isNotBlank(editorContentDto.getKeyword())){
            	criteria.andTitleLike("%"+editorContentDto.getKeyword()+"%");
            }
            criteria2.andTypeEqualTo(Specification.ArticleType.LIVE.index);
            criteria.andStatusNotEqualTo(1);
            example.or(criteria2);
        }
    }

    public int total(EditorContentDto editorContentDto){
        ContentExample example = new ContentExample();
        ContentExample.Criteria criteria = example.createCriteria();
        queryCondition(editorContentDto, example, criteria);
        return contentMapper.countByExample(example);
    }

    public Integer getTopicStatus(long topicId){
       Integer result = contentMapper.getTopicStatus(topicId);
        return  result == null ? 1 : result;
    }

    public void deleteTopicById(long topicId){
        contentMapper.deleteTopicById(topicId);
    }

    public int isFavorite(long topicId,long uid){
        IsFavoriteDto isFavoriteDto = new IsFavoriteDto();
        isFavoriteDto.setUid(uid);
        isFavoriteDto.setTopicId(topicId);
        return contentMapper.isFavorite(isFavoriteDto);
    }

    public List<Content> getHottestContent(int sinceId){
        return contentMapper.loadHottestContent(sinceId);
    }

    public List<Content> getHottestTopsContent(int flag){
        return contentMapper.loadHottestTopsContent(flag);
    }

    public int getContentImageCount(long cid){
        ContentImageExample example = new ContentImageExample();
        ContentImageExample.Criteria criteria = example.createCriteria();
        criteria.andCidEqualTo(cid);
        return contentImageMapper.countByExample(example);
    }

    public List<Content> getNewest4Old(long uid,long sinceId,List<Long> blacklistUids){
    	return contentMapper.loadNewestContent4Old(uid,sinceId,blacklistUids);
    }
    
    public List<Content> getNewest(long uid,long sinceId,List<Long> blacklistUids){
        return contentMapper.loadNewestContent(uid,sinceId, blacklistUids);
    }

    public List<Content> getAttention(long sinceId , long meUid, int vFlag){
        Map<String,Object> params = Maps.newHashMap();
        params.put("uid",meUid);
        params.put("sinceId",sinceId);
        params.put("flag", vFlag);
        return contentMapper.getAttention(params);
    }

    public void createContentTagsDetails(ContentTagsDetails contentTagsDetails){
        contentTagsDetailsMapper.insert(contentTagsDetails);
    }

    public void createReview(ContentReview review){
        contentReviewMapper.insertSelective(review);
    }

    public List<Content> getContentByTopicId(long topicId){
        ContentExample example = new ContentExample();
        ContentExample.Criteria criteria =example.createCriteria();
        criteria.andForwardCidEqualTo(topicId);
        criteria.andTypeEqualTo(Specification.ArticleType.LIVE.index);
        return contentMapper.selectByExample(example);
    }
    
    public List<Content> getContentByTopicIds(List<Long> topicIds){
    	if(topicIds==null || topicIds.isEmpty()){
    		return new ArrayList<Content>();
    	}
    	ContentExample example = new ContentExample();
        ContentExample.Criteria criteria =example.createCriteria();
        criteria.andForwardCidIn(topicIds);
        criteria.andTypeEqualTo(Specification.ArticleType.LIVE.index);
        return contentMapper.selectByExample(example);
    }

    public List<ContentReview> getContentReviewByCid(long cid,long sinceId){
        ContentReviewExample example = new ContentReviewExample();
        ContentReviewExample.Criteria criteria = example.createCriteria();
        criteria.andCidEqualTo(cid);
        criteria.andIdLessThan(sinceId);
        criteria.andStatusNotEqualTo(Specification.ContentDelStatus.DELETE.index);//非删除的内容
        example.setOrderByClause(" create_time desc limit 20 ");
        return contentReviewMapper.selectByExample(example);
    }

    public List<ContentReview> getArticleReviewByCid(long cid,long sinceId){
        List<ContentReview> result = Lists.newArrayList();
        ArticleReviewExample example = new ArticleReviewExample();
        ArticleReviewExample.Criteria criteria = example.createCriteria();
        criteria.andArticleIdEqualTo(cid);
        criteria.andIdLessThan(sinceId);
        criteria.andStatusNotEqualTo(Specification.ContentDelStatus.DELETE.index);//非删除的内容
        example.setOrderByClause(" create_time desc limit 20 ");
        List<ArticleReview> list = articleReviewMapper.selectByExample(example);
        for(ArticleReview articleReview : list){
            ContentReview contentReview = new ContentReview();
            contentReview.setId(articleReview.getId());
            contentReview.setCid(articleReview.getArticleId());
            contentReview.setCreateTime(articleReview.getCreateTime());
            contentReview.setReview(articleReview.getReview());
            contentReview.setUid(articleReview.getUid());
            contentReview.setAtUid(articleReview.getAtUid());
            contentReview.setExtra(articleReview.getExtra());
            result.add(contentReview);
        }
        return result;
    }

    public List<ContentReview> getContentReviewTop3ByCid(long cid){
        ContentReviewExample example = new ContentReviewExample();
        ContentReviewExample.Criteria criteria = example.createCriteria();
        criteria.andCidEqualTo(cid);
        criteria.andStatusNotEqualTo(Specification.ContentDelStatus.DELETE.index);
        example.setOrderByClause(" create_time desc limit 20 ");
        return contentReviewMapper.selectByExample(example);
    }
    
    public int countContentReviewByCid(long cid){
    	ContentReviewExample example = new ContentReviewExample();
        ContentReviewExample.Criteria criteria = example.createCriteria();
        criteria.andCidEqualTo(cid);
        criteria.andStatusNotEqualTo(Specification.ContentDelStatus.DELETE.index);
        return contentReviewMapper.countByExample(example);
    }
    
    public List<ContentReview> getContentReviewPageByUid(long uid, int start, int pageSize){
    	ContentReviewExample example = new ContentReviewExample();
        ContentReviewExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(uid);
        example.setOrderByClause(" id desc limit "+start+","+pageSize);
        return contentReviewMapper.selectByExample(example);
    }
    
    public int countContentReviewPageByUid(long uid){
    	ContentReviewExample example = new ContentReviewExample();
        ContentReviewExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(uid);
        return contentReviewMapper.countByExample(example);
    }

    public int isLike(long cid, long uid){
        ContentLikesDetailsExample example = new ContentLikesDetailsExample();
        ContentLikesDetailsExample.Criteria criteria = example.createCriteria();
        criteria.andCidEqualTo(cid);
        criteria.andUidEqualTo(uid);
        int count = contentLikesDetailsMapper.countByExample(example);
        return  count > 0 ? 1 : 0;
    }

    public void createContentLikesDetails(ContentLikesDetails contentLikesDetails){
        contentLikesDetailsMapper.insertSelective(contentLikesDetails);
    }

    public void deleteContentLikesDetails(ContentLikesDetails contentLikesDetails){
        ContentLikesDetailsExample example = new ContentLikesDetailsExample();
        ContentLikesDetailsExample.Criteria criteria = example.createCriteria();
        criteria.andCidEqualTo(contentLikesDetails.getCid());
        criteria.andUidEqualTo(contentLikesDetails.getUid());
        contentLikesDetailsMapper.deleteByExample(example);
    }

    public ContentLikesDetails getContentLikesDetails(ContentLikesDetails contentLikesDetails){
        ContentLikesDetailsExample example = new ContentLikesDetailsExample();
        ContentLikesDetailsExample.Criteria criteria = example.createCriteria();
        criteria.andCidEqualTo(contentLikesDetails.getCid());
        criteria.andUidEqualTo(contentLikesDetails.getUid());
        List<ContentLikesDetails> list = contentLikesDetailsMapper.selectByExample(example);
        return list != null &&list.size() > 0 ? list.get(0) :null;
    }

    public ArticleLikesDetails getArticleLikesDetails(ArticleLikesDetails articleLikesDetails){
        ArticleLikesDetailsExample example = new ArticleLikesDetailsExample();
        ArticleLikesDetailsExample.Criteria criteria = example.createCriteria();
        criteria.andArticleIdEqualTo(articleLikesDetails.getArticleId());
        criteria.andUidEqualTo(articleLikesDetails.getUid());
        List<ArticleLikesDetails> list = articleLikesDetailsMapper.selectByExample(example);
        return list != null &&list.size() > 0 ? list.get(0) :null;
    }

    public void deleteArticleLikesDetails(ArticleLikesDetails articleLikesDetails){
        ArticleLikesDetailsExample example = new ArticleLikesDetailsExample();
        ArticleLikesDetailsExample.Criteria criteria = example.createCriteria();
        criteria.andArticleIdEqualTo(articleLikesDetails.getArticleId());
        criteria.andUidEqualTo(articleLikesDetails.getUid());
        articleLikesDetailsMapper.deleteByExample(example);
    }

    public int countFragment(long topicId,long uid){
        CountFragmentDto countFragmentDto = new CountFragmentDto();
        countFragmentDto.setTopicId(topicId);
        countFragmentDto.setUid(uid);
        return contentMapper.countFragment(countFragmentDto);
    }

    public void createArticleLike(LikeDto likeDto){
        ArticleLikesDetails articleLikesDetails = new ArticleLikesDetails();
        articleLikesDetails.setArticleId(likeDto.getCid());
        articleLikesDetails.setUid(likeDto.getUid());
        articleLikesDetailsMapper.insertSelective(articleLikesDetails);
    }

    public void createArticleReview(ReviewDto reviewDto){
        ArticleReview review = new ArticleReview();
        review.setArticleId(reviewDto.getCid());
        review.setReview(reviewDto.getReview());
        review.setUid(reviewDto.getUid());
        review.setAtUid(reviewDto.getAtUid());
        review.setStatus(Specification.ContentDelStatus.NORMAL.index);
        if(StringUtils.isNotEmpty(reviewDto.getExtra())){
            review.setExtra(reviewDto.getExtra());
        }
        articleReviewMapper.insertSelective(review);
    }

    public List<ArticleLikesDetails> getArticleLikesDetails(long id){
        ArticleLikesDetailsExample example = new ArticleLikesDetailsExample();
        ArticleLikesDetailsExample.Criteria criteria = example.createCriteria();
        criteria.andArticleIdEqualTo(id);
        return articleLikesDetailsMapper.selectByExample(example);
    }

    public List<ArticleReview> getArticleReviews(long id ,long sinceId){
        ArticleReviewExample example = new ArticleReviewExample();
        ArticleReviewExample.Criteria criteria = example.createCriteria();
        criteria.andArticleIdEqualTo(id);
        criteria.andIdLessThan(sinceId);
        criteria.andStatusNotEqualTo(Specification.ContentDelStatus.DELETE.index);
        example.setOrderByClause(" id desc limit 20 ");
        return articleReviewMapper.selectByExample(example);
    }
    
    public int countArticleReviews(long id){
    	ArticleReviewExample example = new ArticleReviewExample();
        ArticleReviewExample.Criteria criteria = example.createCriteria();
        criteria.andArticleIdEqualTo(id);
        criteria.andStatusNotEqualTo(Specification.ContentDelStatus.DELETE.index);
        return articleReviewMapper.countByExample(example);
    }
    
    public List<ArticleReview> getArticleReviewPageByUid(long uid, int start, int pageSize){
    	ArticleReviewExample example = new ArticleReviewExample();
        ArticleReviewExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(uid);
        example.setOrderByClause(" id desc limit "+start+","+pageSize);
        return articleReviewMapper.selectByExample(example);
    }
    
    public int countArticleReviewPageByUid(long uid){
    	ArticleReviewExample example = new ArticleReviewExample();
        ArticleReviewExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(uid);
        return articleReviewMapper.countByExample(example);
    }

    public void createContentArticleDetails(ArticleTagsDetails articleTagsDetails){
        articleTagsDetailsMapper.insertSelective(articleTagsDetails);
    }

    public List<ContentLikesDetails> getContentLikesDetails(long id){
        ContentLikesDetailsExample example = new ContentLikesDetailsExample();
        ContentLikesDetailsExample.Criteria criteria = example.createCriteria();
        criteria.andCidEqualTo(id);
        example.setOrderByClause(" create_time desc ");
        return contentLikesDetailsMapper.selectByExample(example);
    }

    public List<ArticleTagsDetails> getArticleTagsDetails(long id){
        ArticleTagsDetailsExample example = new ArticleTagsDetailsExample();
        ArticleTagsDetailsExample.Criteria criteria = example.createCriteria();
        criteria.andArticleIdEqualTo(id);
        return articleTagsDetailsMapper.selectByExample(example);
    }

    public List<ResultKingTopicDto> kingTopic(KingTopicDto kingTopic){
        return contentMapper.kingTopic(kingTopic);
    }

    public int getTopicCount(long topicId){
        return contentMapper.getTopicCount(topicId);
    }

    public Long getTopicLastUpdateTime(long topicId){
        Long result = contentMapper.getTopicLastUpdateTime(topicId);
        return result == null ? 0 : result;
    }

    public List<Content> myPublishByType(MyPublishDto myPublishDto) {
        return contentMapper.loadMyPublishDataByType(myPublishDto);
    }
    
    public List<Content> loadMyKingdom(MyPublishDto dto){
    	return contentMapper.loadMyKingdom(dto);
    }
    
    /**
     * 获取只属于自己的王国
     * @param dto
     * @return
     */
    public List<Content> getMyOwnKingdom(MyPublishDto dto){
    	return contentMapper.getMyOwnKingdom(dto);
    }
    
    /**
     * 获取加入的或则是核心圈的王国
     * @param dto
     * @return
     */
    public List<Content> loadMyJoinKingdom(MyPublishDto dto){
    	return contentMapper.loadMyJoinKingdom(dto);
    }
    
    public int countMyJoinKingdom(MyPublishDto dto){
    	return contentMapper.countMyJoinKingdom(dto);
    }
    
    public int countMyKingdom(MyPublishDto dto){
    	return contentMapper.countMyKingdom(dto);
    }

    public int countMyPublishByType(MyPublishDto myPublishDto) {
        return contentMapper.countMyPublishByType(myPublishDto);
    }

    public void createAtReview(AtReview atReview){
        atReviewMapper.insertSelective(atReview);
    }


    public AtReview getAtReview(long reviewId, int type){
        AtReviewExample example = new AtReviewExample();
        AtReviewExample.Criteria criteria = example.createCriteria();
        criteria.andReviewIdEqualTo(reviewId);
        criteria.andReviewTypeEqualTo(type);
        List<AtReview> list = atReviewMapper.selectByExample(example);
        return com.me2me.common.utils.Lists.getSingle(list);
    }

    public void clearData(){
        contentMapper.clearData();
    }

    /**
     * 
     * @param sinceId
     * @param flag   0 2.2.0版本前
     * @return
     */
    public List<Content2Dto> getHottestContentByUpdateTime(int sinceId, int flag){
        return contentMapper.loadHottestContentByUpdateTime(sinceId, flag);
    }
    
    /**
     * 
     * @param sinceId
     * @param type  0 所有内容    1 聚合王国
     * @param pageSize
     * @return
     */
    public List<Content2Dto> getHotContentByType(long uid,long sinceId, int type, int pageSize,List<String> ids,List<Long> blacklistUids,String blackTagIds){
        HotQueryDto hotQueryDto = new HotQueryDto();
        hotQueryDto.setType(type);
        hotQueryDto.setSinceId(sinceId);
        hotQueryDto.setPageSize(pageSize);
        hotQueryDto.setIds(ids);
        hotQueryDto.setBlacklistUids(blacklistUids);
        hotQueryDto.setUid(uid);
        hotQueryDto.setBlackTagIds(blackTagIds);
    	return contentMapper.getHotContentByType(hotQueryDto);
    }
    /**
     * 
     * @param sinceId
     * @param type  0 所有内容    1 聚合王国
     * @param pageSize
     * @return
     */
    public List<Content2Dto> getHotContentListByType(long uid, int type, int start,int pageSize,List<String> ids,List<Long> blacklistUids,String blackTagIds){
        HotQueryDto hotQueryDto = new HotQueryDto();
        hotQueryDto.setType(type);
        hotQueryDto.setPageSize(pageSize);
        hotQueryDto.setStart(start);
        hotQueryDto.setIds(ids);
        hotQueryDto.setBlacklistUids(blacklistUids);
        hotQueryDto.setUid(uid);
        hotQueryDto.setBlackTagIds(blackTagIds);
    	return contentMapper.getHotContentListByType(hotQueryDto);
    }
    public List<Content2Dto> getHotContentByRedis(long uid, List<String> ids, List<Long> blacklistUids,String blackTagIds){
        return contentMapper.getHotContentByRedis(uid,ids, blacklistUids,blackTagIds);
    }

    public int getUgcCount(long uid){
        ContentExample example = new ContentExample();
        ContentExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(uid);
        criteria.andTypeNotBetween(3,6);
        criteria.andStatusEqualTo(0);
        return contentMapper.countByExample(example);
    }

    public int getLiveCount(long uid){
        ContentExample example = new ContentExample();
        ContentExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(uid);
        criteria.andTypeBetween(3,6);
        criteria.andStatusEqualTo(0);
        return contentMapper.countByExample(example);
    }
    
    public ArticleReview getArticleReviewById(long id){
    	return articleReviewMapper.selectByPrimaryKey(id);
    }
    
    public void updateArticleReview(ArticleReview ar){
    	articleReviewMapper.updateByPrimaryKeySelective(ar);
    }
    
    public ContentReview getContentReviewById(long id){
    	return contentReviewMapper.selectByPrimaryKey(id);
    }
    
    public void updateContentReview(ContentReview cr){
    	contentReviewMapper.updateByPrimaryKeySelective(cr);
    }
    
    public List<Content> getUgcPageByUid(long uid, int start, int pageSize){
    	ContentExample example = new ContentExample();
        ContentExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(uid);
        criteria.andTypeEqualTo(Specification.ArticleType.ORIGIN.index);
        example.setOrderByClause(" id desc limit "+start+","+pageSize);
        List<Content> list = contentMapper.selectByExampleWithBLOBs(example);
    	return list;
    }
    
    public int countUgcPageByUid(long uid){
    	ContentExample example = new ContentExample();
        ContentExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(uid);
        criteria.andTypeEqualTo(Specification.ArticleType.ORIGIN.index);
        return contentMapper.countByExample(example);
    }

    public List<BillBoard> loadBillBoard(){
        BillBoardExample example = new BillBoardExample();
        example.setOrderByClause("id desc");
        return billBoardMapper.selectByExample(example);
    }

    public List<BillBoardRelation> loadBillBoardRelation(long sourceId){
        BillBoardRelationExample example = new BillBoardRelationExample();
        BillBoardRelationExample.Criteria criteria = example.createCriteria();
        criteria.andSourceIdEqualTo(sourceId);
        example.setOrderByClause(" sort asc,id desc");
        return billBoardRelationMapper.selectByExample(example);
    }
    
    public List<BillBoardRelation> getBillBoardRelationsByBidsAndType(List<Long> bids, int type){
    	BillBoardRelationExample example = new BillBoardRelationExample();
        BillBoardRelationExample.Criteria criteria = example.createCriteria();
        criteria.andSourceIdIn(bids);
        criteria.andTypeEqualTo(type);
        return billBoardRelationMapper.selectByExample(example);
    }
    
    public List<BillBoardRelation> getRelationListPage(long bid, int sinceId, int pageSize, List<Long> noTargetIds){
    	BillBoardRelationExample example = new BillBoardRelationExample();
        BillBoardRelationExample.Criteria criteria = example.createCriteria();
        criteria.andSourceIdEqualTo(bid);
        criteria.andSortGreaterThan(sinceId);
        if(null != noTargetIds && noTargetIds.size() > 0){
        	criteria.andTargetIdNotIn(noTargetIds);
        }
        if(pageSize > 0){
        	example.setOrderByClause(" sort asc limit " + pageSize);
        }else{
        	example.setOrderByClause(" sort asc ");
        }
        return billBoardRelationMapper.selectByExample(example);
    }

    public BillBoard loadBillBoardById(long id){
       return billBoardMapper.selectByPrimaryKey(id);
    }

    public void deleteBillBoardListByKey(String key){
    	BillBoardListExample example = new BillBoardListExample();
    	BillBoardListExample.Criteria criteria = example.createCriteria();
    	criteria.andListKeyEqualTo(key);
    	billBoardListMapper.deleteByExample(example);
    }
    
    public void insertBillBoardList(BillBoardList bbl){
    	billBoardListMapper.insertSelective(bbl);
    }
        
    public List<BillBoardList> getBillBoardListPage(String key, int sinceId, int pageSize, List<Long> noTargetIds){
    	BillBoardListExample example = new BillBoardListExample();
    	BillBoardListExample.Criteria criteria = example.createCriteria();
    	criteria.andListKeyEqualTo(key);
    	if(null != noTargetIds && noTargetIds.size() > 0){
    		criteria.andTargetIdNotIn(noTargetIds);
    	}
    	criteria.andSinceIdGreaterThan(sinceId);
    	if(pageSize > 0){
    		example.setOrderByClause(" since_id asc limit " + pageSize);
    	}else{
    		example.setOrderByClause(" since_id asc ");
    	}
    	return billBoardListMapper.selectByExample(example);
    }

    public List<BillBoardRelation> loadBillBoardRelations(int type){
        return billBoardMapper.loadBillBoard(type);
    }

    public List<BillBoardRelation> loadBillBoardRelationsBySinceId(long sinceId,long sourceId, List<Long> noTargetIds){
        return billBoardMapper.loadBillBoardBySinceId(sourceId,sinceId,noTargetIds);
    }

    public List<Long> loadBillBoardCover(int type){
        return billBoardMapper.loadBillBoardCover(type);
    }

    public List<BillBoard> loadBillBoardByBids(List<Long> ids) {
        BillBoardExample example = new BillBoardExample();
        BillBoardExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return billBoardMapper.selectByExample(example);
    }
    
    public List<BillBoard> loadBillBoardByBidsAndType(List<Long> ids, int type) {
        BillBoardExample example = new BillBoardExample();
        BillBoardExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        criteria.andTypeEqualTo(type);
        return billBoardMapper.selectByExample(example);
    }
    
    public List<BillBoardDetails> getShowListPageByType(int sinceId, int type){
    	BillBoardDetailsExample example = new BillBoardDetailsExample();
    	BillBoardDetailsExample.Criteria criteria = example.createCriteria();
    	criteria.andTypeEqualTo(type);
    	criteria.andSortGreaterThan(sinceId);
    	criteria.andStatusEqualTo(1);//只要上架的
    	example.setOrderByClause(" sort asc limit 10");
    	return billBoardDetailsMapper.selectByExample(example);
    }
    
    public List<BillBoardDetails> getBillBoardDetailsByStatusAndType(int status, int type){
    	BillBoardDetailsExample example = new BillBoardDetailsExample();
    	BillBoardDetailsExample.Criteria criteria = example.createCriteria();
    	criteria.andTypeEqualTo(type);
    	criteria.andStatusEqualTo(status);
    	return billBoardDetailsMapper.selectByExample(example);
    }
    
    /**
     * 修改榜单
     * @author zhangjiwei
     * @date Mar 21, 2017
     * @param bb
     */
	public void updateBillBoard(BillBoard bb) {
		billBoardMapper.updateByPrimaryKeySelective(bb);
	}
	/**
	 * 删除榜单
	 * @author zhangjiwei
	 * @date Mar 21, 2017
	 * @param id
	 */
	public void deleteBillBoardByKey(long id) {
		billBoardMapper.deleteByPrimaryKey(id);
	}

	public void insertBillBoard(BillBoard bb) {
		billBoardMapper.insertSelective(bb);
	}

	public void insertBillBoardRelation(BillBoardRelation br) {
		billBoardRelationMapper.insertSelective(br);
	}

	public void delBillBoardRelationById(long rid) {
		billBoardRelationMapper.deleteByPrimaryKey(rid);
	}

	public void updateBillBoardRelation(BillBoardRelation br) {
		billBoardRelationMapper.updateByPrimaryKeySelective(br);
	}
	/**
	 * 按榜单ID删除detail.
	 * @author zhangjiwei
	 * @date Mar 21, 2017
	 * @param bid
	 */
	public void deleteBillBoardDetailByBId(long bid) {
		BillBoardDetailsExample example = new BillBoardDetailsExample();
		example.createCriteria().andBidEqualTo(bid);
		billBoardDetailMapper.deleteByExample(example);
	}

	public List<BillBoardDetails> getBillBoardDetailByBidAndType(Long bid,int type) {
		BillBoardDetailsExample example = new BillBoardDetailsExample();
		example.createCriteria().andBidEqualTo(bid).andTypeEqualTo(type);
		List<BillBoardDetails> details =billBoardDetailMapper.selectByExample(example);
		return details;
	}
	public List<BillBoardDetails> getBillBoardDetailsByType(int type){
		BillBoardDetailsExample example = new BillBoardDetailsExample();
		example.createCriteria().andTypeEqualTo(type);
		example.setOrderByClause("sort asc,id desc");
		return billBoardDetailMapper.selectByExample(example);
	}
	public void insertBillBoardDetail(BillBoardDetails br) {
		billBoardDetailMapper.insertSelective(br);
	}

	public void delBillBoardDetailById(long rid) {
		billBoardDetailMapper.deleteByPrimaryKey(rid);
	}

	public void updateBillBoardDetailById(BillBoardDetails br) {
		billBoardDetailMapper.updateByPrimaryKeySelective(br);
	}
	/**
	 * 判断排行数据是否存在
	 * @author zhangjiwei
	 * @date Mar 23, 2017
	 * @param br
	 * @return
	 */
	public boolean existsBillBoardRelation(BillBoardRelation br) {
		// 判断 srouceId ，targetid.
		BillBoardRelationExample example = new BillBoardRelationExample();
		example.createCriteria().andSourceIdEqualTo(br.getSourceId()).andTargetIdEqualTo(br.getTargetId());
		int count = billBoardRelationMapper.countByExample(example);
		return count>0;
	}

	public void saveContentShareHistory(ContentShareHistory csh){
		contentShareHistoryMapper.insertSelective(csh);
	}
	
	/**
	 * 查询王国分享次数
	 * @param topicId
	 * @return
	 */
	public int getTopicShareCount(long topicId){
		ContentShareHistoryExample example = new ContentShareHistoryExample();
		ContentShareHistoryExample.Criteria criteria  = example.createCriteria();
		criteria.andTypeEqualTo(1);
		criteria.andCidEqualTo(topicId);
		int count = contentShareHistoryMapper.countByExample(example);
		return count;
	}
	/**
	 * 查询查询广告位列表总数
	 * @param status
	 * @return
	 */
	public int getAdBannerCount(int status){
		AdBannerExample example = new AdBannerExample();
		if(status!=-1){
			example.createCriteria().andStatusEqualTo(status);
		}
		example.setOrderByClause(" id desc");
		int count = adBannerMapper.countByExample(example);
		return count;
	}
	/**
	 * 查询广告位列表
	 * @param status
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<AdBanner> getAdBannerList(int status,int start,int pageSize){
		AdBannerExample example = new AdBannerExample();
		if(status!=-1){
			example.createCriteria().andStatusEqualTo(status);
		}
		example.setOrderByClause(" id desc limit "+start+","+pageSize);
		return adBannerMapper.selectByExample(example);
	}
	/**
	 * 查询所有广告位列表
	 * @param status
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<AdBanner> getAllAdBannerList(int status){
		AdBannerExample example = new AdBannerExample();
		if(status!=-1){
			example.createCriteria().andStatusEqualTo(status);
		}
		example.setOrderByClause(" id desc ");
		return adBannerMapper.selectByExample(example);
	}
	
	/**
	 * 查询所有有广告的广告位列表
	 * @return
	 */
	public List<AdBanner> getAllNormalBannerList(long uid){
		return adBannerMapper.getNormalBanners(uid);
	}
	/**
	 * 保存广告位
	 * @param adBanner
	 * @return
	 */
	public int saveAdBanner(AdBanner adBanner){
		return adBannerMapper.insertSelective(adBanner);
	}
	/**
	 * 更新广告位
	 * @param adBanner
	 * @return
	 */
	public int updateAdBanner(AdBanner adBanner){
		return adBannerMapper.updateByPrimaryKeySelective(adBanner);
	}
	
	/**
	 * 获取广告位
	 * @param long id
	 * @return
	 */
	public AdBanner getAdBannerById(long id){
		return adBannerMapper.selectByPrimaryKey(id);
	}
	/**
	 * 查询查询广告信息列表总数
	 * @param status
	 * @param bannerList
	 * @return
	 */
	public int getAdInfoCount(int status,List<Long> bannerList){
		AdInfoExample example = new AdInfoExample();
		AdInfoExample.Criteria criteria = example.createCriteria();
		if(status!=-1){
			criteria.andStatusEqualTo(status);
		}
		if(bannerList.size()>0){
			criteria.andBannerIdIn(bannerList);
		}
		example.setOrderByClause(" effective_time desc");
		int count = adInfoMapper.countByExample(example);
		return count;
	}
	/**
	 * 查询广告信息列表
	 * @param status
	 * @param bannerList
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<AdInfo> getAdInfoList(int status,List<Long> bannerList,int start,int pageSize){
		AdInfoExample example = new AdInfoExample();
		AdInfoExample.Criteria criteria = example.createCriteria();
		if(status!=-1){
			criteria.andStatusEqualTo(status);
		}
		if(bannerList.size()>0){
			criteria.andBannerIdIn(bannerList);
		}
		example.setOrderByClause(" effective_time desc limit "+start+","+pageSize);
		return adInfoMapper.selectByExample(example);
	}
	/**
	 * 保存广告信息
	 * @param adInfo
	 * @return
	 */
	public int saveAdInfo(AdInfo adInfo){
		return adInfoMapper.insertSelective(adInfo);
	}
	/**
	 * 更新广告信息
	 * @param adInfo
	 * @return
	 */
	public int updateAdInfo(AdInfo adInfo){
		return adInfoMapper.updateByPrimaryKeySelective(adInfo);
	}
	
	/**
	 * 获取广告信息
	 * @param id
	 * @return
	 */
	public AdInfo getAdInfoById(long id){
		return adInfoMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 广告点击信息添加
	 * @param id
	 * @return
	 */
	public int saveAdRecrod(AdRecord adRecord){
		return adRecordMapper.insertSelective(adRecord);
	}
	
	public List<Content> getTagTopicList(long tagId, List<Long> blacklistUids,int page,int pageSize){
		return contentMapper.getTagTopicList(tagId, blacklistUids,page,pageSize);
	}
	public List<Content> getAcKingdomList(long topicId,int page,int pageSize){
		return contentMapper.getAcKingdomList(topicId,page,pageSize);
	}
	public List<Map<String,Object>> getAcKingdomImageList(long topicId,int page,int pageSize){
		return contentMapper.getAcKingdomImageList(topicId,page,pageSize);
	}
	
	public List<Long> getAcKingdomImageLikeList(long uid,List<Long> imageIdList){
		return contentMapper.getAcKingdomImageLikeList(uid, imageIdList);
	}
	public int getAttentionAndLikeTagCount(long uid){
		return contentMapper.getAttentionAndLikeTagCount(uid);
	}
	public List<Map<String,Object>> getTagTopicInfo(List<Long> idList){
		return contentMapper.getTagTopicInfo(idList);
	}
	
	
}
