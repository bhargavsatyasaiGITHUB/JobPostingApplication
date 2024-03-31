package com.JobPostingApplication.JobPosting.controllers;


import com.JobPostingApplication.JobPosting.Repositories.PostRepository;
import com.JobPostingApplication.JobPosting.models.Post;
import com.JobPostingApplication.JobPosting.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class PostController {

    @Autowired
   PostService postService;
    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/getAllPosts")
    public List<Post> getAllPosts(){
       return postService.getAllPosts();
    }

    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text){
return postService.searchPostsByText(text);
    }

    @PostMapping("/addPost")
    public Post addPost(@RequestBody Post post){
        return postService.addPost(post);
    }

}
