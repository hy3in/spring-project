package com.example.demo.project.controller;

import com.example.demo.community.vo.ReplyVO;
import com.example.demo.project.dto.ProjectBookmarkDTO;
import com.example.demo.project.dto.ProjectReplyDTO;
import com.example.demo.project.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/project")
@Slf4j
public class ProjectRest {

    @Autowired
    @Qualifier("projectServiceImpl")
    ProjectService projectService;


    public ProjectRest(ProjectService projectService) {
        log.info(":: "+getClass().getName()+" Start::");
        this.projectService = projectService;
    }

    @PostMapping("/addBookmark")
    public int addBookmark(@RequestBody ProjectBookmarkDTO projectBookmarkDTO) {

        if (projectBookmarkDTO.getBookmarkControl() == 1) {
            return projectService.addBookmark(projectBookmarkDTO);
        } else if (projectBookmarkDTO.getBookmarkControl() == 2) {
            return projectService.deleteBookmark(projectBookmarkDTO);
        } else {
            return 0;
        }
    }

    @PostMapping("/addReply")
    public ReplyVO addReply(@RequestBody ProjectReplyDTO projectReplyDTO){
        return projectService.addProjectReply(projectReplyDTO);
    }



}
