package com.dziuba.resources;

import com.dziuba.domain.Post;
import com.dziuba.dto.UserDTO;
import com.dziuba.services.PostService;
import com.dziuba.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostResource {

    private final PostService postService;
    public PostResource(PostService postService) {
        this.postService = postService;
    }


    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> find(@PathVariable String id) {
        Post post = this.postService.findById(id);
        return ResponseEntity.ok().body(post);
    }
}
