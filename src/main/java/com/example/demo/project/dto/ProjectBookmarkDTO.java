package com.example.demo.project.dto;


public class ProjectBookmarkDTO {
    private int bookmarkNo;
    private int projectNo;
    private String userId;
    private int bookmarkControl;

    public int getBookmarkNo() {
        return bookmarkNo;
    }

    public void setBookmarkNo(int bookmarkNo) {
        this.bookmarkNo = bookmarkNo;
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

    public int getBookmarkControl() {
        return bookmarkControl;
    }

    public void setBookmarkControl(int bookmarkControl) {
        this.bookmarkControl = bookmarkControl;
    }
}
