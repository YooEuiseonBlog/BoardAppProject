package com.prototype.portfolio.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PagingVoTest {
	@Test
	@DisplayName("pagoingVo 계산 테스트")
	void PagingTest() {
		PagingVo page = new PagingVo(3, 100);
		System.out.println(page);
	}
}
