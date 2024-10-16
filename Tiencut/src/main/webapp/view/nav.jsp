<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<ul class="nav navbar-nav">
			<li class="active"><a href="mt.jsp">Trang chủ</a></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Các code<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="chucNang/BangCuuChuong/bangCuuChuong.jsp">Bảng cửu chương</a></li>
					<li><a href="chucNang/FormDkWebTruong/formDK.jsp">FormDkWebTruong</a></li>
					<li><a href="chucNang/mayTinh/mayTinh.jsp">Máy Tính</a></li>
					<li><a href="chucNang/xoSoKienThiet/xskt.jsp">Xskt</a></li>
					<li><a href="chucNang/congN.jsp">Cộng N</a></li>
				</ul></li>
			<li><a></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<%
			String loggedInUser = (String) session.getAttribute("dn");
			if (loggedInUser != null) {
			%>
			<li>
				<a href="#">
					<span class="glyphicon glyphicon-user"></span>
					Chào, <%=loggedInUser%>
				</a>
			</li>
			<li>
				<a href="TrangChu/logout.jsp">
				<span class="glyphicon glyphicon-log-out"></span>Đăng xuất
				</a>
			</li>
			<%
			} else {
			%>
			<li><a href="TrangChu/signUp.jsp"> <span
					class="glyphicon glyphicon-user"></span> Sign Up
			</a></li>
			<li><a href="TrangChu/login.jsp"><span
					class="glyphicon glyphicon-log-in"></span> Login</a></li>
			<%
			}
			%>
		</ul>
	</div>
</nav>
<%
// Xử lý đăng xuất
String action = request.getParameter("action");
if (action != null && action.equals("logout")) {
	session.removeAttribute("dn");
	response.sendRedirect("tc.jsp");
	return;
}
%>