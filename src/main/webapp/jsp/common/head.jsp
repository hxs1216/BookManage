<!DOCTYPE HTML>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" href="<%=basePath%>css/common.css">
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/login.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/common.js"></script>
</head>
</html>