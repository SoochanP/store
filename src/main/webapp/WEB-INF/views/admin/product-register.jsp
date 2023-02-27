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
        <title>상품등록</title>
<%@ include file = "../plug/config.jsp" %>
<style>
textarea{
 	font-family: 'Noto Sans KR','Noto Sans Korean', "Nanum Gothic", sans-serif !important;
    -webkit-appearance: none;
    -webkit-border-radius: 0;
    outline: none;
    font-size: 10px;
    
	resize: none;
	width: 100%;
    border: 1px solid #bbbbbb !important;
    font-size: 1rem;
    line-height: 1.45;
    letter-spacing: -0.04rem;
    border-radius: 8px;
    padding: 16px;
    margin-top: 12px;
    
}
</style>
    </head>
    <body>
<script>
	
	let msg = "${msg}";
	if(msg!=""){
		alert(msg);
	}
</script>
        <!-- Navigation-->
<%@ include file = "../plug/nav.jsp" %>

        <!-- Header-->
		<header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h1 class="display-4 fw-bolder">AdminPage</h1>
                    <p class="lead fw-normal text-white-50 mb-0">for product register</p>
                </div>
            </div>
        </header>
        
        <!-- Section-->
       <section class="p-5 mb-4 rounded-3 text-center">
	  			
			<form role="form" method="post" autocomplete="off">
			<div>
				<span class="me-3">
				 <label>1차 분류</label>
			 		<select class="category1">
			  			<option value="">전체</option>
			 		</select>
				</span>
				<span>
			 	<label>2차 분류</label>
			 		<select class="category2" name=cateCode>
			  			<option value="">전체</option>
			 		</select>
				</span>
			</div>
			<div class="dust-class">
				<label for="gdsName"><span>* </span>상품명</label>
				<input type="text" id="gdsName" name="gdsName" placeholder="상품명을 입력하세요." required="required"><br><br>
			</div>
			<div class="dust-class">
				<label for="gdsPrice"><span>* </span>상품가격</label>
				<input type="text" id="gdsPrice" name="gdsPrice" placeholder="상품가격을 입력하세요." required="required"><br><br>
			</div>
			<div class="dust-class">
				<label for="gdsStock"><span>* </span>상품수량</label>
				<input type="text" id="gdsStock" name="gdsStock" placeholder="상품수량을 입력하세요." required="required"><br><br>
			</div>
			<div class="dust-class">
				<label for="gdsDes"><span>* </span>상품소개</label>
				<textarea id="gdsDes" name="gdsDes"></textarea><br><br>
			</div>
			<div>
				<button class="btn btn-outline-secondary" type="submit" id="register_Btn">등록</button>
				<button class="btn btn-outline-secondary" type="reset" id="cancle_Btn">취소</button>
			</div>
			</form>
			
		</section>
        <!-- Footer-->
        <%@ include file="../plug/footer.jsp" %>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="/resources/js/scripts.js"></script>
        
<script>
	// 컨트롤러에서 데이터 받기
	var jsonData = JSON.parse('${category}');
	console.log(jsonData);
	
	var cate1Arr = new Array();
	var cate1Obj = new Object();
	
	// 1차 분류 셀렉트 박스에 삽입할 데이터 준비
	for(var i = 0; i < jsonData.length; i++) {
	 
	 if(jsonData[i].level == "1") {
	  cate1Obj = new Object();  //초기화
	  cate1Obj.cateCode = jsonData[i].cateCode;
	  cate1Obj.cateName = jsonData[i].cateName;
	  cate1Arr.push(cate1Obj);
	 }
	}
	
	// 1차 분류 셀렉트 박스에 데이터 삽입
	var cate1Select = $("select.category1")
	
	for(var i = 0; i < cate1Arr.length; i++) {
	 cate1Select.append("<option value='" + cate1Arr[i].cateCode + "'>"
	      + cate1Arr[i].cateName + "</option>"); 
	}

</script>
    
<script>
    $(document).on("change", "select.category1", function(){

    	 var cate2Arr = new Array();
    	 var cate2Obj = new Object();
    	 
    	 // 2차 분류 셀렉트 박스에 삽입할 데이터 준비
    	 for(var i = 0; i < jsonData.length; i++) {
    	  
    	  if(jsonData[i].level == "2") {
    	   cate2Obj = new Object();  //초기화
    	   cate2Obj.cateCode = jsonData[i].cateCode;
    	   cate2Obj.cateName = jsonData[i].cateName;
    	   cate2Obj.cateCodeRef = jsonData[i].cateCodeRef;
    	   
    	   cate2Arr.push(cate2Obj);
    	  }
    	 }
    	 
    	 var cate2Select = $("select.category2");

    	 // 2차분류 중복 생겨서 주석 처리함
    	/*  for(var i = 0; i < cate2Arr.length; i++) {
    	   cate2Select.append("<option value='" + cate2Arr[i].cateCode + "'>"
    	        + cate2Arr[i].cateName + "</option>");
    	 }  */
    	 
    	 
    	 cate2Select.children().remove();

    	 $("option:selected", this).each(function(){
    	  
    	  var selectVal = $(this).val();  
    	  cate2Select.append("<option value='" + selectVal + "'>전체</option>");
    	  
    	  for(var i = 0; i < cate2Arr.length; i++) {
    	   if(selectVal == cate2Arr[i].cateCodeRef) {
    	    cate2Select.append("<option value='" + cate2Arr[i].cateCode + "'>"
    	         + cate2Arr[i].cateName + "</option>");
    	   }
    	  }
    	  
    	 });
    	 
    	});
</script>
</body>
</html>
