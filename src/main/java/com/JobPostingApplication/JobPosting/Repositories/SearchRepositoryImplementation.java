package com.JobPostingApplication.JobPosting.Repositories;

import com.JobPostingApplication.JobPosting.models.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImplementation implements SearchRepository{
    @Autowired
    MongoClient mongoClient;
    @Autowired

    MongoConverter mongoConverter;
    @Override
    public List<Post> searchByText(String text) {
        final List<Post> posts=new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("JobPostingApplication");
        MongoCollection<Document> collection = database.getCollection("JobPosting");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("desc")))),
                new Document("$sort",
                        new Document("exp", 1L)),
                new Document("$limit", 1L)));


        result.forEach(doc -> posts.add(mongoConverter.read(Post.class,doc)));

        return posts;
    }
}
