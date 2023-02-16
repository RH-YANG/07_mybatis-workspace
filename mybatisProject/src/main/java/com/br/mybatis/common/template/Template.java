package com.br.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	public static SqlSession getSqlSession() {
		//기존에는 driver.properties를 읽어들였다면
		//mybatis-config.xml파일을 읽어들여서 해당 DB와 접속된
		//SqlSession 객체 생성해서 반환
		SqlSession sqlSession = null;
		try {
			// 1) mybatis-config 파일을 읽어들이기 위한 입력용 스트림 객체 생성하기
			// Resources 클래스 : mybatis에서 제공하는 클래스, import 시 org.apache.ibatis.io.Resources
			// 메소드 내부로 파일을 선택하기 위한 일부 경로 작성하기 : 첫'/' = 현재 소스폴더
			InputStream stream = Resources.getResourceAsStream("/config/mybatis-config.xml");
			//new SqlSessionFactoryBuilder().build(Input객체) >> SqlSessionFactory 객체 반환
			// .openSession() >> SqlSession 객체 반환
			//     매개변수로 true/false를 지정할 수 있는데 자동커밋 여부를 지정한다(안넣으면 기본이 false임)            
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSession;
	}

}
