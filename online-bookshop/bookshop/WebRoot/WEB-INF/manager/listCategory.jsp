<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<Form action="${pageContext.request.contextPath }/manager/searchCategory?current=1"
				method="post" class="uesr_search">

				<div class="navbar-form navbar-right">
					<div class="input-group">
						<div class="input-group-addon">
							<i class="glyphicon glyphicon-search"></i>
						</div>
						<input type="text" class="form-control" id="relatedField"
							name="relatedField" value="${relatedField }" placeholder="搜索" />
					</div>
					<select name="field" id="field" class="form-control selectpicker" title="请选择字段">
							<option value="all">全选</option>  
					          <optgroup label="分类">
					                  <option value="categoryName">名称</option>
					                  <option value="categoryDesc">描述</option>
					           </optgroup>                            
					</select>
					
					<button type="submit" class="btn btn-info">搜索</button>
				</div>
			</Form>
	</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-md-2">
				<div class="list-group">
					<a href="${pageContext.request.contextPath }/manager"
						class="list-group-item">添加分类</a> 
					<a href="${pageContext.request.contextPath }/manager/QueryController"
						class="list-group-item active">查询分类</a> 
					<a href="${pageContext.request.contextPath }/manager/addBook" role="button"
						class="list-group-item">添加图书</a>
					<a href="${pageContext.request.contextPath}/manager/QueryBookController?pageNum=1" role="button"
						class="list-group-item">查询图书</a>
				</div>
			</div>
			
			
					
			<div class="col-md-10">
			<div class="alert alert-info" role="alert">
				<strong>警告：</strong> 删除分类会删除该分类下所有书籍！！谨慎操作！！
			</div>
			<div class="alert alert-info" role="alert">
					<strong>技巧提示：</strong> 支持模糊搜索和匹配搜索，匹配搜索使用*代替！
			</div>
				<table class="table table-hover">
					<tr>
						<td>分类编号</td>
						<td>分类名称</td>
						<td>分类描述</td>
						<td colspan="2">操作</td>
					</tr>
					<c:forEach items="${categorys}" var="category">
						<tr>
							<td>${category.id }</td>
							<td>${category.name }</td>
							<td>${category.description }</td>
							<td>
								<a href="${pageContext.request.contextPath }/manager/updateCategoryIndex?categoryId=${category.id}">修改</a> 
								<a href="${pageContext.request.contextPath }/manager/deleteCategory?categoryId=${category.id}">删除</a> 
								
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		
	</script>
</body>
</html>
