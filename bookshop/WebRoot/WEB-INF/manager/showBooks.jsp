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
		<Form action="${pageContext.request.contextPath }/search?current=1&manager=true"
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
			<div class="alert alert-info" role="alert">
				<strong>技巧提示：</strong> 支持模糊搜索和匹配搜索，匹配搜索使用*代替！
			</div>
				<table class="table table-hover">
					<tr>
						<td>书籍名称</td>
						<td>书籍作者</td>
						<td>书籍价格</td>
						<td>书籍图片</td>
						
						<td>书籍分类</td>
						<td colspan="3">操作 </td>
					</tr>
					<!-- 
						page是一个对象
						对象里面有两个属性 total books
						但是我们要循环遍历的是books
					 -->
					<c:forEach items="${page.books }" var="book"> <tr>
					<td>${book.name }</td>
					<td>${book.author }</td>
					<td>${book.price }</td>
					<td><c:if test="${book.image_b !=null}">
					<img src="<%=path %>${book.image_b}" width=50 />
					</c:if>
					</td>
				
					<td>${book.category.name}</td>
					<td>
						<a href="${pageContext.request.contextPath }/manager/showBookDetail?bookId=${book.id}">查看</a>	
						<a href="${pageContext.request.contextPath }/manager/updateBookIndex?bookId=${book.id}">修改</a> 
						<a href="${pageContext.request.contextPath }/manager/deleteBook?bookId=${book.id}">删除</a> 
					</td>
					</tr>
					</c:forEach>
				</table>
				<nav aria-label="Page navigation">
				<ul style="float:right" class="pagination">
					<!-- 
						begin:代表从1开始循环
						end：代表从3结束
						varStatus="status"生成一个变量名字随便取的
						status.index = 得到下标
					 -->
					<c:forEach var="i" begin="1" end="${page.totalPage }"
						varStatus="status">
						<li><a href="${pageContext.request.contextPath }/manager/QueryBookController?pageNum=${status.index}">${status.index }</a></li>
					</c:forEach>
				</ul>
				</nav>
			</div>
		</div>
	</div>
</body>
</html>
