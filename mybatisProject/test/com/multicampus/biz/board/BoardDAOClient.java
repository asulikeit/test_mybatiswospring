package com.multicampus.biz.board;

import java.sql.SQLException;
import java.util.List;

public class BoardDAOClient {	
	public static void main(String[] args) throws SQLException {
		BoardDAO boardDAO = new BoardDAO();
		
		BoardVO vo = new BoardVO();
//		vo.setTitle("myBaits test3");
//		vo.setWriter("new User");
//		vo.setContent("myBatis content.....");		
//		boardDAO.insertBoard(vo);
		
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
}
