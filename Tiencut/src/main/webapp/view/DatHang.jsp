<%-- 
<%@page import="giohangmodal.giohangBO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method='post' action='DatHang.jsp'>
		<label for='tenSP'>Tên hàng:</label>
		<input type='text' id='txtth' name='tenSP'><br>
		
		<label for='gia'>Giá:</label>
		<input type='text' id='txtgia' name='gia'><br>
		
		<label for='soLuong'>Số lượng:</label>
		<input type='text' id='txtsl' name='soLuong'><br>
		
		<input type='submit' name='un1' value='Đặt Hàng'>
	</form>
	Gio hang
	<%
	String tenSP = request.getParameter("tenSP");
	long gia = Long.parseLong(request.getParameter("gia"));
	int soLuong = Integer.parseInt(request.getParameter("soLuong"));
	if (tenSP != null && gia != 0 && soLuong != 0) {
		giohangBO gioHang = new giohangBO();
		//Neu mua hang lan dau
		if (session.getAttribute("gh") == null) {
			session.setAttribute("gh", gioHang);//Tao gio
		}
		//Gian session: gh vao bien: g
		gioHang = (giohangBO) session.getAttribute("gh");
		//Them hang vao bien: g
		gioHang.Them(maSP, tenSP, gia, soLuong);
		//Luu bien vao session
		session.setAttribute("gh", gioHang);
	}
	
	//Hien thi do trong session: gh
	if (session.getAttribute("gh") != null) {
		giohangBO gioHang = new gioHangBO();
		gioHang = (gioHangBO) session.getAttribute("gh");
		int sh = g.ds.size();
	%>
	<table border='1' width='100%'>
		<%
		for (int i = 0; i < sh; i++) {
		%>
		<tr>
			<td><%=g.ds.get(i).getTenHang()%></td>
			<td><%=g.ds.get(i).getSoluong()%>
			<td><%=g.ds.get(i).getGia()%></td>
				<form method='post'
					action='sua.jsp?th=<%=g.ds.get(i).getTenHang()%>'>
					<input type='text' 	 name='txtsua'> 
					<input type='submit' name='tt' value='Sua'>
				</form></td>
			<td><%=g.ds.get(i).getThanhtien()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<div align='right'>
		Tong tien:
		<%=g.Tongtien()%></div>
	<%
	}
	%>

</body>
</html> 
--%>