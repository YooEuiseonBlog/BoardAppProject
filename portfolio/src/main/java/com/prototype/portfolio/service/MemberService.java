package com.prototype.portfolio.service;

import java.util.List;
import java.util.Optional;

import com.prototype.portfolio.vo.MemberVo;

public interface MemberService {
	public int join(MemberVo member);
	public Optional<MemberVo> makeAnInquiry(MemberVo memeber);
	public List<MemberVo> inquireAll();
}
