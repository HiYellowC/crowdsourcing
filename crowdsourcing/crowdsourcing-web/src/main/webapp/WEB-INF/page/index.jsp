<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="/static/img/favicon.ico">
<title>众众众包 图片处理众包平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<jsp:include page="common/header.jsp"></jsp:include>
	<jsp:include page="common/sidebar.jsp"></jsp:include>
	<section id="main-content"> <section class="wrapper">
		<h3>要求描述</h3>
		<hr>
		<h4>任务一：单目标实体标注</h4>
		<div>
			在图片上标注边界框，容括一个未被标注的目标物体并判定类别，具体要求如下：<br>
			1、在容括一个目标物体所有可见部位的条件下，该边界框要足够小<br>
			2、只需标注一个目标物体<br>
			3、不要标注已被边界框包围的目标物体<br>
			4、正确地判断当前标注目标物体的类别<br>
			<div class="row" style="padding: 10px">
				<img style="width:40%;height:40%" src="/static/img/app/1_1.png">
				<img style="width:40%;height:40%" src="/static/img/app/1_2.png">
			</div>
			<div class="row" style="padding: 10px">
				<img style="width:40%;height:40%" src="/static/img/app/1_3.png">
				<img style="width:40%;height:40%" src="/static/img/app/1_4.png">
			</div>
		</div>
		<h4>任务二：质量评测</h4>
		<div>
			评判上一个用户的工作是否满足要求
		</div>
		<h4>任务三：全覆盖评测</h4>
		<div>
			评判其他用户的工作是否满足全覆盖<br>
			全覆盖：任何一个符合要求的目标物体都要标注边界框，不能缺漏
			<div class="row" style="padding: 10px">
				<img style="width:80%;height:80%" src="/static/img/app/3_1.png">
			</div>
		</div>
	</section>
	<jsp:include page="common/footer.jsp"></jsp:include>
	</section>
</body>
</html>