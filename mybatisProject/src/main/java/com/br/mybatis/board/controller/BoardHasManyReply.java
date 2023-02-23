package com.br.mybatis.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.br.mybatis.board.model.dao.BoardDao;
import com.br.mybatis.board.model.vo.Board;
import com.br.mybatis.common.template.Template;

/**
 * Servlet implementation class BoardHasOneMember
 */
@WebServlet("/hasmany.do")
public class BoardHasManyReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardHasManyReply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = Template.getSqlSession();
		Board b = new BoardDao().boardHasManyReply(sqlSession);
		System.out.println("게시글정보 : "+b);
		System.out.println("리플정보 : "+b.getReplyList());
		request.setAttribute("b", b);
		request.getRequestDispatcher("WEB-INF/views/board/boardHasManyReply.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
