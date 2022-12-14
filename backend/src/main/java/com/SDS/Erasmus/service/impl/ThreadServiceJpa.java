package com.SDS.Erasmus.service.impl;

import com.SDS.Erasmus.dao.ThreadRepository;
import com.SDS.Erasmus.domain.Thread;
import com.SDS.Erasmus.service.EntityMissingException;
import com.SDS.Erasmus.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.UUID;

@Service
public class ThreadServiceJpa implements ThreadService {

    @Autowired
    private ThreadRepository threadRepo;

    @Override
    public List<Thread> listAll(){
        return threadRepo.findAll();
    }

    @Override
    public Thread createThread(Thread thread) {
        validate(thread);
        return threadRepo.save(thread);
    }

    @Override
    public Thread updateThread(Thread thread) {
        validate(thread);
        UUID threadId = thread.getId();
        if (!threadRepo.existsById(threadId))
            throw new EntityMissingException(Thread.class, threadId);
        return threadRepo.save(thread);

    }
    
    private void validate(Thread thread){
        Assert.notNull(thread,"Thread object must ge given");
        Assert.notNull(thread.getId(), "Thread must have an ID");
        Assert.notNull(thread.getTitle(), "Thread must have a title");
        Assert.notNull(thread.getContent(), "Thread must have a content");

    }


}
