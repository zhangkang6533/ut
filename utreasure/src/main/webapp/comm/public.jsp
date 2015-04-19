<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='icon' href="<%=basePath%>images/front.ico" type="image/x-ico"/> 
<link rel="stylesheet" href="<%=basePath%>jquery.mobile-1.3.2/jquery.mobile-1.3.2.min.css">
<script src="<%=basePath%>jquery.mobile-1.3.2/jquery-1.8.3.min.js"></script>
<script src="<%=basePath%>jquery.mobile-1.3.2/jquery.mobile-1.3.2.min.js"></script>