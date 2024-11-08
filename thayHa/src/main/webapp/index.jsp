<%@page import="sachMODEL.Sach"%>
<%@page import="java.util.List"%>
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
    <jsp:include page="View/Nav.jsp" />

    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-2">
				<%-- JSP --%>
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
            </div>
            
            <div class="col-sm-8" style="border-left: 2px dashed black; border-right: 2px dashed black;">
                <%
                    List<Sach> listSach = (List<Sach>) request.getAttribute("listSach");
                    if (listSach != null) {
                        for (Sach sach : listSach) {
                %>
                	<div class="col-sm-6 col-md-4 col-lg-3 mb-3">
                            <div class="card">
                                <img src="View/<%= sach.getAnh() %>" class="card-img-top" alt="<%= sach.getTenSach() %>">
                                <div class="card-body">
                                    <h5 class="card-title"><%= sach.getTenSach() %></h5>
                                    <p class="card-text"><%= sach.getGia() %></p>
                                    <a href="<%= request.getSession().getAttribute("username") == null ? "accountController" : "indexController?action=themVaoGio&maSach=" + sach.getMaSach() %>" class="btn-primary"> 
                                        <img src="View/image_sach/buynow.jpg" alt="Buy now">
                                    </a>
                                </div>
                            </div>
					</div>
				<%
                        }
                    } else {
                %>
						<p>Không có dữ liệu để hiển thị</p>
				<%
				    }
                %>
	        </div>
	        
	        <div class="col-sm-2">
				<form action="indexController?action=timSach&maSachCanTim=${maSachCanTim}" method="post">
					<input type="text" name="maSachCanTim" placeholder="Tìm kiếm"> 
					<input type="submit" value="Tìm">
				</form>
			</div>
        </div>
    </div>
</body>
</html>