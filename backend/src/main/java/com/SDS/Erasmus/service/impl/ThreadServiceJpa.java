package com.SDS.Erasmus.service.impl;

import com.SDS.Erasmus.dao.ThreadRepository;
import com.SDS.Erasmus.domain.Thread;
import com.SDS.Erasmus.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ThreadServiceJpa implements ThreadService {

    @Autowired
    private ThreadRepository threadRepo;

    @Override
    public List<Thread> listAll(){
        return threadRepo.findAll();
    }
}
