package com.me2me.live.dto;

import com.me2me.common.web.BaseEntity;
import lombok.Data;

/**
 * 上海拙心网络科技有限公司出品
 * Author: chenxiang
 * Date: 2017-09-05
 */
@Data
public class SendGiftDto implements BaseEntity {

    public long fragmentId;
    
    public int count;
    
    public int remainPrice;

}
