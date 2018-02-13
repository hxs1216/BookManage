<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="head">
    <div class="headbox">
        <div class="logo" onclick="locationChange('index')"><img src="<%=basePath%>images/logo.png" alt="我的书生" /></div>
        <div class="loginbox">
            <span class="login" onclick="locationChange('login');"><a href="javascript:void(0);">登录</a></span>
            <span class="register" onclick="locationChange('register');"><a href="javascript:void(0);">注册</a></span>
        </div>
    </div>
</div>
<script type="text/javascript">

    //页面跳转
    function locationChange(type) {
        if(type == "login"){
            window.location.href="<%=basePath%>jsp/login.jsp";
        }else if(type == "register"){
            window.location.href="<%=basePath%>jsp/register.jsp";
        }else if(type == "index"){
            window.location.href="<%=basePath%>system/allBook";
        }

    }
</script>
