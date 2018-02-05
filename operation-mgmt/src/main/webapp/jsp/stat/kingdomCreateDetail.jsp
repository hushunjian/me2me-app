﻿<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="../common/meta.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta charset="utf-8" />

<title>ZX_IMS 2.0 - 王国创建明细统计</title>

<link href="${ctx}/css/bootstrap.min.css" rel="stylesheet" />
<link href="${ctx}/css/bootstrap-reset.css" rel="stylesheet" />
<link href="${ctx}/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href="${ctx}/assets/advanced-datatable/media/css/demo_page.css" rel="stylesheet" />
<link href="${ctx}/assets/advanced-datatable/media/css/demo_table.css" rel="stylesheet" />
<link rel="stylesheet" href="${ctx}/assets/data-tables/DT_bootstrap.css" />
<link href="${ctx}/css/slidebars.css" rel="stylesheet" />
<link href="${ctx}/css/style.css" rel="stylesheet" />
<link href="${ctx}/css/style-responsive.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="${ctx}/assets/bootstrap-datetimepicker/css/datetimepicker.css" />

<script src="${ctx}/js/jquery.js"></script>
<script src="${ctx}/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="${ctx}/js/jquery-migrate-1.2.1.min.js"></script>
<script src="${ctx}/js/bootstrap.min.js"></script>
<script type="text/javascript">
var pageSize = 10;

var currentPage = 1;

var getCurrentPage = function(){
	return currentPage;
}

var setCurrentPage = function(num){
	currentPage = currentPage + num;
}

//上一页
var previous = function(){
	var currPage = getCurrentPage();
	if(currPage <= 1){
		return;
	}
	var page = currPage-1;
	
	$.ajax({
		url : "${ctx}/stat/kingdomCreate/detail/page?nickName="+$("#nickName").val()+"&channelCode="+$("#channelCode").val()+"&startTime="+$("#startTime").val()+"&endTime="+$("#endTime").val()+"&page="+page+"&pageSize="+pageSize,
		async : false,
		type : "GET",
		contentType : "application/json;charset=UTF-8",
		success : function(resp) {
			setCurrentPage(-1);
			buildTable(resp);
		}
	});
}

//下一页
var next = function(type){
	var currPage = getCurrentPage();
	var totalPage = $("#totalPage").val();
	if(currPage >= totalPage){
		return;
	}
	var page = currPage+1;
	
	$.ajax({
		url : "${ctx}/stat/kingdomCreate/detail/page?nickName="+$("#nickName").val()+"&channelCode="+$("#channelCode").val()+"&startTime="+$("#startTime").val()+"&endTime="+$("#endTime").val()+"&page="+page+"&pageSize="+pageSize,
		async : false,
		type : "GET",
		contentType : "application/json;charset=UTF-8",
		success : function(resp) {
			setCurrentPage(1);
			buildTable(resp);
		}
	});
}

var buildTable = function(resp){
	var result = eval("("+resp+")");
	var currentPage = getCurrentPage();
	totalPage = $("#totalPage").val();
	if(result){
		buildTableBody(result.result);
	}
	
	//记录分页信息
	$("#DataTables_Table_info").html("当前第 "+currentPage+" 页，共 "+totalPage+" 页");
	$("#prev").removeClass("disabled");
	$("#next").removeClass("disabled");
	if(currentPage == 1){
		$("#prev").addClass("disabled");
	}
	if(currentPage >= totalPage){
		$("#next").addClass("disabled");
	}
}

