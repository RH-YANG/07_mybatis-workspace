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
@WebServlet("/hasone.do")
public class BoardHasOneMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardHasOneMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = Template.getSqlSession();
		Board b = new BoardDao().boardHasOneMember(sqlSession);
		System.out.println("게시글정보 : "+b);
		System.out.println("작성자정보 : "+b.getMem());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
