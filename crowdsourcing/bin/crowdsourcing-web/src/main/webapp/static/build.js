({
//	baseUrl: './js',
//	paths: {
//		jquery: 'lib/jquery/jquery.min',
//		cropper: 'lib/cropper/cropper.min'
//	},
//	name: "app/image-task1",
//	out: "main-built.js"
	
	appDir: './',
	dir: './vajoy',
	baseUrl: './js',
	modules:[
	         {name:'app/image/image-save'},
	         {name:'app/image/image-task1'},
	         {name:'app/image/image-task2'},
	         {name:'app/image/image-task3'},
								
	],
	fileExclusionRegExp: /^(r|build)\.js|.*\.scss$/,	//过滤，匹配到的文件将不会被输出到输出目录去
	
	optimizeCss: 'standard', 
	
	removeCombined: true,   //如果为true，将从输出目录中删除已合并的文件
	
	paths: {	//相对baseUrl的路径
		jquery: 'lib/jquery/jquery.min',
		cropper: 'lib/cropper/cropper.min',
		webuploader : 'lib/webuploader/webuploader'
	}
})