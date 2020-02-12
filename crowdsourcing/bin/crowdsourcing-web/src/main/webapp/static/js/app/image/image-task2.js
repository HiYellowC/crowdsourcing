require.config({
	baseUrl: '/',
	paths: {
		jquery: 'static/js/lib/jquery/jquery.min',
	}
});
require(['jquery'], function($) {
	$(document).ready(function() {
		var imageId = $('#imageId').attr('value');
		$('#image').attr('src', '/image/showProcessedImage?id=' + imageId +'&p=' + Math.random());
		$('.btn').click(function() {
			var choice = $(this).attr('id');
			$.ajax({
				url: "/image/task2",
				data: {
					id: imageId,
					isPass: choice
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
	});
});
