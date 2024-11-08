<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% if (request.getAttribute("errorMessage") != null) { %>
    <script>
        toastr.error('<%= request.getAttribute("errorMessage") %>');
    </script>
<% } %>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<ul class="nav navbar-nav">
			<li><a href="indexController">Trang chủ</a></li>
			<li><a href="NavController?action=xemGioHang">Giỏ hàng</a></li>
			<li><a href="NavController?action=xacNhanDatMua">Xác nhận đặt mua</a></li>
			<li><a href="NavController?action=LichSuMuahang">Lịch sử mua hàng</a></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<%
			if (request.getAttribute("username") != null) {
			%>
			<li>
				<a href="#">
					<span class="glyphicon glyphicon-user"></span>
					Chào, <%=request.getAttribute("username")%>
				</a>
			</li>
			<li>
 				<a href="accountController?action=logout">
					<span class="glyphicon glyphicon-log-out"></span> Đăng xuất
				</a>
			</li>
			<%
			} else {
			%>
			<li>
				<a href="accountController?action=LoginOrRegister">
					 <span class="glyphicon glyphicon-user"></span>Sign Up/
					 <span class="glyphicon glyphicon-log-in"></span>Login
				 </a>
			</li>
			<%
			}
			%>
		</ul>

	</div>
</nav>


<%-- boostrap --%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<%-- jquery --%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

