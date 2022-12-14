package com.SDS.Erasmus.service;

import com.SDS.Erasmus.domain.AppUser;
import com.SDS.Erasmus.domain.Thread;

import java.util.List;
import java.util.UUID;

public interface ThreadService {

    List<Thread> listAll();

    Thread createThread(Thread thread);

    Thread updateThread(Thread thread);

}
