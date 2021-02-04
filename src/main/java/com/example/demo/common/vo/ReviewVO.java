package com.example.demo.common.vo;

import lombok.Data;

import java.util.List;

@Data
public class ReviewVO {

    private int reviewNo;
    private int projectNo;
    private int reviewGrade;
    private String reviewComment;
    private String userId;

}
