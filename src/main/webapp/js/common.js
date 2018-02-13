

/**
 * 格式化为人民币格式
 * @param {Object} varStr 数值字符
 * @return {TypeName} 格式化后的字符
 */
function fomatMoney(varStr) {
	if (varStr == '' || varStr.trim() == '')
		return '';

	var s = varStr.split('.');
	var v0 = s[0];//.replace(/,/g,'');
	var v = '';
	while (v0.length > 3) {
		if (v != '') {
			v = v0.substr(v0.length - 3, 3) + ',' + v;
		} else {
			v = v0.substr(v0.length - 3, 3)
		}
		v0 = v0.substring(0, v0.length - 3);
	}
	if (v != '') {
		v = v0 + ',' + v;
	} else {
		v = v0;
	}
	if (s.length == 2) {
		var s1 = s[1].length > 2 ? s[1].substr(0, 2) : s[1];
		v = v + '.' + s1;
	} else {
		v = v + '.00';
	}
	return v;
}

// 清空页面值
function ClearAllText() {   
     $(":text").each(function(){ 
     $(this).val("");
     });
     
     var pagesize = $("#page_pageSize").val();
      $("select").each(function(){ 
        $(this).children("option:first").attr('selected','selected');
     });
      $("#page_pageSize").val(pagesize);
      
}


/**
 * 将意见存入cookie中
 * 
 */
function addCookie(objName,objValue,objHours){// 添加cookie
	if (typeof objValue == "undefined")
	{
	    return;
	} 
	var str = objName + "=" + escape(objValue);
	if(objHours > 0){// 为0时不设定过期时间，浏览器关闭时cookie自动消失
		var date = new Date();
		var ms = objHours*3600*1000;
		date.setTime(date.getTime() + ms);
		str += "; expires=" + date.toGMTString();
	}
	document.cookie = str;
// alert("添加cookie成功");
}

function getCookie(objName){// 获取指定名称的cookie的值
	var arrStr = document.cookie.split("; ");
	for(var i = 0;i < arrStr.length;i ++){
		var temp = arrStr[i].split("=");
		if(temp[0] == objName){
			if (typeof temp[1] == "undefined")
			{
			    return "";
			} 
			return unescape(temp[1]);
		}
	} 
}

function delCookie(name){// 为了删除指定名称的cookie，可以将其过期时间设定为一个过去的时间
	var date = new Date();
	date.setTime(date.getTime() - 10000);
	document.cookie = name + "=a; expires=" + date.toGMTString();
}



//获取当前文本框选中的文本
function getSelectedText(domObj) {
    if (domObj.selectionStart || domObj.selectionStart == '0') {
        return domObj.value.substring(domObj.selectionStart, domObj.selectionEnd);
    }else if (document.selection) { //for IE
        domObj.focus();
        var sel = document.selection.createRange();
        return sel.text;
    }
    else return '';
}

//限制文本框只能输入数字，并屏蔽输入法和粘贴  
$.fn.numeral = function() {     
	   $(this).css("ime-mode", "disabled");
	   this.bind("keypress",function(e) {
	   	   var code = (e.keyCode ? e.keyCode : e.which);  //兼容火狐 IE
		   if((e.keyCode==0x8))  //火狐下不能使用退格键
		   {
				return ;
			}
			   return code >= 48 && code<= 57;
	   });
	   this.bind("blur", function() {
		   if (this.value.lastIndexOf(".") == (this.value.length - 1)) {
			   this.value = this.value.substr(0, this.value.length - 1);
		   } else if (isNaN(this.value)) {
			   this.value = "";
		   }
	   });
	   this.bind("paste", function() {
		   var s = clipboardData.getData('text');
		   if (!/\D/.test(s));
		   value = s.replace(/^0*/, '');
		   return false;
	   });
	   this.bind("dragenter", function() {
		   return false;
	   });
	   this.bind("keyup", function() {
	   if (this.value != "0" && /(^0+)/.test(this.value)) {
		   this.value = this.value.replace(/^0*/, '');
		   }
	   });
};

//只能输入英文与数字，并屏蔽输入法和粘贴
$.fn.textal = function() {
	$(this).css("ime-mode", "disabled");
	var regNumber = /.*([\u4e00-\u9fa5]).*/;
	this.bind("keypress",function(e) {
		var code = (e.keyCode ? e.keyCode : e.which);  //兼容火狐 IE
		//火狐下不能使用退格键
		if((e.keyCode==0x8)){
			return ;
		}
		return true;
	});
	this.bind("blur", function() {

		if (this.value.lastIndexOf(".") == (this.value.length - 1)) {
			this.value = this.value.substr(0, this.value.length - 1);
		}else if(regNumber.test(this.value)){
			this.value = "";
		}
	});
	this.bind("paste", function() {
		var s = clipboardData.getData('text');
		if(regNumber.test(this.value)){
			this.value = "";
		}
	});
	this.bind("dragenter", function() {
		return false;
	});
	this.bind("keyup", function() {
		if(regNumber.test(this.value)){
			this.value = "";
		}
	});
};

//取消返回
function returnMain(bath){
	if(confirm("你确定退出吗")){
		window.location.href = bath+"jsp/login.jsp";
	}
}

//分页跳转
function goto(count) {
	$("[name='currentPage']").val(count);
	document.forms[0].submit();
}

function SetArticleId(o, i) {
	if (o.checked) {
		AddCookie(i)
	}else {
		RemoveCookie(i)
	}
}

function SetCookie(name, value) {
	document.cookie = name + "=" + escape(value);
}

//获取cookie中的值
function GetCookie(name) {
	if (document.cookie.length > 0) {
		c_start = document.cookie.indexOf(name + "=");
		if (c_start != -1) {
			c_start = c_start + name.length + 1;
			c_end = document.cookie.indexOf(";", c_start);
			if (c_end == -1) c_end = document.cookie.length;
			return unescape(document.cookie.substring(c_start, c_end));
		}
	}
	return "";
}

//添加cookie的值
function AddCookie(i) {
	d = GetCookie("ArticleId");
	if (d == "") d = "|";
	if (d.indexOf("|" + i + "|") == -1) {
		d += i + "|";
		SetCookie("ArticleId", d);
	}
}

function RemoveCookie(i) {
	d = GetCookie("ArticleId");
	var reg = new RegExp("\\|" + i + "\\|");
	if (reg.test(d)) {
		d = d.replace(reg, "|");
		SetCookie("ArticleId", d);
	}
}

function  RemoveArticle() {
	var date=new Date();
	date.setTime(date.getTime()-10000);
	document.cookie="ArticleId"+"=v; expires="+date.toGMTString();
}




