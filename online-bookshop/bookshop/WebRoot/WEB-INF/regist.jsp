<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-2.1.0.min.js">
</script>

<center>
	<div class="panel panel-default">
		<div class="panel-body">
			<form
				action="${pageContext.request.contextPath }/RegistController"
				method="post">
				<input type="hidden" name="op" value="regist" />
				<div style="width: 300px" class="input-group">
					<span class="input-group-addon id="basic-addon1"><sapn
							class="glyphicon glyphicon-user"></sapn></span> <input id="user"
						type="text" class="form-control" name="username"
						placeholder="username" aria-describedby="basic-addon1">
				</div>
				<span id="span1"></span>
				<br />
				<div style="width: 300px" class="input-group">
					<span class="input-group-addon" id="basic-addon1"><sapn
							class="glyphicon glyphicon-eye-close"></sapn></span> <input type="password"
						class="form-control" name="password" placeholder="password"
						aria-describedby="basic-addon1">
				</div>
				<br />
				<div style="width: 300px" class="input-group">
					<span class="input-group-addon" id="basic-addon1"><sapn
							class="glyphicon glyphicon-apple"></sapn></span> <input type="text"
						class="form-control" name="nickname" placeholder="nickname"
						aria-describedby="basic-addon1">
				</div>
				<br />
				<div style="width: 300px" class="input-group">
					<span class="input-group-addon" id="basic-addon1"><sapn
							class="glyphicon glyphicon-phone"></sapn></span> <input type="text"
						class="form-control" name="phonenum" placeholder="phonenum"
						aria-describedby="basic-addon1">
				</div>
				<br />
				<div style="width: 300px" class="input-group">
					<span class="input-group-addon" id="basic-addon1"><sapn
							class="glyphicon glyphicon-envelope"></sapn></span> <input type="text"
						class="form-control" name="email" placeholder="email"
						aria-describedby="basic-addon1">
				</div>
				<br />
				<div style="width: 300px" class="input-group">
					<span class="input-group-addon" id="basic-addon1"><sapn
							class="glyphicon glyphicon-home"></sapn></span> <input type="text"
						class="form-control" name="address" placeholder="address"
						aria-describedby="basic-addon1">
				</div>
				<br /> <input class="btn btn-info" type="submit" value="提交" />
			</form>
		</div>
	</div>

</center>
<body>
	 <%
		String message = (String)request.getAttribute("message");
		if(message == "exist"){
			%>
	 			<script type="text/javascript">
						alert("用户名已存在!");
				 </script>
			<%
		}else if(message == "phoneillegal"){
			%>
 			<script type="text/javascript">
					alert("电话位数不正确!");
			 </script>
		<%
		}else if(message == "paranull"){
			%>
 			<script type="text/javascript">
					alert("注册项目不能为空!");
			 </script>
		<%
		}
	 %>
</body>
</html>
