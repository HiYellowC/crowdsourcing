<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Bootstrap core CSS -->
    <link href="/static/css/lib/bootstrap/bootstrap.min.css" rel="stylesheet">
    <!--external css-->
    <link rel="stylesheet" type="text/css" href="/static/css/lib/dashgumfree/font-awesome.css" />
    <link rel="stylesheet" type="text/css" href="/static/css/lib/dashgumfree/zabuto_calendar.css" />
    <link rel="stylesheet" type="text/css" href="/static/css/lib/dashgumfree/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="/static/css/lib/dashgumfree/lineicons/style.css" />    
    
    <!-- Custom styles for this template -->
    <link rel="stylesheet" type="text/css" href="/static/css/lib/dashgumfree/style.css" />
    <link rel="stylesheet" type="text/css" href="/static/css/lib/dashgumfree/style-responsive.css" />
	
    <script src="/static/js/lib/dashgumfree/Chart.js"></script>
    
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<!--header start-->
      <header class="header black-bg">
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="导航栏"></div>
              </div>
            <!--logo start-->
            <a href="/" class="logo"><b>图片处理众包平台</b></a>
            <!--logo end-->
            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
                    <shiro:user>
                    <li><a class="logout" href="/user/logout">注 销</a></li>
                    </shiro:user>
                    <shiro:guest>
                    <li><a class="logout" href="/user/loginPage">登 陆</a></li>
                    </shiro:guest>
            	</ul>
            </div>
        </header>
      <!--header end-->
      
    <!-- js placed at the end of the document so the pages load faster -->
    <script src="/static/js/lib/jquery/jquery.min.js"></script>
    <script src="/static/js/lib/bootstrap/bootstrap.min.js"></script>
    <script src="/static/js/lib/dashgumfree/jquery.dcjqaccordion.2.7.js"></script>
    <script src="/static/js/lib/dashgumfree/jquery.scrollTo.min.js"></script>
    <script src="/static/js/lib/dashgumfree/jquery.nicescroll.js"></script>
    <script src="/static/js/lib/dashgumfree/jquery.sparkline.js"></script>
      
    <!--common script for all pages-->
    <script src="/static/js/lib/dashgumfree/common-scripts.js"></script>
    <script src="/static/js/lib/dashgumfree/jquery.gritter.js"></script>
    <script src="/static/js/lib/dashgumfree/gritter-conf.js"></script>

</body>
</html>