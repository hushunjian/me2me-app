package com.me2me.web.request;

import lombok.Getter;
import lombok.Setter;

import com.me2me.common.web.Request;

public class CheckUserActivityKindomRequest extends Request {

	@Getter
	@Setter
	private int type;
	@Getter
	@Setter
	private long uid2;
	@Getter
	@Setter
	private long activityId;
}
