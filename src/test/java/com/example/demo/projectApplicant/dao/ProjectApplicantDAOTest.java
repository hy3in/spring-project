package com.example.demo.projectApplicant.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.project.service.ProjectService;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.projectApplicant.service.ProjectApplicantService;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProjectApplicantDAOTest {
	
	@Autowired
	@Qualifier("projectApplicantServiceImpl")
	private ProjectApplicantService projectApplicantService;
	
	public ProjectApplicantDAOTest() {
		System.out.println("TEST APP @@@@@");
	}
	
	@Test
	public void GetProject() throws Exception{
		
		ProjectVO projectVO = new ProjectVO();
		
		projectVO = projectApplicantService.getProject(1);
		
		System.out.println(projectVO);
		
		//junit.framework.Assert.assertEquals("", );
	}
	

}