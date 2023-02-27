package com.myproject.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myproject.shop.domain.MemberDTO;
import com.myproject.shop.service.Implement.MemberServicelmpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

//	의존성 주입
	@Autowired
	private MemberServicelmpl memberService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
//	로그인 창으로 이동
	@GetMapping("/login")
	public String login() {
		return "member/login";
				
	}
	
//	로그인 실행
	@PostMapping("/login")
	public String login(MemberDTO memberDTO, HttpServletRequest req, RedirectAttributes rttr, Model model) {
		
		MemberDTO login;
		
		try {
					login = memberService.login(memberDTO);
				
					HttpSession session = req.getSession();
					
					boolean passMatch = passwordEncoder.matches(memberDTO.getUserPass(), login.getUserPass());
					
					if(login != null && passMatch) {
						session.setAttribute("member", login);
						model.addAttribute("msg", "로그인에 성공하였습니다.");
						return "index";
//					비밀번호가 틀릴 때 작동
					}else {
						session.setAttribute("member", null);
						rttr.addFlashAttribute("msg",false);
						return "redirect:/member/login";
					}
				}catch (Exception e) {
					e.printStackTrace();
//					아이디가 틀릴 때 작동
					rttr.addFlashAttribute("msg",false);
					return "redirect:/member/login";
					
			}
				
	}
			
		

	
//	로그아웃 실행
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		memberService.logout(session);
		return "redirect:/";
	}
	
	
//	회원가입 창으로 이동
	@GetMapping("/joinus")
	public String joinus() {
		return "member/joinus";
		
	}
	
//	회원가입 실행
	@PostMapping("/joinus")
	public String joinus(MemberDTO memberDTO, Model model) {

		log.info(" 회원가입 실행 ");
		System.out.println(memberDTO);
		String msg="";
		
		String inputPass = memberDTO.getUserPass();
		memberDTO.setUserPass(passwordEncoder.encode(inputPass));
		int result = memberService.joinUs(memberDTO);
		
		if(!(result<0)) {
			msg="회원가입에 성공하였습니다.";
			model.addAttribute("msg", msg);
			return "index";
		}else {
			msg="회원가입에 실패하였습니다.";
			model.addAttribute("msg", msg);
			return "member/joinus";
		}
			
	}
	
	
}
