package com.SDS.Erasmus;

import com.SDS.Erasmus.domain.Thread;
import com.SDS.Erasmus.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ThreadController {

    @Autowired
    ThreadService threadService;

    @GetMapping("/app-threads")
    public List<Thread> listThreads() {
        return threadService.listAll();
    }


}
