package com.myproject.shop.repository.Implement;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.shop.entity.CategoryEntity;
import com.myproject.shop.entity.GoodsEntity;
import com.myproject.shop.repository.AdminDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class AdminDAOImpl implements AdminDAO{

	@Autowired
	private SqlSession sqlSession;
	
	private static final String nameSpace ="com.myproject.shop.mappers.adminMapper";
	
//	카테고리 호출
	@Override
	public List<CategoryEntity> category() {
		return sqlSession.selectList(nameSpace+".category");
	}

//	상품등록
	@Override
	public int register(GoodsEntity goods) {
		log.info("--- DAO 상품등록 시작 ---");
		System.out.println(goods);
		return sqlSession.insert(nameSpace+".register", goods);
	}

}
