package com.myproject.shop.repository.Implement;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.shop.domain.MemberDTO;
import com.myproject.shop.entity.MemberEntity;
import com.myproject.shop.repository.MemberDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MemberDAOlmpl implements MemberDAO {


//	sqlSession 의존성 주입
	@Autowired
	private SqlSession sqlSession;
	
	
//	네임스페이스 상수로 사용
	private static final String nameSpace = "com.myproject.shop.mappers.memberMapper";
	
//	회원가입
	@Override
	public int joinUs(MemberEntity member) {
		System.out.println(member);
		return sqlSession.insert(nameSpace+".joinUs", member);
	}

//	로그인 처리
	@Override
	public MemberDTO login(MemberEntity member) {
		return sqlSession.selectOne(nameSpace+".login", member);
	}
	
}
