<%@page import="sachMODEL.Sach"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <c:choose>
        <c:when test="${not empty listSach}">
            <c:forEach var="sach" items="${listSach}">
                <div class="col-sm-6 col-md-4 col-lg-3 mb-3">
                    <div class="card mb-3 border">
                        <img src="View/${sach.getAnh()}" class="card-img-top" alt="${sach.getTenSach()}">
                        <div class="card-body">
                            <h5 class="card-title">Tên sách: ${sach.getTenSach()}</h5>
                            <p class="card-text">Giá: ${sach.getGia()} VNĐ</p>
                            <a href="${sessionScope.username == null ? 'accountController' : 'GioHangController?action=themVaoGio&maSach=' + sach.getMaSach()}" class="btn btn-primary">
                                <img src="View/image_sach/buynow.jpg" alt="Buy now" class="img-fluid">
                            </a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <p>Không có dữ liệu để hiển thị</p>
        </c:otherwise>
    </c:choose>
</body>
</html>