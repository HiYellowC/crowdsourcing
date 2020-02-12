require.config({
	baseUrl: '/',
	paths: {
		jquery: 'static/js/lib/jquery/jquery.min',
	}
});
require(['jquery'], function($) {
	$(document).ready(function() {
		var imageId = $('#imageId').attr('value');
		var recordId = $('#recordId').attr('value');
		var round = $('#round').attr('value');
		$('#image').attr('src', '/image/showProcessedImage?id=' + imageId + '&round=' + round + '&p=' + Math.random());
		$('#pass, #noPass').click(function() {
			var choice = $(this).attr('id');
			$.ajax({
				url: "/image/task2",
				data: {
					id: imageId,
					isPass: choice,
					recordId: recordId,
					round: round
				},
				success: function(result) {
					if(result.status == 200) {
						location.href = "/image/task/2"	
					} else if(result.status == 500) {
						alert(result.msg);
					} else {
						alert("处理超时，请重试");
						location.href = "/image/task/2"
					}
				}
			});
		});
		$('#sample').click(function(){
			location.href = "/";
		});
	});
});
