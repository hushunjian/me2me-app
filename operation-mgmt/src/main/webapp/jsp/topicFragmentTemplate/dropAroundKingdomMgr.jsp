﻿<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="../common/meta.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta charset="utf-8" />

<title>ZX_IMS 2.0 - 串门王国管理</title>

<link href="${ctx}/css/bootstrap.min.css" rel="stylesheet" />
<link href="${ctx}/css/bootstrap-reset.css" rel="stylesheet" />
<link href="${ctx}/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href="${ctx}/css/slidebars.css" rel="stylesheet" />
<link href="${ctx}/css/style.css" rel="stylesheet" />
<link href="${ctx}/css/style-responsive.css" rel="stylesheet" />

<script src="${ctx}/js/jquery.js"></script>
<script src="${ctx}/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="${ctx}/js/jquery-migrate-1.2.1.min.js"></script>
<script src="${ctx}/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${ctx}/js/DataTables-1.10.11/media/css/jquery.dataTables.min.css" />


<script src="${ctx}/js/messager/js/messenger.min.js"></script>
<script src="${ctx}/js/messager/js/messenger-theme-flat.js"></script>
<link rel="stylesheet" href="${ctx}/js/messager/css/messenger.css" />
<link rel="stylesheet" href="${ctx}/js/messager/css/messenger-theme-flat.css" />

</head>
<body>
	<section id="container" class="">
		<!--header start-->
		<%@include file="../common/header.jsp"%>
		<!--header end-->

		<!--sidebar start-->
		<jsp:include page="../common/leftmenu.jsp" flush="false">
			<jsp:param name="t" value="7" />
			<jsp:param name="s" value="7_7" />
		</jsp:include>
		<!--sidebar end-->

		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<div class="row ">
					
					<div class="col-xs-12 ">
						<form class="form-inline">
							<div class="form-group">
								<div class="input-group">
										<input type="text" id="myKeyword" class="form-control" placeholder="可搜标题关键字、昵称"> 
										<input type="text" id="hide" class="form-control hidden" placeholder="Search for...">
										<span class="input-group-btn">
										<button class="btn btn-primary" type="button" id="btnSearchMyKingodm">搜索</button>
										</span>
								</div>
							</div>
							<div class="form-group">
								<a class="btn btn-danger dialog" href="../ranking/listKingdoms">添加王国</a>
							</div>
							
						</form>
						<table id="myKingdomList" class="table hover" width="100%"></table>
					</div>
				</div>				
			</section>
		</section>
		<!--main content end-->

		<%@include file="../common/rightSlidebar.jsp"%>

		<!--footer start-->
		<%@include file="../common/footer.jsp"%>
		<!--footer end-->
	</section>
	<!-- js placed at the end of the document so the pages load faster -->
	<script class="include" type="text/javascript" src="${ctx}/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="${ctx}/js/jquery.scrollTo.min.js"></script>
	<script src="${ctx}/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script type="text/javascript" src="${ctx}/js/DataTables-1.10.11/media/js/jquery.dataTables.min.js"></script>
	<script src="${ctx}/js/respond.min.js"></script>
	<script src="${ctx}/js/slidebars.min.js"></script>
	<script src="${ctx}/js/bootstrap-switch.js"></script>
	<script src="${ctx}/js/jquery.tagsinput.js"></script>
	<script src="${ctx}/js/common-scripts.js"></script>
	<script src="${ctx}/js/jquery.json-2.4.min.js"></script>
	 <script type="text/javascript" src="${ctx}/js/bootbox.min.js"></script>
	<script>
	$.fn.dataTable.ext.errMode="console";
	$.extend( $.fn.dataTable.defaults, {
		"pageLength": 15,
		searching: false,
	    ordering:  false,
	    columnDefs:{
            orderable:false//禁用排序
        },
        dom: 'rtlip',
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
	Messenger.options = {
		    extraClasses: 'messenger-fixed messenger-on-top',
		    theme: 'flat'
		}
		function addMyKingodms(dataArr){
			
			var jsonStr = $.toJSON(dataArr);
			$.post("./addDropAroundKingdom",{data:jsonStr},function(data){
				if(data.code!=1){
					alert(data.desc);
				}else{
					myKingdomTable.ajax.reload();
					Messenger().post({message:"添加成功！",hideAfter: 2});
				}
			})
		}
	
		$(document).on("click",".btnAddKingdom",function(){
			var tr = $(this).closest("tr");
			var data =sourceTable.row(tr).data()
			addMyKingodms([data])
		})
		
		var myKingdomTable=$('#myKingdomList').DataTable( {
		    "ajax":"./loadMyKingdomPage",
		    "columns": [
		        {data: "title",title: "标题"},
		        {data: "nickName",title: "作者"},
		        {title:"操作",width:60,render:function(data, type, row, meta){
		        	var txt= "<a href='#stop' title='topicId:"+row.topicId+",uid:"+row.uid+"' class='btn btn-danger btn-xs btnDelMyKingdom'>删除</a> ";
		        	return txt;
		        }}
		     ]
		});
		
		$(document).on("click",".btnDelMyKingdom",function(){
			var tr = $(this).closest("tr");
			var id =myKingdomTable.row(tr).data().id
			if(confirm("确认删除吗？")){
				$.getJSON("./delMyKingdom",{r:Math.random(),id:id},function(data){
					if(data.code!=1){
						alert(data.desc);
					}else{
						myKingdomTable.ajax.reload();
					}
				})
			}
		})
		$("#btnSearchMyKingodm").click(function(){
			var url = "loadMyKingdomPage?keyword="+$("#myKeyword").val();
			myKingdomTable.ajax.url(url).load();
		})
		
		$("#myKeyword").on("keydown",function(e){
			 if(e && e.keyCode==13){ // enter 键
				 $("#btnSearchMyKingodm").trigger('click')
		    }
		})
		var sort= 0;
		// 子窗口添加数据
		function onAdd(dataArr){
			addMyKingodms(dataArr);
		}
		$("a.dialog").click(function(){
    		var url =$(this).attr("href");
    		bootbox.dialog({ 
    			size:"large",
    			message: "<iframe src='"+url+"' style='width:100%;min-height:750px;border:0px;'></iframe>" 
    		})
    		return false;
    	})
	</script>
</body>
</html>