<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="common/head.jsp" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>书籍作者 | 我的书生</title>
    <link href="<%=basePath%>css/content.css" rel="stylesheet" type="text/css" />
</head>
<body>
<center>
    <%@ include file="common/loginHead.jsp"%>
    <form method="post">
        <input type="hidden" name="bookSeries" value=""/>
        <input type="hidden" name="bookAuro" value="${searchKey}"/>
        <input type="hidden" name="library" value=""/>
        <input type="hidden" name="bookIds" value=""/>
        <div style="position: absolute;top: 120px;left: 300px;">
            <input type="text" name="searchKey" class="search_text" value="${searchKey}" placeholder="搜索书名/作者/图书系列/个人图书馆"/>
            <input type="button" onclick="search();" class="search_button" value="搜索"/>
        </div>
        <div id="main">
            <div class="tablebox">
                <h1 style="margin-top: 194px;"></h1>
                <table class="index_table">
                    <thead>
                    <tr>
                        <td class="td1"><input type="checkbox" onclick="allCheck(this);"/></td>
                        <td class="td2">书名</td>
                        <td class="td2">系列</td>
                        <td class="td2">作者</td>
                        <td class="td2" >类别</td>
                        <td class="td2">年龄段</td>
                        <td class="td2">状态</td>
                        <td class="td2">个人图书馆</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${books}" var="book" varStatus="status">
                        <tr bgcolor="${(status.index)%2==0?'#eee':'#ffffff'}">
                            <td><input  id="book_${book.id}" type="checkbox" onclick="SetArticleId(this,'book_${book.id}');"/></td>
                            <td><a href="<%=basePath%>system/bookOtherDetail/${book.id}">${book.bookName}</a></td>
                            <td><a href="javascript:void(0);" onclick="showOtherBook('1','${book.bookSeries}');">${book.bookSeries}</a></td>
                            <td>${book.bookAuthor}</td>
                            <td>${book.bookType}</td>
                            <td>${book.bookAge}</td>
                            <td>${book.bookStatus}</td>
                            <td><a href="javascript:void(0);" onclick="showOtherBook('3','${book.bookLibrary}');">${book.bookLibrary}</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                    <tfoot>
                    <tr>
                        <td colspan="8">
                            <ol>
                                <li class="cart" onclick="addShopping();"><a href="javascript:void(0);">将已选书目加入您的求借和索取清单</a></li>
                                <c:forEach begin="${page.startPage}" step="1" end="${page.endPage}" var="count">
                                    <input type="hidden" name="currentPage" value="${page.currentPage}"/>
                                    <li class="${count==page.currentPage?'current_page':null}" onclick="goto('${count}');">${count}</li>
                                </c:forEach>
                            </ol>
                        </td>
                    </tr>
                    </tfoot>
                </table>
            </div>
        </div>
    </form>
</center>
<div id="foot">&nbsp;</div>
</body>
</html>
<script type="text/javascript">
    var index = '${fn:length(books)}';

    $(function(){
        d = GetCookie("ArticleId");
        var check=[];
        check=d.split("|");
        check.splice(0,1);
        check.splice(check.length-1,1);
        for(var i=0;i<check.length;i++){
            console.log(check[i]);
            $("#"+check[i]).attr('checked','true');
        }
    });

    //将已选书目加入购物车中
    function addShopping(){
        var bookIds = "";
        d = GetCookie("ArticleId");
        var check=[];
        check=d.split("|");
        check.splice(0,1);
        check.splice(check.length-1,1);
        for(var i=0;i<check.length;i++){
            if(check[i].indexOf("book") != -1){
                bookIds = bookIds + check[i].substring(check[i].indexOf("_")+1,check[i].length)+",";
            }
        }
        if(bookIds=="" || bookIds ==null){
            alert("请至少勾选一个书目")
            return false;
        }
        $("[name='bookIds']").val(bookIds);

        if(confirm("你确定添加到您的求借和索取清单吗")){
            $.ajax({
                url:'<%=basePath%>shopping/addBookShop',
                type:'post',
                dataType:'json',
                async:'false',
                data:$('form').serialize(),
                success:function(data){
                    if(data.show){
                        alert(data.content);
                        RemoveArticle();
                        location.reload();
                    }else{
                        alert(data.content);
                    }
                }
            });
        }
    }


    //根据不同条件进行选择
    function showOtherBook(type,obj) {
        if(type == '1'){
            $("[name='bookSeries']").val(obj);
        }else if(type == '2'){
            $("[name='bookAuro']").val(obj);
        }else if(type == '3'){
            $("[name='library']").val(obj);
        }

        $("[name='currentPage']").val(1);
        document.forms[0].action = "<%=basePath%>system/searchLoginBooks/"+type;
        document.forms[0].submit();

    }

    //首页搜索
    function search(){
        $("[name='currentPage']").val(0);
        document.forms[0].action = "<%=basePath%>system/showOtherBookByCondition";
        document.forms[0].submit();
    }

    //全选
    function allCheck(obj){
        var check = $(obj)[0].checked;
        <c:forEach items="${books}" var="book">
            if(check){
                $("#book_"+${book.id})[0].checked = true;
                AddCookie('book_'+${book.id});
            }else{
                $("#book_"+${book.id})[0].checked = false;
                RemoveCookie('book_'+${book.id});
            }
        </c:forEach>
    }
</script>
