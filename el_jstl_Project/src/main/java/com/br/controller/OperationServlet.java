package com.br.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.model.vo.Person;

/**
 * Servlet implementation class OperationServlet
 */
@WebServlet("/operation.do")
public class OperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setAttribute("big", 10); 
		request.setAttribute("small", 3);
		
		request.setAttribute("sOne", "안녕");
		request.setAttribute("sTwo", "잘가");
		
		request.setAttribute("pOne", new Person("홍길동", 20, "남자"));
		request.setAttribute("pTwo", null);
	
		ArrayList<String> list1 = new ArrayList<>(); 
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("ㅋㅋㅋ");
		
		request.setAttribute("lOne", list1); // 텅빈리스트
		request.setAttribute("lTwo", list2); // 뭔가가 담겨있는 리스트
		
		request.getRequestDispatcher("views/01_EL/elOperation.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
