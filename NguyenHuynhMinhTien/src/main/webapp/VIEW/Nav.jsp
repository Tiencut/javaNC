<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- jquery và toastr CSS --%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

<% 
    session = request.getSession(false);
    String errorMessage = (session != null) ? (String) session.getAttribute("errorMessage") : null;
	String successMessage = (session != null) ? (String) session.getAttribute("successMessage") : null;
    if (errorMessage != null) { 
%>
		<script>
			toastr.error('<%=errorMessage%>');
		</script>
<% 
        session.removeAttribute("errorMessage");
    }
	if (successMessage != null) {
%>
		<script>
			toastr.success('<%=successMessage%>');
		</script>
<%
		session.removeAttribute("successMessage");
	}
%>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <ul class="nav navbar-nav">
            <li><a href="indexController">Trang chủ</a></li>
            <li><a href="GioHangController">Giỏ hàng</a></li>
            <li><a href="XacNhanDatMuaController">Xác nhận đặt mua</a></li>
            <li><a href="LichSuMuaHangController">Lịch sử mua hàng</a></li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
            <%
            if (session != null && session.getAttribute("username") != null) {
            %>
            <li>
                <a href="#">
                    <span class="glyphicon glyphicon-user"></span>
                    Chào, <%=session.getAttribute("username")%>
                </a>
            </li>
            <li>
                <a href="NavController?action=Logout">
                    <span class="glyphicon glyphicon-log-out"></span> Đăng xuất
                </a>
            </li>
            <%
            } else {
            %>
            <li>
                <a href="accountController">
                     <span class="glyphicon glyphicon-user"></span>Sign Up/
                     <span class="glyphicon glyphicon-log-in"></span>Login
                 </a>
            </li>
            <%
            }
            %>
        </ul>
    </div>
</nav>

<%-- bootstrap CSS và JS --%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>