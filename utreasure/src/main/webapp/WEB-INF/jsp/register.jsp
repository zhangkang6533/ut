<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<jsp:include page="../../comm/public.jsp"></jsp:include>
<title>register</title>
<!-- js  css 信息 -->

<script type="text/javascript">
function registerInfo(){
	var  loginName=$("#user_profile_name").val();
	var  email=$("#user_profile_email").val();
	var  password=$("#user_profile_password").val();
	var  password2=$("#user_profile_password2").val();
	 
	/**
		1、用户名 5-13位 数字 字母 下划线 
	**/
	
		var reLoginName = /^[a-z_A-z]\w{4,12}$/;
	    if(!reLoginName.test(loginName)){
	    	alert("对不起，您的用户名不符合规范");
	    	return  false;
	    } 
	    
	  /**
	   2、密码三种混合
	  **/
	  
	    if(password!=password2){
	    	alert("两次密码长度不同 ");
	    	return  false;
	    }
	    
	    
}

   
//ajax 
$(function(){
	$("#user_profile_name").bind("blur", function(){
		var _this=$(this);
		if(_this.val()){   //如果存在值
			$.ajax({
				   type: "POST",
				   url: "user/getUserName.do",
				   data:"loginName="+_this.val(),
				   success: function(msg){
					  var  Otip=$("#user_profile_tip"); 
					  var oDiv= document.createElement('span');
					  if(eval(msg)){
						 oDiv.innerHTML ='此账号可以正常使用 ';
						 oDiv.className="normalTip";
						 $(".btn-primary").attr("disabled",false);  //开启按钮提交  
					  }else{
						 oDiv.innerHTML ='对不起，此账号已经存在';
						 oDiv.className="warnTip";
						$(".btn-primary").attr("disabled",true);
						/// oLay.style.display = "block";
					  }
					  Otip.html(oDiv);
				   }
				});
			}
		});
})
</script>


<style type="text/css">
.boxed-group{
width: 100%;
height: 100%;
}

.warnTip{
color: red;
}


.normalTip{
color:blue;
}


.btn-primary{
	width: 100px;
}
</style>
</head>
<body>
	<div class="boxed-group"  data-role="page">
		<div  data-role="header" data-position="fixed">
		<h3>注册信息</h3>
		</div>
		<div  data-role="content">
			<form accept-charset="UTF-8" action="user/doRegister.do"  method="post"  onsubmit="return  registerInfo()">
				<div>
					<dl class="form">
						<dt>
							<label for="user_profile_name">登陆名</label>
						</dt>
						<dd>
							<input id="user_profile_name" name="loginName"  type="text"  />
						</dd>
						<dd id="user_profile_tip">
						</dd>
					</dl>
					<dl class="form">
						<dt>
							<label for="user_profile_email">邮箱</label>
						</dt>
						<dd>
							<input id="user_profile_email" name="email"  type="email" />
						</dd>
						<dd>
							<span  id="user_profile_email"></span>
						</dd>
					</dl>
					<dl class="form">
						<dt>
							<label for="user_profile_password">密码</label>
						</dt>
						<dd>
							<input id="user_profile_password" name="password"  type="password" />
						</dd>
					</dl>
					<dl class="form">
						<dt>
							<label for="user_profile_password2">密码确认</label>
						</dt>
						<dd>
							<input id="user_profile_password2" name="password2"  type="password" />
						</dd>
					</dl>
					<p>
						<button type="submit" class="btn-primary" >确认注册</button>
					</p>
				</div>
			</form>
		</div>
	</div>
</body>
</html>