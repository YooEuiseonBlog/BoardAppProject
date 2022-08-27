package com.prototype.portfolio.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prototype.portfolio.mytools.MyTools;
import com.prototype.portfolio.service.BoardService;
import com.prototype.portfolio.vo.BoardVo;
import com.prototype.portfolio.vo.PagingVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	private final BoardService service;
	private final MyTools myTools;
	
	public BoardController(BoardService service, MyTools myTools) {
		super();
		this.service = service;
		this.myTools = myTools;
	}

	@GetMapping("/list/{pageNum}")
	public String moveToBoardListView(@PathVariable int pageNum, Model model) {
		int totalRecord = service.countAllBoard();
		PagingVo page = new PagingVo(pageNum, totalRecord);
		List<BoardVo> list = service.readAllBoard(page);
		model.addAttribute("boardList", list);
		return "boards/boardList";
	}
	
	@GetMapping("/post")
	public String moveToBoardPostView() {
		return "boards/boardPost";
		
	}
	
	@PostMapping("/post")
	public String uploadPost(BoardVo board, RedirectAttributes ra) {

		try {
			int cnt = service.uploadPost(board);
			BoardVo bData = service.readLastBoardByAuthor(board);
			System.out.println("bData =" + bData);
			myTools.addFlashProcessName(ra, "글쓰기 등록");
			if(cnt!=1) {
				throw new Exception("글등록 실패");
			}
			myTools.addFlashResult(ra, true);
			return "redirect:/board/read/"+bData.getBno();
		} catch (Exception e) {
			e.printStackTrace();
			myTools.addFlashResult(ra, false);
			return "redirect:/board/post";
		}		
	}
	
	@GetMapping("/read/{num}")
	public String moveToReadPostView(@PathVariable int num, BoardVo board, Model model) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("bno", num);
		service.updatePlusViews(map); // views up + 1;
		board.setBno(num);
		BoardVo readBoard = service.readBoardOne(board);
		System.out.println("read = " + readBoard);
		model.addAttribute("board", readBoard);
		model.addAttribute("readOk", "readOk");
		return "boards/boardPost";
	}
}
