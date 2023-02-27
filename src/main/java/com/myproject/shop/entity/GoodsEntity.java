package com.myproject.shop.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoodsEntity {
	
	private int gdsNum;
	private String gdsName;
	private String cateCode;
	private int gdsPrice;
	private int gdsStock;
	private String gdsDes;
	private String gdsImg;
	private Date gdsDate;

}
