<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="Nav.jsp"/>
	
	<div class="container">
		<div class="row">
			<!-- Cột trái: Đăng ký -->
			<div class="col-md-6" style="border-right: 2px dashed black;">
				<h2>Đăng ký</h2>
				<form action="accountController" method="post">
					<input type="hidden" name="action" value="Register">
					<div class="form-group">
						<label for="fullName">Họ tên:</label> 
						<input type="text" class="form-control" id="fullName" name="fullName" required>
					</div>
					<div class="form-group">
						<label for="address">Địa chỉ:</label> 
						<input type="text" class="form-control" id="address" name="address" required>
					</div>
					<div class="form-group">
						<label for="phoneNumber">Số điện thoại:</label> 
						<input type="text" class="form-control" id="phoneNumber" name="phoneNumber" required>
					</div>
					<div class="form-group">
						<label for="email">Email:</label> 
						<input type="email" class="form-control" id="email" name="email" required>
					</div>
					<div class="form-group">
						<label for="username">Tên đăng ký:</label> 
						<input type="text" class="form-control" id="username" name="username" required>
					</div>
					<div class="form-group">
						<label for="password">Mật khẩu:</label> 
						<input type="password" class="form-control" id="password" name="password" required>
					</div>
					<div class="form-group">
						<label for="confirmPassword">Xác nhận lại mật khẩu:</label> 
						<input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
					</div>
					<button type="submit" class="btn btn-primary">Đăng ký</button>
				</form>
			</div>

			<!-- Cột phải: Đăng nhập -->
			<div class="col-md-6">
				<h2>Đăng nhập</h2>
				<form action="accountController" method="post">
					<input type="hidden" name="action" value="Login">
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
				
				<h2>
					<%=(request.getAttribute("thongBao") != null) ? request.getAttribute("thongBao") : ""%>
				</h2>
			</div>
		</div>
	</div>
</body>
</html>