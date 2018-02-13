//验证参数
function valiateParam() {

	//个人图书馆
	if($.trim($("[name='libraryName']").val()).length == 0) {
		alert("你还没输入个人图书馆名称");
		$("[name='libraryName']").select();
		$("[name='libraryName']").css("border","1px solid red");
		return false;
	}

	//账号
	if($.trim($("[name='loginAccount']").val()).length == 0) {
		alert("你还没输入账号");
		$("[name='loginAccount']").select();
		$("[name='loginAccount']").css("border","1px solid red");
		return false;
	}

	//密码
	if($.trim($("[name='userPwd']").val()).length == 0) {
		alert("你还没输入密码");
		$("[name='userPwd']").select();
		$("[name='userPwd']").css("border","1px solid red");
		return false;
	}

	if($.trim($("[name='userPwdOther']").val()).length == 0) {
		alert("请再次输入密码");
		$("[name='userPwdOther']").select();
		$("[name='userPwdOther']").css("border","1px solid red");
		return false;
	}

	if($("[name='userPwdOther']").val() != $("[name='userPwd']").val()){
		alert("请输入正确的密码");
		$("[name='userPwdOther']").val("");
		$("[name='userPwdOther']").select();
		$("[name='userPwdOther']").css("border","1px solid red");
		return false;
	}

	//电话
	if($.trim($("[name='connectPhone']").val()).length == 0) {
		alert("你还没输入电话");
		$("[name='connectPhone']").select();
		$("[name='connectPhone']").css("border","1px solid red");
		return false;
	}

	//微信号
	if($.trim($("[name='wechatAccount']").val()).length == 0) {
		alert("你还没输入微信号");
		$("[name='wechatAccount']").select();
		$("[name='wechatAccount']").css("border","1px solid red");
		return false;
	}

	//个人图书馆介绍
	if($.trim($("[name='libraryIntroduce']").val()).length == 0) {
		alert("你还没输入个人图书馆介绍");
		$("[name='libraryIntroduce']").select();
		$("[name='libraryIntroduce']").css("border","1px solid red");
		return false;
	}
	return true;
}

//返回首页
function backIndex(){
	window.location.href="<%=basePath%>jsp/index.jsp";
}

