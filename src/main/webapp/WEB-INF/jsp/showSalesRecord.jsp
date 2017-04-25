<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>sales record</title>

<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script> 
<link href="<%=request.getContextPath()%>/js/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">  
<script src="<%=request.getContextPath()%>/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>  
<script src="<%=request.getContextPath()%>/js/bootstrap-3.3.7-dist/js/bootstrap-paginator.js"></script>
<script src="<%=request.getContextPath()%>/js/layer.js"></script>

<link rel="stylesheet"  type="text/css"  href="<%=request.getContextPath()%>/js/layer.css"/>

<link rel="stylesheet"  type="text/css"  href="<%=request.getContextPath()%>/js/showSalesRecord.css"/>

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
	  <li class="layui-nav-item"><a href="">销售记录</a></li>
	  <li class="layui-nav-item"><a href="<%=request.getContextPath()%>/bootstrapTest1">收银</a></li>
	</ul>
	
	<div id = "queryDiv">
		<input id = "textInput" type="text" >
		<button id = "queryButton" class="btn btn-primary" type="button">Search</button>
	</div>
	
	<div id="queryMethod">
		<span>search by date</span>
		<input type="radio" name="method" value="0" checked>
		<span>search by productID</span>
		<input type="radio" name="method" value="1" >
	</div>

	<form id = "form1">
		<table class="table table-bordered" id = 'tableResult'>  
            <caption>sales record</caption>  
            <thead>  
                <tr>  
                	<th>name</th>
                	<th>type</th>
                    <!-- <th>product id</th> -->  
                    <!-- <th>product name</th> -->
                    <th>date</th>
                    <th>count</th>  
                </tr>  
            </thead>  
            <tbody id="tableBody">
            
            </tbody>  
        </table>
	</form>
	
	<script type="text/javascript">
	
		function getDate() {
			var _date = new Date();
			//var s = _date.toLocaleDateString();
			var date = ""+_date.getFullYear()+"-";
			var m = _date.getMonth() + 1;
			if (m < 10) {
				m = "0"+ m;
			}
			var d = _date.getDate();
			if (d < 10) {
				d = "0" + d;
			}
			date += m+"-"+d;
			console.info(date);
			return date;
		}	
		
		//获取当前项目的路径
		var urlRootContext = (function () {  
            var strPath = window.document.location.pathname;  
            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);  
            return postPath;  
        })();
		
		//生成表格
		function buildTable(date_id, method) {
			
			console.info(method);
			console.info(date_id);
			var url = urlRootContext + "/listRecord";
			/* if (method == 1) {
				url = urlRootContext + "/listRecordByProductId";
			}
			 */
			$("#tableBody").empty();
			$(function(){
				$.ajax({
					type: "POST",
					url: url,
					data: {"date_id": date_id, "method": method},
					dataType:"json",
					success: function(data) {
						console.info(data);
						var l = data.length;
						console.info(data[0]);
						console.info("length: "+l);
						
						var tableBody = $("#tableBody");
						tableBody.empty();
						if (data.length > 0) {
							$(data).each(function() {
								/* console.info(this.count);
								console.info(this.date.date);
								console.info(this.date.month+1);
								console.info(this.date.year+1900);
								console.info(this.productId);
								console.info(this.recordId); */
								var productId = this.productId;
								
								var day = this.date.date;
								var month = this.date.month+1;
								var year = this.date.year+1900;
								var date = year + "-" + month + "-" + day;
								
								getProduct(productId, date, this.count);
								
								
								
								
//								console.info(productId);
								//tr.append('<td>'+this.productId+'</td>');
								
								
							});
							
							
						} else {
							layer.msg("no sales record today", {
								time: 1000
							});
							console.info("no record");
						}
					},// success
					error: function(e) {
						console.info("查询失败： "+ e);
					}
				}); //ajax
			});// function
		} // buildtable
		
		function getProduct(pro_id, date, count) {
			console.info(pro_id);
			var url = urlRootContext + "/getProductById";
			//var a = [];
			$.ajax({
				type:"get",
				url: url,
				dataType: "json",
				data: {"productId": pro_id},
				success: (function(pro) {
					if (pro != null) {
						console.info(pro);
						var type = pro.productName;
						var name = pro.description;
						console.info(type);
						console.info(name);
						var a = new Array(type,name);
						console.info("aaaaa"+a);
						console.info("tttt"+a[0]);
						//return a;
						//var tr = $('tr.'+pro.productId);
						var tr = $('<tr class="'+this.productId+'"></tr>');
						tr.append('<td>'+name+'</td>');
						tr.append('<td>'+type+'</td>');
						tr.append('<td>'+date+'</td>');
						tr.append('<td>'+count+'</td>');
						var tableBody = $("#tableBody");
						tableBody.append(tr); 
						
					} else {
						console.info("查找失败");
					}
								
				})
				
			});
			//return a;
		}
		
		function queryMethod() {
			var method = $('input[name="method"]').filter(":checked")[0];
			console.info(method.value);
			/* if (method == 1) {
				$('#textInput').attr("placeholder", "productID");
			} else {
				$('#textInput').attr("placeholder", "format:####-##-##");
			} */
			return method.value;
		}
		
		$(function() {
			//默认展示当天的销售记录
			var date = getDate();
			var method = queryMethod();
			buildTable(date, method);
			
			$('#queryButton').bind("click", function(){
				var method = queryMethod();
				var date_id = $("#textInput").val();
				console.info("date_id"+date_id);
				console.info(method);
				buildTable(date_id, method);
				console.info("builded");
			});
		});
		
	</script>

</body>
</html>