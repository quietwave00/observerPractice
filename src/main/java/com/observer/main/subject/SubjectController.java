package com.observer.main.subject;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;


@RestController
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService service;


    @GetMapping(value = "/subscribe/{observerId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter subscribe(@PathVariable("observerId") Long observerId) throws IOException {
        return service.subscribe(observerId);
    }

    @GetMapping("/upload")
    public void upload() throws IOException {
        service.upload();
    }
}
