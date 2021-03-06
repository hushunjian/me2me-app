package com.me2me.activity.dto;

import com.me2me.common.web.BaseEntity;
import lombok.Data;

/**
 * 上海拙心网络科技有限公司出品
 * Author: 赵朋扬
 * Date: 2016/4/26.
 */
@Data
public class CreateActivityNoticeDto implements BaseEntity {

    private long id;

    private String activityNoticeTitle;

    private String activityNoticeCover;

    private String activityResult;

}
