<%@page import="giohangmodal.hang"%>
<%@page import="giohangmodal.giohangBO"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="loaiModal.loai"%>
<%@ page import="sachModal.sach"%>
<%@ page import="loaiModal.loaiBO"%>
<%@ page import="sachModal.sachBO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Giỏ hàng</title>
</head>

<body>
	<jsp:include page="nav.jsp" />
	<%-- 	
	<jsp:include page="view/order-form.jsp"></jsp:include>
	<jsp:include page="view/Modal.jsp"></jsp:include>
 --%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2">
				<%
				loaiBO lBO = new loaiBO();
				for (loai l : lBO.getLoai()) {
				%>
				<a href="tc.jsp?ml=<%=l.getMaLoai()%>"> <%=l.getTenLoai()%></a>		<hr>
				<%}%>
			</div>

			<div class="col-sm-8" style="background-color: pink;">
				<table class="table table-hover">
					<tr-header>
						<td>Tên sách</td>
						<td>Số lượng</td>
						<td>Giá</td>
						<td>Sửa số lượng</td>
						<td>Thành tiền</td>
						<td>Khác</td>
					</tr-header>
					<%
					giohangBO gh = (giohangBO) session.getAttribute("gh");
					if (gh != null) {
						for (hang h : gh.ds) {
					%>
						<tr>
							<td><%=h.getTensach()%></td>
							<td><%=h.getSoLuong()%></td>
							<td><%=h.getGia()%></td>
							<td>
								<form action="GioHang.Sua.jsp?maSP=<%=h.getMasach()%>&tenSach=<%=h.getTensach()%>&gia=<%=h.getGia()%>&soLuong=<%=h.getSoLuong()%>" method="post">
									<input type="number" name="soLuong" style="width: 50px"> 
									<input type="submit" name="but1" value="Sửa" class="btn-primary">
								</form>
							</td>
							<td><%=h.getThanhTien()%></td>
							<td><a href="GioHang.xoa.jsp?maSP=<%=h.getMasach()%>">Xoa</a></td>
						</tr>
					<%
						}
					}
					%>
					<tr-footer>
						<td colspan="6" style="text-align: right;">Tổng cộng:</td>
						<td><%= gh != null ? gh.Tong() : 0 %></td>
					</tr-footer>
				</table>
			</div>
		</div>
	</div>
		<jsp:include page="TrangChu/bootstrap.jsp"></jsp:include>
</body>

</html>