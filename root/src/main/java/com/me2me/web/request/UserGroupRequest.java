package com.me2me.web.request;

import com.me2me.common.web.Request;
import lombok.Getter;
import lombok.Setter;

/**
 * 上海拙心网络科技有限公司出品
 * Author: chenxiang
 * Date: 2017/9/21
 * Time :10:03
 */
public class UserGroupRequest extends Request{

    @Setter
    @Getter
    private long cid;
}
