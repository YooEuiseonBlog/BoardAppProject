package com.prototype.portfolio.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.prototype.portfolio.dao.BoardDao;
import com.prototype.portfolio.vo.BoardVo;
import com.prototype.portfolio.vo.PagingVo;

@Service
public class BoardServiceImpl implements BoardService {
	private final BoardDao dao;
	
	public BoardServiceImpl(BoardDao dao) {
		super();
		this.dao = dao;
	}
	
	@Override
	public int uploadPost(BoardVo board) {
		return dao.insertBoard(board);
	}
	
	@Override
	public BoardVo readBoardOne(BoardVo board) {
		return dao.findBoardOne(board);
	}
	
	@Override
	public List<BoardVo> readBoardList(PagingVo page) {
		return null;
	}

	@Override
	public int updatePlusViews(Map<String, Integer> map) {
		return dao.upCountViews(map);
		
	}

	@Override
	public List<BoardVo> readAllBoard(PagingVo page) {
		return dao.findBoardList(page);
	}

	@Override
	public int countAllBoard() {
		return dao.countAllBoard();
	}

	@Override
	public BoardVo readLastBoardByAuthor(BoardVo board) {
		return dao.findLastRecordByAuthor(board);
	}
}
