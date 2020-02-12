<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

<link rel="shortcut icon" href="/static/img/favicon.ico">
<title>众众众包 任务一</title>

<link rel="stylesheet" type="text/css" href="/static/css/lib/cropper/cropper.min.css">
<link rel="stylesheet" type="text/css" href="/static/css/lib/cropper/main.css">
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/sidebar.jsp"></jsp:include>
	<!-- Content -->

	<section id="main-content"> <section class="wrapper">
	<input type="hidden" id="imageId" value="${info.id}"/>
	<h1>task1</h1>
	<h2>关键字: ${info.keyword}</h2>
	<div class="container">
		<div class="row">
			<div class="row mt">
				<div class="col-md-5">
					<!-- <h3>Demo:</h3> -->
					<div class="img-container">
						<img id="image" alt="Picture">
					</div>
				</div>
				<div class="col-md-3">
					<!-- <h3>Preview:</h3> -->
					<div class="docs-preview clearfix">
						<div class="img-preview preview-lg"></div>
					</div>
				</div>
			</div>
			<div class="row mt">
				<button id="submit" type="button" class="btn btn-round btn-success">确认
					下一张</button>
			</div>
		</div>
	</div>
	</section> 

	</section>
	<script type="text/javascript" src="/static/js/require.js" data-main="/static/js/app/image/image-task1"></script>
</body>
</html>
