<%@page import="com.crowdsourcing.pojo.TbUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="/static/img/favicon.ico">
<title>众众众包 个人中心</title>
</head>
<body>

	<section id="container"> <jsp:include
		page="../common/header.jsp"></jsp:include> <jsp:include
		page="../common/sidebar.jsp"></jsp:include> <section id="main-content">
	<section class="wrapper site-min-height">
	<h3>
		<i class="fa fa-angle-right"></i> 个人中心
	</h3>
	<%
		TbUser user = (TbUser) request.getAttribute("user");
		double task1Quantity = user.getTask1Quantity().doubleValue();
		double task2Quantity = user.getTask2Quantity().doubleValue();
		double task3Quantity = user.getTask3Quantity().doubleValue();
		double task1DoubtfulQuantity = user.getTask1DoubtfulQuantity().doubleValue();
		double task2DoubtfulQuantity = user.getTask2DoubtfulQuantity().doubleValue();
		double task3DoubtfulQuantity = user.getTask3DoubtfulQuantity().doubleValue();
	%> <!-- page start-->
	<div class="row mt">
		<div class="col-lg-12">
			<div class="form-panel">
				<h4 class="mb">
					<i class="fa fa-angle-right"></i> 基本信息
				</h4>
				<form class="form-horizontal style-form" method="get">
                          <div class="form-group">
                <label class="col-sm-2 col-sm-2 control-label">用户名: ${user.username}</label>
				<label class="col-sm-2 col-sm-2 control-label">积分: ${user.score}</label>
				</div>
				</form>
			</div>
		</div>
	</div>
	<div class="col-md-4 col-sm-4 mb">
		<div class="green-panel pn">
			<div class="green-header">
				<h5>任务一</h5>
			</div>
			<canvas id="task1-chart" height="120" width="120"></canvas>
			<script>
				var doughnutData = [ {
					value : parseInt('${user.task1DoubtfulQuantity}'),
					color : "#2b2b2b"
				}, {
					value : parseInt('${user.task1Quantity}'),
					color : "#fffffd"
				} ];
				var myDoughnut = new Chart(document.getElementById(
						"task1-chart").getContext("2d")).Doughnut(doughnutData);
			</script>
			<div class="row">
				<div class="col-sm-6 col-xs-6 goleft">
					<p>
						总量：${user.task1Quantity}<br />不合格量：${user.task1DoubtfulQuantity}
					</p>
				</div>
				<div class="col-sm-6 col-xs-6">
					<h2>
						<c:set var="task1">${user.task1Quantity }</c:set>
						<c:choose>
							<c:when test="${task1 == 0}">0</c:when>
							<c:otherwise>
								<fmt:formatNumber type="number"
									value="<%=task1DoubtfulQuantity * 100 / task1Quantity%>"
									maxFractionDigits="2" />
							</c:otherwise>
						</c:choose>
						%
					</h2>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-4 col-sm-4 mb">
		<div class="green-panel pn">
			<div class="green-header">
				<h5>任务二</h5>
			</div>
			<canvas id="task2-chart" height="120" width="120"></canvas>
			<script>
			var doughnutData = [ {
				value : parseInt('${user.task2DoubtfulQuantity}'),
				color : "#2b2b2b"
			}, {
				value : parseInt('${user.task2Quantity}'),
				color : "#fffffd"
			} ];
				var myDoughnut = new Chart(document.getElementById(
						"task2-chart").getContext("2d")).Doughnut(doughnutData);
			</script>
			<div class="row">
				<div class="col-sm-6 col-xs-6 goleft">
					<p>
						总量：${user.task2Quantity}<br />不合格量：${user.task2DoubtfulQuantity}
					</p>
				</div>
				<div class="col-sm-6 col-xs-6">
					<h2>
						<c:set var="task2">${user.task2Quantity }</c:set>
						<c:choose>
							<c:when test="${task2 == 0}">0</c:when>
							<c:otherwise>
								<fmt:formatNumber type="number"
									value="<%=task2DoubtfulQuantity * 100 / task2Quantity%>"
									maxFractionDigits="2" />
							</c:otherwise>
						</c:choose>
						%
					</h2>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-4 col-sm-4 mb">
		<div class="green-panel pn">
			<div class="green-header">
				<h5>任务三</h5>
			</div>
			<canvas id="task3-chart" height="120" width="120"></canvas>
			<script>
			var doughnutData = [ {
				value : parseInt('${user.task3DoubtfulQuantity}'),
				color : "#2b2b2b"
			}, {
				value : parseInt('${user.task3Quantity}'),
				color : "#fffffd"
			} ];
				var myDoughnut = new Chart(document.getElementById(
						"task3-chart").getContext("2d")).Doughnut(doughnutData);
			</script>
			<div class="row">
				<div class="col-sm-6 col-xs-6 goleft">
					<p>
						总量：${user.task3Quantity}<br />不合格量：${user.task3DoubtfulQuantity}
					</p>
				</div>
				<div class="col-sm-6 col-xs-6">
					<h2>
						<c:set var="task3">${user.task3Quantity }</c:set>
						<c:choose>
							<c:when test="${task3 == 0}">0</c:when>
							<c:otherwise>
								<fmt:formatNumber type="number"
									value="<%=task3DoubtfulQuantity * 100 / task3Quantity%>"
									maxFractionDigits="2" />
							</c:otherwise>
						</c:choose>
						%
					</h2>
				</div>
			</div>
		</div>
	</div>
	<!-- /END CHART - 4TH ROW OF PANELS --> </section> </section> 

	<jsp:include page="../common/footer.jsp"></jsp:include>
	</section>
</body>
</html>