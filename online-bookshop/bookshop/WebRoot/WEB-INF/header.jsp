<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-2.1.0.min.js"></script>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-2.1.0.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<title>My JSP 'header.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<!--
		<link rel="stylesheet" type="text/css" href="styles.css">
-->

<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/list.css'/>">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/list.js"></script>
</head>

<body>
	 <%
		String message = (String)request.getAttribute("message");
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
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${pageContext.request.contextPath }">当当书城</a>
		</div>

		</script>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">

			<c:if test="${param.categoryFlag != null}">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">所有分类<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a id="action-1"
								href="${pageContext.request.contextPath }/">所有分类</a></li>
							<c:forEach items="${categorys}" var="category">
								<li><a
									href="${pageContext.request.contextPath }/CategoryPageController?categoryId=${category.id}&current=1">${category.name }</a></li>
							</c:forEach>

						</ul></li>

				</ul>
			</c:if>

			<ul class="nav 
				navbar-nav navbar-right">
				<li><a href="${pageContext.request.contextPath }/showCar">购物车</a></li>
				<li><a href="${pageContext.request.contextPath }/showOrder">订单管理</a></li>
				<c:if test="${empty customer }">
					<li><a href="${pageContext.request.contextPath }/login">登录</a></li>
					<li><a href="${pageContext.request.contextPath }/regist">注册</a></li>
				</c:if>
				<c:if test="${not empty customer }">
					<li><a href="#">昵称：${customer.nickname }</a></li>
					<li><a href="${pageContext.request.contextPath }/logout">注销</a></li>
				</c:if>
			</ul>


			<Form action="${pageContext.request.contextPath }/search?current=1"
				method="post" class="uesr_search">

				<div class="navbar-form navbar-right">
					<div class="input-group">
						<div class="input-group-addon">
							<i class="glyphicon glyphicon-search"></i>
						</div>
						<input type="text" class="form-control" id="relatedField"
							name="relatedField" value="${relatedField }" placeholder="搜索" />
					</div>
					<select name="field" id="field" class="form-control selectpicker"
						title="请选择字段">
						<option value="all">全选</option>
						<optgroup label="图书">
							<option value="bookName">名称</option>
							<option value="bookAuthor">作者</option>
							<option value="bookDesc">描述</option>
						</optgroup>
						<optgroup label="分类">
							<option value="categoryName">名称</option>
							<option value="categoryDesc">描述</option>
						</optgroup>
					</select>
					<script type="text/javascript">
						$(function() {
							$(".selectpicker").selectpicker({
								noneSelectedText : '请选择',
								countSelectedText : function() {}
							});
						});
						function selectValue() {
							//获取选择的值
							alert($('#field').selectpicker('val'));
						}
					</script>
					<button type="submit" class="btn btn-info">搜索</button>
				</div>
			</Form>


		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>