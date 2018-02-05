﻿<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="../common/meta.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta charset="utf-8" />

<title>ZX_IMS 2.0 - 机器人列表</title>

<link href="${ctx}/css/bootstrap.min.css" rel="stylesheet" />
<link href="${ctx}/css/bootstrap-reset.css" rel="stylesheet" />
<link href="${ctx}/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href="${ctx}/assets/advanced-datatable/media/css/demo_page.css" rel="stylesheet" />
<link href="${ctx}/assets/advanced-datatable/media/css/demo_table.css" rel="stylesheet" />
<link rel="stylesheet" href="${ctx}/assets/data-tables/DT_bootstrap.css" />
<link href="${ctx}/css/slidebars.css" rel="stylesheet" />
<link href="${ctx}/css/style.css" rel="stylesheet" />
<link href="${ctx}/css/style-responsive.css" rel="stylesheet" />
<link rel="stylesheet" href="${ctx}/js/DataTables-1.10.11/media/css/jquery.dataTables.min.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/assets/bootstrap-datetimepicker/css/datetimepicker.css" />
<script src="${ctx}/js/jquery.js"></script>
<script src="${ctx}/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="${ctx}/js/jquery-migrate-1.2.1.min.js"></script>
<script src="${ctx}/js/bootstrap.min.js"></script>
</head>
<body>
	<section id="container" class="">
		<!--header start-->
		<%@include file="../common/header.jsp"%>
		<!--header end-->

		<!--sidebar start-->
		<jsp:include page="../common/leftmenu.jsp" flush="false">
			<jsp:param name="t" value="12" />
			<jsp:param name="s" value="12_7" />
		</jsp:include>
		<!--sidebar end-->

		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
			
			<form id="form2" action="${ctx}/tag/query" method="post">
					<div class="row">
						<div class="col-lg-12">
							<section class="panel">
								<header class="panel-heading">搜索</header>
								<div class="panel-body">
									<div class="form-inline" role="form">
										用户昵称：
										<input type="text" id="nickName" name="nickName" value="" class="form-control">&nbsp;
						<label for="exampleInputEmail1">类型</label>
						<select id="stype" name="stype" class="form-control" >
							<option value="-1" selected>全部</option>
						 <option value="0">机器人</option>
						 <option value="1">日签</option>
						</select>
										<a class="btn btn-primary" href="javascript:search();">搜索</a>
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
								| 机器人列表
								<span class="tools pull-right">
									<a href="javascript:;" class="fa fa-chevron-down"></a>
								</span>
							</header>
							<div class="panel-body">
								<div>
									<a class="btn btn-primary" href="javascript:addRobot()">
										<i  class=" fa fa-plus "></i>
										添加机器人
									</a>
								</div>
								<br>
								<div class="adv-table">
								<table class="display table table-bordered table-striped" id="mytable" width="100%">
		                           	</table>
								</div>
							</div>
						</section>
					</div>
				</div>
				<div class="modal inmodal fade" id="modal" tabindex="-1"	role="dialog" aria-hidden="true">
					<div class="modal-dialog modal-lg">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
								</button>
									用户列表
							</div>
							<div class="modal-body">
								<form id="form2" action="${ctx}/tag/query" method="post" class="form form-inline">
										<div class="form-group">
											<label>用户昵称：</label>
											<input type="text" id="snickName" name="snickName" value="" class="form-control">&nbsp;
											<a class="btn btn-primary" href="javascript:searchUser();">搜索</a>
										</div>
										<div class="form-group">
											&emsp;&emsp;&emsp;
											<label for="exampleInputEmail1">类型：</label>
											<select id="type" name="type" class="form-control" >
											 <option value="0">机器人</option>
											 <option value="1">日签</option>
											</select>
										</div>
								</form>
							
								<div class="ibox-content">
								  <div class="adv-table">
										<table class=" table  table-striped" id="mytable1" width="100%">
				                           	</table>
										</div>
									</div>
								</div>
							</div>
						</div>
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
	<script src="${ctx}/js/dynamic_table_init_0_asc.js"></script>
	<script src="${ctx}/js/bootstrap-switch.js"></script>
	<script src="${ctx}/js/jquery.tagsinput.js"></script>
	<script src="${ctx}/js/common-scripts.js"></script>
	<script type="text/javascript" src="${ctx}/js/DataTables-1.10.11/media/js/jquery.dataTables.min.js"></script>
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
	Date.prototype.Format = function(fmt)   
	{ //author: meizz   
	  var o = {   
	    "M+" : this.getMonth()+1,                 //月份   
	    "d+" : this.getDate(),                    //日   
	    "h+" : this.getHours(),                   //小时   
	    "m+" : this.getMinutes(),                 //分   
	    "s+" : this.getSeconds(),                 //秒   
	    "q+" : Math.floor((this.getMonth()+3)/3), //季度   
	    "S"  : this.getMilliseconds()             //毫秒   
	  };   
	  if(/(y+)/.test(fmt))   
	    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
	  for(var k in o)   
	    if(new RegExp("("+ k +")").test(fmt))   
	  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
	  return fmt;   
	}  
	$.fn.dataTable.ext.errMode="console";
	$.extend( $.fn.dataTable.defaults, {
		pageLength: 10,
		searching: false,
        dom: 'tp',
	    processing: true,
	    serverSide: true,
    	language: {
    		processing:     "加载中...",
    	    search:         "搜索中&nbsp;:",
    	    "lengthMenu":     "每页显示 _MENU_ 条",
    	    "info":           "当前 _START_ 到 _END_ 条，共 _TOTAL_ 条",
    	    "infoEmpty":      "当前第0条",
    	    "infoFiltered":   "(filtered from _MAX_ total entries)",
    	    infoPostFix:    "",
    	    loadingRecords: "加载数据中",
    	    zeroRecords:    "没有数据",
    	    emptyTable:     "没有数据",
    	    paginate: {
    	        first:      "第一页",
    	        previous:   "上一页",
    	        next:       "下一页",
    	        last:       "最后一页"
    	    },
    	    aria: {
    	        sortAscending:  "升序",
    	        sortDescending: "降序"
    	    },
    	    decimal: ","
        }
	} );
	
	
	var sourceTable=$('#mytable').DataTable( {
	    "ajax": {
            "url": ctx+"/quotation/ajaxLoadRobotList",
            "type": "POST",
            "data": function (d) {
                d.nickName = $("#nickName").val();
                d.type =  $("#stype").val();
            }
        },
	    processing:true,
	    "columns": [
			{"data": null,title: "序号",orderable:false,width:50},
	        {data: "nickName",width:200,orderable:false,title: "用户昵称",render:function(data,type,row,meta){
	        	if(data!=null){
	        		return data;
	        	}
	        }},
	        {data: "avatar",width:150,orderable:false,title: "用户头像",render:function(data,type,row,meta){
	        	if(data!=null){
	        		return '<img src="'+data+'" height="50"/>';
	        	}
	        }},
	        {data: "type",width:150,orderable:false,title: "类型",render:function(data,type,row,meta){
	        	if(data!=null){
	        		if(data==0){
	        			return  '机器人';
	        		}else if(data==1){
	        			return '日签'
	        		}
	        	}
	        }},
	        {title:"操作",orderable:false,width:200,render:function(data, type, row, meta){
	        	var txt='';
	        	txt='<a class="btn btn-danger btn-xs " href="javascript:del('+row.id+')">删除</a>';
	        	return txt;
	        }}
	     ],
	     "fnDrawCallback": function(){
       var api = this.api();
	    	var startIndex= api.context[0]._iDisplayStart;//获取到本页开始的条数
	    	         api.column(0).nodes().each(function(cell, i) {
	    	cell.innerHTML = startIndex + i + 1;
	    	}); 
	    	         }  
	});
	var sourceTable1=$('#mytable1').DataTable( {
		    "ajax": {
	            "url": ctx+"/quotation/ajaxLoadUsers",
	            "type": "POST",
	            "data": function (d) {
	                d.nickName = $("#snickName").val();
	            }
	        },
		    processing:true,
		    "columns": [
				{"data": null,title: "序号",orderable:false,width:50},
		        {data: "nickName",width:200,orderable:false,title: "用户昵称",render:function(data,type,row,meta){
		        	if(data!=null){
		        		return data;
		        	}
		        }},
		        {data: "avatar",width:150,orderable:false,title: "用户头像",render:function(data,type,row,meta){
		        	if(data!=null){
		        		return '<img src="'+data+'" height="50"/>';
		        	}
		        }},
		        {title:"操作",orderable:false,width:200,render:function(data, type, row, meta){
		        	var txt='';
		        	txt='<a class="btn btn-primary btn-xs " href="javascript:addRobotInfo('+row.uid+')">添加</a>';
		        	return txt;
		        }}
		     ],
		     "fnDrawCallback": function(){
	       var api = this.api();
		    	var startIndex= api.context[0]._iDisplayStart;//获取到本页开始的条数
		    	         api.column(0).nodes().each(function(cell, i) {
		    	cell.innerHTML = startIndex + i + 1;
		    	}); 
		    	         }  
		});
	
	
	function search(){
		 sourceTable.draw(true);
	}
	
	$("#mytable").on("click","th:eq(0)",function(){
		$("input[type='checkbox']").each(function(){
			if($(this).attr("checked")!=null){
				$(this).removeAttr("checked")
			}else{
				$(this).attr("checked","checked")
			}
		})
	})
	$(document).on("click",".btnAdd",function(){		// 父窗口添加选中用户。
		var tr = $(this).closest("tr");
		var data =sourceTable.row(tr).data();
		parent.onAdd([data.topicId],[data]);
	})
	function addBatch(){
		var idArr=[],dataArr=[];
		$("#mytable input:checked").each(function(){
			var tr = $(this).closest("tr");
			var data =sourceTable.row(tr).data()
			dataArr.push(data);
			idArr.push(data.topicId);
		})
		parent.onAdd(idArr,dataArr);
	}
	$("#flushKingdomCache").click(function(){
		if(confirm("确认刷新吗？")){
			 var $btn = $(this).button('loading');
			 $.getJSON("./ajaxUpdateKingdomsCache",{r:Math.random()},function(d){
				 alert(d.desc);		 
				 $btn.button('reset')
			 })
		}
	})
	
	
	   function del(id){
		 var msg = "您真的确定要删除吗？"; 
		 if (confirm(msg)){ 
			 var param = {id:id,status:status};
			  	$.ajax({
		            cache: true,
		            type: "POST",
		            dataType :"json",
		            url:"./delRobot",
		            data:param,
		            async: true,
		            error: function(request) {
		                alert('服务器出错'); 
		            },
		            success: function(data) {
		            	  if(data=='1'){
		            		  //sourceTable.ajax.reload();
		            		  alert('操作成功');
		            		  sourceTable.draw(false);
		            	  }else{
		                    	alert("提交失败");
		                        }
		            }
		        });
		 }
    }
	function addRobot(){
		sourceTable1.ajax.reload();
		$('#modal').modal('show');
	}
	   function addRobotInfo(id){
			 var msg = "您真的确定要添加吗？"; 
			 if (confirm(msg)){ 
				 var param = {uid:id,type:$("#type").val()};
				  	$.ajax({
			            cache: true,
			            type: "POST",
			            dataType :"json",
			            url:"./addRobot",
			            data:param,
			            async: true,
			            error: function(request) {
			                alert('服务器出错'); 
			            },
			            success: function(data) {
			            	  if(data=='1'){
			            		  //sourceTable.ajax.reload();
			            		  alert('操作成功');
			            		  sourceTable.draw(false);
			            		  $('#modal').modal('hide');
			            	  }else if(data=='2'){
			            		  alert('机器人不能重复添加！');
			            	  }else{
			                    	alert("操作失败");
			                        }
			            }
			        });
			 }
	    }
	function searchUser(){
		 sourceTable1.draw(true);
	}
	</script>
</body>
</html>