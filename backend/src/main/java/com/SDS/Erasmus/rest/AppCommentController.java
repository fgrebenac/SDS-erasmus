package com.SDS.Erasmus.rest;

import com.SDS.Erasmus.domain.AppComment;
import com.SDS.Erasmus.service.AppCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppCommentController {

    @Autowired
    AppCommentService appCommentService;

    @GetMapping("/app-comments")
    public List<AppComment> listAppComments() {
        return appCommentService.listAll();
    }


}
