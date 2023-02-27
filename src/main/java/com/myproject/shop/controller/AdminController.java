package com.myproject.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myproject.shop.domain.CategoryDTO;
import com.myproject.shop.domain.GoodsDTO;
import com.myproject.shop.service.Implement.AdminServiceImpl;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminServiceImpl admin;
	
//	상품등록 페이지 이동
	@GetMapping("/register")
	public String register(Model model) {
		List<CategoryDTO> category = admin.category();
		model.addAttribute("category", JSONArray.fromObject(category));
		return "admin/product-register";
	}
	
//	상품등록 
	@PostMapping("/register")
	public String register(GoodsDTO goods, RedirectAttributes rttr,Model model) {
		
		log.info("--- 컨트롤러 상품 등록 시작 ---");
		System.out.println(goods);
		int result = admin.register(goods);
		if(result==0) {
			String msg = "상품 등록에 실패하셨습니다.";
			rttr.addAttribute("msg", msg);
			return "redirect:admin/product-register";
		}else {
			String msg = "상품 등록에 성공하셨습니다.";
			model.addAttribute("msg", msg);
			return "index";
		}
			
		
	}
}
