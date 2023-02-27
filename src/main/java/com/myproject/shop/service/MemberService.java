package com.myproject.shop.service;


import javax.servlet.http.HttpSession;

import com.myproject.shop.domain.MemberDTO;
import com.myproject.shop.entity.MemberEntity;

public interface MemberService {

//	회원가입
	public int joinUs(MemberDTO memberDTO);
	
//	로그인
	public MemberDTO login(MemberDTO memberDTO) throws Exception;
	
//	로그아웃
	public void logout(HttpSession session);
	
}
