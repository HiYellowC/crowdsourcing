<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="/static/img/favicon.ico">
<title>众众众包 图片上传</title>

<link rel="stylesheet" type="text/css" href="/static/css/lib/bootstrap/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="/static/css/lib/webuploader/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/static/css/lib/webuploader/syntax.css">
<link rel="stylesheet" type="text/css" href="/static/css/lib/webuploader/style.css">
<link rel="stylesheet" type="text/css" href="/static/css/lib/webuploader/webuploader.css">
<link rel="stylesheet" type="text/css" href="/static/css/lib/webuploader/demo.css">

</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/sidebar.jsp"></jsp:include>

	<!-- Content -->
	<section id="main-content"> <section class="wrapper">
	<div class="page-body">
		<div id="post-container" class="container">
			<h1 id="demo">图片上传</h1>
			<p>您可以尝试文件拖拽，使用QQ截屏工具，然后激活窗口后粘贴，或者点击添加图片按钮，来完成图片上传</p>
			<div class="input-group" style="width: 30%">
				<span class="input-group-addon" id="basic-addon1">关键字</span> <input
					id="keyword" type="text" class="form-control" placeholder="待识别的关键字"
					aria-describedby="basic-addon1" />
			</div>
			<div class="page-container">

				<div id="uploader" class="wu-example">
					<div class="queueList">
						<div id="dndArea" class="placeholder">
							<div id="filePicker"></div>
							<p>或将照片拖到这里，单次最多可选300张</p>
						</div>
					</div>
					<div class="statusBar" style="display: none;">
						<div class="progress">
							<span class="text">0%</span> <span class="percentage"></span>
						</div>
						<div class="info"></div>
						<div class="btns">
							<div id="filePicker2"></div>
							<div class="uploadBtn">开始上传</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section> 
	<jsp:include page="../common/footer.jsp"></jsp:include>
	</section>
	<script type="text/javascript" src="/static/js/require.js" data-main="/static/js/app/image/image-save"></script>
</body>
</html>