package com.myproject.shop.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {
	
	private String userId;
	private String userPass;
	private String userName;
	private String userPhone;
	private String userAddr1;
	private String userAddr2;
	private String userAddr3;
	private Date regiDate;
	private int verify;

}
