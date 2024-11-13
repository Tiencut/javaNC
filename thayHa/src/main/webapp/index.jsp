<%@page import="sachMODEL.Sach"%>
<%@page import="java.util.List"%>
<%@page import="loaiMODEL.loai"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%
//request.getAttribute("soTrang");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .card-hover:hover {
        background-color: #f8f9fa; /* Màu nền sáng hơn */
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* Thêm bóng */
        transition: background-color 0.3s, box-shadow 0.3s; /* Hiệu ứng chuyển đổi mượt mà */
	}
	.card-img-top {
		width: 100%;
		height: auto;
		object-fit: cover;
	}
</style>
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
			    <c:choose>
			        <c:when test="${not empty listSach}">
					<div class="row">
			            <c:forEach var="sach" items="${listSach}">
			                <div class="col-sm-6 col-md-4 col-lg-3 mb-3">
			                    <div class="card mb-3 border card-hover shadow--sm">
			                        <img src="View/${sach.getAnh()}" class="card-img-top img-fluid" alt="${sach.getTenSach()}">
			                        <div class="card-body">
			                            <h5 class="card-title">Tên sách: ${sach.getTenSach()}</h5>
			                            <p class="card-text">Giá: ${sach.getGia()} VNĐ</p>
			                            <a href="GioHangController?action=themVaoGio&maSach=${sach.getMaSach()}" class="btn btn-primary">
			                                <img src="View/image_sach/buynow.jpg" alt="Buy now" class="img-fluid">
			                            </a>
			                        </div>
			                    </div>
			                </div>
			            </c:forEach>
					</div>
			        </c:when>
			        <c:otherwise>
			            <p>Không có dữ liệu để hiển thị</p>
			        </c:otherwise>
			    </c:choose>

	        </div>
	        
	        <div class="col-sm-2">
				<form action="indexController?action=timSach" method="post">
					<input type="text" name="maSachCanTim" placeholder="Tìm kiếm"> 
					<input type="submit" value="Tìm">
				</form>
			</div>
        </div>

        <%-- phân trang --%>
		<div class="row">
			<div class="col-sm-offset-2 col-sm-8 text-center">
			    <nav aria-label="Page navigation">
					<ul class="pagination justify-content-center">
						<c:forEach begin="1" end="${soTrang}" var="i">
							<li class="page-item ${i == index ? 'active' : ''}">
								<a class="page-link" href="indexController?index=${i}">${i}</a>
							</li>
						</c:forEach>
					</ul>
				</nav>
			</div>
		</div></body>
</html>