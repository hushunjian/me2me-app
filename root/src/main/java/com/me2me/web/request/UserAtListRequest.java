package com.me2me.web.request;

import lombok.Getter;
import lombok.Setter;

import com.me2me.common.web.Request;

public class UserAtListRequest extends Request {

	@Getter
    @Setter
	private String keyword;
	@Getter
    @Setter
	private int page;
	@Getter
    @Setter
	private long topicId;
}
