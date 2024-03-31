package com.JobPostingApplication.JobPosting.Repositories;

import com.JobPostingApplication.JobPosting.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,String> {
}
