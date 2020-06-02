package com.example.Application1;

import java.util.ArrayList;
import java.util.List;

public class PostRequestList
{
    private List<PostRequest> requests = new ArrayList<>();

    public PostRequestList() {}

    public List<PostRequest> getRequests() {
        return requests;
    }

    public void setRequests(List<PostRequest> requests) { this.requests = requests; }
}