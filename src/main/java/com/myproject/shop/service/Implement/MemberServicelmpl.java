package com.myproject.shop.service.Implement;

import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.shop.domain.MemberDTO;
import com.myproject.shop.entity.MemberEntity;
import com.myproject.shop.repository.Implement.MemberDAOlmpl;
import com.myproject.shop.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServicelmpl implements MemberService {

//	의존성 주입
	@Autowired
	private MemberDAOlmpl memberDAO;
	
	@Autowired
	private ModelMapper modelMapper;

//	회원가입
	@Override
	public int joinUs(MemberDTO memberDTO) {
		
		log.info("----서비스 회원가입 시작 ----");
		System.out.println(memberDTO);
		
//		DTO와 ENTITY  구분하고자 modelMapper 사용
		int result =  memberDAO.joinUs(modelMapper.map(memberDTO, MemberEntity.class));
		if(!(result<0))
			return 1;
		return 0;
	}

//	로그인
	@Override
	public MemberDTO login(MemberDTO memberDTO) throws Exception {
		return modelMapper.map(memberDAO.login(modelMapper.map(memberDTO, MemberEntity.class)), MemberDTO.class);
	}

//	로그아웃
	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}
	
}
