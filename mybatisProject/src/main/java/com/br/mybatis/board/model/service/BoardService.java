package com.br.mybatis.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.br.mybatis.board.model.vo.Board;
import com.br.mybatis.board.model.vo.Reply;
import com.br.mybatis.common.model.vo.PageInfo;

public interface BoardService {
	
	//게시글 리스트 조회 서비스
	int selectListCount(); //총게시글 조회
	ArrayList<Board> selectList(PageInfo pi); //게시글 목록을 구성하기 위한 조회
	
	//게시글 작성 서비스
	int  insertBoard(Board b);
	
	//게시글 상세조회 서비스
	int increaseCount(int boardNo); //카운트 증가
	Board selectBoard(int boardNo); //게시글 조회
	ArrayList<Reply> selectReplyList(int boardNo); //댓글목록 조회
	
	//게시글 검색
	int selectSearchCount(HashMap<String, String> map); //총게시글 수(페이징용)
	ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi);
	
	
	
}
