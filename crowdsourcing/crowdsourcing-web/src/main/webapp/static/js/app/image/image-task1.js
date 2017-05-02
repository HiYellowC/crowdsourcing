require.config({
	baseUrl: '/',
	paths: {
		jquery: 'static/js/lib/jquery/jquery.min',
		cropper: 'static/js/lib/cropper/cropper.min'
	}
});
require([ 'jquery', 'cropper' ], function($) {
	$(document).ready(function() {
		var imageId = $('#imageId').attr('value');
		var $image = $('#image');
		$('#image').attr('src', '/image/showOriginalImage?id=' + imageId +'&p=' + Math.random());
		var options = {
			guides : false,
			preview : '.img-preview',
			crop : function(e) {
			}
		};
		// Cropper
		$image.cropper(options);
		$('#submit').click(function() {
			$.ajax({
				url : "/image/task1",
				data : {
					id : imageId,
					x : $image.cropper('getData').x,
					y : $image.cropper('getData').y,
					width : $image.cropper('getData').width,
					height : $image.cropper('getData').height
				},
				success : function(result) {
					if (result.status == 200) {
						location.href = "/image/task/1"
					} else if (result.status == 201) {
						alert(result.msg);
					} else {
						alert("处理超时，请重试");
						location.href = "/image/task/1"
					}
				}
			});
		});
	});
});