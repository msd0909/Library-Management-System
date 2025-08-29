package com.wipro.libsystem.service;

import com.wipro.libsystem.entity.Publisher;
import com.wipro.libsystem.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    public Publisher getPublisherById(Long id) {
        return publisherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publisher not found with id " + id));
    }

    public Publisher updatePublisher(Long id, Publisher publisherDetails) {
        Publisher pub = getPublisherById(id);
        pub.setName(publisherDetails.getName());
        pub.setPublisherId(publisherDetails.getPublisherId());
        return publisherRepository.save(pub);
    }

    public void deletePublisher(Long id) {
        publisherRepository.deleteById(id);
    }
}
