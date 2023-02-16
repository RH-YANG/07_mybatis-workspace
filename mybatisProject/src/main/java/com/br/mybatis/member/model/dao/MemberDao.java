package com.br.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.br.mybatis.member.model.vo.Member;

public class MemberDao {
	
	public int insertMember(SqlSession sqlSession, Member m) {
		int result = sqlSession.insert("memberMapper.insertMember", m);
		return result;
	}
	
	public Member loginMember(SqlSession sqlSession, Member m) {
		Member loginMem = sqlSession.selectOne("memberMapper.loginMember", m); //이때 객체는 1개만 전달가능해서 아이디와 비번을 멤버객체에 담은 것
		return loginMem;
	}
	
	public int updateMember(SqlSession sqlSession, Member m) {
		return sqlSession.update("memberMapper.updateMember", m);
	}

}
