package com.me2me.web.request;

import com.me2me.common.web.Request;
import lombok.Getter;
import lombok.Setter;

/**
 * 上海拙心网络科技有限公司出品
 * Author: 代宝磊
 * Date: 2016/4/13
 * Time :17:57
 */
public class SetLiveRequest extends Request {

    @Getter
    @Setter
    private long uid;

    @Getter
    @Setter
    private long topicId;

    @Getter
    @Setter
    private long topId;

    @Getter
    @Setter
    private long bottomId;

    @Getter
    @Setter
    private int action;
}
