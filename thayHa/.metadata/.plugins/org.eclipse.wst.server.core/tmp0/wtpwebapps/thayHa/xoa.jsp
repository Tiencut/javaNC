<%@page import="loaiMODEL.loai"%>
<%@page import="java.util.ArrayList"%>
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
        // Lấy thuộc tính listTenLoai từ request
        ArrayList<loai> listTenLoai = (ArrayList<loai>) request.getAttribute("listTenLoai");
        if (listTenLoai != null) {
            // Duyệt qua danh sách và hiển thị các phần tử
            for (loai l : listTenLoai) {
    %>
                <a href="indexController?action=sachTheoLoai&maLoai=<%=l.getMaLoai()%>"><%= l.getTenLoai() %></a>
                <hr>
    <%
            }
        } else {
    %>
            <p>Không có dữ liệu để hiển thị</p>
    <%
        }
    %>
</body>
</html>