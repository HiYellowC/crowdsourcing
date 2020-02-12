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
		var round = $('#round').attr('value');
		var $image = $('#image');
		$('#image').attr('src', '/image/showProcessedImage?id=' + imageId + '&round=' + round + '&p=' + Math.random());
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
					height : $image.cropper('getData').height,
					round : round,
					cls: encodeURIComponent($('select#cls option:selected').text())
				},
				success : function(result) {
					if (result.status == 200) {
						location.href = "/image/task/1"
					} else if (result.status == 201) {
						alert(result.msg);
						location.href = "/image/task/1"
					} else {
						alert("处理发生错误，请重试");
						location.href = "/image/task/1"
					}
				}
			});
		});
		$('#sample').click(function() {
			location.href = "/";
		});
		$('#done').click(function() {
			$.ajax({
				url: "/image/task3",
				data: {
					id: imageId,
					isPass: "pass",
					round: round
				},
				success: function(result) {
					if(result.status == 200) {
						location.href = "/image/task/1"	
					} else if(result.status == 500) {
						alert(result.msg);
					} else {
						alert("处理超时，请重试");
						location.href = "/image/task/1"
					}
				}
			});
		});
		$('#a').click(function() {
			target = "https://baike.baidu.com/item/" + $('select#cls option:selected').text();
			window.open(target)
		});
	});
});