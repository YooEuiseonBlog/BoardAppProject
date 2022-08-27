package com.prototype.portfolio.mytools;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class MyTools {
	public MyTools() {
		// TODO Auto-generated constructor stub
	}
	
	public void addFlashProcessName(RedirectAttributes ra, String processName) {
		ra.addFlashAttribute("processName", processName);
	}
	public void addFlashResult(RedirectAttributes ra, boolean result) {
		String content = "";
		if(result) {
			content = "success";
		} else {
			content = "fail";
		}

		ra.addFlashAttribute("result", content);
	}
}
