package com.SDS.Erasmus.rest;

import com.SDS.Erasmus.domain.AppUser;
import com.SDS.Erasmus.domain.Thread;
import com.SDS.Erasmus.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/threads")
public class ThreadController {

    @Autowired
    ThreadService threadService;

    @GetMapping("")
    public List<Thread> listThreads() {
        return threadService.listAll();
    }

    //@GetMapping("/{id}")
    //public Thread getThread(@PathVariable("id") UUID id) {
    //    return threadService.fetch(id);
    //}

    @PostMapping("")
    public ResponseEntity<Thread> createThread(@RequestBody Thread thread) {
        Thread saved = threadService.createThread(thread);
        return ResponseEntity.created(URI.create("/threads/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public Thread updateThread(@PathVariable("id") UUID id, @RequestBody Thread thread) {
        if (!thread.getId().equals(id))
            throw new IllegalArgumentException("Thread ID must be preserved");
        return threadService.updateThread(thread);
    }



}
