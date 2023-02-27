package com.myproject.shop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.myproject.shop.domain.MemberDTO;

public class AdminInterceptor extends HandlerInterceptorAdapter {
	
//	컨트롤러가 요청을 처리하기전에 호출하는 메소드   postHanlde  --> 예외처리 발생 x, 컨트롤러 작업 끝난 후 진행, afterCompletion --> 예외처리 발생 상관없이, 컨트롤러 작업 끝난 후 진행
	@Override
	 public boolean preHandle(HttpServletRequest req,
			 		HttpServletResponse res, Object obj) throws Exception {
	  
	  HttpSession session = req.getSession();
//		세션 불러와서 멤버 DTO 에 넣기
	  MemberDTO member = (MemberDTO)session.getAttribute("member");
//	  	DTO 널 이면 로그인 페이지로 이동
	  if(member == null) {
		  res.sendRedirect("/member/login");
		  return false;
	  }
//	   DTO가 NULL은 아니지만 관리자 가 아닐때 메인페이지로 이동
	  else if(member != null && member.getVerify() != 9) {
	   res.sendRedirect("/");
	   return false;
	  }
	  
	  return true;
	 }
	
}
