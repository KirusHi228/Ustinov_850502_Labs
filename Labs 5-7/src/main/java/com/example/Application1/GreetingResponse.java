package com.example.Application1;

public class GreetingResponse
{
    private String responseStr;

    public GreetingResponse(){};

    public GreetingResponse(String answer)
    {
        this.responseStr = answer;
    }
    public String getAnswer()
    {
        return responseStr;
    }
    public void setAnswer(String Answer)
    {
        this.responseStr = Answer;
    }
}