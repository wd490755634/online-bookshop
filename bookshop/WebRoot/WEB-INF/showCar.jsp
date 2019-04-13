<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:include page="header.jsp"></jsp:include>
<center>
	<!-- 
		empty为null的意思
	 -->
	<c:if test="${empty car.carItems }">
		您没有购买商品
		${car.carItems }
	</c:if>
	<c:if test="${not empty car.carItems }">
		<table class="table">
  			<tr>
  				<td>商品名称</td>
  				<td>商品图片</td>
  				<td>商品数量</td>
  				<td>商品单价</td>
  				<td>小计</td>
  				<td>操作</td>
  			</tr>
  			<!-- 
  				得到的是car对象 car对象里面有很多东西
  				总数量：totalnum
  				总金额：totalmoney
  			 -->
  			<c:forEach items="${car.carItems }" var="item">
  				<tr>
  					<td>${item.book.name}</td>
  					<td>
  					<img src="<%=path %>${item.book.image_b}" width=50 />
  					</td>
  					<td>${item.num}</td>
  					<td>${item.book.currprice}</td>
  					<td>${item.money}</td>
  					<td><a href="${pageContext.request.contextPath }/DeleteCarItem?caritemid=${item.id }">删除</a></td>
  				</tr>
  			</c:forEach>
  			<tr style="right;">
  				<td>总数量:${car.totalNum }</td>
  				<td>总金额:${car.totalMoney }</td>
  				<td><a href="${pageContext.request.contextPath }/OrderController?op=order&num=${car.totalNum }&money=${car.totalMoney }">去结算</a></td>
  			</tr>
  		</table>
	</c:if>
</center>
  </body>
</html>
