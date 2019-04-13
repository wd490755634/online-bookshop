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

<title>修改图书</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="<c:url value='/css/manager/add.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/css/manager/jquery.datepick.css'/>">
<script type="text/javascript" src="<c:url value='/js/manager/jquery-1.5.1.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/manager/jquery.datepick.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/manager/jquery.datepick-zh-CN.js'/>"></script>
<script type="text/javascript">
$(function () {
	$("#publishtime").datepick({dateFormat:"yy-mm-dd"});
	$("#printtime").datepick({dateFormat:"yy-mm-dd"});
	
	$("#btn").click(function() {
		var name = $("#name").val();
		var price = $("#price").val();
		var discount = $("#discount").val();
		var author = $("#author").val();
		var press = $("#press").val();
		var edition = $("#edition").val();
		var pagenum = $("#pagenum").val();
		var wordnum = $("#wordnum").val();
		var booksize = $("#booksize").val();
		
		if(!name || !price || !discount) {
			alert("字段不能为空");
			return false;
		}
		
		if(isNaN(edition) || isNaN(pagenum) || isNaN(wordnum) || isNaN(booksize)){
			alert("版次、页数、字数、开本 必须是整数！");
			return false;
		}
		
		if(isNaN(price) || isNaN(discount)) {
			alert("当前价、定价、折扣必须是合法小数！");
			return false;
		}
		$("#form").submit();
	});
});
</script>
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
					<a href="${pageContext.request.contextPath }/manager/addBook"
						role="button" class="list-group-item ">添加图书</a> 
					<a href="${pageContext.request.contextPath}/manager/QueryBookController?pageNum=1"
						class="list-group-item">查询图书</a> 
					<a href="${pageContext.request.contextPath }/manager/updateBookIndex?bookId=${book.id}"
						class="list-group-item active">更新图书</a>
				</div>
			</div>
			<div class="col-md-10">
				<form
					action="${pageContext.request.contextPath }/manager/updateBook?categoryId=${category.id}"
					method="post" enctype="multipart/form-data" class="uesr_search">
					<div class="alert alert-info" role="alert">
						<strong>技巧提示：</strong> 修改后提交即可
					</div>
					<div class="form-group">
						<label for="name">书籍名称</label> 
						<input style="visibility:hidden" type="text" name="id" value="${book.id }" /> 
						<input type="texte" id="name" class="form-control" name="name" value="${book.name}" />
					</div>
					<div class="form-group">
						<label for="name">书籍作者</label> 
						<input type="texte" id="author" class="form-control" name="author" value="${book.author}"/>
					</div>
					<div class="form-group">
						<label for="name">出版社</label> <input type="texte" id="press"
							class="form-control" name="press" value="${book.press }">
					</div>
					<div class="form-group">
						<label for="name">书籍原价</label> 
						<input type="texte" id="price" class="form-control" name="price" value="${book.price}"/>
					</div>
					<div class="form-group">
						<label for="name">书籍折扣</label> <input type="texte" id="discount"
							class="form-control" name="discount" value="${book.discount }">
					</div>
					<div class="form-group">
						<label for="name">修改书籍大图</label> 
						<br />
						<c:if test="${book.image_w !=null}">
							<img src="<%=path %>${book.image_w}" width=100px />
							<input style="visibility:hidden" type="text" name="image_w" value="${book.image_w }" />
							<br />
						</c:if>
						<input id="picture_w" type="file" name="picture_w" />
					</div>
					<div class="form-group">
						<label for="name">修改书籍小图</label> 
						<br />
						<c:if test="${book.image_b !=null}">
							<img src="<%=path %>${book.image_b}" width=50px />
							<input style="visibility:hidden" type="text" name="image_b" value="${book.image_b }" />
							<br />
						</c:if>
						<input id="picture_b" type="file" name="picture_b" />
					</div>
					
					<div class="form-group">
						<label for="name">选择书籍类型       </label> 
						<select name="categoryId" class="selectpicker">
							<option value="${book.category.id}">${book.category.name}</option>

							<c:forEach items="${categorys}" var="category">
								<c:if test="${book.category.name != category.name}">
									<option value="${category.id}">${category.name}</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="description">书籍描述</label>
						<textarea class="form-control" name="description" rows="3">${book.description}</textarea>
					</div>
					<div class="form-group">
						<label for="description">其他</label>
						<ul>
							<li colspan="3">出版时间：<input type="text" id="publishtime" value="${book.publishtime }"
								name="publishtime" style="width:100px;" />
								印刷时间：<input type="text" name="printtime" value="${book.printtime }"
								id="printtime" style="width:100px;" />
								版次： <input type="text" name="edition" id="edition" value="${book.edition }"
								style="width:80px;" />
							</li>
							
							<li>页数： <input type="text" name="pagenum" id="pagenum" value="${book.pagenum }"
								style="width:80px;" />
								字数： <input type="text" name="wordnum" id="wordnum" value="${book.wordnum }"
								style="width:80px;" />
							</li>
						
							<li width="250">开本： <input type="text" name="booksize" value="${book.booksize }"
								id="booksize" style="width:80px;" />
								纸张： <input type="text" name="paper" id="paper" value="${book.paper }"
								style="width:100px;" />
							</li>
						</ul>
					</div>

					<button type="submit" id="btn" class="btn btn-info">提交</button>
				</form>
			</div>

		</div>

	</div>

</body>
</html>
