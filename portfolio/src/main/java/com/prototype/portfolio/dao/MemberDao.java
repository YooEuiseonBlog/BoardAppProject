package com.prototype.portfolio.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.prototype.portfolio.vo.MemberVo;

@Mapper
@Repository
public interface MemberDao {
	public Optional<MemberVo> findByIdAndPwd(MemberVo member);
	public MemberVo findById(Map<String, Object> map);
	public int addMember(MemberVo member);
	public List<MemberVo> findMemberList();
}
