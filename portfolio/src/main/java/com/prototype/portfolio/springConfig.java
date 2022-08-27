package com.prototype.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prototype.portfolio.mytools.MyTools;
import com.prototype.portfolio.service.MemberService;

@Configuration
public class springConfig {
	@Bean
	MyTools myTools() {
		return new MyTools();
	}
}
