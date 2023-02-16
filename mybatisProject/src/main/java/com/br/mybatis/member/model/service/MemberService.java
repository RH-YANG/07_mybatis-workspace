package com.br.mybatis.member.model.service;

import com.br.mybatis.member.model.vo.Member;

public interface MemberService {
	//1. 회원가입서비스
	/*public abstract*/int insertMember(Member m);
	
	//2. 로그인서비스
	//Member loginMember(String userId, String userPwd); 
	//마이바티스를 쓸때는 매개변수가 2개 이상일 경우 한곳에 담아야함.
	//sql에 1개만 전달할 수 있기 때문
	Member loginMember(Member m);
	
	//3. 회원정보수정서비스
	int updateMember(Member m);
	
	//4. 회원탈퇴서비스
	int deleteMember(String userId);	
}
