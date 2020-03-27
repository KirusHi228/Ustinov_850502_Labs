package com.example.Application1;

public class Answer
{
    private final long counter;
    private final String text;

    public Answer(long counter, String text)
    {
        this.counter = counter;
        this.text = text;
    }

    public long getCounter() {
        return counter;
    }

    public String getText() {
        return text;
    }
}