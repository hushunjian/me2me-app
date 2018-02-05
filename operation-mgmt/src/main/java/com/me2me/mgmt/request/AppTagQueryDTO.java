package com.me2me.mgmt.request;

import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;
import com.me2me.mgmt.vo.DatatablePage;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class AppTagQueryDTO extends DatatablePage{

	@Getter
    @Setter
	private String tagName;
	@Getter
    @Setter
	private String startTime;
	@Getter
    @Setter
	private String endTime;
	@Getter
    @Setter
	private int isSys = -1;
	@Getter
    @Setter
	private int isRec = -1;
	@Getter
    @Setter
	private String topicCountStart;
	@Getter
    @Setter
	private String topicCountEnd;
	@Getter
	@Setter
	private int page = 1;
	@Getter
	@Setter
	private int pageSize = 10;
	
	@Getter
	@Setter
	private int noParent=0;
	
	@Getter
    @Setter
	private int totalCount = 0;
	@Getter
    @Setter
	private int totalPage = 0;
	
	@Getter
    @Setter
    private Integer pid;
}
