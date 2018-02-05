package com.me2me.live.dto;

import com.google.common.collect.Lists;
import com.me2me.common.web.BaseEntity;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 上海拙心网络科技有限公司出品
 * Author: 代宝磊
 * Date: 2016/4/11
 * Time :18:28
 */
@Data
public class LiveTimeLineDto implements BaseEntity {

    private  List<LiveElement> liveElements = Lists.newArrayList();

    public static LiveElement createElement(){
        return new LiveElement();
    }

    @Data
    public static class LiveElement implements BaseEntity {

        private long uid;

        private String nickName;

        private int isFollowed;

        private long fragmentId;

        private Date createTime;

        private int contentType;

        private int type;

        private String fragment;

        private String fragmentImage;

        private String avatar;
        
        private String avatarFrame;

        private long id;

        private int internalStatus;

        private long atUid;

        private String atNickName;

        private int source;

        private String extra;

        private int v_lv;

        private int level;

        private int status;
        
        private int teaseStatus;
        
        private int giftStatus;
        
        private int score;

    }

}
