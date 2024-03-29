package com.me2me.web.request;

import com.me2me.common.web.Request;
import lombok.Getter;
import lombok.Setter;

/**
 * 上海拙心网络科技有限公司出品
 * Author: 代宝磊
 * Date: 2016/2/29
 * Time :9:51
 */
public class VerifyRequest extends Request{


    @Getter
    @Setter
    private int action;

    @Getter
    @Setter
    private String mobile;

    @Getter
    @Setter
    private String verifyCode;

    @Getter
    @Setter
    private int channelAdapter;
    
    @Getter
    @Setter
    private int isTest;
}
