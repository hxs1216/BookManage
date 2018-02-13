/**
 * creater:hxs
 */


/**
 * 监听Enter键执行登陆
 */
function keyLogin(){
	
	//回车键的键值为13  
	if (event.keyCode==13){ 
       var button = $("#btnsub");
       button.click = loginIn();
	}  
}

/**
 * 功能：登陆方法 
 */
function loginIn(){
	var userId = $.trim($("#userId").val());
	if(userId == '' || userId.length == 0 || typeof(userId) == 'undefined'){
		alert("请输入您的用户名");
		$("#userId").focus();
		$("#userId").css("border","1px solid #f00");
		$("#userId").val("");
		return false;
	}
	var userPwd = $("#userPwd").val();
	if(userPwd == '' || userPwd.length == 0 || typeof(userPwd) == 'undefined'){
		alert("请输入您的密码");
		$("#userPwd").focus();
		$("#userPwd").css("border","1px solid #f00");
		return false;
	}
	document.forms[0].action="system/loginAction";
	document.forms[0].submit();
	
}
