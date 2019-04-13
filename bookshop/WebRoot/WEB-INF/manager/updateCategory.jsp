<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<base href="<%=basePath%>">

<title>修改分类</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	 <%
		String message = (String)request.getSession().getAttribute("message");
		if(message == "logfalse"){
			%>
	 			<script type="text/javascript">
						alert("注销失败!");
				 </script>
			<%
		}
	 %>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="${pageContext.request.contextPath }/manager"> <span
				class="glyphicon glyphicon-th-large"></span>   当当书城后台管理
			</a>
		</div>
		<ul class="nav navbar-nav navbar-right">
				
				<c:if test="${empty managerFlag }">
					<li><a href="${pageContext.request.contextPath }/Login">登录</a></li>
					<li><a href="${pageContext.request.contextPath }/Regist">注册</a></li>
				</c:if>
				<c:if test="${not empty managerFlag }">
					<li><a href="#">昵称：${customer.nickname }</a></li>
					<li><a href="${pageContext.request.contextPath }/LogoutController">注销</a></li>
				</c:if>

		</ul>
	</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-md-2">
				<div class="list-group">
					<a href="${pageContext.request.contextPath }/manager"
						class="list-group-item ">添加分类</a> 
					<a href="${pageContext.request.contextPath }/manager/QueryController"
						class="list-group-item">查询分类</a> 
					<a href="${pageContext.request.contextPath }/manager/updateCategoryIndex?categoryId=${category.id}"
						class="list-group-item active">更新分类</a> 
					<a href="${pageContext.request.contextPath }/manager/addBook"
						role="button" class="list-group-item">添加图书</a>
					<a href="${pageContext.request.contextPath}/manager/QueryBookController?pageNum=1"
						class="list-group-item">查询图书</a>
				</div>
			</div>
			<div class="col-md-10">
				<form
					action="${pageContext.request.contextPath }/manager/updateCategory"
					method="post" enctype="multipart/form-data" class="uesr_search">
					<div class="alert alert-info" role="alert">
						<strong>技巧提示：</strong> 修改后提交即可
					</div>
					<div class="form-group">
						<label for="name">分类名称</label> 
						<input style="visibility:hidden" type="text" name="id" value="${category.id }" />
						<input type="texte" id="name"
							class="form-control" name="name" value="${category.name}">
					</div>
					<div class="form-group">
						<label for="description">分类描述</label>
						<textarea class="form-control" name="description" rows="3" >${category.description}</textarea>
					</div>
					
				
					<button type="submit" class="btn btn-default">提交</button>
				</form>
			</div>

		</div>

	</div>

</body>
</html>
