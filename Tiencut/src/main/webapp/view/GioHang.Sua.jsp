<%@page import="giohangmodal.hang"%>
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
<%
giohangBO gioHang 	= (giohangBO) session.getAttribute("gh");
String maSach 		= request.getParameter("maSP");
String tenSach 		= request.getParameter("tenSach");
int soLuong 		= Integer.parseInt(request.getParameter("soLuong"));
long gia 			= Long.parseLong(request.getParameter("gia"));

// lấy số lượng sách trong giỏ hàng
int soLuongTrongGio = 0;

if (gioHang != null) {
    for (hang h : gioHang.ds) {
        if (h.getMasach().equals(maSach)) {
            soLuongTrongGio = h.getSoLuong();
            break;
        }
    }
}

if (gioHang == null) {
    out.println("Giỏ hàng không hợp lệ.");
} else if (maSach == null || maSach.isEmpty()) {
    out.println("Mã sách không hợp lệ.");
} else if ((soLuong + soLuongTrongGio) < 0) {
    out.println("Số lượng không hợp lệ.");
} else {
    try {
        gioHang.Them(maSach, tenSach, gia, soLuong);
        session.setAttribute("gioHang", gioHang);
/*         response.sendRedirect("DatHang.jsp"); */
        response.sendRedirect("htgio.jsp");
    } catch (NumberFormatException e) {
        out.println("Số lượng không hợp lệ.");
    }
}
%>
</body>
</html>