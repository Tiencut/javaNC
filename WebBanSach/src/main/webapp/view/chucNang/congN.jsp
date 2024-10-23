<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Tính Tổng</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    </head>

    <body>
<%-- 		<jsp:include page="view\TrangChu/nav.jsp" /> --%>
        <div class="container">
            <%
            if (session.getAttribute("tong") == null) {
			session.setAttribute("tong", (int) 0);
		}
		String nn = request.getParameter("txtn");
		if (nn != null) {
            int n = Integer.parseInt(nn);
			int s = (int) session.getAttribute("tong");
			s += n;
			session.setAttribute("tong", s);
			out.print("Tong: " + session.getAttribute("tong"));
		}
		%>
                <form action="index.jsp" method="post">
                    n = <input type="number" name="txtn"> <br> <input type="submit" name="but" value="Tính Tổng"> <br>
                </form>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </body>

    </html>