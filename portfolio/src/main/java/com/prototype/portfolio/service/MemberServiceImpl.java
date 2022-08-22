package com.prototype.portfolio.service;



import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.portfolio.dao.MemberDao;
import com.prototype.portfolio.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {
	@Inject
	MemberDao dao;
	
//	public MemberServiceImpl(MemberDao dao) {
//		super();
//		this.dao = dao;
//	}

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

}
