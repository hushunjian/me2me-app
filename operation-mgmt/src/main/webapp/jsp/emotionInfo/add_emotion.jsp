﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@include file="../common/meta.jsp"%>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta charset="utf-8" />
    <title>ZX_IMS 2.0 - 新建</title>

    <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/css/bootstrap-reset.css" rel="stylesheet">
    <link href="${ctx}/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/bootstrap-fileupload/bootstrap-fileupload.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/bootstrap-wysihtml5/bootstrap-wysihtml5.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/bootstrap-datepicker/css/datepicker.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/bootstrap-timepicker/compiled/timepicker.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/bootstrap-colorpicker/css/colorpicker.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/bootstrap-daterangepicker/daterangepicker-bs3.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/bootstrap-datetimepicker/css/datetimepicker.css" />
    
    <link href="${ctx}/css/slidebars.css" rel="stylesheet">
    <link href="${ctx}/css/style.css" rel="stylesheet">
    <link href="${ctx}/css/style-responsive.css" rel="stylesheet" />
      <script src="${ctx}/js/jquery.js"></script>
        <script src="${ctx}/js/jquery-ui-1.9.2.custom.min.js"></script>
        <script src="${ctx}/js/jquery-migrate-1.2.1.min.js"></script>
        <script src="${ctx}/js/bootstrap.min.js"></script>
        <script class="include" type="text/javascript" src="${ctx}/js/jquery.dcjqaccordion.2.7.js"></script>
        <script src="${ctx}/js/jquery.scrollTo.min.js"></script>
        <script src="${ctx}/js/jquery.nicescroll.js" type="text/javascript"></script>
        <script src="${ctx}/js/respond.min.js"></script>
    <script type="text/javascript">
    var errMsg = '${errMsg}';
    if(errMsg && errMsg != 'null' && errMsg != ''){
    	alert(errMsg);
    }
    function check(){
    	if($("#topicid").val()==null || $("#topicid").val()==''){
    		alert("请选择王国！");
    		return false;
    	}
    	if($("#id").val()==null || $("#id").val()==''){
    	if($("#file").val()==''){
    		alert("个人情绪王国封面图！");
    		return false;
    	}
    	}
    	
    	if($("#emotionpackid").val()==''){
    		alert("请选择表情！");
    		return false;
    	}
    	
    	$.ajax({
            cache: true,
            type: "POST",
            dataType :"json",
            url:"./existsEmotionInfoByName",
            data:$('#form1').serialize(),
            async: true,
            error: function(request) {
                alert('服务器出错'); 
            },
            success: function(data) {
            	  if(data=='0'){
                  	$("#form1").submit();
                      }else{
                    	alert("情绪名重复");
                        }
            }
        });
    	
       
    }
    function packSelect(id,title,image){
    	$("#emotionpackid").val(id);
    	$("#image").attr("src",image);
    	$("#packTitle").html(title);
    	$("#myModal").modal('hide');
    }
    function modalShow(){
    	$("#myModal").modal('show');
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
    			<jsp:param name="t" value="12"/>
    			<jsp:param name="s" value="12_5"/>
    		</jsp:include>
            <!--sidebar end-->

            <!--main content start-->
            <section id="main-content">
            	<form id="form1" action="./doSaveEmotion" method="POST"  enctype="multipart/form-data">
            		<input type="hidden" name="id" value="${item.id}" id="id"/>
                <section class="wrapper">
                    <!-- page start-->
                    <div class="row">
                        <div class="col-lg-12">
                            <section class="panel">
                                <header class="panel-heading">基本信息</header>
                                <div class="panel-body">
                                    <div role="row">
                                    	<div class="col-md-6">
	                                        <div class="form-group">
	                                            <label for="exampleInputFile">情绪名称</label>
	                                            <input name="emotionname"  class="form-control" value="${item.emotionname}" required/>
	                                        </div>
	                                        <div class="form-group">
	                                            <label for="exampleInputFile">开心指数最小值</label>
                                    	  <input name="happymin" type="number"  class="form-control" value="${item.happymin}"  required/>
                                    	   </div>
                                    	     <div class="form-group">
	                                            <label for="exampleInputFile">开心指数最大值</label>
	                                      <input name="happymax" type="number"   class="form-control" value="${item.happymax}"  required/>
	                                        </div>
	                                        <div class="form-group">
	                                            <label for="exampleInputFile">空闲指数最小值</label>
	                                            <input name="freemin" type="number"   class="form-control" value="${item.freemin}"  required/>
	                                            </div>
	                                              <div class="form-group">
	                                            <label for="exampleInputFile">空闲指数最大值</label>
	                                            <input name="freemax" type="number"   class="form-control" value="${item.freemax}"  required/>
	                                        </div>
	                                               <div class="form-group">
                                            <label for="exampleInputEmail1">王国名称</label>
                                            <p>
                                            <input type="text" name="kingdomname" class="form-control required" value="${topicTitle}" style="display:inline"/>
                                            <a class="btn btn-danger dialog" id="selectKingdom" href="${ctx}/ranking/listKingdoms">选择王国</a>
                                            </p>
                                        </div>
                                        <div class="form-group hidden">
                                            <label for="exampleInputEmail1">王国id</label>
                                            <input type="text" name="topicid" id="topicid" class="form-control required" value="${item.topicid}"/>
                                        </div>
	                                        </div>
	                                        <div class="col-md-6">
	                                        <div class="form-group">
	                                        <input type="button"  value="选择大表情" class="btn btn-danger"  onclick="modalShow();"/>&nbsp;<span id="packTitle">${epd.title }</span>
	                                             </br>
	                                              </br>
	                                            <input name="emotionpackid"  id="emotionpackid" class="form-control" value="${item.emotionpackid}" type="hidden"/>
	                                             <div class="fileupload-new thumbnail" style="width: 200px; height: 150px;">
                                                    	<c:if test="${epd.image!=null }">
                                                        <img src="http://cdn.me-to-me.com/${epd.image}" alt=""  id="image"  style="max-height:140px;"/>
                                                        </c:if>
                                                        <c:if test="${epd.image==null }">
                                                        <img src="" alt=""  id="image"  style="max-height:140px;"/>
                                                        </c:if>
                                                        
                                                    </div>
	                                        </div>
	                                        <div class="form-group">
	                                            <label for="exampleInputFile">个人情绪王国封面图片</label>
                                                <div class="fileupload fileupload-new" data-provides="fileupload">
                                                    <div class="fileupload-new thumbnail" style="width: 200px; height: 150px;">
                                                    	<c:if test="${item.topiccoverphoto!=null }">
                                                        <img src="http://cdn.me-to-me.com/${item.topiccoverphoto}" alt="" />
                                                        </c:if>
                                                    </div>
                                                    <div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
                                                    <div>
                                                        <span class="btn btn-white btn-file">
                                                            <span class="fileupload-new"><i class="fa fa-paper-clip"></i>选择上传图片</span>
                                                            <span class="fileupload-exists"><i class="fa fa-undo"></i>修改</span>
                                                            <input type="file" id="file" name="file" class="default">
                                                        </span>
                                                        <a href="#" class="btn btn-danger fileupload-exists" data-dismiss="fileupload"><i class="fa fa-trash"></i>删除</a>
                                                    </div>
                                                </div>
	                                        </div>
	                                   
	                                      
                                        </div>
                                    </div>
                                </div>
                            </section>
                        </div>
                    </div>
                    <input type="button" id="btnSave" value="提交" class="btn btn-danger"  onclick="check()"/>
                    <span class="btn btn-default"><a href="javascript:history.back(-1)">返回</a></span>
                </section>
                <!-- page end-->
                </form>
            </section>

            <!--main content end-->

            <!-- Right Slidebar start -->
            <%@include file="../common/rightSlidebar.jsp"%>
            <!-- Right Slidebar end -->

            <!--footer start-->
            <%@include file="../common/footer.jsp"%>
            <!--footer end-->
        </section>
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
						<section class="panel">
							<header class="panel-heading">
								| 表情列表
								<span class="tools pull-right">
									<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
								</span>
							</header>
							<div class="panel-body">
								<div class="adv-table">
									<table class="display table table-bordered table-striped" id="dynamic-table">
										<thead>
											<tr>
												<th>序号</th>
												<th>名称</th>
												<th>图像</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${dataList2}" var="item" varStatus="status">
												<tr class="gradeX">
													<td>${status.index + 1}</td>
													<td >
														${item.title }
													</td>
													<td >
														<img src="http://cdn.me-to-me.com/${item.image }" style="max-height:32px;"/>
													</td>
													<td>
														<a class="btn btn-warning btn-xs " href="javascript:packSelect(${item.id},'${item.title}','http://cdn.me-to-me.com/${item.image }');">选择</a>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</section>
       </div>
       </div>
</div>
        <!--this page plugins-->

        <script src="${ctx}/js/jquery.js"></script>
        <script src="${ctx}/js/jquery-ui-1.9.2.custom.min.js"></script>
        <script src="${ctx}/js/jquery.validate.min.js"></script>
        <script src="${ctx}/js/jquery-migrate-1.2.1.min.js"></script>
        <script src="${ctx}/js/bootstrap.min.js"></script>
        <script class="include" type="text/javascript" src="${ctx}/js/jquery.dcjqaccordion.2.7.js"></script>
        <script src="${ctx}/js/jquery.scrollTo.min.js"></script>
        <script src="${ctx}/js/jquery.nicescroll.js" type="text/javascript"></script>
        <script type="text/javascript" src="${ctx}/assets/advanced-datatable/media/js/jquery.dataTables.js"></script>
        <script type="text/javascript" src="${ctx}/assets/data-tables/DT_bootstrap.js"></script>
        <script src="${ctx}/js/respond.min.js"></script>

        <!--this page plugins-->

        <script type="text/javascript" src="${ctx}/assets/fuelux/js/spinner.min.js"></script>
        <script type="text/javascript" src="${ctx}/assets/bootstrap-fileupload/bootstrap-fileupload.js"></script>
        <script type="text/javascript" src="${ctx}/assets/bootstrap-wysihtml5/wysihtml5-0.3.0.js"></script>
        <script type="text/javascript" src="${ctx}/assets/bootstrap-wysihtml5/bootstrap-wysihtml5.js"></script>
        <script type="text/javascript" src="${ctx}/assets/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
        <script type="text/javascript" src="${ctx}/assets/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
        <script type="text/javascript" src="${ctx}/assets/bootstrap-daterangepicker/moment.min.js"></script>
        <script type="text/javascript" src="${ctx}/assets/bootstrap-daterangepicker/daterangepicker.js"></script>
        <script type="text/javascript" src="${ctx}/assets/bootstrap-colorpicker/js/bootstrap-colorpicker.js"></script>
        <script type="text/javascript" src="${ctx}/assets/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>
        <script type="text/javascript" src="${ctx}/assets/jquery-multi-select/js/jquery.multi-select.js"></script>
        <script type="text/javascript" src="${ctx}/assets/jquery-multi-select/js/jquery.quicksearch.js"></script>

        <script type="text/javascript" src="${ctx}/assets/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
        <!--right slidebar-->
        <script src="${ctx}/js/slidebars.min.js"></script>

        <!--dynamic table initialization -->
        <script src="${ctx}/js/dynamic_table_init.js"></script>
        <!--custom switch-->
        <script src="${ctx}/js/bootstrap-switch.js"></script>
        <!--custom tagsinput-->
        <script src="${ctx}/js/jquery.tagsinput.js"></script>
        <!--script for this page-->
        <script src="${ctx}/js/form-component.js"></script>
        <!--common script for all pages-->
        <script src="${ctx}/js/common-scripts.js"></script>
        <script src="${ctx}/js/advanced-form-components.js"></script>

        <script src="${ctx}/js/xheditor-1.2.2.min.js"></script>
        <script src="${ctx}/js/xheditor_lang/zh-cn.js"></script>
        <script src="${ctx}/js/xheditSelf.js"></script>
        <script type="text/javascript" src="${ctx}/js/bootbox.min.js"></script>
        <script type="text/javascript">
$("form").validate();
$("#selectKingdom").click(function(){
	var url =$(this).attr("href");
	bootbox.dialog({ 
		size:"large",
		message: "<iframe src='"+url+"' style='width:100%;min-height:750px;border:0px;'></iframe>" 
	})
	return false;
});

//子窗口添加数据
function onAdd(idArr,dataArr){
	$("input[name='kingdomname']").val(dataArr[0].title);
	$("input[name='topicid']").val(dataArr[0].topicId);
	bootbox.hideAll();
}
</script>
</body>
</html>
