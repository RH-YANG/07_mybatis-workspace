package com.br.mybatis.board.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.br.mybatis.board.model.vo.Board;
import com.br.mybatis.board.model.vo.Reply;
import com.br.mybatis.common.model.vo.PageInfo;

public class BoardDao {
	
	public int selectListCount(SqlSession sqlSession) {
		return sqlSession.selectOne("boardMapper.selectListCount");
	}
	
	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi){
		/*
		 * 마이바티스에서는 페이징처리를 위해 RowBounds라는 클래스를 제공한다.
			>>RowBounds객체 생성시, 몇개의 데이터를 건너뛰고 몇개의 데이터를 조회할지 설정 가능하다.
			offset : 몇개의 게시글을 건너뛸건지에 대한 값
			limit : 몇개의 게시글을 조회할건지
		 */
		
		int offset = (pi.getCurrentPage()-1)*pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds);
	}
	
	public int insertBoard(SqlSession sqlSession, Board b) {
		return sqlSession.insert("boardMapper.insertBoard", b);
	}
	
	public int selectSearchCount(SqlSession sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("boardMapper.selectSearchCount", map);
	}
	
	public ArrayList<Board> selectSearchList(SqlSession sqlSession, HashMap<String, String> map, PageInfo pi){
		int offset = (pi.getCurrentPage()-1)*pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		return (ArrayList)sqlSession.selectList("boardMapper.selectSearchList", map, rowBounds);		
	}
	public int increseCount(SqlSession sqlSession, int boardNo) {
		return sqlSession.update("boardMapper.increseCount", boardNo);
	}
	public Board selectBoard(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.selectBoard", boardNo);
	}
	public ArrayList<Reply> selectReplyList(SqlSession sqlSession, int boardNo){
		return (ArrayList)sqlSession.selectList("boardMapper.selectReplyList", boardNo);
	}
	
	public Board boardHasOneMember(SqlSession sqlSession) {
		return sqlSession.selectOne("sampleMapper.boardHasOneMember");
	}
	
	public Board boardHasManyReply(SqlSession sqlSession) {
		return sqlSession.selectOne("sampleMapper.boardHasManyReply");
	}
	
	public ArrayList<Board> boardList(SqlSession sqlSession) {
		return (ArrayList)sqlSession.selectList("sampleMapper.boardList");
	}
	
	
}
