var process_request = "<img src='loading.gif' width='16' height='16' border='0' align='absmiddle'>正在数据处理中...";  
var productType_empty = "<span style='COLOR:#ff0000'>  × 产品类型不能为空!</span>";  
var produtcType_longer = "<span style='COLOR:#ff0000'> × 产品类型长度不能大于 40个字符。</span>";  
//var productType_name_invalid = "- 产品类型和产品名称只能是由字母数字以及下划线组成。";
var price_empty = "<span style='COLOR:#ff0000'> × 登录密码不能为空。</span>";
var productName_longer = "<span style='COLOR:#ff0000'> × 产品类型长度不能大于 40个字符。</span>";  
var productName_empty = "<span style='COLOR:#ff0000'> × 产品名称不能为空！</span>";
var period_empty = "<span style='COLOR:#ff0000'> × 保质期密码不能为空。</span>";
var ok ="<span></span>"; 
var empty="<span style='COLOR:#ff0000'>*</span>";
var productType_flag=false;
var productName_flag=false;
var price_flag=false;
var qualityGuaranteePeriod_flag=false;

$(function(){
	change_submit();	
});

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
/*
 * 产品类型检测
 */
function checkProductType(productType) {
	if (productType.value.length < 1) {
//		showInfo("username_notice", productType_empty);
		showInfo("username_notice", empty);
	} else if(productType.value.length>39){
		showInfo("username_notice", empty);
    } else {
    	showInfo("username_notice", ok);
    	productType_flag = true;
    	change_submit();
    	return;
    }
	productType_flag=false;
	change_submit();
}  
/*
 * ProductType检测是否包含非法字符
 */
function checks(t) {
	szMsg = "[#%&\'\"\\,;:=!^@]"
	for (i = 1; i < szMsg.length + 1; i++) {
		if (t.indexOf(szMsg.substring(i - 1, i)) > -1) {
			return false;
		}
	}
	return true;
}
/*
 * 产品名称检测
 */
 function checkProductName(description) {
	if (description.value.length < 1) {
//		showInfo("email_notice", productName_empty);
		showInfo("email_notice", empty);
	} else if(description.value.length>199){
		showInfo("email_notice", empty);
    } else {
    	showInfo("email_notice", ok);
    	productName_flag = true;
    	change_submit();
    	return;
    }
 
	productName_flag=false;
	change_submit();
} 

/*
 * 价格检测
 */
 function checkPrice( price )  
 {  
	 if(price.value.length < 1){
		 password_flag=false;
//         showInfo("password_notice",price_empty);
		 showInfo("password_notice",empty);
         change_submit();
	 } else {
		 showInfo("password_notice", ok);
         price_flag = true;
     	 change_submit();
     	 return;
     }  
 }  
 
 function checkPeriod(period) {
	 if(period.value.length < 1) {
//		 showInfo("period_notice", period_empty);
		 showInfo("period_notice", empty);
	 } else {
		 showInfo("period_notice", ok);
		 qualityGuaranteePeriod_flag = true;
		 change_submit();
		 return;
	 }
	 
	 qualityGuaranteePeriod_flag = false;
	 change_submit();
	 return;
	 
 }
 
function change_submit()  
{   	
	console.info("check");
	if(productType_flag&&productName_flag&&price_flag&&qualityGuaranteePeriod_flag){
		console.info("keyi");
		  document.forms['formProduct'].elements['Submit1'].disabled = ''; 
		   //$('#confirm').attr("disabled","");   
	}
   else  
     {  
	   		console.info("no");
          //document.forms['formProduct'].elements['Submit1'].disabled = 'disabled';  
          $('#confirm').attr("disabled","disabled");
     }  
}
 


 
/*
 * 公用程序
 */  
    function showInfo(target,Infos){  
    document.getElementById(target).innerHTML = Infos;  
    }  
    function showclass(target,Infos){  
    document.getElementById(target).className = Infos;  
    }     