<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section id="navbar">
	<nav class="navbar navbar-expand-md navbar-dark " style="background-color: #447db8;">
		<div class="container">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/">
				<img width="75" height="37.5" src="https://portal.ptit.edu.vn/wp-content/uploads/2016/04/ptit-logo.png" alt="">
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item" id="homePage"><a class="nav-link"
						href="${pageContext.request.contextPath}/">Trang chủ </a></li>
					<li class="nav-item " id="listSubjects"><a class="nav-link"
						href="${pageContext.request.contextPath}/monhoc">Danh
							sách lớp</a></li>
					<li class="nav-item" id="listthongke"><a class="nav-link"
						href="${pageContext.request.contextPath}/thongke">
						Thống kê</a></li>
				</ul>
				<ul class="navbar-nav">

					<c:choose>
						<c:when test="${pageContext.request.userPrincipal != null}">
							<li class="nav-item">
								<a class="nav-link" href="<c:url value="/logout"/>">Đăng xuất</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="nav-item" id="homePage"><a class="nav-link"
								href="${pageContext.request.contextPath}/login">Đăng nhập</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</nav>
</section>