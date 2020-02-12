<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

<link rel="shortcut icon" href="/static/img/favicon.ico">
<title>众众众包 注册</title>
<!-- Bootstrap CSS v3.0.0 or higher -->
<link rel="stylesheet" href="/static/css/lib/bootstrap/bootstrap.min.css">

<!-- FormValidation CSS file -->
<link rel="stylesheet" href="/static/css/lib/formvalidation/formValidation.min.css">

<!-- jQuery v1.9.1 or higher -->
<script type="text/javascript" src="/static/js/lib/jquery/jquery.min.js"></script>

<!-- Bootstrap JS -->
<script src="/static/js/lib/bootstrap/bootstrap.min.js"></script>

<!-- FormValidation plugin and the class supports validating Bootstrap form -->
<script src="/static/js/lib/formvalidation/formValidation.min.js"></script>
<script src="/static/js/lib/formvalidation/bootstrap.min.js"></script>
<!--external css-->
<link href="/static/css/lib/dashgumfree/font-awesome.css" rel="stylesheet" />

<!-- Custom styles for this template -->
<link href="/static/css/lib/dashgumfree/style.css" rel="stylesheet">
<link href="/static/css/lib/dashgumfree/style-responsive.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->

	<div id="login-page">
		<div class="container">

			<form id="basicBootstrapForm" class="form-login" action="/user/register"
				method="post">
				<h2 class="form-login-heading">注 册</h2>

				<div class="login-wrap">
					<div class="form-group">
						<input type="text" class="form-control" name="username"
							placeholder="username" autofocus>
					</div>
					<br>
					<div class="form-group">
						<input type="password" class="form-control" name="password"
							placeholder="password">
					</div>
					<label class="checkbox">
					${errorInfo } 
					</label>
					<div class="form-group">
						<button class="btn btn-theme btn-block" type="submit">
							<i class="fa fa-lock"></i> 确 定
						</button>
					</div>
					<hr>

				</div>

			</form>

		</div>
	</div>



	<!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
	<script type="text/javascript"
		src="/static/js/lib/dashgumfree/jquery.backstretch.min.js"></script>
	<script>
		$.backstretch("/static/img/lib/dashgumfree/login-bg.jpg", {
			speed : 500
		});
	</script>
	<script>
		$(document).ready(function() {
			$('#basicBootstrapForm').formValidation({
				framework : 'bootstrap',
				icon : {
					valid : 'glyphicon glyphicon-ok',
					invalid : 'glyphicon glyphicon-remove',
					validating : 'glyphicon glyphicon-refresh'
				},
				fields : {
					username : {
						validators : {
							notEmpty : {
								message : 'The username is required'
							}
						}
					},
					password : {
						validators : {
							notEmpty : {
								message : 'The password is required'
							}
						}
					}
				}
			});
		});
	</script>

</body>
</html>
