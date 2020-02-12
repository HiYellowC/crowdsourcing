<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/static/css/lib/dashgumfree/jquery.fancybox.css"
	rel="stylesheet" />
<link rel="shortcut icon" href="/static/img/favicon.ico">
<title>众众众包 图片下载</title>
</head>
<body>

	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/sidebar.jsp"></jsp:include>

	<section id="main-content"> <section
		class="wrapper site-min-height">
	<h3>
		<i class="fa fa-angle-right"></i> 图片下载
	</h3><br>
	<div>
		<div
			style="width: 30%; float: left; margin-left: 10px; margin-right: 10px">
			<div class="input-group">
				<span class="input-group-addon">关键字</span> <input id="keyword"
					type="text" class="form-control" placeholder="图片的关键字" />
			</div>
		</div>
		<div
			style="width: 30%; float: left; margin-left: 10px; margin-right: 10px">
			<div class="input-group">
				<span class="input-group-addon">上传日期</span> <input id="date"
					type="date" class="form-control" />
			</div>
		</div>
		<div
			style="width: 30%; float: right; margin-left: 10px; margin-right: 10px">
			<div class="input-group" style="float: right;">
				<input id="query" class="btn btn-default" type="button" value="查询" />
				<i class="fa fa-download"></i> <a id="download" class="btn">全部下载</a>
			</div>
		</div>
	</div>
	<br>
	<br>
	<hr>
	</section> 
	<jsp:include page="../common/footer.jsp"></jsp:include> 
	</section>
	<script type="text/javascript" src="/static/js/require.js"
		data-main="/static/js/app/image/image-list"></script>
</body>
</html>