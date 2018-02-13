<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="head">
    <div class="headbox">
        <div class="logo" onclick="locationChange('index')"><img src="<%=basePath%>images/logo.png" alt="我的书生" /></div>
        <div class="loginbox">
            <span style="margin-left: 20px;font-size: 15px;">${sessionScope.currentUser.loginAccount}</span>
            <span style="margin-left: 5px;"><a href="javascript:void(0);" onclick="quitSystem();" style="color: rgb(0,175,255);">退出</a></span>
        </div>
        <div class="loginbox">
            <span class="login" onclick="locationChange('library')"><a href="javascript:void(0);">我的图书</a></span>
            <span class="register" onclick="locationChange('shopping')"><a href="javascript:void(0);">购物车</a></span>
        </div>
    </div>
</div>
<script type="text/javascript">

    //页面跳转
    function locationChange(type) {
        if(type == "library"){
            window.location.href="<%=basePath%>book/myLibrary";
        }else if(type == "shopping"){
            window.location.href="<%=basePath%>shopping/showShopping";
        }else if(type == "index"){
            window.location.href="<%=basePath%>system/loginIn";
        }

    }

    //退出系统
    function quitSystem() {
        if(confirm("你确定退出系统")){
            window.location.href="<%=basePath%>system/loginOut";
        }
    }
</script>
