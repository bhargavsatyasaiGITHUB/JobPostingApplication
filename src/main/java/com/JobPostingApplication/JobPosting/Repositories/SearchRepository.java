package com.JobPostingApplication.JobPosting.Repositories;

import com.JobPostingApplication.JobPosting.models.Post;

import java.util.List;

public interface SearchRepository  {
    List<Post> searchByText(String text);
}
