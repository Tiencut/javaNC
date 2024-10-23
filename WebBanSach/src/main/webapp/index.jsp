<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="view/nav.jsp" />

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2">
				<c:forEach var="l" items="${loaiList}">
					<a href="indexController?action=sachTheoLoai&ml=${l.getMaLoai()}">${l.getTenLoai()}</a>
					<hr>
				</c:forEach>
			</div>

			<div class="col-sm-8" style="background-color: pink;">
				<c:forEach var="s" items="${sachList}">
					<div class="col-sm-6 col-md-4 col-lg-3 mb-3">
						<div class="card">
							<img src="view/image_sach/${s.getAnh()}" class="card-img-top" alt="$s.getTenSach()">
							<div class="card-body">
								<h5 class="card-title">${s.getTenSach()}</h5>
								<p class="card-text">${s.getGia()}</p>
								<a href="chiTietSachController?ms=${s.getMaSach()}" class="btn-primary">
									<img src="view/image_sach/buynow.jpg" alt="Buy now">
								</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

			<div class="col-sm-2" style="background-color: rgb(170, 71, 87);">
				<form action="indexController?action=timSach" method="post">
					<input type="text" name="sachCanTim" placeholder="Tìm kiếm">
					<input type="submit" value="Tìm">
				</form>
			</div>
		</div>
	</div>
</body>

</html>