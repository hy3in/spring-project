package com.example.demo.projectApplicant.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.common.vo.SearchVO;
import com.example.demo.project.vo.ProjectVO;
import com.example.demo.projectApplicant.dao.ProjectApplicantDAO;
import com.example.demo.projectApplicant.dto.UpdateApplicantStatusDTO;
import com.example.demo.projectApplicant.service.ProjectApplicantService;
import com.example.demo.projectApplicant.vo.ApplicantVO;

@Service("projectApplicantServiceImpl")
public class ProjectApplicantServiceImpl implements ProjectApplicantService{
	
	@Autowired
	@Qualifier("projectApplicantDAOImpl")
	ProjectApplicantDAO projectapplicantDAO;
	public void setProjectapplicantDAO(ProjectApplicantDAO projectapplicantDAO) {
		System.out.println("::"+getClass()+".projectApplicantDAOImpl Call....");
		this.projectapplicantDAO = projectapplicantDAO;
	}
	
	//Constructor
	public ProjectApplicantServiceImpl() {
		System.out.println("::"+getClass()+".default Constructor Call....");
	}

	@Override
	public void addApplicant(ApplicantVO applicantVO) {
		projectapplicantDAO.addApplicant(applicantVO);
	}

	@Override
	public ApplicantVO getApplicant(int applicantNo) {
		return projectapplicantDAO.getApplicant(applicantNo);
	}

	@Override
	public void updateApplicantStatus(UpdateApplicantStatusDTO updateApplicantStatusDTO) {
		projectapplicantDAO.updateApplicantStatus(updateApplicantStatusDTO);
		if(updateApplicantStatusDTO.getApplicantStatus()==5) {
			projectapplicantDAO.updateProjectMember(updateApplicantStatusDTO);
		}
	}

	@Override
	public Map<String, Object> getApplicantList(SearchVO searchVO) {
		List<ApplicantVO> list = projectapplicantDAO.getApplicantList(searchVO);
		int totalCount = projectapplicantDAO.getApplicantTotalCount(searchVO);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", list);
		map.put("totalCount", new Integer(totalCount));
		return map;
	}

	@Override
	public Map<String, Object> getAppliedProjectList(SearchVO searchVO) {
		List<ApplicantVO> list = projectapplicantDAO.getAppliedApplicantList(searchVO);
		int totalCount = projectapplicantDAO.getAppliedTotalCount(searchVO);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", list);
		map.put("totalCount", new Integer(totalCount));
		return map;
	}

	@Override
	public void addProApplicant(ProjectVO projectVO) {
		projectapplicantDAO.addProApplicant(projectVO);
	}

}
