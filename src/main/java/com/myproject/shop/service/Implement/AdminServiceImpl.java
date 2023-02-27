package com.myproject.shop.service.Implement;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.shop.domain.CategoryDTO;
import com.myproject.shop.domain.GoodsDTO;
import com.myproject.shop.entity.CategoryEntity;
import com.myproject.shop.entity.GoodsEntity;
import com.myproject.shop.repository.Implement.AdminDAOImpl;
import com.myproject.shop.service.AdminService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAOImpl admin;
	
	@Autowired
	private ModelMapper modelMapper;
	
//	카테고리 호출
	@Override
	public List<CategoryDTO> category() {
		
		List<CategoryEntity> category = admin.category();
		
		return category.stream()
				.map(CategoryEntity -> modelMapper.map(CategoryEntity, CategoryDTO.class))
				.collect(Collectors.toList());
	}

//	상품등록
	@Override
	public int register(GoodsDTO goods) {
		log.info("--- 서비스 상품 등록 시작 ");
		System.out.println(goods);
		int result = admin.register(modelMapper.map(goods, GoodsEntity.class));
		
		if(!(result>0))
			return 0;
		
		return 1;
	}

}
