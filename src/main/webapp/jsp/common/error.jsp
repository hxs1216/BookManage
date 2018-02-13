<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
		<base href="<%=basePath%>" />
		<title>未找到该页面</title>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
	</head>
	
	<body style="margin:0px;background-color: #ffffff;">
		<div id="alert">
			<div class="txt" style="TEXT-ALIGN: center">
				<img alt="未找到该页面" src="images/error.jpg">
			</div>
		</div>
		<div id="shadowMeasureIt"></div>
		<div id="divCoordMeasureIt"></div>
		<div id="divRectangleMeasureIt">
			<div id="divRectangleBGMeasureIt"></div>
		</div>
	</body>
</html>