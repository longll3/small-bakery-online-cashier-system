function AddItems(id) {
	
	var totalPrice = $('#totalPrice');
	if (totalPrice.length > 0) {
		layer.msg('please finish this deal first!',{time: 700});
		return;
	} else {
		var t = "#"+id;
//		var count = new Number($(t).text());
		var t1 = "p."+id+"type";
		var t2 = "h3."+id;
		var t3 = "p."+id+"price";
		var type = $(t1).text();
		var name = $(t2).text();
		var price = $(t3).text();
		
		console.info("type: "+type);
		console.info("name: "+name);
		console.info("price: "+price);
		
		var count;
		var t4 = "#"+id;
//		console.info($(t4).text());
		if ($(t4).text() == "") {
//			console.info("none");
			count = 1;
			$("#tableBody").append('<tr class = "'+id+'"></tr>');
			var tr = $("#tableBody").find($('tr.'+id));
			
			tr.append('<td>' + type + '</td>');
		    tr.append('<td>' + name + '</td>');
		    tr.append('<td>' + price + '</td>');
		    tr.append('<td id="'+id+'">' + count + '</td>');
		    var td_id = $('<td>'+id+'</td>');
		    tr.append(td_id);
		    td_id.hide();
		} else {
			
			count = new Number($(t4).text());
			count += 1;
			
//			console.info(count);
			showInfo(id, count.toString());
		}
		return;
	}
	
	
}

function CutItems(id) {
	var t = "#"+id;
	var t1 = "p."+id+"type";
	var t2 = "h3."+id;
	var t3 = "p."+id+"price";
	var type = $(t1).text();
	var name = $(t2).text();
	var price = $(t3).text();
	var count;
	var t4 = "#"+id;
	console.info($(t4).text());
	if ($(t4).text() == "") {
		alert("you didn't put it in shorpping cart!");
		return;	
	} else {
		count = new Number($(t4).text());
		if (count > 1) {
			count -= 1;
			console.info("cut "+count);
			showInfo(id, count.toString());
			return;
		} else {
			console.info(count);
			var tr = $('tr.'+id);
			tr.remove();
			return;
		}
		
	}
}




function checkOut() {
	
	var tableChildren = $('#tableBody').children();
	console.info(tableChildren);
	if (tableChildren.length == 0) {
		//there is no product in shopping car
		console.info(tableChildren.length);
		layer.msg('no goods!',{time: 700});
		return;
	} else {
		var id_info = "";
		var count_info = "";
//		var  map = new Map();
//		map.clear();
		var price_total = 0;
		$(tableChildren).each(function(){
			
			var price_unit = this.childNodes[2].textContent;
			console.info("price_unit "+price_unit);
			
			var count_str = this.childNodes[3].textContent;
			console.info("count_str "+count_str);
			
			var productId = this.childNodes[4].textContent;
			console.info("id "+ productId);
			
			id_info += productId+" ";
			count_info += count_str +" ";
//			map.set(productId,count_str);
			
			var price = price_unit * count_str;
			price_total += price;
		});
		console.info(id_info);
		console.info(count_info);
		var info = "";
		info = id_info + "*" + count_info;
		console.info(info);

//		map.forEach(function (item, key, mapObj) {
//			console.info(item.toString());
//			console.info(key.toString());
//		});

		var form = $('#form2');
		form.append('<div id = "totalPrice" class = "caption"></div>');
		var div = $('#totalPrice');
		var h3 = "The total price is: "+price_total+" RMB"; 
		var btn = $('<button id="submitRecord" class="btn btn-primary" type="button">next sale</button>');
		var cancle = $('<button id="cancleCheckout" class="btn btn-primary" type="button">cancel</button>')
		btn.click(function() {
			SubmitRecord(info);
		});
		cancle.click(function() {
			div.remove();
		});
//		var info_span = $('<span id="info_span">'+info+'</span>');
		
		div.append('<h3 >'+h3+'</h3>');
		div.append(btn);
		div.append(cancle);
//		div.append(info_span);
//		info_span.hide();
		return;
	}
}

function SubmitRecord(info) {
	console.info(info);
	
	/*var info = $('#info_span').text();
	console.info(info);*/
	
	var records = info.split("*");
	console.info(records);
	/*records.forEach(function(){
		console.info(this);
	}*/
	var product_id = records[0];
	var count = records[1];
	
	$.ajax({
		type: "post",
		url: getRootPath() + "checkout",
		dataType: 'json',
		data: {product_id : product_id, count: count},
		success: function(json) {
			if (json.flag) {
				return;
			} else {
				layer.msg('check out failed',{time: 700});
				return;
			}
		} 
	
	});
	
	
	
	$('#totalPrice').remove();
	clearShoppingCart();
	
	
	return;
}

function clearShoppingCart() {
	$('#tableBody').empty();
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