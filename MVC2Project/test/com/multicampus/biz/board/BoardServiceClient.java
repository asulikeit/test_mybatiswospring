package com.multicampus.biz.board;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.multicampus.biz.board.BoardService;
import com.multicampus.biz.board.BoardVO;

public class BoardServiceClient {
	public static void main(String[] args) {
		// 1. Spring 
		ApplicationContext container = 
			new ClassPathXmlApplicationContext("applicationContext.xml");

		// 2. Spring BoardService Lookup
		BoardService boardService = 
			(BoardService) container.getBean("boardService");
		
		// 3. boardService
		BoardVO vo = new BoardVO();
		vo.setSeq(100);
		vo.setTitle("JDBC test");
		vo.setWriter("writer");
		vo.setContent("JDBC content....");
//		boardService.insertBoard(vo);
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
}
