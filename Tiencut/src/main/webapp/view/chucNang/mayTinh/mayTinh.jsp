<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Máy tính đơn giản</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>

<body>
	<a href="chucNang/mayTinh/mayTinh.jsp"></a>
	<%
	out.println(session.getAttribute("test"));
	out.println(request.getAttribute("tam"));
	/*  */
	int ketQua=0, a=0, b=0;
    if (request.getAttribute("ketQua") != null) {
        ketQua = (int) request.getAttribute("ketQua");
        a = (int) request.getAttribute("a");
        b = (int) request.getAttribute("b");
    }
	%>

	<form action="tmpController" method="post"
		class="container border border-primary p-3">
		<div class="">
			<div class="colspan-1">
				<label for="num1" class="form-label">Số thứ nhất:</label> <input
					type="number" class="form-control" name="num1" id="num1" required>

				<label for="num2" class="form-label">Số thứ hai:</label> <input
					type="number" class="form-control" name="num2" id="num2" required>
			</div>
			<div class="colspan-1">
				<div class="row row-cols-2 g-2">
					<div class="col">
						<input type="submit" class="btn btn-primary w-100 h-100"
							name="phepTinh" value="+" />
					</div>
					<div class="col">
						<input type="submit" class="btn btn-primary w-100 h-100"
							name="phepTinh" value="-" />
					</div>
					<div class="col">
						<input type="submit" class="btn btn-primary w-100 h-100"
							name="phepTinh" value="*" />
					</div>
					<div class="col">
						<input type="submit" class="btn btn-primary w-100 h-100"
							name="phepTinh" value="/" />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="colspan-2">
				<div class="mb-3 border-top border-3 pt-3">
					<label for="ketQua" class="form-label">Kết quả:</label> <input
						type="number" class="form-control" name="ketQua" id="ketQua"
						readonly>
				</div>
			</div>
		</div>
	</form>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>

</html>