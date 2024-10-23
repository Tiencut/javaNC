<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <%
String loginID = request.getParameter("loginID");
String password = request.getParameter("password");
String errorMessage = "";

if (loginID != null && password != null) {
	if (loginID.equals("abc") && password.equals("123")) {
		response.sendRedirect("http://ums.husc.edu.vn");
	} else {
		errorMessage = "Tên đăng nhập hoặc mật khẩu không đúng!";
	}
}
%>

        <head>
            <meta charset="UTF-8">
            <title>Insert title here</title>
            <link rel="stylesheet" href="style.css">
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        </head>

        <body>
            <div class="hitec-col-signin">
                <form action="formDK.jsp" method="post" class="hitec-form-signin">
                    <img src="https://student.husc.edu.vn/Themes/Login/images/logo-small.png" alt="">
                    <h2 class="form-signin-heading" style="color: #006eb7;">SINH VIÊN
                    </h2>
                    <div class="form-group">
                        <label for="loginID">Tên đăng nhập:</label> <input type="text" id="loginID" name="loginID" class="form-control input-lg" placeholder="Mã giảng viên/Email" required autofocus value="" />
                    </div>
                    <div class="form-group">
                        <label for="password">Mật khẩu:</label> <input type="password" id="password" name="password" class="form-control input-lg" placeholder="Mật khẩu" required value="" />
                    </div>
                    <div class="form-group">
                        <span class="text-danger"></span>
                    </div>
                    <button class="btn btn-lg btn-primary btn-block btn-custom" type="submit">Đăng nhập</button>
                </form>
            </div>
            <!--  -->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        </body>

    </html>