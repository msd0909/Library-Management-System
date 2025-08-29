package com.wipro.libsystem.controller;

import com.wipro.libsystem.entity.Publisher;
import com.wipro.libsystem.repository.PublisherRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PublisherController {

    private final PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @GetMapping("/publishers")
    public List<String> getAllPublisherNames() {
        return publisherRepository.findAll().stream()
                .map(Publisher::getName)
                .toList();
    }
}
