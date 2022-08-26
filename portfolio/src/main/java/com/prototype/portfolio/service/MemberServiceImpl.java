package com.prototype.portfolio.service;



import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.portfolio.dao.MemberDao;
import com.prototype.portfolio.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {
	
	private final MemberDao dao;
	
	public MemberServiceImpl(MemberDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public int join(MemberVo member) {
		return dao.addMember(member);
	}

	@Override
	public Optional<MemberVo> makeAnInquiry(MemberVo memeber) {
		return dao.findByIdAndPwd(memeber);
	}

	@Override
	public List<MemberVo> inquireAll() {
		return dao.findMemberList();
	}

	@Override
	public MemberVo inquireOne(Map<String, Object> map) {
		return dao.findById(map);
	}

	@Override
	public int edit(MemberVo member) {
		return dao.updateMember(member);
	}

	@Override
	public int remove(Map<String, String> map) {
		return dao.deleteMember(map);
	}

}
