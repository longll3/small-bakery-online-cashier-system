<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>
<!DOCTYPE html>  
<html lang="en">  
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1.0">  
<title>product info</title>  
<!-- <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script> -->
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script> 
<link href="<%=request.getContextPath()%>/js/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">  
<script src="<%=request.getContextPath()%>/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>  
<script src="<%=request.getContextPath()%>/js/bootstrap-3.3.7-dist/js/bootstrap-paginator.js"></script>
<script src="<%=request.getContextPath()%>/js/layer.js"></script>
<!-- <script type="text/javascript" src="<%=request.getContextPath()%>/js/addProductCheck.js" ></script> -->

<link rel="stylesheet"  type="text/css"  href="<%=request.getContextPath()%>/js/layer.css"/>
<link rel="stylesheet"  type="text/css"  href="<%=request.getContextPath()%>/js/displayProduct.css"/>

<script src="<%=request.getContextPath()%>/js/DelPro.js"></script>
<script src="<%=request.getContextPath()%>/js/checkOut.js"></script>
<script src="<%=request.getContextPath()%>/js/addProduct.js"></script>
 
</head>  
<body>  

	<!-- 侧边导航 from layer.js -->
	<!-- <ul class="layui-nav layui-nav-tree layui-nav-side" lay-filter="test"> -->
	<ul class="layui-nav layui-nav-tree layui-nav-side" lay-filter="demo">
	 <!--li class="layui-nav-item layui-nav-itemed" -->
	  <li class="layui-nav-item ">
	    <a href="<%=request.getContextPath()%>/login">退出</a>
	    <!-- <dl class="layui-nav-child">
	      <dd><a href="javascript:;">选项1</a></dd>
	      <dd><a href="javascript:;">选项2</a></dd>
	      <dd><a href="">跳转</a></dd>
	    </dl> -->
	  </li>
	  <li class="layui-nav-item">
	    <%-- <a href="<%=request.getContextPath()%>/add" >添加商品</a> --%>
	    <a href="#" onClick="AddProduct()" >添加商品</a>
	    <dl class="layui-nav-child">
	      <!-- <dd><a href="">移动模块</a></dd>
	      <dd><a href="">后台模版</a></dd>
	      <dd><a href="">电商平台</a></dd> -->
	    </dl>
	  </li>
	  <li class="layui-nav-item"><a href="<%=request.getContextPath()%>/salesRecord">销售记录</a></li>
	  <li class="layui-nav-item"><a href="<%=request.getContextPath()%>/bootstrapTest1">收银</a></li>
	</ul>


    <div id = "queryDiv">  
        <input id = "textInput" type="text" placeholder="please input product type" >  
        <button id = "queryButton" class="btn btn-primary" type="button">Search</button>
        <!-- <a href="<%=request.getContextPath()%>/add"><button id="addButton" type="button" class="btn btn-primary">ADD</button></a> -->  
    </div>  
    <form id="form1">  
        <div id="display" class="row">
        	<div class="col-sm-6 col-md-4" id="displayK">
        	</div>
        </div>
        <!-- 底部分页按钮 -->  
        <div id="bottomTab"></div>  
   	</form> 
   	
	<form id="form2" action="<%=request.getContextPath()%>/checkout">
		<table class="table table-bordered" id = 'tableResult'>  
            <caption>Shopping Cart</caption>  
            <thead>  
                <tr>  
                    <th>product type</th>  
                    <th>product name</th>
                    <th>unit price</th>
                    <th>count</th>  
                </tr>  
            </thead>  
            <tbody id="tableBody">
            
            </tbody>  
        </table>
        
	</form>
	
	<button id="checkButton" class="btn btn-primary" type="button" onClick="checkOut()">check out</button>
	<button id="emptyButton" class="btn btn-primary" type = "button" onClick="clearShoppingCart()">empty cart</button>
   	
   	 
    <script type='text/javascript'>
    
        var PAGESIZE = 5;  
        var options = {    
            currentPage: 1,  //当前页数  
            totalPages: 10,  //总页数，这里只是暂时的，后头会根据查出来的条件进行更改  
            size:"normal",    
            alignment:"center",
            pageUrl:"#",
            itemTexts: function (type, page, current) {    
                switch (type) {    
                    case "first":    
                        return "第一页";    
                    case "prev":    
                        return "前一页";    
                    case "next":    
                        return "后一页";    
                    case "last":    
                        return "最后页";    
                    case "page":    
                        return  page;    
                }                   
            },    
            onPageClicked: function (e, originalEvent, type, page) {    
                var userName = $("#textInput").val(); //取内容  
                buildTable(userName,page,PAGESIZE);//默认每页最多10条  
            }    
        }    
  
        //获取当前项目的路径  
        var urlRootContext = (function () {  
            var strPath = window.document.location.pathname;  
            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);  
            return postPath;  
        })();  
          
         
        //生成表格  
        function buildTable(userName,pageNumber,pageSize) {  
             var url =  urlRootContext + "/list"; //请求的网址  
             //var url =  urlRootContext;
             var reqParams = {'userName':userName, 'pageNumber':pageNumber,'pageSize':pageSize};//请求数据  
             $(function () {     
                  $.ajax({  
                        type:"POST",  
                        url:url,  
                        data:reqParams,  
                        async:false,  
                        dataType:"json",  
                        success: function(data){  
                            if(data.isError == false) {  
            //               		options.totalPages = data.pages;  
		                        var newoptions = {    
			                        currentPage: 1,  //当前页数  
			                        totalPages: data.pages==0?1:data.pages,  //总页数  
			                        size:"normal",    
			                        alignment:"center",    
			                        itemTexts: function (type, page, current) {    
				                        switch (type) {    
				                            case "first":    
				                            return "第一页";    
				                            case "prev":    
				                            return "前一页";    
				                            case "next":    
				                            return "后一页";    
				                            case "last":    
				                            return "最后页";    
					                        case "page":    
					                        return  page;
					                        //console.info(page);
				                		}                   
			            			},    
					            	onPageClicked: function (e, originalEvent, type, page) {    
						                var userName = $("#textInput").val(); //取内容  
						                buildTable(userName,page,PAGESIZE);//默认每页最多10条  
					            	}    
		         				}// newoption	                           
         						$('#bottomTab').bootstrapPaginator("setOptions",newoptions); //重新设置总页面数目  
         						var dataList = data.dataList;  
         						//$("#tableBody").empty();//清空表格内容  
         						$("#displayK").empty();
						        if (dataList.length > 0 ) {  
						            $(dataList).each(function(){//重新生成  
						            	var parentdiv=$("#displayK");
						            	//var count = "0";
						            	//var count_span = $('<div class="counter" id="'+this.productId+'">0</div>');
						            	//var count_str = count_span.text();
						            	var childdiv=$('<div class="thumbnail"></div>');

						            	var grandchilddiv=$('<div class="caption"></div>');
						            	grandchilddiv.append('<h3 class="'+this.productId+'">'+this.description+'</h3>');
						            	grandchilddiv.append('<p class="'+this.productId+'type">'+this.productName+'</p>');
						            	grandchilddiv.append('<p class="'+this.productId+'price">'+this.price+'</p>')
						            	
						            	grandchilddiv.append('<a href="#" class="btn btn-primary" role="button" onclick="AddItems('+this.productId+')">+</a>');
						            	grandchilddiv.append('<a href="#" class="btn btn-primary" role="button" onclick="CutItems('+this.productId+')">-</a>');
						            	grandchilddiv.append('<input class="btn btn-primary '+this.productId+'" onclick="AreYouSure('+this.productId+')" type="submit" value="del" >');
						            	
						            	
						            	
						            	//childdiv.append(count_span);
						            	childdiv.append(grandchilddiv);
						            	parentdiv.append(childdiv);
						 
						           });    
          						} else {
          							var parentdiv=$("#displayK");
					            	//var count = "0";
					            	//var count_span = $('<div class="counter" id="'+this.productId+'">0</div>');
					            	//var count_str = count_span.text();
					            	var childdiv=$('<div class="thumbnail"></div>');

					            	var grandchilddiv=$('<div class="caption"></div>');
					            	grandchilddiv.append('<h3 class="'+this.productId+'">No this production</h3>');
					            	grandchilddiv.append('<p class="'+this.productId+'type">oops</p>');
					            	//childdiv.append(count_span);
					            	childdiv.append(grandchilddiv);
					            	parentdiv.append(childdiv);
					              	//$("#tableBody").append('<tr><th colspan ="4"><center>查询无数据</center></th></tr>');  
					            }  
          					}else{  
              					alert(data.errorMsg);  
          					}  
        				}, //success end  
                        error: function(e){  
                           alert("查询失败:" + e);  
                        }  
                    });  //ajax
               });  
        } // buildTable end  
          
        //渲染完就执行  
        $(function() {  
              
            //生成底部分页栏  
            $('#bottomTab').bootstrapPaginator(options);       
              
            buildTable("",1,5);//默认空白查全部  
              
            //创建结算规则  
            $("#queryButton").bind("click",function(){  
                var userName = $("#textInput").val();     
                buildTable(userName,1,PAGESIZE);  
            });
            
        });  
    </script>  
</body>  
</html> 