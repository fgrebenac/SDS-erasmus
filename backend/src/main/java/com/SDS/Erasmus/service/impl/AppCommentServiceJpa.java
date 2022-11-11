package com.SDS.Erasmus.service.impl;

import com.SDS.Erasmus.dao.AppCommentRepository;
import com.SDS.Erasmus.domain.AppComment;
import com.SDS.Erasmus.service.AppCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppCommentServiceJpa implements AppCommentService {

    @Autowired
    private AppCommentRepository appCommentRepository;

    @Override
    public List<AppComment> listAll(){
        return appCommentRepository.findAll();
    }
}
