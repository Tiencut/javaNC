<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Đăng nhập</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String thongBao = null;
	// check đăng nhập
	if (username != null && password != null) {
	    if (username.equals("abc") && password.equals("123")) {
	        session.setAttribute("dn", username);
	        response.sendRedirect("tc.jsp");
//	        return;
	    } else {
	    	thongBao = "Dang nhap sai";
	    }
	    out.println(thongBao);
	}
	%>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li class="active"><a href="mt.jsp">Máy tính</a></li>
				<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Page 1-1</a></li>
						<li><a href="#">Page 1-2</a></li>
						<li><a href="#">Page 1-3</a></li>
					</ul></li>
				<li><a href="#">Page 2</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="signUp.jsp"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a></li>
				<li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span>
						Login</a></li>
			</ul>
		</div>
	</nav>
		
	<div class="container">
		<h2>Đăng nhập</h2>
		<form action="login.jsp" method="post">
			<div class="form-group">
				<label for="username">Tên đăng nhập:</label>
				<input type="text" class="form-control" id="username" name="username" required>
			</div>
			<div class="form-group">
				<label for="password">Mật khẩu:</label>
				<input type="password" class="form-control" id="password" name="password" required>
			</div>
			<button type="submit" class="btn btn-primary">Đăng nhập</button>
		</form>
		<%= (thongBao!=null)?thongBao:"" %>
	</div>
</body>
</html>
