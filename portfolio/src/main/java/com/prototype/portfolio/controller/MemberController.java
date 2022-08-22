package com.prototype.portfolio.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.prototype.portfolio.service.MemberService;
import com.prototype.portfolio.vo.MemberVo;

@Controller
public class MemberController {
	@Inject
	MemberService service;
	
//	public MemberController(MemberService service) {
//		super();
//		this.service = service;
//	}
//	
	@GetMapping("/login")
	public String moveToLoginView() {
		return "members/login";
	}
	
	@PostMapping("/login")
	public String loginOk(MemberVo member, HttpSession session) {
		// 입력한 정보를 가지고와서 아이디 존재여부를 확인하고,
		System.out.println("member: " + member.getUserid());
		Optional<MemberVo> userId = service.makeAnInquiry(member);
		System.out.println("userId: " + userId);

		if(checkNull(userId)) {
			return "redirect:/login";
		}
		// 아이디가 조회되면 입력한 아이디를 섹션에 넣어서 게속 유지해준다.
	
		session.setAttribute("sessionId", userId.get().getUserid());
		session.setAttribute("sessionPwd", userId.get().getUserpwd());
		session.setAttribute("sessionNickname", userId.get().getNickname());
		System.out.println("final------");
		
		
		return "redirect:/";
	}
	
	private boolean checkNull(Optional<MemberVo> member) {
		return member.isEmpty();
	}
	@GetMapping("/join")
	public String moveToJoinView() {
		return "members/join";
	}
	
	@PostMapping("/join")
	public String joinOk(MemberVo member) {
		try {
			System.out.println(member);
			int result = service.join(member);
			if(result!=1) {
				throw new Exception("Join fail_ 회원가입 오류");
			}
		} catch (Exception e) {
			System.out.println("join fail");
			return "redirect:/join";
		}
		
		System.out.println("------------------- Join success -------------------");
		return "redirect:/login";
	}
	
	@GetMapping("/memberList")
	public String moveToMemberList(Model model) {
		List<MemberVo> members = service.inquireAll();
		model.addAttribute("memberList", members);
		System.out.println("------------------------- List Start -------------------------");
		return "members/memberList";
	}
	
	@GetMapping("/update")
	public String moveToUpdateView() {
		return "members/update";
	}
}
