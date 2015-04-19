<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../../comm/public.jsp"></jsp:include>
<title>needless treasure</title>
<style type="text/css">
*{
margin: 0px;
padding: 0px;
}

a{
 font:italic bold 18px arial,sans-serif;
}
.fullScreen{
width: 100%;
height: 100%;
}

.head_left{
position:relative;
float:left;
margin-left: 10px;
}

.head_right{
position:relative;
margin-left: 10px;
}
</style>
</head>
<body>
	<div  class="fullScreen"   data-role="page">
		<div  class="head"  data-role="header" data-position="fixed">
				<div class="head_left">
						<a href="">帮助</a>
				</div>
				
				<div class="head_right">
					<a href="">登陆</a>
					<a href="user/toRegister.do">注册</a>	
				</div>
		</div>
		<div  data-role="content">
		
		
		</div>
		
		<div  data-role="footer" data-position="fixed">
		  <a></a>
		</div>
	
	</div>
</body>
</html>