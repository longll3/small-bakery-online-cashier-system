

/*
 * 获取工程的路径
 */
function getRootPath() {
	var pathName = window.location.pathname.substring(1);
	var webName = pathName == '' ? '' : pathName.substring(0, pathName
			.indexOf('/'));
	return window.location.protocol + '//' + window.location.host + '/'
			+ webName + '/';
}

function AreYouSure(id) {
	var tableChildren = $('#tableBody').children();
	console.info(tableChildren);
	if (tableChildren.length > 0) {
//		console.info(tableChildren.length);
//		$('#test5').on('click', function(){
//		layer.tips('please finish this deal first!', ':input.'+'id');
		layer.open({
			  type: '1',
			  title:'Sorry',
			  area: ['300px', '120px'],
			  anim: '0',
			  shadeClose: true, //点击遮罩关闭
			  content: '\<\div style="padding:20px;">please finish this deal first!\<\/div>'
			  });
//			});
//		alert('please finish this deal first!');
		console.info(tableChildren.length);
		return;
	} else {
		layer.msg('Are you sure to delete this product?',{
			btn: ['Yes', 'No'],
			yes: function(index){
				//调用Ajax函数，删除
		    	$.ajax({
		    		type: "post",
		    		url: getRootPath()+"/bootstrapTest1/delPro",
		    		dataType:'json',
		    		data:{id:id},
		    		success: function(json) {
		    			if(json.flag) {
		    				layer.msg('succeed', {
		    					time: 500
		    				});
		    				//alert("successed");
		    				buildTable("",1,5);
		    			} else {
		    				layer.msg('failed', {
		    					time: 1000
		    				});
		    			}
		    		}
		    	});
				
			},
			btn2: function(index) {
				layer.close(index);
			}
			
		});
		/*layer.confirm('Are you sure delete this product?', {
			  btn: ['Yes', 'No'] //可以无限个按钮
			  ,yes: function(index){
			      layer.close(index);
			      layer.msg('雅蠛蝶 O.o', {
			      icon: 6
			      ,btn: ['嗷','嗷','嗷']
			    });
			    
			  }
			  ,btn2: function(index) {
				  return;
			  }	
			});*/
		/*if (!confirm("are you sure to delete this item？")) {  
	         alert(id);
			return;
		} else {
			//调用Ajax函数，删除
	    	$.ajax({
	    		type: "post",
	    		url: getRootPath()+"/bootstrapTest1/delPro",
	    		dataType:'json',
	    		data:{id:id},
	    		success: function(json) {
	    			if(json.flag) {
	    				
	    				alert("successed");
	    				buildTable("",1,5);
	    			} else {
	    				alert("failed");
	    			}
	    		}
	    	});
	    	
	    }*/
		
		//return;
	}	
    	
}
