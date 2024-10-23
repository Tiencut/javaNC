<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Random"%>
<%!// Hàm tạo số ngẫu nhiên với số chữ số cho trước
	public static String generateRandomNumber(int digits) {
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < digits; i++) {
			sb.append(rand.nextInt(10));
		}
		return sb.toString();
	}%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>

<body class="container mt-5">
	<h1 class="text-center mb-4">Bảng Xổ Số Kiến Thiết</h1>
	<table class="table table-bordered table-striped">
		<thead class="table-dark">
			<tr>
				<th colspan="2" class="text-center"><%=java.time.LocalDate.now()%>
				</th>
			</tr>
			<tr>
				<th>Giải</th>
				<th>Số trúng</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Giải Đặc Biệt</td>
				<td class="fw-bold text-danger"><%=generateRandomNumber(6)%>
				</td>
			</tr>
			<tr>
				<td>Giải Nhất</td>
				<td><%=generateRandomNumber(5)%></td>
			</tr>
			<tr>
				<td>Giải Nhì</td>
				<td><%=generateRandomNumber(5)%></td>
			</tr>
			<tr>
				<td>Giải Ba</td>
				<td><%=generateRandomNumber(5)%></td>
			</tr>
			<tr>
				<td>Giải Tư</td>
				<td><%=generateRandomNumber(4)%></td>
			</tr>
			<tr>
				<td>Giải Năm</td>
				<td><%=generateRandomNumber(4)%></td>
			</tr>
			<tr>
				<td>Giải Sáu</td>
				<td><%=generateRandomNumber(3)%></td>
			</tr>
			<tr>
				<td>Giải Bảy</td>
				<td><%=generateRandomNumber(2)%></td>
			</tr>
		</tbody>
	</table>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>

</html>