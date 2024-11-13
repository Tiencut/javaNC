<%@page import="DTModal.DienThoai"%>
<%@page import="java.util.List"%>
<%@page import="NCCModal.NCC"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%-- bootstrap CSS và JS --%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<%-- jquery và toastr CSS --%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>
	<div class="container">
		<div class="row border">
			<!-- Cột 1 -->
			<div class="col-md-6 d-flex align-items-center">
				<h3 class="">Nhập tên ĐT hoặc mã nhà cung cấp</h3>
				<form action="indexController" method="get" class="d-flex">
					<div class="form-group">
						<input type="text" name="search" class="form-control">
					</div>
					<button type="submit" class="btn btn-primary">Search</button>
				</form>
			</div>

			<!-- Cột 2 -->
			<div class="col-md-6">
				<h3 class="">Chức năng</h3>
				<form action="indexController" method="get" class="d-inline">
					<input type="hidden" name="action" value="thongKe">
					<button type="submit" class="btn btn-primary">Thống kê</button>
				</form>
				<form action="indexController" method="get" class="d-inline">
					<input type="hidden" name="action" value="themSanPham">
					<button type="submit" class="btn btn-success">Thêm sản
						phẩm</button>
				</form>
				<form action="indexController" method="get" class="d-inline">
					<input type="hidden" name="action" value="capNhatSanPham">
					<button type="submit" class="btn btn-warning">Cập nhật sản
						phẩm</button>
				</form>
				<form action="indexController" method="get" class="d-inline">
					<input type="hidden" name="action" value="xoaSanPham">
					<button type="submit" class="btn btn-danger">Xóa sản phẩm</button>
				</form>
				<form action="indexController" method="get" class="d-inline">
					<input type="hidden" name="action" value="timKiemNangCao">
					<button type="submit" class="btn btn-info">Tìm kiếm nâng cao</button>
				</form>
			</div>
		</div>

		<div class="row border p-3">
			<div class="col-md-12">
				<c:choose>
					<c:when test="${showThongKe}">
						<h3>Kết quả thống kê</h3>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Tên NCC</th>
									<th>Tổng số lượng điện thoại</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listTK}" var="tk">
									<tr>
										<td>${tk.getTenNCC()}</td>
										<td>${tk.getTongSoLuong()}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
					<c:otherwise>
						<h3>Danh sách sản phẩm</h3>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Mã ĐT</th>
									<th>Tên ĐT</th>
									<th>Số lượng</th>
									<th>Giá</th>
									<th>Mã NCC</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listDT}" var="dt">
									<tr>
										<td>${dt.getMaDT()}</td>
										<td>${dt.getTenDT()}</td>
										<td>${dt.getSoLuong()}</td>
										<td>${dt.getGia()}</td>
										<td>${dt.getMaNCC()}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<%-- xử lý không kết quả tìm kiếm --%>
	<%
	String errorMessage = (session != null) ? (String) request.getAttribute("errorMessage") : null;
	if (errorMessage != null) {
	%>
	<script>
            toastr.error('<%=errorMessage%>
		');
	</script>
	<%
	session.removeAttribute("errorMessage");
	}
	%>
</body>
</html>