package com.myproject.shop.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
	private String cateName;
	private String cateCode;
	private String cateCodeRef;
	private int level;
}
