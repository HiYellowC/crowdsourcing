require.config({
	baseUrl: '/',
	paths: {
		jquery: 'static/js/lib/jquery/jquery.min',
		bs: 'static/js/lib/bootstrap/bootstrap.min'
	}
});
require(['jquery', 'bs'], function($) {
	$(document).ready(function() {
		$('#submit1').click(function() {
			$('#modal2').modal('hide');
			$.ajax({
				type : 'POST',
				url : '/user/permission/2',
				success : function(result) {
					if (result.status == 200) {
						$('#modal3').modal('show');
					} else {
						alert(result.msg);
					}
				}
			});
		});
		$('#submit2').click(function() {
			$('#addDiv').remove();
			$('#footer1')
					.prepend(
							"<div id='addDiv' style='float:left; color:red'>这个黄色框可没有完全容括关键字物体哦~</div>")
		});
		$('#modal2').on('hidden.bs.modal', function() {
			$('#addDiv').remove();
		});
		$('#modal3').on('hidden.bs.modal', function() {
			location.href = "/image/task/2"
		});
	});
});
