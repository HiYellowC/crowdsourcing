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
	<input type="hidden" id="round" value="${info.round}"/>
	<h1>单目标实体标注</h1>
	<!-- 
	<h2>关键字: ${info.keyword}</h2>
	 -->
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
					<!-- 类别添加 -->
					<div class="row mt" style="margin-left:0px">
						<span style="font-size:20px">实体类别：</span>
						<select id="cls">
						  <option value="person">少锡</option>
						  <option value="bird">鸟</option>
						  <option value ="cat">猫</option>
						  <option value="cow">牛</option>
						  <option value ="dog">狗</option>
						  <option value="horse">马</option>
						  <option value="sheep">羊</option>
						  <option value="aeroplane">飞机</option>
						  <option value="bicycle">自行车</option>
						  <option value="boat">船</option>
						  <option value="bus">公共汽车</option>
						  <option value="car">小汽车</option>
						  <option value="motorbike">摩托车</option>
						  <option value="train">火车</option>
						  <option value="bottle">瓶子</option>
						  <option value="chair">椅子</option>
						  <option value="dining-table">桌子</option>
						  <option value="potted-plant">盆栽</option>
						  <option value="sofa">沙发</option>
						  <option value="tv/monitor">电视</option>
						  <!--
						   Person: person
                            Animal: bird, cat, cow, dog, horse, sheep
                            Vehicle: aeroplane, bicycle, boat, bus, car, motorbike, train
                            Indoor: bottle, chair, dining table, potted plant, sofa, tv/monitor 
						   -->
						</select>
					</div>
					<div class="row mt" style="margin-left:0px">
						<a id="a" href="javascript:;">查看wiki定义</a>
					</div>
					<!--  -->
				</div>
			</div>
			<div class="row mt" style="margin-left:0px">
				<button id="submit" type="button" class="btn btn-round btn-success">确认
					下一张</button>
				<!-- 按钮添加 -->
				<button id="sample" type="button" class="btn btn-round btn-info" style="margin-left:40px">查看示例</button>
				<button id="done" type="button" class="btn btn-round btn-danger" style="margin-left:40px">无可标注目标</button>
				<!--  -->
			</div>
		</div>
	</div>
	</section> 

	</section>
	<script type="text/javascript" src="/static/js/require.js" data-main="/static/js/app/image/image-task1"></script>
</body>
</html>
