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


			<!--  -->
			<div class="col-sm-8" style="background-color: pink;">
				<table class="table table-hover">
					<thead>
						<td><input type="checkbox" id="select-all" onclick="toggleCheckboxes(this)""></td>
						<td>Sản phẩm</td>
						<td>Số lượng</td>
						<td>Số lượng</td>
						<td>Đơn Giá</td>
						<td>Thành tiền</td>
						<td>Thao tác</td>
					</thead>

					<tbody>
						<%
						ArrayList<Sach> listSachTrongGio = (ArrayList<Sach>) request.getAttribute("listSachTrongGio");
						if (listSachTrongGio != null) {
							for (Sach h : listSachTrongGio) {
						%>

							<tr>
								<td><input type="checkbox" class="item-checkbox"></td>
								<td><%=h.getTenSach()%></td>
								<td><%=h.getGia()%></td>
								<td><%=h.getSoLuong()%></td>
								<td>
									<form action="GioHangController?action=sua&soLuong=<%=h.getSoLuong()%>" method="post">
										<input type="number" name="soLuong" style="width: 50px">
										<input type="submit" name="but1" value="Sua" class="btn-primary">
									</form>
								</td>
								<td><%=h.getGia()*h.getSoLuong()%></td>
								<td><a href="GioHangController?action=xoa&maSach=<%=h.getMaSach()%>">Xóa</a></td>
							</tr>
						<%
							}
						}
						%>
					</tbody>

					<tfoot>
						<td colspan="5" style="text-align: right">Tổng cộng:</td>
						<td><%=listSachTrongGio.stream().mapToLong(sach -> sach.getGia()*sach.getSoLuong()).sum()%></td>
						<td><input type="submit" value="Xoá đã chọn"></td>
						<td><a href="GioHangController?action=XacNhanDatMua">Xác nhận đặt mua</a></td>
					</tfoot>
				</table>
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
		var checkboxes = document.querySelectorAll('.item-checkbox');
		for (var i = 0; i < checkboxes.length; i++) {
			checkboxes[i].checked = source.checked;
		}
	}
</script>
</html>