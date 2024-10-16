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
<title>Web trường thầy Hà đẹp trai</title>
</head>

<body>
	<jsp:include page="view/nav.jsp" />
<%-- 	
	<jsp:include page="view/order-form.jsp">
	<jsp:include page="view/Modal.jsp">
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
				<%
				sachBO sBO = new sachBO();
				String ml = request.getParameter("ml");
				ArrayList<sach> ds = sBO.getSach();
				if (ml != null) {
					ds = sBO.TimMa(ml);
				}
				int n = ds.size();
				for (int i = 0; i < n; i++) {
					sach s = ds.get(i);
				%>
				<div class="row">
					<div class="col-sm-4 col-md-4">
						<img src="<%=s.getAnh()%>"> <br>
						<%=s.getTenSach()%>			<br>
						<%=s.getGia()%>				<br> 
						<img src="view/image_sach/buynow.jpg">
						<a href="view/giohang.jsp?ms=<%=s.getMaSach()%>&ts=<%=s.getTenSach() %>&gia=<%=s.getGia() %>">
							<img src="view/image_sach/buynow.jpg">
						</a>
					</div>
				</div>
				<%
				i++;
				if (i < n) {
					s = ds.get(i);
				%>
					<div class="col-sm-4 col-md-4">
						<img src="<%=s.getAnh()%>"> <br>
						<%=s.getTenSach()%>			<br>
						<%=s.getGia()%>				<br> 
						<img src="view/image_sach/buynow.jpg">
						<a href="view/giohang.jsp?ms=<%=s.getMaSach()%>&ts=<%=s.getTenSach() %>&gia=<%=s.getGia() %>">
							<img src="view/image_sach/buynow.jpg">
						</a>
					</div>				<%
				}
				%>
				<%
				}
				%>
			</div>
	
			<div class="col-sm-2" style="background-color: rgb(170, 71, 87);">
				<form action="timkiem.jsp" method="post">
					<input type="text" name="key" placeholder="Tìm kiếm"> 
					<input type="submit" value="Tìm">
				</form>
				<%
				if (request.getParameter("key") != null) {
					String key = request.getParameter("key");
					ArrayList<sach> ds_timKiem = sBO.TimMa(key);
					if (ds_timKiem != null && !ds_timKiem.isEmpty()) { // Kiểm tra nếu ds_timKiem không rỗng
						for (sach s : ds_timKiem) {
				%>
							<div class="row">
								<div class="col-sm-4 col-md-4">
									<img src="<%=s.getAnh()%>"> <br>
									<%=s.getTenSach()%>			<br>
									<%=s.getGia()%> 			<br> 
									<img src="view/image_sach/buynow.jpg">
								</div>
							</div>
					<%
						}
					} else {
					%>
					<p>Không tìm thấy sách nào.</p>
					<%
						}
					}
					%>
			</div>
		</div>
	</div>
	<jsp:include page="view/TrangChu/bootstrap.jsp"></jsp:include>
</body>

</html>