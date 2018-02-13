<%@ page import="com.biyao.common.util.SysConfigUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../common/head.jsp" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>新增书目 | 我的书生</title>
    <link href="<%=basePath%>css/mylibrary.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=basePath%>js/ajaxfileupload.js"></script>
</head>
<body onkeydown="keyLogin();">
<center>
    <%@ include file="../common/loginHead.jsp"%>
    <form method="post">
        <input type="hidden" name="bookImage"/>
        <div id="main" >
            <div class="tablebox">
                <div class="book_blank">
                    <label>
                        <img src="<%=basePath%>images/touch.jpg" id="phonoImg" style="height:200px;width:190px;border: 1px solid" />
                        <input type="file" id="uploadFile" name="file" onchange="uploadPhono();" style="display: none;"/>
                    </label>
                    <div><font color="red">(说明：请上传550*600像素的图片)</font></div>
                </div>
                <div class="content_blank">
                    <table>
                        <tr><td class="title2">书名</td><td class="table_content2"><input class="input400" type="text" name="bookName"/></td></tr>
                        <tr><td class="title2">系列</td><td class="table_content2"><input class="input400" type="text" name="bookSeries"/></td></tr>
                        <tr><td class="title2">作者</td><td class="table_content2"><input class="input400" type="text" name="bookAuthor"/></td></tr>
                        <tr>
                            <td class="title2">类别</td>
                            <td class="table_content2">
                            <c:forEach items="${dictionary}" var="type" varStatus="typeIndex">
                                <c:if test="${type.cfgType == 'book_type'}">
                                    <input type="radio" name="bookType" value="${type.cfgValueId}"/> ${type.cfgValue}&nbsp;&nbsp;
                                    <c:if test="${typeIndex.index>0}">${typeIndex.index%4==0?"<br/>":""}</c:if>
                                </c:if>
                            </c:forEach>
                            </td>
                        </tr>
                        <tr>
                            <td class="title2">年龄段</td>
                            <td class="table_content2">
                            <c:forEach items="${dictionary}" var="age" varStatus="ageIndex">
                                <c:if test="${age.cfgType == 'book_age'}">
                                    <input type="radio" name="bookAge" value="${age.cfgValueId}"/> ${age.cfgValue}&nbsp;&nbsp;
                                </c:if>
                            </c:forEach>
                            </td>
                        </tr>
                        <tr>
                            <td class="title2">状态</td>
                            <td class="table_content2">
                            <c:forEach items="${dictionary}" var="statu" varStatus="typeIndex">
                                <c:if test="${statu.cfgType == 'book_status'}">
                                    <input type="radio" name="bookStatus" value="${statu.cfgValueId}"/> ${statu.cfgValue}&nbsp;&nbsp;
                                </c:if>
                            </c:forEach>
                            </td>
                        </tr>
                        <tr><td class="title2">简介</td><td class="table_content2"><textarea class="box" name="express1"></textarea> </td></tr>
                        <tr><td class="title2">自我点评</td><td class="table_content2"><textarea class="box" name="bookComment"></textarea> </td></tr>

                        <tr>
                            <td></td>
                            <td class="table_content2">
                                <input type="button" class="register" onclick="submitCommit();" value="提交保存"/>
                                <input type="button" class="login" onclick="quxiao();" value="取消返回"/>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        </form>
</center>
<div id="foot">&nbsp;</div>
</body>
</html>

<script type="text/javascript">

    function keyLogin(){
        //回车键的键值为13
        if (event.keyCode==13){
            submitCommit();
        }
    }

    //取消返回
    function quxiao(){
        window.location.href = "<%=basePath%>book/myLibrary";
    }

    //提交保存
    function submitCommit(){

        //验证
        if(!valiateParams()){
            return false;
        }

        //书目进行保存
        if(confirm("你确定保存吗")){
            $(".register").attr("disabled","disabled");
            $.ajax({
                url:'<%=basePath%>book/bookAdd',
                type:'post',
                dataType:'json',
                async:'false',
                data:$('form').serialize(),
                success:function(data){
                    if(data.show){
                        alert(data.content);
                        window.location.href = "<%=basePath%>book/myLibrary";
                    }else{
                        alert(data.content);
                    }
                }
            });
        }

    }

    //验证参数
    function valiateParams() {

        //图片
//        if($("#phonoImg").attr("src")==""){
//            alert("请上传该书目图片");
//            return false;
//        }


        //书名
        if($.trim($("[name='bookName']").val()).length == 0) {
            alert("你还没输入书名");
            $("[name='bookName']").select();
            $("[name='bookName']").css("border","1px solid red;");
            return false;
        }

        //系列
        if($.trim($("[name='bookSeries']").val()).length == 0) {
            alert("你还没输入系列");
            $("[name='bookSeries']").select();
            $("[name='bookSeries']").css("border","1px solid red;");
            return false;
        }

        //作者
        if($.trim($("[name='bookAuthor']").val()).length == 0) {
            alert("你还没输入作者");
            $("[name='bookAuthor']").select();
            $("[name='bookAuthor']").css("border","1px solid red;");
            return false;
        }

        //类别
        var typeIndex = 0;
        $.each($("[name='bookType']"),function(){
            if(!$(this)[0].checked){
                typeIndex++;
            }
        })
        if(typeIndex==$("[name='bookType']").length){
            alert("你还没选择类型");
            return false;
        }

        //年龄段
        var ageIndex = 0;
        $.each($("[name='bookAge']"),function(){
            if(!$(this)[0].checked){
                ageIndex++;
            }
        })
        if(ageIndex==$("[name='bookAge']").length){
            alert("你还没选择年龄段");
            return false;
        }

        //状态
        var statusIndex = 0;
        $.each($("[name='bookStatus']"),function(){
            if(!$(this)[0].checked){
                statusIndex++;
            }
        })
        if(statusIndex==$("[name='bookStatus']").length){
            alert("你还没选择状态");
            return false;
        }

        //简介
        if($.trim($("[name='express1']").val()).length == 0) {
            alert("你还没输入简介");
            $("[name='express1']").select();
            $("[name='express1']").css("border","1px solid red;");
            return false;
        }

        //发表点评
        if($.trim($("[name='bookComment']").val()).length == 0) {
            alert("你还没输入发表点评");
            $("[name='bookComment']").select();
            $("[name='bookComment']").css("border","1px solid red;");
            return false;
        }
        return true;
    }

    //上传图片
    var imgType="gif,jpg,jpeg,bmp,png,psd";
    function uploadPhono(){
        var fileName=$("#uploadFile").val();
        if(-1==imgType.indexOf(fileName.substring(fileName.lastIndexOf(".")+1))){
            alert("请上传图片类型：gif,jpg,jpeg,bmp,png,psd");
            return;
        }

        //异步提交文件表单
        $.ajaxFileUpload({
            url :'<%=basePath%>book/uploadImage',
            secureuri : false,
            fileElementId : 'uploadFile', //文件选择框的id属性
            dataType : 'text', //服务器返回的格式，可以是json
            success : function(data, status) //相当于java中try语句块的用法
            {
                //绑定一个时间的参数，可以解除浏览器的缓存问题
                $("#phonoImg").attr("src","<%=SysConfigUtil.configProperties.getProperty("ftp.url")%>"+data);
                $("[name='bookImage']").val(data);
            },error : function(data, status, e)
            {
                alert("上传失败");
            }
        });
    }


</script>
