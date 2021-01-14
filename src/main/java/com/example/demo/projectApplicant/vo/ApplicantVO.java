package com.example.demo.projectApplicant.vo;

import java.util.List;

public class ApplicantVO {
	
	private int applicantNo;
	private int projectNo;
	private String userId;
	private String profileImg;
	private int applicantStatus;
	private List<String> applicantAnswer;
	private String introToMember;

	public ApplicantVO() {
	}

	public int getApplicantNo() {
		return applicantNo;
	}

	public void setApplicantNo(int applicantNo) {
		this.applicantNo = applicantNo;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public int getApplicantStatus() {
		return applicantStatus;
	}

	public void setApplicantStatus(int applicantStatus) {
		this.applicantStatus = applicantStatus;
	}

	public List<String> getApplicantAnswer() {
		return applicantAnswer;
	}

	public void setApplicantAnswer(List<String> applicantAnswer) {
		this.applicantAnswer = applicantAnswer;
	}

	public String getIntroToMember() {
		return introToMember;
	}

	public void setIntroToMember(String introToMember) {
		this.introToMember = introToMember;
	}
}
