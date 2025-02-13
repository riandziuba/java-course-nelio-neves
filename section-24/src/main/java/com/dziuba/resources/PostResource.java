package com.dziuba.resources;

import com.dziuba.domain.Post;
import com.dziuba.dto.UserDTO;
import com.dziuba.resources.util.URL;
import com.dziuba.services.PostService;
import com.dziuba.services.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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

    @RequestMapping(value = "/titleSearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> posts = this.postService.findByTitle(text);
        return ResponseEntity.ok().body(posts);
    }

    @RequestMapping(value = "/titleSearchv2", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitleV2(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> posts = this.postService.findByTitleV2(text);
        return ResponseEntity.ok().body(posts);
    }

    @RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDateText,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDateText

    ) {
        text = URL.decodeParam(text);
        Date minDate = URL.convertDate(minDateText, new Date(0L));
        Date maxDate = URL.convertDate(maxDateText, new Date());
        List<Post> posts = this.postService.fullSearch(text, minDate, maxDate);
        return ResponseEntity.ok().body(posts);
    }


}
