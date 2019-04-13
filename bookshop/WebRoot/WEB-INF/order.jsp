<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:include page="header.jsp"></jsp:include>
<center>
	请输入发货地址<br/>
	请输入联系人手机号码<br/>
	<c:if test="${empty orders}">
		您没有购买商品
	</c:if>
	<c:if test="${not empty orders }">
	  	<div align="center" class="table_title">
	    <table border="1" width="600px">
	        <thead>
	            <tr>
  				<th>订单号</th>
  				<th>订单状态</th>
  				<th>商品图片</th>
  				<th>商品单价</th>
  				<th>商品数量</th>
	            </tr>
	        </thead>
	        <tbody>
	        <c:forEach items="${orders}" var="item">
	            <tr>
	                <td rowspan="${fn:length(item.orderItems)}" align="center">${item.ordername }</td>
	                <c:if test="${item.status == 0}">
	                <td rowspan="${fn:length(item.orderItems)}" align="center"><a href="${pageContext.request.contextPath }/PayOrderController?orderid=${item.id }">去支付</a></td>
	                </c:if>
					<c:if test="${item.status == 1}">
	                <td rowspan="${fn:length(item.orderItems)}" align="center">已支付</td>
	                </c:if>
	                <c:forEach items="${item.orderItems}" var="orderItem" >
	                    <td align="center"><img src="<%=path %>${orderItem.book.image_b}" width=50 /></td>
	                    <td align="center">${orderItem.book.currprice }</td>
	                    <td align="center">${orderItem.num }</td>
	                </tr>
				</c:forEach>
	        </c:forEach>
	        </tbody>
	    </table>
	</div>
	</c:if>
</center>
  </body>
</html>
