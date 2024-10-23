<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Bảng cửu chương</title>
    </head>

    <body>
        <h1 class="text-center mb-4">Bảng cửu chương</h1>
        <form method="post" class="container">
            <div class="mb-3">
                <label for="n" class="form-label">Nhập n:</label>
                <input type="number" class="form-control" name="n" id="n" required>
            </div>
            <div class="d-grid">
                <button type="submit" class="btn btn-primary">Hiển thị</button>
            </div>
        </form>
        <br>
        <%
	String nStr = request.getParameter("n");
	if (nStr != null && !nStr.isEmpty()) {
		int n = Integer.parseInt(nStr);
	%>
            <table border="1">
                <tr>
                    <th>Bảng cửu chương
                        <%=n%>
                    </th>
                </tr>
                <%for (int i = 1; i <= 10; i++) {%>
                    <tr>
                        <td>
                            <%=n%> x
                                <%=i%> =
                                    <%=n * i%>
                        </td>
                    </tr>
                    <%}%>
            </table>
            <%}%>
    </body>

    </html>