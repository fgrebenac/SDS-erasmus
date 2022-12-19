package com.SDS.Erasmus.service.impl;

import com.SDS.Erasmus.dao.ThreadRepository;
import com.SDS.Erasmus.domain.Thread;
import com.SDS.Erasmus.service.EntityMissingException;
import com.SDS.Erasmus.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
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

    @Override
    public Thread deleteThread(UUID threadId) {
        Thread user = fetch(threadId);
        threadRepo.delete(user);
        return user;
    }
    @Override
    public Thread fetch(UUID userId) {
        return findById(userId).orElseThrow(
                () -> new EntityMissingException(Thread.class, userId)
        );
    }

    private Optional<Thread> findById(UUID userId) {
        return threadRepo.findById(userId);
    }


    private void validate(Thread thread){
        Assert.notNull(thread,"Thread object must ge given");
        Assert.notNull(thread.getTitle(), "Thread must have a title");
        Assert.notNull(thread.getContent(), "Thread must have a content");
        Assert.notNull(thread.getUserID(), "Thread must have a owner");

    }


}
