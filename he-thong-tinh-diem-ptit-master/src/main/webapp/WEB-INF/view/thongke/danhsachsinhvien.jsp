<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!doctype html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/mdb.min.css">
<style>
.error {
	color: red;
}
</style>
<title>Danh sách sinh viên</title>
</head>

<body>
	<jsp:include page="/WEB-INF/view/navbar/navbar.jsp"></jsp:include>
	<section id="body">
		<div class="container mt-5">

			<form:form
				action="${pageContext.request.contextPath}/thongke/${maMonHoc }/${nhomMH }/dssv/saveDiemSo"
				modelAttribute="lst" method="POST">
				<p>
					<strong>Tên môn học:</strong> ${tenMH }&ensp; <strong>Nhóm
						môn học:</strong> ${nhomMH}&ensp; <strong>Giảng viên:</strong>
					${giangVien }&ensp; <strong>Cấu hình: </strong> ${cauHinhDiem }
					<strong>được thi/Tổng:</strong> ${thi}/${tong} &ensp;
				</p>
				<input type="hidden" name="maMH" value="${maMonHoc }">
				<input type="hidden" name="nhomMH" value="${nhomMH }">
				<input type="hidden" name="tenMH" value="${tenMH }">
				<input type="hidden" name="giangVien" value="${giangVien }">
				<input type="hidden" name="cauHinh" value="${cauHinhDiem }">
				<table class="table mt-5 text-center table-bordered ">
					<thead>
						<tr class=" table-primary">
							<th scope="col">#</th>
							<th scope="col">Mã sinh viên</th>
							<th scope="col">Họ lót</th>
							<th scope="col">Tên</th>
							<th scope="col">Tên lớp</th>
							<th scope="col">Điểm CC</th>
							<th scope="col">Điểm BTL</th>
							<th scope="col">Điểm GK</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${lst.listSinhVienDiem }"
							varStatus="count">
							<tr>
								<th scope="row" class="align-middle">${count.count }</th>
								<td class="align-middle">${item.maSV }<form:hidden
										path="listSinhVienDiem[${count.index }].maSV" />
								</td>
								<td class="align-middle">${item.hoLot }</td>
								<td class="align-middle">${item.ten }</td>
								<td class="align-middle">${item.tenLop }</td>
								<td class="align-middle" > ${item.diemCC} </td>
								<td class="align-middle" > ${item.diemBTL} </td>
								<td class="align-middle" > ${item.diemGK} </td>

						</c:forEach>
					</tbody>
				</table>
			</form:form>
		</div>
	</section>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.jstepper.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.numeric.js"></script>
	<script src="${pageContext.request.contextPath}/js/mdb.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#listthongke').addClass('active');
			$('.validateData').numeric({
				allowEmpty : true,
				live : true,
				decimalPlaces : 2,
				negative : false
			}, function(val) {
				console.log(val);
			});
			$('.validateData').jStepper({
				maxValue : 10,
				minLength : 0,
				decimalSeparator : ".",
				decimalSeparator : ",",
				maxDecimals : 2,
				disableAutocomplete : false
			});
			$('#noDecimal').keypress(function(e) {
				if (e.which == 46) {
					e.preventDefault();
				}
			});
			$('[data-toggle="tooltip"]').tooltip();   
		});
	</script>
</body>

</html>