var buildTableBody = function(dataList){
	var bodyHtml = "";
	if(dataList && dataList.length > 0){
		for(var i=0;i<dataList.length;i++){
			bodyHtml = bodyHtml + "<tr class=\"gradeX\">";
			bodyHtml = bodyHtml + "<th>"+dataList[i].topicId+"</th>";
			bodyHtml = bodyHtml + "<th>"+dataList[i].title+"</th>";
			bodyHtml = bodyHtml + "<th><a href=\""+dataList[i].h5Addr+"\" target=\"view_window\">"+dataList[i].h5Addr+"</a></th>";
			bodyHtml = bodyHtml + "<th>"+dataList[i].updateCount+"</th>";
			bodyHtml = bodyHtml + "<th>"+dataList[i].memberCount+"</th>";
			bodyHtml = bodyHtml + "<th>"+dataList[i].uid+"</th>";
			bodyHtml = bodyHtml + "<th>"+dataList[i].nickName+"</th>";
			bodyHtml = bodyHtml + "<th>"+dataList[i].registerMode+"</th>";
			bodyHtml = bodyHtml + "<th>"+parserDatetimeStr(new Date(dataList[i].registerDate))+"</th>";
			bodyHtml = bodyHtml + "<th>"+dataList[i].channel+"</th>";
			bodyHtml = bodyHtml + "<th>";
			if(dataList[i].platform == 1){
				bodyHtml = bodyHtml + "安卓";
			}else if(dataList[i].platform == 2){
				bodyHtml = bodyHtml + "IOS";
			}else if(dataList[i].platform == 3){
				bodyHtml = bodyHtml + "H5";
			}else{
				bodyHtml = bodyHtml + "未知";
			}
			bodyHtml = bodyHtml + "</th>";
			bodyHtml = bodyHtml + "</tr>";
		}
	}
	$("#tbody").html(bodyHtml);
}

var parserDatetimeStr = function(time){
	var year=time.getYear()+1900;
	var m=time.getMonth()+1;
	var month;
	if(m<10){
		month = "0" + m;
	}else{
		month = "" + m;
	}
	var d=time.getDate();
	var date;
	if(d<10){
		date = "0" + d;
	}else{
		date = "" + d;
	}
	var h=time.getHours();
	var hour;
	if(h<10){
		hour = "0" + h;
	}else{
		hour = "" + h;
	}
	var mm=time.getMinutes();
	var minute;
	if(mm<10){
		minute = "0" + mm;
	}else{
		minute = "" + mm;
	}
	var s=time.getSeconds();
	var second;
	if(s<10){
		second = "0" + s;
	}else{
		second = "" + s;
	}
	return year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
}

