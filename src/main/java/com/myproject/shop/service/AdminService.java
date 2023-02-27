package com.myproject.shop.service;

import java.util.List;

import com.myproject.shop.domain.CategoryDTO;
import com.myproject.shop.domain.GoodsDTO;

public interface AdminService {

//	카테고리 호출
	public List<CategoryDTO> category();
	
//	상품등록
	public int register(GoodsDTO goods);
}
