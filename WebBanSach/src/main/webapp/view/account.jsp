<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Đăng nhập/Đăng ký</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.container {
	border: 2px dashed #000;
	border-radius: 15px;
	padding: 20px;
}

.row {
	display: flex;
}

.col-md-6 {
	flex: 1;
	padding: 20px;
}

.col-md-6:not(:last-child) {
	border-right: 2px dashed #000;
}
</style>
</head>
<body>
	<jsp:include page="nav.jsp" />

	<div class="container">
		<div class="row">
			<!-- Cột trái: Đăng ký -->
			<div class="col-md-6">
				<h2>Đăng ký</h2>
				<form action="AccountController" method="post">
					<input type="hidden" name="action" value="signup">
					<div class="form-group">
						<label for="username">Tên đăng ký:</label> <input type="text"
							class="form-control" id="username" name="username" required>
					</div>
					<div class="form-group">
						<label for="password">Mật khẩu:</label> <input type="password"
							class="form-control" id="password" name="password" required>
					</div>
					<div class="form-group">
						<label for="confirmPassword">Xác nhận lại mật khẩu:</label> <input
							type="password" class="form-control" id="confirmPassword"
							name="confirmPassword" required>
					</div>
					<button type="submit" class="btn btn-primary">Đăng ký</button>
				</form>
			</div>

			<!-- Cột phải: Đăng nhập -->
			<div class="col-md-6">
				<h2>Đăng nhập</h2>
				<form action="AccountController" method="post">
					<input type="hidden" name="action" value="login">
					<div class="form-group">
						<label for="username">Tên đăng nhập:</label> <input type="text"
							class="form-control" id="username" name="username" required>
					</div>
					<div class="form-group">
						<label for="password">Mật khẩu:</label> <input type="password"
							class="form-control" id="password" name="password" required>
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