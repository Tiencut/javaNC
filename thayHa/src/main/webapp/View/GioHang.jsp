<%@page import="sachMODEL.Sach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="loaiMODEL.loai"%>
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
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2">
                <%
                    ArrayList<loai> listTenLoai = (ArrayList<loai>) request.getAttribute("listTenLoai");
                    if (listTenLoai != null) {
                        for (loai l : listTenLoai) {
                %>
                            <a href="GioHangController?action=sachTheoLoai&maLoai=<%=l.getMaLoai()%>"><%= l.getTenLoai() %></a>
                            <hr>
                <%
                        }
                    } else {
                %>
                        <p>Không có dữ liệu để hiển thị</p>
                <%
                    }
                %>
			</div>


			<!-- giỏ hàng -->
			<div class="col-sm-8" style="background-color: pink;">
				<form action="GioHangController" method="post">
					<table class="table table-hover">
						<thead>
							<th><input type="checkbox" id="listMaSachCanXoa" onclick="toggleCheckboxes(this)"></th>
							<th>Sản phẩm</th>
							<th>Số lượng</th>
							<th>Đơn Giá</th>
							<th>Thành tiền</th>
							<th>Thao tác</th>
						</thead>

						<tbody>
							<%
							ArrayList<Sach> gioHang = (ArrayList<Sach>) session.getAttribute("gioHang");
							if (gioHang != null) {
								for (Sach h : gioHang) {
							%>

								<tr>
									<td><input type="checkbox" class="listMaSachCanXoa" value="<%=h.getMaSach()%>"></td>
									<td><%=h.getTenSach()%></td>
									<td>
										<%=h.getSoLuong()%>
											<form action="GioHangController?action=sua&soLuong=<%=h.getSoLuong()%>" method="post">
											<input type="number" name="soLuong" style="width: 50px">
											<input type="submit" name="but1" value="Sua" class="btn-primary">
										</form>
									</td>
									<td><%=h.getGia()%></td>
									<td><%=h.getGia()*h.getSoLuong()%></td>
									<td>
										<form action="GioHangController" method="post" style="display:inline;">
											<input type="hidden" name="action" value="xoaKhoiGio">
											<input type="hidden" name="maSachXoa" value="<%=h.getMaSach()%>">
											<button type="submit" style="background:none;border:none;color:blue;text-decoration:underline;cursor:pointer;">Xóa</button>
										</form>
									</td>
								</tr>
							<%
								}
							}
							%>
						</tbody>

						<tfoot>
							<%
							if (gioHang != null) {
							%>
								<tr>
									<td colspan="4" style="text-align: right">Tổng cộng:</td>
									<td><%=gioHang.stream().mapToLong(sach -> sach.getGia() * sach.getSoLuong()).sum()%></td>
									<td><input type="submit" name="action" value="xoaDaChon"></td>
									<td><a href="XacNhanDatMuaController?action=XacNhanDatMua">Xác nhận đặt mua</a></td>
								</tr>
							<%
							}
							%>
						</tfoot>

						 <input type="hidden" name="action" value="xoaDaChon">
					</table>
				</form>
			</div>

			<!-- tìm kiếm -->
			<div class="col-sm-2" style="background-color: rgb(170, 71, 87);">
				<form action="GioHangController?action=timSach" method="post">
					<input type="text" name="sachCanTim" placeholder="Tìm kiếm">
					<input type="submit" value="Tìm">
				</form>
			</div>

		</div>
	</div>
</body>

<script>
	function toggleCheckboxes(source) {
		var checkboxes = document.querySelectorAll('.listMaSachCanXoa');
		for (var i = 0; i < checkboxes.length; i++) {
			checkboxes[i].checked = source.checked;
		}
	}
</script>
</html>