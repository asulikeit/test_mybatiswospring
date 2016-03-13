package com.multicampus.view.board;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.multicampus.biz.board.BoardListVO;
import com.multicampus.biz.board.BoardService;
import com.multicampus.biz.board.BoardVO;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
//	@Autowired
	@Resource(name="xmlView")
	private View xmlView;

//	@Autowired
	@Resource(name="jsonView")
	private View jsonView;
	
	//  
	@RequestMapping("/dataTransform.do")
	public ModelAndView transform(@RequestParam("format") String format){
		BoardVO vo = new BoardVO();
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		BoardListVO listVO = new BoardListVO();
		listVO.setBoardList(boardList);
		ModelAndView mav = new ModelAndView();
		mav.addObject(listVO);
		
		if(format.equals("xml")) mav.setView(xmlView);	// View 
		if(format.equals("json")) mav.setView(jsonView);	// View 
		return mav;		
	}
	
	//  
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException {
		//  ε ó
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()){
			String file = uploadFile.getOriginalFilename();
//			byte[] data = uploadFile.getBytes();
//			FileOutputStream out = new FileOutputStream("C:/" + file);
//			out.write(data);
//			out.close();
			uploadFile.transferTo(new File("C:/" + file));
		}
		
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}
	
	//  	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo) {		
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	//  
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	//   
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getBoard(vo)); // Model 
		return "getBoard.jsp";   // View ̸ 
	}
	
	//  
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		model.addAttribute("boardList", boardService.getBoardList(vo)); // Model 
		return "getBoardList.jsp";   // View  ̸ 
	}
}
