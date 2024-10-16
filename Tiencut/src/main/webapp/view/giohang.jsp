<%@page import="giohangmodal.giohangBO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String masach = request.getParameter("ms");
String tensach = request.getParameter("ts");
String gia = request.getParameter("gia");
giohangBO gh = (giohangBO) session.getAttribute("gh");

if (gh == null) {
    gh = new giohangBO(); // Khởi tạo giỏ hàng nếu chưa có
    session.setAttribute("gh", gh);
}

gh.Them(masach, tensach, Long.parseLong(gia), (int) 1);
session.setAttribute("gh", gh);
response.sendRedirect("htgio.jsp");
%>
</body>
</html>