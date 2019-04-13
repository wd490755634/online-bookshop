<i><%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<jsp:include page="header.jsp"></jsp:include>


	<center>
		<div class="panel panel-default">
			<div class="panel-body">
				<span class="loginTop">书城用户登录</span>
				<form action="${pageContext.request.contextPath }/LoginController"
					method="post">
					<input type="hidden" name="op" value="login">
					<div style="width: 300px" class="input-group">
						<span class="input-group-addon id=" basic-addon1=""><sapn
								class="glyphicon glyphicon-user"></sapn></span> <input id="user"
							type="text" class="form-control" name="username"
							placeholder="username" aria-describedby="basic-addon1">
					</div>
					<br>
					<div style="width: 300px" class="input-group">
						<span class="input-group-addon" id="basic-addon1"><sapn
								class="glyphicon glyphicon-eye-close"></sapn></span> <input
							type="password" class="form-control" name="password"
							placeholder="password" aria-describedby="basic-addon1">
					</div>
					<br> <br> <input class="btn btn-info" type="submit" value="提交">
				</form>
			</div>
		</div>

	</center>

	<body>
	 <%
		String message = (String)request.getAttribute("message");
		if(message == "online"){
			%>
	 			<script type="text/javascript">
						alert("用户已在线!");
				 </script>
			<%
		}else if(message == "false"){
			%>
 			<script type="text/javascript">
					alert("用户状态更新失败!");
			 </script>
		<%
		}else if(message == "no"){
			%>
 			<script type="text/javascript">
					alert("用户不存在!");
			 </script>
		<%
		}
	 %>
	</body>
	<html></html> </i>