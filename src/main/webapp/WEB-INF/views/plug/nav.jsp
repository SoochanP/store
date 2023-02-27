<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <div class="navbar-brand">SC Store</div>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a id="home"class="nav-link" aria-current="page" href="/">Home</a></li>
                        <li class="nav-item"><a id="about"class="nav-link" href="#!">About</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#!">All Products</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="#!">Popular Items</a></li>
                                <li><a class="dropdown-item" href="#!">New Arrivals</a></li>
                            </ul>
                        </li>
                    </ul>
                   <!--  <form class="d-flex">
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi-cart-fill me-1"></i>
                            Cart
                            <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
                        </button>
                    </form> -->
                    <c:if test="${member == null }">
                   	 <div class="nav-item">
                    	<a class="nav-link ps-0" href ="/member/login">log In</a>
                    </div>
                    </c:if>
                    <c:if test="${member != null }">
		                    <div class="nav-item">
		                    	<a class="nav-link ps-0" href="#">${member.userName } 님</a>
		                    </div>
                    	<c:if test="${member.verify == 9 }">
                    	 <div class="nav-item dropdown">
                    		<div class="nav-item dropdown">
	                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Manage</a>
		                    		<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
		                                <li><a class="dropdown-item" href="#!">상품관리</a></li>
		                                <li><hr class="dropdown-divider" /></li>
		                                <li><a class="dropdown-item" href="/admin/register">상품등록</a></li>
		                                <li><a class="dropdown-item" href="/admin/list">상품목록</a></li>
		                                <li><a class="dropdown-item" href="/admin/review">상품소감</a></li>
		                                <li><a class="dropdown-item" href="/admin/user">유저목록</a></li>
		                            </ul>
                    		</div>
                    	</div>
                    	</c:if>
		                    <div class="nav-item">
		                     	<a class="nav-link ps-0" href="/member/logout">log Out</a>
		                    </div>
                    </c:if>
                    <div class="nav-item">
                    <a class="nav-link ps-0" href ="/member/joinus">Join Us</a>
                    </div>
                </div>
            </div>
        </nav>
