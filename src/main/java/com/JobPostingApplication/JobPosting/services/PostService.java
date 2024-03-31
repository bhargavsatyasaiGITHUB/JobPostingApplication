package com.JobPostingApplication.JobPosting.services;

import com.JobPostingApplication.JobPosting.Repositories.PostRepository;
import com.JobPostingApplication.JobPosting.Repositories.SearchRepository;
import com.JobPostingApplication.JobPosting.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository repository;

    @Autowired
    SearchRepository searchRepository;

    public  Post addPost(Post post) {
        return repository.save(post);
    }

public List<Post> searchPostsByText(String text){
  return   searchRepository.searchByText(text);
}
    public List<Post> getAllPosts() {
        return  repository.findAll();
    }
}
