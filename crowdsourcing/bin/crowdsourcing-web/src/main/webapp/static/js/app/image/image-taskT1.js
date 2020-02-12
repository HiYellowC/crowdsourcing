require.config({
	baseUrl : '/',
	paths : {
		jquery : 'static/js/lib/jquery/jquery.min',
		cropper : 'static/js/lib/cropper/cropper.min',
		bs: 'static/js/lib/bootstrap/bootstrap.min'
	}
});
require(
		[ 'jquery', 'cropper', 'bs'],
		function($) {
			$(document)
					.ready(
							function() {
								function IOU(rectangle1, rectangle2) {
									var x1 = rectangle1.x;
									var y1 = rectangle1.y;
									var width1 = rectangle1.width;
									var height1 = rectangle1.height;

									var x2 = rectangle2.x;
									var y2 = rectangle2.y;
									var width2 = rectangle2.width;
									var height2 = rectangle2.height;

									var endx = Math.max(x1 + width1, x2
											+ width2);
									var startx = Math.min(x1, x2);
									var width = width1 + width2
											- (endx - startx);

									var endy = Math.max(y1 + height1, y2
											+ height2);
									var starty = Math.min(y1, y2);
									var height = height1 + height2
											- (endy - starty);

									if (width <= 0 || height <= 0) {
										return 0;
									}
									var area = width * height;
									var area1 = width1 * height1;
									var area2 = width2 * height2;
									return area / (area1 + area2 - area)
											* 100.0;
								}

								var $image1 = $('#image1');
								var $image2 = $('#image2');
								$('#modal2').on('shown.bs.modal', function() {
									$image1.cropper({
										guides : false,
									});
								}).on('hidden.bs.modal', function() {
									$image1.cropper('destroy');
									$('#addDiv').remove();
								});
								$('#modal3').on('shown.bs.modal', function() {
									$image2.cropper({
										guides : false,
									});
								}).on('hidden.bs.modal', function() {
									$image2.cropper('destroy');
									$('#addDiv2').remove();
								});
								$('#modal4').on('hidden.bs.modal', function() {
									location.href = "/image/task/1"
								});
								$('#submit1')
										.click(
												function() {
													var rectangle1 = {
														x : 90.0,
														y : 93.2,
														width : 148.0,
														height : 202.6
													};
													var rectangle2 = {
														x : 305.0,
														y : 100.2,
														width : 128.0,
														height : 198.6
													}
													var rectangle = {
														x : $image1
																.cropper('getData').x,
														y : $image1
																.cropper('getData').y,
														width : $image1
																.cropper('getData').width,
														height : $image1
																.cropper('getData').height
													};
													if (IOU(rectangle1,
															rectangle) > 90
															|| IOU(rectangle2,
																	rectangle) > 90) {
														$('#modal2').modal(
																'hide');
														$('#modal3').modal(
																'show');
													} else {
														$('#addDiv').remove();
														$('#footer1')
																.prepend(
																		"<div id='addDiv' style='float:left; color:red'>这工作不合符要求哦~调整框的大小和位置再试一试~</div>")
													}
												});
								$('#submit2')
										.click(
												function() {
													var rectangle1 = {
														x : 36.0,
														y : 77.4,
														width : 174.0,
														height : 217.2
													};
													var rectangle2 = {
														x : 173.0,
														y : 197.8,
														width : 219.0,
														height : 136.2
													}
													var rectangle = {
														x : $image2
																.cropper('getData').x,
														y : $image2
																.cropper('getData').y,
														width : $image2
																.cropper('getData').width,
														height : $image2
																.cropper('getData').height
													};
													if (IOU(rectangle1,
															rectangle) > 90
															|| IOU(rectangle2,
																	rectangle) > 90) {
														$('#modal3').modal(
																'hide');
														$
																.ajax({
																	type : 'POST',
																	url : '/user/permission/1',
																	success : function(
																			result) {
																		if (result.status == 200) {
																			$(
																					'#modal4')
																					.modal(
																							'show');
																		} else {
																			alert(result.msg);
																		}
																	}
																});
													} else {
														$('#addDiv2').remove();
														$('#footer2')
																.prepend(
																		"<div id='addDiv2' style='float:left; color:red'>这工作不合符要求哦~调整框的大小和位置再试一试~</div>")
													}
												});
							});
		});