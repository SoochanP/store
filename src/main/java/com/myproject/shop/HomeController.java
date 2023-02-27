package com.myproject.shop;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Controller
public class HomeController {

//	메인페이지 이동 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		log.info("메인 페이지");
		return "index";
	}
	
}
