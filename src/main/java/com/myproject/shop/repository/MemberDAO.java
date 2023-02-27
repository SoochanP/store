package com.myproject.shop.repository;


import com.myproject.shop.domain.MemberDTO;
import com.myproject.shop.entity.MemberEntity;

public interface MemberDAO {

//	회원가입
	public int joinUs(MemberEntity member);
	
//	로그인
	public MemberDTO login(MemberEntity member);
	
}
