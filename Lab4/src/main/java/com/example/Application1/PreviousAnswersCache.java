package com.example.Application1;

import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class PreviousAnswersCache
{
    Map<String, GreetingResponse> cache;

    public PreviousAnswersCache()
    {
        cache = new HashMap<>();
    }

    public GreetingResponse getValue(String parameters)
    {
        return cache.get(parameters);
    }
    public void setValue(GreetingResponse correctResponse, String parameters)
    {
        cache.put(parameters, correctResponse);
    }

    public boolean checkPresenceInCache(String parameters)
    {
        return cache.containsKey(parameters);
    }
}