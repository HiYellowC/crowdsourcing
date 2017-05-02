<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="/static/img/favicon.ico">
<title>众众众包 任务三</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/sidebar.jsp"></jsp:include>

	<section id="main-content"> <section class="wrapper">
	<input type="hidden" id="imageId" value="${info.id}"/>
	<h1>task3</h1>
	<h2>关键字: ${info.keyword}</h2>
	<div class="container">
		<div class="row">
			<div class="row mt">
				<img id="image" alt="Picture">
			</div>
			<div class="row mt">
				<button id="noPass" type="button" class="btn btn-round btn-danger">不合格</button>
				<button id="pass" type="button" class="btn btn-round btn-success">合格</button>
			</div>
		</div>
	</div>
	</section> 
	</section>
	<script type="text/javascript" src="/static/js/require.js" data-main="/static/js/app/image/image-task3"></script>
</body>
</html>