var errMsg = '${errMsg}';
if(errMsg && errMsg != 'null' && errMsg != ''){
	alert(errMsg);
}
</script>
</head>
<body>
	<section id="container" class="">
		<!--header start-->
		<%@include file="../common/header.jsp"%>
		<!--header end-->

		<!--sidebar start-->
		<jsp:include page="../common/leftmenu.jsp" flush="false">
			<jsp:param name="t" value="3" />
			<jsp:param name="s" value="3_8" />
		</jsp:include>
		<!--sidebar end-->

		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<form id="form1" action="${ctx}/stat/kingdomCreate/detail/query" method="post">
					<div class="row">
						<div class="col-lg-12">
							<section class="panel">
								<header class="panel-heading">执行操作</header>
								<div class="panel-body">
									<div class="form-inline" role="form">
										渠道标识
										<input type="text" id="channelCode" name="channelCode" value="${dataObj.channelCode }" class="form-control">&nbsp;&nbsp;
										昵称
										<input type="text" id="nickName" name="nickName" value="${dataObj.nickName }" class="form-control">&nbsp;&nbsp;
										开始时间
										<input type="text" id="startTime" name="startTime" value="${dataObj.startTime }" class="form-control" required>&nbsp;&nbsp;
										结束时间
										<input type="text" id="endTime" name="endTime" value="${dataObj.endTime }" class="form-control" required>&nbsp;&nbsp;
										<input type="submit" id="btnSearch" name="btnSearch" value="搜索" class="btn btn-info" />
									</div>
								</div>
							</section>
						</div>
					</div>
				</form>
				<!-- page start-->
				<div class="row">
					<div class="col-sm-12">
						<section class="panel">
							<header class="panel-heading">
								| 王国详细
								<span class="tools pull-right">
									<a href="javascript:;" class="fa fa-chevron-down"></a>
								</span>
							</header>
							<div class="panel-body">
								<div class="adv-table">
									<table class="display table table-bordered table-striped" id="table">
										<thead>
											<tr>
												<th>王国ID</th>
												<th>王国名</th>
												<th>H5链接</th>
												<th>王国更新数</th>
												<th>王国成员数</th>
												<th>用户ID</th>
												<th>用户名</th>
												<th>账号类型</th>
												<th>注册时间</th>
												<th>渠道</th>
												<th>终端类型</th>
											</tr>
										</thead>
										<tbody id="tbody">
											<c:forEach items="${dataObj.result}" var="item">
												<tr class="gradeX">
													<th>${item.topicId }</th>
													<th>${item.title }</th>
													<th><a href="${item.h5Addr }" target="view_window">${item.h5Addr }</a></th>
													<th>${item.updateCount }</th>
													<th>${item.memberCount }</th>
													<th>${item.uid }</th>
													<th>${item.nickName }</th>
													<th>${item.registerMode }</th>
													<th><fmt:formatDate value="${item.registerDate }" pattern="yyyy-MM-dd HH:mm:ss"/></th>
													<th>${item.channel }</th>
													<th>
													<c:choose>
                                                		<c:when test="${item.platform == '1'}">
                                                			安卓
                                                		</c:when>
                                                		<c:when test="${item.platform == '2'}">
                                                			IOS
                                                		</c:when>
                                                		<c:when test="${item.platform == '3'}">
                                                			H5
                                                		</c:when>
                                                		<c:otherwise>
                                                			未知
                                                		</c:otherwise>
                                                	</c:choose>
													</th>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<input type="hidden" id="totalPage" value="${dataObj.totalPage }" >
								</div>
								<div id="bottomTool" class="row-fluid">
									<div class="span6">
										<div id="DataTables_Table_info" class="dataTables_info">当前第 1 页，共 ${dataObj.totalPage } 页</div>
									</div>
									<div class="span6">
										<div class="dataTables_paginate paging_bootstrap pagination">
											<ul id="previousNext">
												<li id="prev" onclick="previous()" class="prev disabled"><a href="#">上一页</a></li>
												<li id="next" onclick="next()" class="next ${dataObj.totalPage<=1?'disabled':''}"><a href="#">下一页</a></li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</section>
					</div>
				</div>
				<!-- page end-->
			</section>
		</section>
		<!--main content end-->

		<!-- Right Slidebar start -->
		<%@include file="../common/rightSlidebar.jsp"%>
		<!-- Right Slidebar end -->

		<!--footer start-->
		<%@include file="../common/footer.jsp"%>
		<!--footer end-->
	</section>
	<!-- js placed at the end of the document so the pages load faster -->
	<script class="include" type="text/javascript" src="${ctx}/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="${ctx}/js/jquery.scrollTo.min.js"></script>
	<script src="${ctx}/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script type="text/javascript" src="${ctx}/assets/advanced-datatable/media/js/jquery.dataTables.js"></script>
	<script type="text/javascript" src="${ctx}/assets/data-tables/DT_bootstrap.js"></script>
	<script src="${ctx}/js/respond.min.js"></script>
	<script src="${ctx}/js/slidebars.min.js"></script>
	<script src="${ctx}/js/bootstrap-switch.js"></script>
	<script src="${ctx}/js/jquery.tagsinput.js"></script>
	<script src="${ctx}/js/form-component.js"></script>
	<script src="${ctx}/js/common-scripts.js"></script>
	<script src="${ctx}/js/advanced-form-components.js"></script>
		<script type="text/javascript" src="${ctx}/assets/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript">
	$.fn.datetimepicker.dates['zh'] = {  
            days:       ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六","星期日"],  
            daysShort:  ["日", "一", "二", "三", "四", "五", "六","日"],  
            daysMin:    ["日", "一", "二", "三", "四", "五", "六","日"],  
            months:     ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月","十二月"],  
            monthsShort:  ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"],  
            meridiem:    ["上午", "下午"],  
            //suffix:      ["st", "nd", "rd", "th"],  
            today:       "今天"  
    };
	$('#startTime').datetimepicker({
		format: 'yyyy-mm-dd',
		language: 'zh',
		startView: 2,
		autoclose:true,
		weekStart:1,
		todayBtn:  1,
		minView:2
		});
	$('#endTime').datetimepicker({
		format: 'yyyy-mm-dd',
		language: 'zh',
		startView: 2,
		autoclose:true,
		weekStart:1,
		todayBtn:  1,
		minView:2
		});
	</script>
</body>
</html>