<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="/static/img/favicon.ico">
<title>众众众包 任务二</title>
<link rel="stylesheet" type="text/css" href="/static/css/lib/cropper/cropper.min.css">
<link rel="stylesheet" type="text/css" href="/static/css/lib/cropper/main.css">
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/sidebar.jsp"></jsp:include>

	<section id="main-content"> <section class="wrapper">
	<input type="hidden" id="imageId" value="${info.id}"/>
	<input type="hidden" id="recordId" value="${info.recordId}"/>
	<input type="hidden" id="round" value="${info.round}"/>
	<h1>质量验证</h1>
	<h3>实体类别: ${info.cls}</h3>
	<div class="container">
		<div class="row">
			<div class="row mt">
                 <div class="col-md-5">
                    <!-- <h3>Demo:</h3> -->
                    <div class="img-container">
                        <img id="image" alt="Picture">
                    </div>
                </div>
            </div>
			<!-- 文本添加 -->
			<div class="row mt">
				<p>判断黄色边界框是否符合要求，并且框内实体是否属于显示的实体类别，作出你的判断：</p>
			</div>
			<!--  -->
			<div class="row mt">
				<button id="pass" type="button" class="btn btn-round btn-success">合格</button>
				<!-- 按钮添加 -->
				<button id="sample" type="button" class="btn btn-round btn-info" style="margin-left:40px">查看示例</button>
				<!--  -->
				<button id="noPass" type="button" class="btn btn-round btn-danger" style="margin-left:40px">不合格</button>
			</div>
		</div>
	</div>
	</section> 
	</section>
	<script src="/static/js/require.js" data-main="/static/js/app/image/image-task2"></script>
</body>
</html>