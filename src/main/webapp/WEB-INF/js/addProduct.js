function showAddPage() {
	/*$("#form1").empty();
	$('#form2').empty();
	$('#queryDiv').empty();*/
	$('#checkButton').hide();
	$('#emptyButton').hide();
	var form1 = $("#form1");
	var form2 = $('#form2');
	var queryDiv = $('#queryDiv');
	var tableResult = $('#tableResult');
	tableResult.hide();
	queryDiv.hide();
	form1.hide();
//	form2.hide();
//	$('body').append('<select name="city" lay-verify=""><option value="010">北京</option><option value="021">上海</option><option value="0571" selected>杭州</option></select>');
	
	var table = $('<TABLE width="100%" align=center border=0 id="table"></TABLE>');
	var tbody = $('<TBODY></TBODY>');
	var tr1 = $('<TR></TR>');
	var type_td = $('<TD><INPUT id="productName" name="productType" onBlur="checkProductType(this)" placeholder="product type"></TD>');
	var type_span = $('<SPAN id="username_notice" >*</SPAN>');
	type_td.append(type_span);
	tr1.append(type_td);
	tbody.append(tr1);
	
	var tr2 = $('<TR></TR>');
	var name_td = $('<TD><INPUT id="emial" name="description" placeholder="product name"></TD>');
	var name_span = $('<SPAN id=email_notice >*</SPAN>');
	name_td.append(name_span);
	tr2.append(name_td);
	tbody.append(tr2);
	
	var tr3 = $('<TR></TR>');
	var price_td = $('<TD><INPUT id="password"  type="text" name="price" placeholder="price"></TD>');
	var price_span = $('<SPAN id=password_notice >*</SPAN>');
	price_td.append(price_span);
	tr3.append(price_td);
	tbody.append(tr3);
	
	var tr4 = $('<TR></TR>');
	var period_td = $('<TD><INPUT id="conform_password"  type="text" name="period" placeholder="quality guarantee period"></TD>');
	var period_span = $('<SPAN id=period_notice >*</SPAN>');
	period_td.append(period_span);
	tr4.append(period_td);
	tbody.append(tr4);
	
	var tr5 = $('<TR></TR>');
	var button_td = $('<TD><input type="submit" value="add item" name="Submit1" class ="anniu" id="confirm"></TD>');
	tr5.append(button_td);
	tbody.append(tr5);
	
	var aa = '<%=request.getContextPath()%>/add/successed';
	form2.attr({"name":"formProduct", "method":"post"});
	form2.append(table);
	form2.append(tbody);
//	$("#table").show();
	return;
}

function showShoppingPage() {
	
	$("#table").hide();
	
	$('#checkButton').show();
	$('#emptyButton').show();
	
	$("#form1").show();
	$('#queryDiv').show();
	$('#tableResult').show();
	return;
}

function AddProduct() {
	var tableChildren = $('#tableBody').children();
	console.info(tableChildren);
//	var count = tableChildren.length;
	if (tableChildren.length > 0) {
		//there is no product in shopping car
		console.info(tableChildren.length);
//		alert('no goods!');
		layer.open({
			  type: 1,
			  area: ['300px', '120px'],
			  shadeClose: true, //点击遮罩关闭
			  content: '\<\div style="padding:20px;">please finish this deal first!\<\/div>'
			  });
		return;
	} else {
		console.info("tiaohzuan");
		window.location.href=getRootPath()+"add";
		//showAddPage();
		
	}
	
}

function HomePage() {
	showShoppingPage();
	return;
}

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