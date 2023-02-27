package com.myproject.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity {
	
	private String cateName;
	private String cateCode;
	private String cateCodeRef;
	private int level;
}
