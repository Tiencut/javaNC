<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="giohangmodal.giohangBO"%>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<ul class="nav navbar-nav">
			<li class="active"><a href="index.jsp">Trang chủ</a></li>
			<li><a href="NavController?action=xemGioHang">Giỏ hàng (<%=request.getAttribute("soLuongHang")%>)
			</a></li>
			<li><a href="NavController?action=xacNhanDatMua">Xác nhận
					đặt mua</a></li>
			<li><a href="NavController?action=LichSuMuahang">Lịch sử mua
					hàng</a></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<%=(request.getAttribute("loggedInUser") != null)
		? "<li><a href='#'><span class='glyphicon glyphicon-user'></span> Chào, " + request.getAttribute("loggedInUser")
				+ "</a></li>"
				+ "<li><a href='AccountController?action=\"logout\"'><span class='glyphicon glyphicon-log-out'></span> Đăng xuất</a></li>"
		: "<li><a href='AccountController'><span class='glyphicon glyphicon-user'></span> Sign Up/<span class='glyphicon glyphicon-log-in'></span> Login</a></li>"%>
		</ul>
	</div>
</nav>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>