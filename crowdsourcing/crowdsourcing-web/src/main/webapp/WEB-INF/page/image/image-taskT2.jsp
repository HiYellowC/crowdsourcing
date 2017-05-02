<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="/static/img/favicon.ico">
<title>众众众包 任务二训练</title>
</head>
<body>

	<jsp:include page="../common/header.jsp"></jsp:include>
	<jsp:include page="../common/sidebar.jsp"></jsp:include>
	
	<!-- Content -->
	<section id="main-content"> <section class="wrapper">
	
	<div class="contaioner" style="margin-top: 240px; text-align: center">
		<h3>你还没有完成任务二训练，完成训练才能开始相应的任务哦~</h3>
		<a id="a1" class="btn btn-primary" data-target="#modal1"
			data-toggle="modal">开始训练</a>
	</div>
	
	<div class="modal fade" id="modal1" role="dialog"
		aria-labelledby="modalLabel" tabindex="-1">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modalLabel">任务二训练 Ⅰ</h5>
				</div>
				<div class="modal-body">
					要求:该任务要求你正确评判其他用户的工作是否合格，即黄色标注框是否符合准确性要求<br>
					注： ①绿色标注框为已通过评判的标注框，不需要你的评判<br>&nbsp&nbsp&nbsp
					&nbsp&nbsp&nbsp&nbsp②准确性：在容括一个关键字物体的条件下，该边界框要足够小<br>
					 就像这样~
					<p>关键字：狗</p>
					<img src="/static/img/app/1_1.jpg" height="40%" width="40%">
					<img src="/static/img/app/1_2.jpg" height="40%" width="40%">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal"
						data-target="#modal2" data-toggle="modal">知道了</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="modal2" aria-labelledby="modalLabel"
		role="dialog" tabindex="-1">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modalLabel">任务二训练 Ⅱ</h5>
				</div>
				<div class="modal-body">
					你也来试一试吧~
					<p>关键字：狗</p>
					<div class="img-container">
						<img id="image1" src="/static/img/app/T2_1.jpg" alt="Picture">
					</div>
				</div>
				<div id="footer1" class="modal-footer">
					<button id="submit1" type="button" class="btn btn-danger">不合格</button>
					<button id="submit2" type="button" class="btn btn-success">合格</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="modal3" role="dialog"
		aria-labelledby="modalLabel" tabindex="-1">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modalLabel">任务二训练 Ⅲ</h5>
				</div>
				<div class="modal-body">
					恭喜你，已成功完成任务二训练，开始任务赚取积分吧~~
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">好的</button>
				</div>
			</div>
		</div>
	</div>
	
	</section>
	</section>
	
	<script src="/static/js/require.js" data-main="/static/js/app/image/image-taskT2"></script>
	
</body>
</html>