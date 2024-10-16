<%@page import="giohangmodal.giohangBO"%>
<%@page import="Tam.CgioHang"%>

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
out.println("Debug: Start of JSP"); // Debug message
giohangBO gh = (giohangBO)session.getAttribute("gh");
if (gh != null) {
    out.println("Debug: gh is not null"); // Debug message
    String mssua = request.getParameter("mssua");
    String soLuong = request.getParameter("txts");
    String maSP = request.getParameter("maSP");
    if (maSP != null) {
        out.println("Debug: ms is not null"); // Debug message
        gh.Xoa(maSP);
        response.sendRedirect("htgio.jsp");
    }
%>
    <%-- if (mssua != null) {
        out.println("Debug: mssua is not null"); // Debug message
        gh.Them(mssua, "", (long) 0, Long.parseLong(sl));
        session.setAttribute("gh", gh);
        response.sendRedirect("htgio.jsp");
    } --%>
<%
} else {
    out.println("Debug: gh is null"); // Debug message
    out.println("<script type='text/javascript'>");
    out.println("alert('Giỏ hàng trống');");
    out.println("</script>");
    response.sendRedirect("htgio.jsp");
}
out.println("Debug: End of JSP"); // Debug message
%>
</body>
</html>