<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/static/css/lib/bootstraptable/bootstrap-table.css">
<style type="text/css">
.btn-default {
	height: 34px
}
</style>
<link rel="shortcut icon" href="/static/img/favicon.ico">
<title>众众众包 用户管理</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/sidebar.jsp"></jsp:include>

	<!-- Content -->
	<section id="main-content"> <section class="wrapper">
	<div class="row mt">
		<div class="col-md-12">
			<div class="content-panel">
				<table 
				class="table" 
				data-url="/user/list" 
				data-striped="true"
				data-toggle="table"
				data-id-field="id"
				data-search="true"
				data-show-columns="true"
				data-pagination="true"
				data-show-refresh="true">
					<h4>
						<i class="fa fa-angle-right"></i> 用户管理
					</h4>
					<hr>
					<thead>
						<tr>
							<th data-field="id" data-align="center"><i class="fa fa-hand-o-right"></i> ID</th>
							<th data-field="username" data-align="center"><i class="fa fa-user"></i>用户名</th>
							<th data-field="gmtCreate" data-align="center" data-formatter="dateFormat"><i class="fa fa-bookmark"></i> 注册时间</th>
							<th data-field="email" data-align="center"><i class="fa fa-envelope-o"></i> 电子邮箱</th>
							<th data-field="role" data-align="center"><i class="fa fa-tags"></i> 用户类型</th>
							<th data-field="isLock" data-align="center" data-formatter="statusFormat"><i class="fa fa-lock"></i> 状态</th>
							<th data-field="operate" data-align="center" data-formatter="operateFormat" data-events="operateEvents"><i class="fa fa-edit"></i> 操作</th>
						</tr>
					</thead>
					
				</table>
			</div>
			<!-- /content-panel -->
		</div>
		<!-- /col-md-12 -->
	</div>
	<!-- /row --> </section> 
	<jsp:include page="../common/footer.jsp"></jsp:include>
	</section>
	<!-- /MAIN CONTENT -->
	<script src="/static/js/lib/bootstraptable/bootstrap-table.js"></script>
	<script src="/static/js/lib/bootstraptable/bootstrap-table-zh-CN.js"></script>
	<script src="/static/js/app/user/user-list.js"></script>
	
</body>
</html>