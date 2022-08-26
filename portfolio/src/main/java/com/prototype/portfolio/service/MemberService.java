package com.prototype.portfolio.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.prototype.portfolio.vo.MemberVo;

public interface MemberService {
	public int join(MemberVo member);
	public Optional<MemberVo> makeAnInquiry(MemberVo memeber);
	public List<MemberVo> inquireAll();
	public MemberVo inquireOne(Map<String, Object> map);
	public int edit(MemberVo member);
	public int remove(Map<String, String> map);
}
