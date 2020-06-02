package com.example.Application1;

import org.springframework.stereotype.Component;

@Component
public class RequestsCounter
{
    private Integer counter = 0;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter)
    {
        this.counter = counter;
    }

    synchronized public void increaseCounter() { counter++; }

}