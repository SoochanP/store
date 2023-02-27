package com.myproject.shop.repository;

import java.util.List;

import com.myproject.shop.entity.CategoryEntity;
import com.myproject.shop.entity.GoodsEntity;

public interface AdminDAO {
	
//	카테고리 호출
	public List<CategoryEntity> category();
	
//	상품등록
	public int register(GoodsEntity goods);
}
