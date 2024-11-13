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
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>
    <div class="container">
        <div class="row border p-3 mb-3">
            <!-- Cột 1 -->
            <div class="col-md-6 d-flex align-items-center">
                <p class="mb-0 mr-2">Nhập tên ĐT hoặc mã nhà cung cấp</p>
                <form action="indexController2" method="get" class="d-flex">
                    <div class="form-group mb-0 mr-2">
                        <input type="text" name="search" class="form-control">
                    </div>
                    <button type="submit" class="btn btn-primary">Search</button>
                </form>
            </div>
            <!-- Cột 2 -->
            <div class="col-md-6">
                <a href="indexController2?action=thongKe" class="btn btn-secondary">Thống kê</a>
            </div>
        </div>
        <div class="row border p-3">
            <!-- Nơi hiển thị dữ liệu -->
            <div class="col-md-12">
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
            </div>
        </div>
        <!-- Bảng thống kê -->
        <c:if test="${showThongKe}">
            <div class="row border p-3 mt-3">
                <div class="col-md-12">
                    <h3>Kết quả thống kê</h3>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Mã NCC</th>
                                <th>Tên NCC</th>
                                <th>Tổng số lượng điện thoại</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listTK}" var="tk">
                                <tr>
                                    <td>${tk.getMaNCC()}</td>
                                    <td>${tk.getTenNCC()}</td>
                                    <td>${tk.getTongSoLuong()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </c:if>
    </div>
</body>
</html>