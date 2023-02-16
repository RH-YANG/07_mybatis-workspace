package com.br.mybatis.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.br.mybatis.board.model.dao.BoardDao;
import com.br.mybatis.board.model.vo.Board;
import com.br.mybatis.board.model.vo.Reply;
import com.br.mybatis.common.model.vo.PageInfo;

import static com.br.mybatis.common.template.Template.*;

public class BoardServiceImpl implements BoardService{

	private BoardDao bDao = new BoardDao();
	
	@Override
	public int selectListCount() {
		SqlSession sqlSession = getSqlSession();
		int result = bDao.selectListCount(sqlSession);
		sqlSession.close();
		return result;
	}

	@Override
	public ArrayList<Board> selectList(PageInfo pi) {
		SqlSession sqlSession = getSqlSession();
		ArrayList<Board> list = bDao.selectList(sqlSession, pi);
		sqlSession.close();
		return list;
	}

	@Override
	public int insertBoard(Board b) {
		SqlSession sqlSession = getSqlSession();
		int result = bDao.insertBoard(sqlSession, b);
		if(result>0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return result;
	}

	@Override
	public int increaseCount(int boardNo) {
		SqlSession sqlSession = getSqlSession();
		int result = bDao.increseCount(sqlSession, boardNo);
		if(result>0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return result;
	}

	@Override
	public Board selectBoard(int boardNo) {
		SqlSession sqlSession = getSqlSession();
		Board b = bDao.selectBoard(sqlSession, boardNo);
		return b;
	}

	@Override
	public ArrayList<Reply> selectReplyList(int boardNo) {
		SqlSession sqlSession = getSqlSession();
		ArrayList<Reply> rList = bDao.selectReplyList(sqlSession, boardNo);
		return rList;
	}

	@Override
	public int selectSearchCount(HashMap<String, String> map) {
		SqlSession sqlSession = getSqlSession();
		int searchCount = bDao.selectSearchCount(sqlSession, map);
		sqlSession.close();
		return searchCount;
	}

	@Override
	public ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi) {
		SqlSession sqlSession = getSqlSession();
		ArrayList<Board> list = bDao.selectSearchList(sqlSession, map, pi);
		sqlSession.close();
		return list;
	}

}
