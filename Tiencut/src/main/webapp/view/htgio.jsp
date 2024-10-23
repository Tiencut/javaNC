
<%@page import="giohangmodal.hang"%>
<%@page import="giohangmodal.giohangBO"%>
<%@page import="loaiModel.loai"%>
<%@page import="loaiModel.loaiBO"%>
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

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-8" style="background-color: pink;">
				<table class="table table-hover">
					<thead>
						<td><input type="checkbox" id="select-all" onclick="toggleCheckboxes(this)""></td>
						<td>Sản phẩm</td>
						<td>Số lượng</td>
						<td>Số lượng</td>
						<td>Đơn Giá</td>
						<td>Thành tiền</td>
						<td>Khác</td>
					</thead>


					<tbody>
						<c:forEach var="h" items="${gh.ds}">
							<tr>
								<td><input type="checkbox" class="item-checkbox"></td>
								<td>${h.getTensach()}></td>
								<td>${h.gia}</td>
            					<td>${h.soLuong}</td>
								<td>
									<form action="GioHangController?actsion=\"sua\"&soLuong=${h.getSoLuong()}" method="post">
										<input type="number" name="soLuong" style="width: 50px">
										<input type="submit" name="but1" value="Sửa" class="btn-primary">
									</form>
								</td>
								<td><${h.getThanhTien()}</td>
								<td><a href="GioHangController?action=\"xoa\"">Xoa</a></td>
							</tr>
						</c:forEach>
					</tbody>

					<tfoot>
						<td colspan="5" style="text-align: right">Tổng cộng:</td>
						<td>${gh.tong}</td>
						<td><input type="submit" value="Xoá đã chọn"></td>
						<td><a href="GioHangController?action=\"XacNhanDatMua\"">Xác nhận đặt mua</a></td>
					</tfoot>
				</table>
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