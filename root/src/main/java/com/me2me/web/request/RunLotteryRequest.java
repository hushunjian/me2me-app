package com.me2me.web.request;

import lombok.Getter;
import lombok.Setter;

import com.me2me.common.web.Request;

public class RunLotteryRequest extends Request {

	@Getter
    @Setter
	private long lotteryId;
	@Getter
    @Setter
	private int  source;
}
