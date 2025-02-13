package com.dziuba.services;

import com.dziuba.domain.Post;
import com.dziuba.repository.PostRepository;
import com.dziuba.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post findById(String id) {
        Optional<Post> post = this.postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByTitle(String search) {
        return this.postRepository.findByTitleContainingIgnoreCase(search);
    }

    public List<Post> findByTitleV2(String search) {
        return this.postRepository.searchTitle(search);
    }

    public List<Post> fullSearch(String search, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return this.postRepository.fullSearch(search, minDate, maxDate);
    }
}
