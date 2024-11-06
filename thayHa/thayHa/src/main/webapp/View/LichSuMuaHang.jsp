<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Lịch Sử Mua Hàng</title>
</head>
<body>
	<jsp:include page="Nav.jsp"></jsp:include>
	
	<h2>Lịch Sử Mua Hàng</h2>
	<table border="1">
		<tr>
			<th>Mã Hoá Đơn</th>
			<th>Mã KH</th>
			<th>Ngày mua</th>
			<th>Đã mua</th>
		</tr>
		<c:forEach var="hoaDon" items="${listHoaDon}">
			<tr>
				<td>${hoaDon.getMaHoaDon()}</td>
				<td>${hoaDon.getMaKH()}</td>
				<td>${hoaDon.getNgayMua()}</td>
				<td><c:choose>
						<c:when test="${hoaDon.isDaMua()}">
            				&#x2714; <!-- Dấu tích xanh -->
						</c:when>
						<c:otherwise>
            				&#x2716; <!-- Dấu nhân đỏ -->
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>