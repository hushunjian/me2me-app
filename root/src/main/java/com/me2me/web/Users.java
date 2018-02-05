package com.me2me.web;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import com.me2me.common.web.ResponseStatus;
import com.me2me.user.dto.*;
import com.me2me.user.rule.Rules;
import com.me2me.web.request.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.me2me.common.utils.CommonUtils;
import com.me2me.common.web.Response;
import com.me2me.common.web.ResponseWapx;
import com.me2me.content.service.ContentService;
import com.me2me.kafka.service.KafkaService;
import com.me2me.live.service.LiveService;
import com.me2me.sms.dto.AwardXMDto;
import com.me2me.sms.dto.VerifyDto;
import com.me2me.sms.service.ChannelType;
import com.me2me.sms.service.SmsService;
import com.me2me.user.service.UserService;
import com.me2me.web.utils.VersionUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * 上海拙心网络科技有限公司出品
 * Author: 赵朋扬
 * Date: 2016/2/25.
 */
@Slf4j
@Controller
@RequestMapping(value = "/api/user")
public class Users extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private KafkaService kafkaService;

    @Autowired
    private SmsService smsService;
    
    @Autowired
    private ContentService contentService;
    
    @Autowired
    private LiveService liveService;

    /**
     * 用户注册接口
     * @return
     */
    @RequestMapping(value = "/signUp",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response signUp(SignUpRequest request, HttpServletRequest rq){
        UserSignUpDto userSignUpDto = new UserSignUpDto();
        userSignUpDto.setMobile(request.getMobile());
        userSignUpDto.setGender(request.getGender());
        userSignUpDto.setStar(request.getStart());
        userSignUpDto.setEncrypt(request.getEncrypt());
        userSignUpDto.setNickName(request.getNickName());
        userSignUpDto.setDeviceNo(request.getDeviceNo());
        userSignUpDto.setPlatform(request.getPlatform());
        userSignUpDto.setOs(request.getOs());
        userSignUpDto.setIntroduced(request.getIntroduced());
        userSignUpDto.setChannel(request.getChannel());
        userSignUpDto.setRegisterVersion(request.getVersion());
        userSignUpDto.setParams(request.getParams());
        userSignUpDto.setOpeninstallData(request.getOpeninstallData());
        userSignUpDto.setDeviceData(request.getDeviceData());
        userSignUpDto.setHwToken(request.getHwToken());

        //获取ipaddress信息
        String ip = rq.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getRemoteAddr();
        }
        if ("127.0.0.1".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip)){
        	try {
                ip = InetAddress.getLocalHost().getHostAddress();
            }catch (UnknownHostException unknownhostexception) {
            }
        }
        userSignUpDto.setIp(ip);
        
        if(StringUtils.isEmpty(request.getChannel())){
        	log.info("手机注册无渠道=["+request.getNickName()+"],["+request.getChannel()+"],["+request.getVersion()+"],["+request.getPlatform()+"],["+request.getOpeninstallData()+"]");
        }else{
        	log.info("手机注册有渠道=["+request.getNickName()+"],["+request.getChannel()+"],["+request.getVersion()+"],["+request.getPlatform()+"],["+request.getOpeninstallData()+"]");
        }
        //埋点
