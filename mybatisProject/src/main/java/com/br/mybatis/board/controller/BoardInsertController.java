package com.br.mybatis.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.br.mybatis.board.model.service.BoardServiceImpl;
import com.br.mybatis.board.model.vo.Board;
import com.br.mybatis.member.model.vo.Member;

/**
 * Servlet implementation class BoardInsertController
 */
@WebServlet("/insert.bo")
public class BoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userNo = String.valueOf(((Member)session.getAttribute("loginUser")).getUserNo());
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Board b = new Board();
		b.setBoardWriter(userNo);
		b.setBoardTitle(title);
		b.setBoardContent(content);
		
		int result = new BoardServiceImpl().insertBoard(b);
		if(result>0) {
			response.sendRedirect(request.getContextPath()+"/list.bo?cpage=1");
			//해당 페이지는 필요한 데이터들이 있으므로 직접 포워딩을 해서는 안된다.
		}else {
			request.setAttribute("errorMsg", "글 작성에 실패하였습니다");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
