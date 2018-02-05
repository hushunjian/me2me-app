package com.me2me.web.request;

import lombok.Getter;
import lombok.Setter;

import com.me2me.common.web.Request;

public class DetailFidPageRequest extends Request {

	@Getter
    @Setter
	private long topicId;
	@Getter
    @Setter
	private long fid;
	@Getter
    @Setter
	private int offset;
}
