<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js" ></script>
<link href="<%=request.getContextPath()%>/js/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<!-- <link rel="stylesheet"  type="text/css"  href="<%=request.getContextPath()%>/js/register.css"/> -->
<link rel="stylesheet"  type="text/css"  href="<%=request.getContextPath()%>/js/layer.css"/>
<!-- <link rel="stylesheet"  type="text/css"  href="<%=request.getContextPath()%>/js/displayProduct.css"/> -->
<link rel="stylesheet"  type="text/css"  href="<%=request.getContextPath()%>/js/addProduct.css"/>

<script src="<%=request.getContextPath()%>/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>  
<script src="<%=request.getContextPath()%>/js/bootstrap-3.3.7-dist/js/bootstrap-paginator.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/addProductCheck.js" ></script>


<title>添加商品检测</title>
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
	    <a href = "<%=request.getContextPath()%>/add" onClick="AddProduct()" >添加产品</a>
	    <dl class="layui-nav-child">
	      <!-- <dd><a href="">移动模块</a></dd>
	      <dd><a href="">后台模版</a></dd>
	      <dd><a href="">电商平台</a></dd> -->
	    </dl>
	  </li>
	  <li class="layui-nav-item"><a href="">销售记录</a></li>
	  <li class="layui-nav-item"><a href="<%=request.getContextPath()%>/bootstrapTest1" ">收银</a></li>
	</ul>
	
	<div id="reg">  
		<FORM name="formProduct"  action="<%=request.getContextPath()%>/add/successed"  method=post>
		  <BR>  
		  <TABLE width="100%" align=center border=0>  
		    <TBODY>  
		      <TR>  
		        <TD align=right class="left_td">
		        	<strong>product type</strong>
		        </TD>
		        <TD width="57%"><INPUT id="productName" class = "form-control" onBlur="checkProductType(this)"   
		      name="productType" style="width:50%;">  
		            <SPAN id="username_notice" >*</SPAN></TD>  
		      </TR>  
		      <TR>  
		        <TD align=right class="left_td">
		        	<strong>product name</strong>
				</TD>  
		        <TD><INPUT id="emial" class = "form-control" onBlur="checkProductName(this)" name="description" style="width:50%;">  
		            <SPAN id=email_notice >*</SPAN></TD>  
		      </TR>  
		      <TR>  
		        <TD align=right class="left_td">
		        	<strong>product price</strong>
				</TD>  
		        <TD><INPUT id="password" class = "form-control" onBlur="checkPrice(this)" type="text" name="price" style="width:50%;">  
		            <SPAN id=password_notice >*</SPAN>
		      </TD>
		      </TR>
		      <TR>  
		        <TD align=right class="left_td">
					<strong>shelf life</strong>
				</TD>  
		        <TD><INPUT id="conform_password" class = "form-control" onBlur="checkPeriod(this)"   
		      type="text" name="period" style="width:50%;">  
		            <SPAN id=period_notice >*</SPAN></TD>  
		      </TR>    
		      <TR>  
		        <TD  ><INPUT type=hidden value=act_register name=act></TD>  
		        <TD  ><input type="submit" value="add item" name="Submit1" class ="btn btn-primary" id="confirm" disabled></TD>  
		      </TR>  
		      <TR>  
		        <TD colSpan=2> </TD>  
		      </TR>  
		    </TBODY>  
		  </TABLE>  
		</FORM>  
	</div>
	<div id="notice">
	${error}
	</div>
         
</body>
</html>