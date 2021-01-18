package com.example.demo.projectApplicant.test;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.demo.projectApplicant.vo.TestHashVO;


@Repository("TestDao")
public class TestDao {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("SQLSESSION @@@@@++++");
	    this.sqlSession = sqlSession;
	 }
	//Constructor
	public TestDao() {
		System.out.println("TestDAO@@@@@@");
	}

	public void Test(TestHashVO vo) {
		System.out.println("TEST METHOD@@@@@@");
		sqlSession.insert("testMapper.test", vo);
	}

}