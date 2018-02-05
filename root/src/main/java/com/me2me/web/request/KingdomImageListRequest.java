package com.me2me.web.request;

import lombok.Getter;
import lombok.Setter;

import com.me2me.common.web.Request;

public class KingdomImageListRequest extends Request {

	@Getter
    @Setter
	private long topicId;
	@Getter
    @Setter
	private String month;
}
