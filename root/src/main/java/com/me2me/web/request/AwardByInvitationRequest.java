package com.me2me.web.request;

import lombok.Getter;
import lombok.Setter;

import com.me2me.common.web.Request;

public class AwardByInvitationRequest extends Request {

	@Getter
    @Setter
	private long fromUid;
	@Getter
    @Setter
	private int type;
}
