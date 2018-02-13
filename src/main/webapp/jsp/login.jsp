<%@include file="common/head.jsp" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>登录 | 我的书生</title>
	<link rel="stylesheet" href="<%=basePath%>css/login.css">
	<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
</head>
<body onkeydown="keyLogin();">
<form method="post">
<div id="head">
	<a href="index.jsp"><img src="<%=basePath%>images/logo.png" alt="我的书生" /></a>
</div>
<div class="box">
 <div class="cnt">
	<div id="huanying" style="text-align: center;">欢迎登录</div>
	<hr>
	<div>
	   <form class="bs-example bs-example-form" role="form">
		  <div class="input-group">
			  <span class="input-group-addon"><img src="<%=basePath%>images/login/zhanghao.png"></span>
			  <input type="text" name="loginAccount" value="${user.loginAccount}" class="form-control" placeholder="请输入你的账号">
		  </div>
		   <br>
		  <div class="input-group">
			  <span class="input-group-addon"><img src="<%=basePath%>images/login/password.png"></span>
			  <input type="password" name="userPwd" value="${user.userPwd}" class="form-control" placeholder="请输入你的密码">
		  </div>
	   </form>
	</div>
	<div style="margin-top:40px;">
	   <input id="btnsub" class="form-control btn btn-info" type="button" value="登录" onclick="loginIn();"/>
	</div>
 </div>
</div>
</form>
</body>
</html>
<script type="text/javascript">

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
		if($.trim($("[name='loginAccount']").val()).length == 0){
			alert("请输入你的账号");
			$("[name='loginAccount']").focus();
			$("[name='loginAccount']").css("border","1px solid #f00");
			$("[name='loginAccount']").val("");
			return false;
		}
		if($.trim($("[name='userPwd']").val()).length == 0){
			alert("请输入你的密码");
			$("[name='userPwd']").focus();
			$("[name='userPwd']").css("border","1px solid #f00");
			return false;
		}

		$.ajax({
			url:'<%=basePath%>system/loginAction',
			type:'post',
			dataType:'json',
			async:'false',
			data:$('form').serialize(),
			success:function(data){
				if(data.show == "1"){
					alert(data.content);
					$("[name='loginAccount']").val("");
					$("[name='userPwd']").val("");
					$("[name='loginAccount']").focus();
					$("[name='loginAccount']").css("border","1px solid #f00");
				}else if(data.show == "2"){
					alert(data.content);
					$("[name='userPwd']").val("");
					$("[name='userPwd']").focus();
					$("[name='userPwd']").css("border","1px solid #f00");
				}else{
					window.location.href = "<%=basePath%>system/loginIn";
				}

			}
		});


	}
</script>
