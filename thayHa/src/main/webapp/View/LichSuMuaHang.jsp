<%@page import="LichSuMODEL.LichSu"%>
<%@page import="java.util.ArrayList"%>
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

	<div class="container">
		<h2 class="text-center">Lịch Sử Mua Hàng</h2>
		
		<table class="table table-bordered table-striped">
			<tr>
				<th>makh</th>
				<th>tensach</th>
				<th>SoLuongMua</th>
				<th>gia</th>
				<th>thanhTien</th>
				<th>NgayMua</th>
				<th>damua</th>
			</tr>
			<%
			ArrayList<LichSu> listLichSu = (ArrayList<LichSu>) request.getAttribute("listLichSu");
			if (listLichSu != null) {
				for (LichSu lichSu : listLichSu) {
			%>
			<tr>
				<td><%=lichSu.getMakh()%></td>
				<td><%=lichSu.getTensach()%></td>
				<td><%=lichSu.getSoLuongMua()%></td>
				<td><%=lichSu.getGia()%></td>
				<td><%=lichSu.getThanhTien()%></td>
				<td><%=lichSu.getNgayMua()%></td>
				<td><%=lichSu.isDamua()%></td>
			</tr>
			<%
			}
			}
			%>
		</table>
	</div>
</body>
</html>
