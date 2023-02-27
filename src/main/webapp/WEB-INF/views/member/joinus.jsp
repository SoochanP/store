<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Sc store JoinUs</title>
<%@ include file = "../plug/config.jsp" %>
    </head>
    <body>
        <!-- Navigation-->
<%@ include file = "../plug/nav.jsp" %>
        <!-- Header-->
		<header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h1 class="display-4 fw-bolder">환영합니다</h1><br>
                    <p class="lead fw-normal text-white-50 mb-0">회원가입 페이지 입니다.</p>
                </div>
            </div>
        </header>
        
        <!-- Section-->
		<section class="p-5 mb-4 rounded-3 text-center">
			<p style="color: red">* 필수기입사항 입니다.</p>
			<br>
			<form role="form" method="post" autocomplete="off">
			<div class="dust-class">
			<label for="userID"><span>* </span>아이디</label>
			<input type="email" id="userId" name="userId" placeholder="example@email.com" required="required"><br><br>				
			</div>
			<div class="dust-class">
			<label for="userPass"><span>* </span>비밀번호</label>
			<input type="password" id="userPass" name="userPass" placeholder="비밀번호를 입력해주세요" required="required"><br><br>				
			</div>
			<div class="dust-class">
			<label for="userName"><span>* </span>별명</label>
			<input type="text" id="userName" name="userName" placeholder="별명을 입력해주세요" required="required"><br><br>				
			</div>
			<div class="dust-class">
			<label for="userPhon"><span>* </span>번호</label>
			<input type="text" id="userPhone" name="userPhone" placeholder="ex)000-0000-0000" required="required"><br><br>
			</div>
			<div>
			<button class="btn btn-outline-secondary" type="submit">작성</button>
			<button class="btn btn-outline-secondary" type="reset">취소</button>				
			</div>
			</form>
			
			
</section>
	<script>
		let msg = "${msg}";
		if(msg!=""){
		alert(msg);
		}
	</script>
		
		        
        <!-- Footer-->
        <%@ include file="../plug/footer.jsp" %>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="/resources/js/scripts.js"></script>
    </body>
</html>
