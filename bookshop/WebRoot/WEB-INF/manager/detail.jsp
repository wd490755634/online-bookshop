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

<title>My JSP 'listCategory.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/desc.css'/>">
<script src="<c:url value='/js/desc.js'/>"></script>

</head>

<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="${pageContext.request.contextPath }/manager"> <span
				class="glyphicon glyphicon-th-large"></span>   当当书城后台管理
			</a>
		</div>
		<ul class="nav navbar-nav navbar-right">
				
				<c:if test="${empty managerFlag }">
					<li><a href="${pageContext.request.contextPath }/login">登录</a></li>
					<li><a href="${pageContext.request.contextPath }/regist">注册</a></li>
				</c:if>
				<c:if test="${not empty managerFlag }">
					<li><a href="#">昵称：${customer.nickname }</a></li>
					<li><a href="${pageContext.request.contextPath }/logout">注销</a></li>
				</c:if>

		</ul>
	
	</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-md-2">
				<div class="list-group">
					<a href="${pageContext.request.contextPath }/manager"
						class="list-group-item">添加分类</a> <a
						href="${pageContext.request.contextPath }/manager/QueryController"
						class="list-group-item">查询分类</a> <a
						href="${pageContext.request.contextPath }/manager/addBook"
						role="button" class="list-group-item">添加图书</a> <a
						href="${pageContext.request.contextPath}/manager/QueryBookController?pageNum=1"
						role="button" class="list-group-item active">查询图书</a>
				</div>
			</div>



			<div class="col-md-10">
				<div class="divBookName">${book.name }</div>
				<div>
					<img align="top" src="<c:url value='/${book.image_w }'/>"
						width="300" class="img_image_w" />
					<div class="divBookDesc">
						<ul>
							<li>商品编号：${book.id }</li>
							<li>传智价：<span class="price_n">&yen;${book.currprice }</span></li>
							<li>定价：<span class="spanPrice">&yen;${book.price }</span>
								折扣：<span style="color: #c30;">${book.discount }</span>折
							</li>
						</ul>
						<hr class="hr1" />
						<table>
							<tr>
								<td colspan="3">作者：${book.author } 著</td>
							</tr>
							<tr>
								<td colspan="3">分类：${book.category.name }</td>
							</tr>
							<c:if test="${book.description != null}">
								<tr>
									<td colspan="3">书籍介绍：${book.description }</td>
								</tr>
							</c:if>
							<tr>
								<td colspan="3">出版社：${book.press }</td>
							</tr>
							<tr>
								<td colspan="3">出版时间：${book.publishtime }</td>
							</tr>
							<tr>
								<td>版次：${book.edition }</td>
								<td>页数：${book.pagenum }</td>
								<td>字数：${book.wordnum }</td>
							</tr>
							<tr>
								<td width="180">印刷时间：${book.printtime }</td>
								<td>开本：${book.booksize }开</td>
								<td>纸张：${book.paper }</td>
							</tr>
						</table>
						
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		
	</script>
</body>
</html>
