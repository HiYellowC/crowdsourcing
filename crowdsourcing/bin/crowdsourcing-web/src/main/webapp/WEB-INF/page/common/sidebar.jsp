<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

	<!--sidebar start-->
	<aside>
	<div id="sidebar" class="nav-collapse">
		<!-- sidebar menu start-->
		<ul class="sidebar-menu" id="nav-accordion">

			<p class="centered">
				<a href="/"><img src="/static/img/lib/dashgumfree/ui-sam.jpg"
					class="img-circle" width="60"></a>
			</p>
			<h5 class="centered">
				<shiro:guest>未登录</shiro:guest>
				<shiro:user>
					<shiro:principal></shiro:principal>
				</shiro:user>
			</h5>

			<shiro:user>
				<li class="mt"><a href="/user/info"> <i
						class="fa fa-user"></i> <span>个人中心</span>
				</a></li>
				<li class="mt"><a href="/image/task/1"> <i
						class="fa fa-dashboard"></i> <span>任务一</span>
				</a></li>
				<li class="mt"><a href="/image/task/2"> <i
						class="fa fa-dashboard"></i> <span>任务二</span>
				</a></li>
				<li class="mt"><a href="/image/task/3"> <i
						class="fa fa-dashboard"></i> <span>任务三</span>
				</a></li>
			</shiro:user>
			<shiro:hasAnyRoles name="admin,superAdmin">
				<li class="mt"><a href="/user/listPage"> <i
						class="fa fa-users"></i> <span>用户管理</span>
				</a></li>
			</shiro:hasAnyRoles>
			<shiro:hasRole name="superAdmin">
				<li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-photo"></i>
                          <span>图片管理</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="/image/savePage">图片上传</a></li>
                          <li><a  href="/image/listPage">图片下载</a></li>
                      </ul>
                  </li>
			</shiro:hasRole>
		</ul>


	</div>
	</aside>
	<!--sidebar end-->
	
	<script type="text/javascript">
		//$('.tooltips').click();
	</script>
	
</body>
</html>