//        kafkaService.saveClientLog(request,req.getHeader("User-Agent"),Specification.ClientLogAction.REG_PAGE2_SAVE);

        return userService.signUp(userSignUpDto);
    }

    /**
     * 用户注册接口
     * @return
     */
    @RequestMapping(value = "/signUpByVerify",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response signUpByVerify(SignUpRequest request, HttpServletRequest rq){
        UserSignUpDto userSignUpDto = new UserSignUpDto();
        userSignUpDto.setMobile(request.getMobile());
        userSignUpDto.setGender(-1);
        userSignUpDto.setStar(request.getStart());
        userSignUpDto.setEncrypt("0");
        userSignUpDto.setDeviceNo(request.getDeviceNo());
        userSignUpDto.setPlatform(request.getPlatform());
        userSignUpDto.setOs(request.getOs());
        userSignUpDto.setIntroduced(request.getIntroduced());
        userSignUpDto.setChannel(request.getChannel());
        userSignUpDto.setRegisterVersion(request.getVersion());
        userSignUpDto.setParams(request.getParams());
        userSignUpDto.setVerifyCode(request.getVerifyCode());
        userSignUpDto.setOpeninstallData(request.getOpeninstallData());
        userSignUpDto.setDeviceData(request.getDeviceData());
        userSignUpDto.setHwToken(request.getHwToken());

        //获取ipaddress信息
        String ip = rq.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getRemoteAddr();
        }
        if ("127.0.0.1".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip)){
        	try {
                ip = InetAddress.getLocalHost().getHostAddress();
            }catch (UnknownHostException unknownhostexception) {
            }
        }
        userSignUpDto.setIp(ip);
        
        if(StringUtils.isEmpty(request.getChannel())){
        	log.info("手机验证码注册无渠道=["+request.getNickName()+"],["+request.getChannel()+"],["+request.getVersion()+"],["+request.getPlatform()+"],["+request.getOpeninstallData()+"]");
        }else{
        	log.info("手机验证码注册有渠道=["+request.getNickName()+"],["+request.getChannel()+"],["+request.getVersion()+"],["+request.getPlatform()+"],["+request.getOpeninstallData()+"]");
        }
        
        return userService.signUpByVerify(userSignUpDto);
    }


    /**
     * 用户登录
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response login(LoginRequest request, HttpServletRequest rq){
        UserLoginDto userLoginDto = new UserLoginDto();
        userLoginDto.setUserName(request.getUserName());
        userLoginDto.setEncrypt(request.getEncrypt());
        userLoginDto.setOs(request.getOs());
        userLoginDto.setPlatform(request.getPlatform());
        userLoginDto.setDeviceNo(request.getDeviceNo());
        userLoginDto.setJPushToken(request.getJPushToken());
        userLoginDto.setChannel(request.getChannel());
        userLoginDto.setRegisterVersion(request.getVersion());
        userLoginDto.setDeviceData(request.getDeviceData());
        userLoginDto.setHwToken(request.getHwToken());

        //获取ipaddress信息
        String ip = rq.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getRemoteAddr();
        }
        if ("127.0.0.1".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip)){
        	try {
                ip = InetAddress.getLocalHost().getHostAddress();
            }catch (UnknownHostException unknownhostexception) {
            }
        }
        userLoginDto.setIp(ip);
        return userService.login(userLoginDto);
    }


    /**
     * 用户使用手机验证码登录
     * @return
     */
    @RequestMapping(value = "/loginByVerify",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response loginByVerify(LoginRequest request, HttpServletRequest rq){
        UserLoginDto userLoginDto = new UserLoginDto();
        userLoginDto.setUserName(request.getUserName());
        userLoginDto.setOs(request.getOs());
        userLoginDto.setPlatform(request.getPlatform());
        userLoginDto.setDeviceNo(request.getDeviceNo());
        userLoginDto.setJPushToken(request.getJPushToken());
        userLoginDto.setVerifyCode(request.getVerifyCode());
        userLoginDto.setChannel(request.getChannel());
        userLoginDto.setRegisterVersion(request.getVersion());
        userLoginDto.setDeviceData(request.getDeviceData());
        userLoginDto.setHwToken(request.getHwToken());

        //获取ipaddress信息
        String ip = rq.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getRemoteAddr();
        }
        if ("127.0.0.1".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip)){
        	try {
                ip = InetAddress.getLocalHost().getHostAddress();
            }catch (UnknownHostException unknownhostexception) {
            }
        }
        userLoginDto.setIp(ip);
        return userService.loginByVerify(userLoginDto);
    }

    /**
     * 修改密码接口
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/modifyEncrypt",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response modifyEncrypt(ModifyEncryptRequest request){
        ModifyEncryptDto modifyEncryptDto = new ModifyEncryptDto();
        modifyEncryptDto.setUserName(request.getUserName());
        modifyEncryptDto.setOldEncrypt(request.getOldEncrypt());
        modifyEncryptDto.setFirstEncrypt(request.getFirstEncrypt());
        modifyEncryptDto.setSecondEncrypt(request.getSecondEncrypt());
        return userService.modifyEncrypt(modifyEncryptDto);
    }

    /**
     * 设置密码接口
     * @param setEncryptRequest
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/setEncrypt",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response setEncrypt(SetEncryptRequest setEncryptRequest){
        SetEncryptDto setEncryptDto = new SetEncryptDto();
        setEncryptDto.setUserName(setEncryptRequest.getUserName());
        setEncryptDto.setEncrypt(setEncryptRequest.getEncrypt());
        return userService.setEncrypt(setEncryptDto);
    }

    /**
     * 找回密码
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findEncrypt",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response findEncrypt(FindEncryptRequest request){
        FindEncryptDto findEncryptDto = new FindEncryptDto();
        findEncryptDto.setUserName(request.getUserName());
        findEncryptDto.setFirstEncrypt(request.getFirstEncrypt());
        findEncryptDto.setSecondEncrypt(request.getSecondEncrypt());
        return userService.retrieveEncrypt(findEncryptDto);
    }

    /**
     * 获取验证码接口
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/verify",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response verify(VerifyRequest request,HttpServletRequest req){
        //用的容联
        VerifyDto verifyDto = new VerifyDto();
        verifyDto.setAction(request.getAction());
        verifyDto.setMobile(request.getMobile());
        verifyDto.setVerifyCode(request.getVerifyCode());
        if(request.getChannelAdapter()==0){
            // 兼容老版本
            verifyDto.setChannel(ChannelType.NORMAL_SMS.index);
        }else {
            verifyDto.setChannel(request.getChannelAdapter());
        }
        verifyDto.setIsTest(request.getIsTest());
        
       //埋点
       /* if(request.getAction()==0) {
            kafkaService.saveClientLog(request,req.getHeader("User-Agent"),Specification.ClientLogAction.REG_PAGE1_GET_VERIFY);
        }else{
            kafkaService.saveClientLog(request,req.getHeader("User-Agent"),Specification.ClientLogAction.REG_PAGE1_NEXT);
        }*/
        return userService.verify(verifyDto);
    }

    /**
     * 发送中奖信息短信接口
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sendAwardMessage",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response sendAwardMessage(UserAwardRequest request){
        AwardXMDto awardXMDto = new AwardXMDto();
        awardXMDto.setNickName(request.getNickName());
        awardXMDto.setAwardName(request.getAwardName());
        awardXMDto.setMobile(request.getMobile());
        return userService.sendAwardMessage(awardXMDto);
    }

    /**
     * 用户资料修改
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/modifyUserProfile",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response modifyUserProfile(ModifyUserProfileRequest request){
        ModifyUserProfileDto modifyUserProfileDto = new ModifyUserProfileDto();
        modifyUserProfileDto.setGender(request.getGender());
        modifyUserProfileDto.setNickName(request.getNickName());
        modifyUserProfileDto.setYearsId(request.getYearsId());
        modifyUserProfileDto.setUid(request.getUid());
        modifyUserProfileDto.setAvatar(request.getAvatar());
        modifyUserProfileDto.setBirthday(request.getBirthday());
        modifyUserProfileDto.setHobby(request.getHobby());
        modifyUserProfileDto.setIntroduced(request.getIntroduced());
        modifyUserProfileDto.setLikeGender(request.getLikeGender());
        modifyUserProfileDto.setAgeGroup(request.getAgeGroup());
        modifyUserProfileDto.setOccupation(request.getOccupation());
       return userService.modifyUserProfile(modifyUserProfileDto);
    }

    /**
     * 修改用户爱好（暂未启用）
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/modifyUserHobby",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response modifyUserHobby(ModifyUserHobbyRequest request){
        ModifyUserHobbyDto modifyUserHobbyDto = new ModifyUserHobbyDto();
        modifyUserHobbyDto.setUserName(request.getUserName());
        modifyUserHobbyDto.setHobby(request.getHobby());
        return userService.modifyUserHobby(modifyUserHobbyDto);
    }

    /**
     * 获取用户基础数据
     *
     */
    @ResponseBody
    @RequestMapping(value = "/getBasicDataByType",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getBasicDataByType(BasicDataRequest request){
        BasicDataDto basicDataDto = new BasicDataDto();
        basicDataDto.setType(request.getType());
        return userService.getBasicDataByType(basicDataDto);
    }

    /**
     * 获取用户基础数据
     * 全量接口（暂未启用）
     */
    @ResponseBody
    @RequestMapping(value = "/getBasicData",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getBasicData(){
        return userService.getBasicData();
    }

    /**
     * 第三方登录（暂未启用）
     */
    @ResponseBody
    @RequestMapping(value = "/thirdPartAuth",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response thirdPartAuth(ThirdPartAuthRequest request){
        return null;
    }

    /**
     * 收藏夹（废弃）
     */
    @ResponseBody
    @RequestMapping(value = "/favorite",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response favorite(ThirdPartAuthRequest request){
        return null;
    }

    /**
     * 贴标签（废弃）
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/pasteTag",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response pasteTags(TagRequest request){
        PasteTagDto pasteTagDto = new PasteTagDto();
        pasteTagDto.setTag(request.getTag());
        pasteTagDto.setTargetUid(request.getTargetUid());
        pasteTagDto.setFromUid(request.getFromUid());
        return userService.writeTag(pasteTagDto);
    }

    /**
     * 获取用户标签列表（废弃）
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/showUserTags",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response showUserTags(GetTagRequest request){
        return userService.showUserTags(request.getUid());
    }

    /**
     * 获取用户标签点赞（废弃）
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/likes",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response likes(LikesRequest request){
        UserLikeDto userLikeDto = new UserLikeDto();
        userLikeDto.setCustomerId(request.getCustomerId());
        userLikeDto.setTid(request.getTid());
        userLikeDto.setUid(request.getUid());
        return userService.likes(userLikeDto);
    }

    /**
     * 用户消息列表
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/userNotice",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response userNotice(UserNoticeRequest request){
        if(request.getSinceId() <= 0){
            request.setSinceId(Integer.MAX_VALUE);
        }
        UserNoticeDto userNoticeDto = new UserNoticeDto();
        userNoticeDto.setUid(request.getUid());
        userNoticeDto.setSinceId(request.getSinceId());
        userNoticeDto.setLevel(request.getLevel());
        return userService.userNotice(userNoticeDto);
    }

    /**
     * 轮寻方式获取用户消息
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/userTips",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response userTips(ShowUserTipsRequest request){
        return userService.getUserTips(request.getUid());
    }

    /**
     * 轮寻方式获取用户消息
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cleanUserTips",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response cleanUserTips(ShowUserTipsRequest request){
        return userService.cleanUserTips(request.getUid());
    }

    /**
     * 举报接口
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/userReport",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response userReport(UserReportRequest request){
        UserReportDto userReportDto = new UserReportDto();
        userReportDto.setUid(request.getUid());
        userReportDto.setCid(request.getCid());
        userReportDto.setReason(request.getReason());
        userReportDto.setAttachment(request.getAttachment());
        return userService.userReport(userReportDto);
    }

    /**
     * 用户关注|取消关注
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/follow",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response follow(UserFollowRequest request){
        FollowDto followDto = new FollowDto();
        followDto.setAction(request.getAction());
        followDto.setTargetUid(request.getTargetUid());
        followDto.setSourceUid(request.getUid());
        return userService.follow(followDto);
    }

    /**
     * 用户粉丝列表
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/showFans",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response showFans(ShowFansRequest request){
        FansParamsDto fansParamsDto = new FansParamsDto();
        fansParamsDto.setTargetUid(request.getCustomerId());
        fansParamsDto.setUid(request.getUid());
        if(request.getSinceId()==-1) {
            fansParamsDto.setSinceId(Integer.MAX_VALUE);
        }else{
            fansParamsDto.setSinceId(request.getSinceId());
        }
        return userService.getFans(fansParamsDto);
    }

    /**
     * 用户关注列表
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/showFollows",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response showFollows(ShowFansRequest request){
        FollowParamsDto followParamsDto = new FollowParamsDto();
        followParamsDto.setSourceUid(request.getCustomerId());
        followParamsDto.setUid(request.getUid());
        if(request.getSinceId()==-1) {
            followParamsDto.setSinceId(Integer.MAX_VALUE);
        }else{
            followParamsDto.setSinceId(request.getSinceId());
        }
        return userService.getFollows(followParamsDto);
    }

    /**
     * 用户粉丝列表(根据关注时间排序)
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/showFans2",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response showFans2(ShowFansRequest request){
        FansParamsDto fansParamsDto = new FansParamsDto();
        fansParamsDto.setTargetUid(request.getCustomerId());
        fansParamsDto.setUid(request.getUid());
        if(request.getSinceId() <1) {
           request.setSinceId(1);
        }
        fansParamsDto.setSinceId((request.getSinceId() - 1) * 10);
        return userService.getFansOrderByTime(fansParamsDto);
    }

    /**
     * 用户关注列表(根据关注时间排序)
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/showFollows2",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response showFollows2(ShowFansRequest request){
        FollowParamsDto followParamsDto = new FollowParamsDto();
        followParamsDto.setSourceUid(request.getCustomerId());
        followParamsDto.setUid(request.getUid());
        if(request.getSinceId() < 1) {
            request.setSinceId(1);
        }
        followParamsDto.setSinceId((request.getSinceId() - 1) * 10);
        return userService.getFollowsOrderByTime(followParamsDto);
    }

    /**
     * 用户关注列表(在直播中启用)
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getUser",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getUser(UserRequest request){
        return userService.getUser(request.getTargetUid(),request.getUid());
    }

    /**
     * 获取用户信息
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getUserProfile",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getUserProfile(UserProfileRequest request){
    	int vflag = 0;
        if(VersionUtil.isNewVersion(request.getVersion(), "2.2.0")){
        	vflag = 1;
        }
        return userService.getUserProfile(request.getUid(), vflag);
    }

    /**
     * 初始化me号
     * @param request
     */
    @ResponseBody
    @RequestMapping(value = "/init",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public void init(ActivityRequest request){
        userService.initUserNumber(request.getSinceId());
    }

    /**
     * 前台获取版本信息
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/versionControl",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response versionControl(VersionControlRequest request ,HttpServletRequest rq){
        //获取ipaddress信息
        String ip = rq.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
            ip = rq.getHeader("Proxy-Client-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
            ip = rq.getHeader("WL-Proxy-Client-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
            ip = rq.getHeader("HTTP_CLIENT_IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
            ip = rq.getHeader("HTTP_X_FORWARDED_FOR");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        	ip = rq.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
            ip = rq.getRemoteAddr();
        if ("127.0.0.1".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip))
            try {
                ip = InetAddress.getLocalHost().getHostAddress();
            }
            catch (UnknownHostException unknownhostexception) {
            }
        return userService.versionControl(request.getVersion(),request.getPlatform(),ip,request.getChannel(),request.getDevice());
    }

    /**
     * 后台添加版本信息(运营使用，暂未启用)
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateVersion",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response updateVersion(UpdateVersionRequest request){
        VersionDto controlDto = new VersionDto();
        controlDto.setUpdateUrl(request.getUpdateUrl());
        controlDto.setVersion(request.getVersion());
        controlDto.setPlatform(request.getPlatform());
        controlDto.setUpdateDescription(request.getUpdateDescription());
        return userService.updateVersion(controlDto);
    }

    /**
     * 给老徐提供查询人员信息接口
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getSpecialUserProfile",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getSpecialUserProfile(SpecialUserProfileRequest request){
        return userService.getSpecialUserProfile(request.getUid());
    }

    /**
     * 后台设置大V接口(运营使用，暂未启用)
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/userExcellent",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response userExcellent(UserExcellentRequest request){
        return userService.setUserExcellent(request.getUid());
    }

    /**
     * 退出接口
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/logout",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response logout(LogoutRequest request){
        return userService.logout(request.getUid());
    }

    /**
     * s生成推广二维码
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/qrcoe",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response circle(QrCodeRequest request){
        return userService.genQRcode(request.getUid());
    }

    /**
     * 推广用户注册
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/refereeSignUp",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response refereeSignUp(RefereeSignUpRequest request){
        UserRefereeSignUpDto userRefereeSignUpDto = new UserRefereeSignUpDto();
        userRefereeSignUpDto.setMobile(request.getMobile());
        userRefereeSignUpDto.setGender(request.getGender());
        userRefereeSignUpDto.setStar(request.getStart());
        userRefereeSignUpDto.setEncrypt(request.getEncrypt());
        userRefereeSignUpDto.setNickName(request.getNickName());
        userRefereeSignUpDto.setDeviceNo(request.getDeviceNo());
        userRefereeSignUpDto.setPlatform(request.getPlatform());
        userRefereeSignUpDto.setOs(request.getOs());
        userRefereeSignUpDto.setIntroduced(request.getIntroduced());
        userRefereeSignUpDto.setRefereeUid(request.getRefereeUid());
        return userService.refereeSignUp(userRefereeSignUpDto);
    }

//    /**
//     * 推广页面获取用户信息
//     * @param request
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "/getUserProfile4H5",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
//    public Response getUserProfile4H5(GetUserProfile4H5Request request){
//        return userService.getUserProfile4H5(request.getUid());
//    }

    @ResponseBody
    @RequestMapping(value = "/getRefereeProfile",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getRefereeProfile(UserProfileRequest request){
        return userService.getRefereeProfile(request.getUid());
    }

    /**
     * 第三方登录接口
     */
    @ResponseBody
    @RequestMapping(value = "/thirdPartLogin",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response thirdPartLogin(ThirdPartRequest request, HttpServletRequest rq){
        ThirdPartSignUpDto dto = new ThirdPartSignUpDto();
        dto.setThirdPartOpenId(request.getThirdPartOpenId());
        dto.setThirdPartToken(request.getThirdPartToken());
        dto.setAvatar(request.getAvatar());
        dto.setThirdPartType(request.getThirdPartType());
        dto.setNickName(request.getNickName());
        dto.setGender(request.getGender());
        dto.setJPushToken(request.getJPushToken());
        dto.setUnionId(request.getUnionId());
        dto.setH5type(request.getH5type());
        dto.setNewNickName(request.getNewNickName());
        dto.setChannel(request.getChannel());
        dto.setPlatform(request.getPlatform());
        dto.setRegisterVersion(request.getVersion());
        dto.setParams(request.getParams());
        dto.setOpeninstallData(request.getOpeninstallData());
        dto.setDeviceData(request.getDeviceData());
        dto.setFromUid(request.getFromUid());
        dto.setFromTopicId(request.getFromTopicId());
        dto.setHwToken(request.getHwToken());

        //获取ipaddress信息
        String ip = rq.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        	ip = rq.getRemoteAddr();
        }
        if ("127.0.0.1".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip)){
        	try {
                ip = InetAddress.getLocalHost().getHostAddress();
            }catch (UnknownHostException unknownhostexception) {
            }
        }
        dto.setIp(ip);
        
        if(StringUtils.isEmpty(request.getChannel())){
        	log.info("三方登录无渠道=["+request.getNickName()+"],["+request.getChannel()+"],["+request.getVersion()+"],["+request.getPlatform()+"],["+request.getOpeninstallData()+"]");
        }else{
        	log.info("三方登录有渠道=["+request.getNickName()+"],["+request.getChannel()+"],["+request.getVersion()+"],["+request.getPlatform()+"],["+request.getOpeninstallData()+"]");
        }
        
        return userService.thirdPartLogin(dto);
    }

    /**
     * 广告模式接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/activityModel",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response activityModel(){
        ActivityModelDto dto = new ActivityModelDto();
        return userService.activityModel(dto);
    }

    /**
     * 检查用户名是否存在接口，判断OPENID是否存在是否还需要上传头像接口
     */
    @ResponseBody
    @RequestMapping(value = "/checkNameOpenId",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response checkNickName(CheckRequest request){
        UserNickNameDto userNickNameDto = new UserNickNameDto();
        if(request.getNickName()!=null) {
            userNickNameDto.setNickName(request.getNickName());
        }else {
            userNickNameDto.setOpenid(request.getOpenId());
            userNickNameDto.setUnionId(request.getUnionId());
            userNickNameDto.setThirdPartType(request.getThirdPartType());
        }
        return userService.checkNameOpenId(userNickNameDto);
    }

    /**
     * 绑定接口
     */
    @ResponseBody
    @RequestMapping(value = "/bind",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response bind(ThirdPartRequest request){
        ThirdPartSignUpDto dto = new ThirdPartSignUpDto();
        dto.setUid(request.getUid());
        dto.setThirdPartType(request.getThirdPartType());
        dto.setMobile(request.getMobile());
        dto.setEncrypt(request.getEncrypt());
        dto.setThirdPartOpenId(request.getThirdPartOpenId());
        dto.setThirdPartToken(request.getThirdPartToken());
        dto.setUnionId(request.getUnionId());
        return userService.bind(dto);
    }

    /**
     * 禁言接口
     */
    @ResponseBody
    @RequestMapping(value = "/gag",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response gag(GagRequest request){
        GagDto dto = (GagDto) CommonUtils.copyDto(request,new GagDto());

        return userService.gag(dto);
    }

    /**
     * 获取入口页配置接口
     */
    @ResponseBody
    @RequestMapping(value = "/entryPageConfig",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response entryPageConfig(EntryPageRequest request){

        EntryPageDto dto = (EntryPageDto) CommonUtils.copyDto(request,new EntryPageDto());

        return userService.getEntryPageConfig(dto);
    }
    /**
     * 上大V接口
     */
//    @ResponseBody
//    @RequestMapping(value = "/addV",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
//    public Response addV(UserInfoRequest request){
//        UserVDto vDto = new UserVDto();
//        vDto.setCustomerId(request.getCustomerId());
//        return userService.addV(vDto);
//    }

    /**
     * 游客模式登录(app)
     */
    @ResponseBody
    @RequestMapping(value = "/touristLogin",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response touristLogin(){
        return userService.touristLogin();
    }

    /**
     * 推送测试入口
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/testPush",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response testPush(TestPushRequest request){
    	return userService.testPush(request.getUid(), request.getMsg(), request.getJsonData());
    }

    /**
     * 用户推荐接口
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/Recommend",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response userRecomm(UserFamousRequest request){
        return userService.userRecomm(request.getUid() ,request.getTargetUid() ,request.getAction());
    }

    /**
     * 万普广告用户登记接口
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/IOSWapxUserRegist",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseWapx iosWapxUserRegist(WapxIosRequest request){
        WapxIosDto dto = new WapxIosDto();
        try {
            request.setCallbackurl(URLDecoder.decode(request.getCallbackurl() ,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        CommonUtils.copyDto(request ,dto);
        return userService.iosWapxUserRegist(dto);
    }

    /**
     * IM 获取token
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getIMUsertoken",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getIMUsertoken(UserInfoRequest request){
        return userService.imUsertoken(request.getCustomerId());
    }

    /**
     * 全量注册userId接口(慎用)
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/registAllIMtoken",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response registAllIMtoken(){
        return userService.registAllIMtoken();
    }

    /**
     * 手机联系人查询接口
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/mobileQuery",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response mobileQuery(MobileQueryRequest request){
    	return userService.mobileQuery(request.getMobiles(), request.getUid());
    }
    
    /**
     * 通讯录查询接口
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/contacts",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response contacts(ContactsRequest request){
    	return userService.contacts(request.getPage(), request.getMobiles(), request.getUid());
    }
    
    /**
     * 求关注列表接口
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/seekFollowsQuery",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response seekFollowsQuery(SeekFollowsQueryRequest request){
    	return userService.seekFollowsQuery(request.getUid(), request.getSinceId());
    }
    
    /**
     * 求关注操作接口
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/seekFollow",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response seekFollow(SeekFollowRequest request){
    	return userService.seekFollow(request.getUid());
    }
    
    /**
     * 我的关注列表查询接口（按首字母分组）
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/myFollowsQuery",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response myFollowsQuery(MyFollowsQueryRequest request){
    	return userService.myFollowsQuery(request.getUid(), request.getName(), request.getPage());
    }
    
    /**
     * 批量关注接口
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/batchFollow",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response batchFollow(BatchFollowRequest request){
    	return userService.batchFollow(request.getUid(), request.getTargetUids());
    }
    
    /**
     * 用户画像属性修改接口
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/personaModify",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response personaModify(PersonaModifyRequest request){
    	return userService.personaModify(request.getUid(), request.getType(), request.getParams());
    }
    
    /**
     * 通用发短信接口(测试用)
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/commonSendMsg",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response commonSendMsg(CommonSendMsgRequest request){
    	return userService.testSendMessage(request.getTemplateId(), request.getMobiles());
    }
    
    
    /**
     * 通知红点查询接口
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/noticeReddotQuery",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response noticeReddotQuery(NoticeReddotQueryRequest request){
    	return userService.noticeReddotQuery(request.getUid());
    }
    
    /**
     * 查询MBTI测试结果。
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getMBTIResult",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getMBTIResult(MBTIRequest request){
    	return userService.getMBTIResult(request.getCustomUid());
    }
    /**
     * 通知红点查询接口
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/saveMBTIResult",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response saveMBTIResult(MBTIRequest request){
    	return userService.saveMBTIResult(request.getUid(),request.getMbti());
    }
    /**
     * 通知红点查询接口
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/saveMBTIShareResult",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response saveMBTIShareResult(MBTIRequest request){
    	return userService.saveMBTIShareResult(request.getUid());
    }
    
    /**
     * 坐标情绪信息查询接口
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getEmotionInfoByValue",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getEmotionInfoByValue(EmotionInfoRequest request){
    	return contentService.getEmotionInfoByValue(request.getHappyValue(), request.getFreeValue());
    }
    
    /**
     * 情绪确定接口
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/submitEmotion",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response submitEmotion(EmotionRecordRequest request){
    	return liveService.submitEmotion(request.getUid(), request.getSource(), request.getEmotionId(), request.getHappyValue(), request.getFreeValue());
    }
    
    /**
     * 最近一次情绪信息查询接口
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getLastEmotionInfo",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getLastEmotionInfo(LastEmotionRequest request){
    	return contentService.getLastEmotionInfo(request.getUid());
    }
    /**
     * 周总结查询接口
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getSummaryEmotionInfo",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getSummaryEmotionInfo(SummaryEmotionInfoRequest request){
    	return userService.getSummaryEmotionInfo(request.getUid(),request.getTime());
    }
    
    /**
     * 开启新的一周情绪接口
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/startNewEmotionInfo",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response startNewEmotionInfo(StartNewEmotionInfoRequest request){
    	return liveService.startNewEmotionInfo(request.getUid(),request.getSource(),request.getImage(),request.getW(),request.getH());
    }
    
    /**
     * 情绪信息列表查询接口
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/emotionInfoList",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public Response emotionInfoList(EmotionInfoListRequest request){
		return liveService.emotionInfoList();
	}


    @ResponseBody
    @RequestMapping(value = "/rechargeToKingdom",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response rechargeToKingdom(RechargeToKingdomRequest request){
	    RechargeToKingdomDto rechargeToKingdomDto = new RechargeToKingdomDto();
	    rechargeToKingdomDto.setAmount(request.getCoin());
	    rechargeToKingdomDto.setTopicId(request.getTopicId());
	    rechargeToKingdomDto.setUid(request.getUid());
        return liveService.rechargeToKingdom(rechargeToKingdomDto);
    }


    @ResponseBody
    @RequestMapping(value = "/getLevelList",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getLevelList(){
        return userService.getLevelList();
    }

    @ResponseBody
    @RequestMapping(value = "/getMyLevel",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getMyLevel(GetMyLevelRequest request){

        return userService.getMyLevel(request.getUid());
    }

    @ResponseBody
    @RequestMapping(value = "/afterShare",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response afterShare(AfterShareRequest request){
        ModifyUserCoinDto modifyUserCoinDto = userService.coinRule(request.getUid(), userService.getCoinRules().get(Rules.SHARE_KING_KEY));
        Response response = Response.success(ResponseStatus.ADD_COIN_SUCCESS.status,ResponseStatus.ADD_COIN_SUCCESS.message);
        response.setData(modifyUserCoinDto);
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/blacklist",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response blacklist(BlacklistRequest request){
    	return userService.blacklist(request.getUid(), request.getTargetUid(), request.getAction());
    }
    
    @ResponseBody
    @RequestMapping(value = "/getGuideInfo",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getGuideInfo(GuideInfoRequest request){
    	return userService.getGuideInfo();
    }


    /**
     * 信息补全完整领取红包接口
     * @param obtainRedBagRequest
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/obtainRedBag",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response obtainRedBag(ObtainRedBagRequest obtainRedBagRequest){
        ObtainRedBagDto obtainRedBagDto = new ObtainRedBagDto();
        obtainRedBagDto.setUid(obtainRedBagRequest.getUid());
        return userService.obtainRedBag(obtainRedBagDto);
    }

    /**
     * 是否领取过补全信息红包
     * @param obtainRedBagRequest
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/isObtainRedBag",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response isObtainRedBag(ObtainRedBagRequest obtainRedBagRequest){
        IsObtainRedBag isObtainRedBag =  new IsObtainRedBag();
        isObtainRedBag.setUid(obtainRedBagRequest.getUid());
        return userService.isObtainRedBag(isObtainRedBag);
    }

    /**
     * 邀请奖励领取接口
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/awardByInvitation",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response awardByInvitation(AwardByInvitationRequest request){
    	return userService.awardByInvitation(request.getUid(), request.getFromUid(), request.getType());
    }
}