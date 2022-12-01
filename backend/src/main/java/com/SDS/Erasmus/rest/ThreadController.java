package com.SDS.Erasmus.rest;

import com.SDS.Erasmus.domain.Thread;
import com.SDS.Erasmus.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/threads")
public class ThreadController {

    @Autowired
    ThreadService threadService;

    @GetMapping("")
    public List<Thread> listThreads() {
        return threadService.listAll();
    }


}
