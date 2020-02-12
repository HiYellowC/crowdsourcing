require.config({
	baseUrl : '/',
	paths : {
		jquery : 'static/js/lib/jquery/jquery.min',
		fancybox : 'static/js/lib/dashgumfree/jquery.fancybox'
	}
});
require([ 'jquery', 'fancybox' ], function($, fancybox) {
	$img = $('#img');
	function showImage(idList, url) {
		for (var i = 0; i < idList.length; i++) {
			if (i % 3 == 0) {
				$('.wrapper').append("<div class='row mt'></div>");
			}
			var imageURL = url + "?id=" + idList[i];
			var addHTML = [
					'<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 desc">',
					'<div class="project-wrapper">', '<div class="project">',
					'<div class="photo-wrapper"> ', '<div class="photo"> ',
					'<a class="fancybox" href="', imageURL, '">',
					'<img class="img-responsive" src="', imageURL, '"> ',
					'</a> ', '</div> ', '<div class="overlay"> ',
					'</div></div></div></div></div>' ].join('');
			$('.row:last').append(addHTML);
		}
	}
	$('#query').click(function() {
		$('.row').remove();
		var date = $('#date').val();
		if (date == "")
			alert("请选择日期");
		else {
//			$('.wrapper').append("<div id='loading' style='text-align: center'><img src='/static/img/app/loading.gif'/></div>");
			$.ajax({
				url : "/image/list",
				data : {
//					keyword : encodeURIComponent(keyword),
					date : date
				},
				success : function(result) {
					if (result.status == 200) {
						if (result.data.length == 0)
							alert("no result");
						else
							showImage(result.data, "/image/showOriginalImage");
						$(".fancybox").fancybox({
							"type" : "image"
						});
					} else {
						alert(result.msg);
					}
				}
			});
		}
	});
	$('#download').click(
			function() {
//				var keyword = $('#keyword').val();
				var date = $('#date').val();
//				keyword = encodeURIComponent(keyword);
				if (date == "") {
					alert("请选择日期");
					return false;
				}
				$('#download').attr(
						'href',
						'/image/zip?date=' + date);
			})
});