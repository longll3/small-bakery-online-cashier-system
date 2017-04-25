<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js" ></script>
<link href="<%=request.getContextPath()%>/js/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"  type="text/css"  href="<%=request.getContextPath()%>/js/register.css"/>  
<script src="<%=request.getContextPath()%>/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>  
<script src="<%=request.getContextPath()%>/js/bootstrap-3.3.7-dist/js/bootstrap-paginator.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/registerCheck.js" ></script>
<title>Ajax+SpringMVC+Spring+MyBatis+Mysql注册验证实例</title>
</head>
<body>  
<div id="reg">  
<FORM name="formUser"  action="<%=request.getContextPath()%>/register/successed"  method=post>  
  <BR>  
  <TABLE width="100%" align=center border=0>  
    <TBODY>  
      <TR>  
        <TD align=right width="15%">
        	<div class="btn btn-default btn-lg">
	        <span class="glyphicon glyphicon-user" aria-hidden="true"></span></div>
        </TD>  
        <TD width="57%"><INPUT id="username" class = "form-control" onBlur="checkUserName(this)"   
      		name="username" placeholder="username">  
            <SPAN id="username_notice" >*</SPAN></TD>  
      </TR>  
      <TR>  
        <TD align=right>
        	<div class="btn btn-default btn-lg">
        		<span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
        	</div>
        </TD>  
        <TD><INPUT id="email" class = "form-control" onBlur="checkEmail(this)" name="email" placeholder="email">  
            <SPAN id=email_notice >*</SPAN>
        </TD>
      </TR>  	
      <TR>  
        <TD align=right>
        	<div class="btn btn-default btn-lg">
        		<span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
        	</div>
		</TD>  
        <TD><INPUT id="password" class = "form-control" onBlur="checkPassword(this)" type="password" name="password" placeholder="password">  
            <SPAN id=password_notice >*</SPAN>
        </TD>  
      </TR>  
      <!-- <TR>  
        <TD align=right><STRONG>password strength:</STRONG></TD>  
        <TD><TABLE cellSpacing=0 cellPadding=1 width=145 border=0>  
          <TBODY>  
            <TR align=middle>  
              <TD id=pwd_lower width="33%">weak</TD>  
              <TD id=pwd_middle width="33%">medium</TD>  
              <TD id=pwd_high width="33%">strong</TD>  
            </TR>  
          </TBODY>  
        </TABLE></TD>  
      </TR>   -->
      <TR>  
        <TD align=right>
        	<div class="btn btn-default btn-lg">
        		<span class="glyphicon glyphicon-check" aria-hidden="true"></span>
        	</div>
		</TD>  
        <TD><INPUT id="conform_password" class = "form-control" onBlur="checkConformPassword(this)"   
      type="password" name="confirm_password" placeholder="confirm password">  
            <SPAN id=conform_password_notice >*</SPAN></TD>  
      </TR>  
      <!-- <TR>  
        <TD> </TD>  
        <TD><LABEL>  
          <INPUT type="checkbox" id="agreement" onclick="checkAgreement(this)">  
          <B>我已看过并接受《<a href="#">用户协议</a>》<SPAN id=agreement_notice >*</SPAN></B></LABEL></TD>  
      </TR>   -->
      <TR>  
        <TD  ><INPUT type=hidden value=act_register name=act></TD>  
        <TD  ><input type="submit" value=register name="Submit1" class="anniu btn btn-lg btn-primary btn-block" id="confirm" disabled></TD>  
      </TR>  
      <TR>  
        <TD colSpan=2> </TD>  
      </TR>  
    </TBODY>  
  </TABLE>  
</FORM>  
</div>
         
</body>
</html>