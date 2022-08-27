package com.prototype.portfolio.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.prototype.portfolio.vo.BoardVo;
import com.prototype.portfolio.vo.MemberVo;
import com.prototype.portfolio.vo.PagingVo;

public interface BoardService {
	int uploadPost(BoardVo board);
	BoardVo readBoardOne(BoardVo board);
	List<BoardVo> readBoardList(PagingVo page);
	int updatePlusViews(Map<String, Integer> map);
	List<BoardVo> readAllBoard(PagingVo page);
	int countAllBoard();
	BoardVo readLastBoardByAuthor(BoardVo board);


}
