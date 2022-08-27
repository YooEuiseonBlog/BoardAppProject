package com.prototype.portfolio.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.prototype.portfolio.vo.BoardVo;
import com.prototype.portfolio.vo.PagingVo;

@Mapper
@Repository
public interface BoardDao {
	int insertBoard(BoardVo board);
	BoardVo findBoardOne(BoardVo board);
	int upCountViews(Map<String, Integer> map);
	List<BoardVo> findBoardList(PagingVo page);
	int countAllBoard();
	BoardVo findLastRecordByAuthor(BoardVo boardVo);
}
