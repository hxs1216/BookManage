<%@include file="common/head.jsp" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>注册 | 我的书生</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/register.css"/>
    <script type="text/javascript" src="<%=basePath%>js/system/register.js"></script>
</head>
<body onkeydown="keyLogin();">
<center>
    <%@ include file="common/IndexHead.jsp"%>
<div id="main" style="text-align: center;">
    <form method="post">
        <table class="register_box">
            <thead><tr style="text-align: left;"><td></td><td>用户注册</td></tr></thead>
            <tbody>
            <tr>
                <td class="td_left">个人图书馆的名字</td>
                <td class="td_right"><input class="input500" type="text" name="libraryName" placeholder="给您自己的图书馆起个炫炫的名字吧"/></td>
            </tr>
            <tr>
                <td class="td_left">账号</td>
                <td class="td_right"><input class="input200" type="text" name="loginAccount"/></td>
            </tr>
            <tr>
                <td class="td_left">输入密码</td>
                <td class="td_right"><input class="input200" type="password" name="userPwd"/></td>
            </tr>
            <tr>
                <td class="td_left">再次输入密码</td>
                <td class="td_right"><input class="input200" type="password" name="userPwdOther"/></td>
            </tr>
            <tr>
                <td class="td_left">Email</td>
                <td class="td_right"><input class="input500" type="text" name="email" placeholder="幼儿、儿童或少年若没有，请填入父母的便于接受求借/索取信息"/></td>
            </tr>
            <tr>
                <td class="td_left">电话</td>
                <td class="td_right"><input class="input200" type="text" name="connectPhone"/></td>
            </tr>
            <tr>
                <td class="td_left">QQ</td>
                <td class="td_right"><input class="input200" type="text" name="qqAccount"/></td>
            </tr>
            <tr>
                <td class="td_left">微信号</td>
                <td class="td_right"><input class="input200" type="text" name="wechatAccount" placeholder="用于登录"/></td>
            </tr>
            <tr>
                <td class="td_left">地区选择</td>
                <td class="td_right"><input class="input100" type="text" name="nation" placeholder="国家"/>-<input class="input100" type="text" name="province" placeholder="省/市"/>-<input class="input100" type="text" name="city" placeholder="市/县/区"/></td>
            </tr>
            <tr>
                <td class="td_left">所在学校/单位</td>
                <td class="td_right"><input class="input500" type="text" name="workUnit" placeholder="请填入完整的学校/单位名"/></td>
            </tr>
            <tr>
                <td class="td_left">班级</td>
                <td class="td_right"><input class="input500" type="text" name="grade"/></td>
            </tr>
            <tr>
                <td class="td_left">个人图书馆介绍</td>
                <td class="td_right"><textarea name="libraryIntroduce"></textarea></td>
            </tr>
            </tbody>
            <tfoot>
            <tr>
                <td class="td_left"></td>
                <td class="td_right">
                    <span class="btn_red" onclick="submitRes();"><a href="javascript:void(0);">提交注册</a></span>
                    <span class="btn_grey" onclick="backIndex();"><a href="javascript:void(0);">取消返回</a></span>
                </td>
            </tr>
            </tfoot>
        </table>
    </form>
</div>
</div>
</center>
</body>
</html>
<script type="text/javascript">

    $(function () {
        //无法输入汉字
        $("[name='loginAccount']").textal();
        $("[name='userPwd']").textal();
        $("[name='userPwdOther']").textal();
        $("[name='email']").textal();
        $("[name='connectPhone']").textal();
        $("[name='qqAccount']").textal();
        $("[name='wechatAccount']").textal();
    })
    
    //取消返回
    function backIndex() {
        window.location.href="<%=basePath%>system/allBook";
    }

    function keyLogin(){

        //回车键的键值为13
        if (event.keyCode==13){
            submitRes();
        }
    }

    //提交注册
    function submitRes(){

        //验证
        if(!valiateParam()){
            return false;
        }

        $.ajax({
            url:'<%=basePath%>system/regist',
            type:'post',
            dataType:'json',
            async:'false',
            data:$('form').serialize(),
            success:function(data){
                if(data.show == "1"){
                    alert(data.content);
                    $("[name='libraryName']").val("");
                    $("[name='libraryName']").select();
                    $("[name='libraryName']").css("border","1px solid red;");
                }else if(data.show == "2"){
                    alert(data.content);
                    $("[name='loginAccount']").val("");
                    $("[name='loginAccount']").select();
                    $("[name='loginAccount']").css("border","1px solid red;");
                }else{
                    alert(data.content);
                    window.location.href = "<%=basePath%>jsp/login.jsp";
                }

            }
        });
    }
</script>



