package com.prototype.portfolio.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prototype.portfolio.service.MemberService;
import com.prototype.portfolio.vo.MemberVo;

@Controller
public class MemberController {

	private final MemberService service;
	
	public MemberController(MemberService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/login")
	public String moveToLoginView() {
		return "members/login";
	}
	
	@PostMapping("/login")
	public String loginOk(MemberVo member, HttpSession session, RedirectAttributes ra) {
		// 입력한 정보를 가지고와서 아이디 존재여부를 확인하고,
		System.out.println("member: " + member.getUserid());
		Optional<MemberVo> userId = service.makeAnInquiry(member);
		System.out.println("userId: " + userId);
		addFlashProcessName(ra, "로그인");

		if(checkNull(userId)) {
			
			addFlashResult(ra, false);
			return "redirect:/login";
		}
		// 아이디가 조회되면 입력한 아이디를 섹션에 넣어서 게속 유지해준다.
	
		session.setAttribute("sessionId", userId.get().getUserid());
		session.setAttribute("sessionPwd", userId.get().getUserpwd());
		session.setAttribute("sessionNickname", userId.get().getNickname());
		System.out.println("final------");
		
		addFlashResult(ra, true);
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
	public String joinOk(MemberVo member, RedirectAttributes ra) {
		System.out.println("join-Member-info : " + member);
		try {		
			int result = service.join(member);
			addFlashProcessName(ra, "회원가입");
			if(result!=1) {
				throw new Exception("Join fail_ 회원가입 오류");
			}
		} catch (Exception e) {
			System.out.println("join fail");
			addFlashResult(ra, false);
			return "redirect:/join";
		}
		
		System.out.println("------------------- Join success -------------------");
		addFlashResult(ra, true);
		return "redirect:/login";
	}
	
	@GetMapping("/memberList")
	public String moveToMemberList(Model model) {
		List<MemberVo> members = service.inquireAll();
		model.addAttribute("memberList", members);
		System.out.println("------------------------- List Start -------------------------");
		return "members/memberList";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes ra) {
		addFlashProcessName(ra, "로그아웃");
		try {
			session.invalidate();
			System.out.println("------------------------- Session Stop -------------------------");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			addFlashResult(ra, false);
			return "redirect:/";
		}
		addFlashResult(ra, true);
		return "redirect:/";
	}
	
	
	@GetMapping("/edit")
	public String moveToUpdateView(Model model, HttpSession session) {
		Object sessionId = session.getAttribute("sessionId");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sessionId", sessionId);
		MemberVo member = service.inquireOne(map);
		System.out.println("member = " + member);
		model.addAttribute("member", member);		
		return "members/join";
	}
	
	@PostMapping("/edit")
	public String update(MemberVo member, RedirectAttributes ra) {
		System.out.println("memberVo member = " + member);
		int cnt = service.edit(member);
		addFlashProcessName(ra, "회원수정");
		System.out.println("cnt =" + cnt);
		if(cnt!=1) {
			// 수정 실패시
			addFlashResult(ra, false);
			return "redirect:/edit";
		}
		// 수정 성공시
		addFlashResult(ra, true);
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String remove(HttpSession session, RedirectAttributes ra) {
		String sessionId = (String) session.getAttribute("sessionId");
		Map<String, String> map = new HashMap<>();
		map.put("sessionId", sessionId);
		int cnt = service.remove(map);
		System.out.println("cnt = " + cnt);
		addFlashProcessName(ra, "회원삭제");
		if(cnt!=1) {
			// 회원삭제 실패시 
			addFlashResult(ra, false);
		}else {
			// 회원삭제 성공시
			session.invalidate();
			addFlashResult(ra, true);
		}
		return "redirect:/";
	}
	
	private void addFlashProcessName(RedirectAttributes ra, String processName) {
		ra.addFlashAttribute("processName", processName);
	}
	private void addFlashResult(RedirectAttributes ra, boolean result) {
		String content = "";
		if(result) {
			content = "success";
		} else {
			content = "fail";
		}

		ra.addFlashAttribute("result", content);
	}
}
