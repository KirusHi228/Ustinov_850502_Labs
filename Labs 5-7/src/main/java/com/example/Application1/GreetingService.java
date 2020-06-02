package com.example.Application1;

public class GreetingService
{
    String current_operation, current_fields;
    String operation0 = "Узнать массу раствора", operation1 = "Узнать массу сухого вещества";
    String field0 = "Масса раствора", field1 = "Процентное содержание", field2 = "Масса сухого вещества";
    int value1, value2;
    int work_mode;
    int calculationAnswer;

    public GreetingService(Integer mode, Integer number1, Integer number2)
    {
        this.work_mode = mode;
        this.value1 = number1;
        this.value2 = number2;
    }

    public Integer getAnswer()
    {
        switch (work_mode) //режим работы. 0 - Узнать массу раствора, 1 - Узнать массу сухого вещества
        {
            case 0:
            {
                current_operation = operation0;
                calculationAnswer = (value2 * 100) / value1;
                current_fields = field1 + " и " + field2;
                break;
            }
            case 1:
            {
                current_operation = operation1;
                calculationAnswer = (value1 * value2) / 100;
                current_fields = field0 + " и " + field1;
                break;
            }
        }
        return calculationAnswer;
    }

    public void setAnswer(Integer answer)
    {
        this.calculationAnswer = answer;
    }

    public String getAnswerMessage()
    {
        final String template = "Результат операции '%s' при параметрах %s равных %d и %d равен %d!";
        String answerMessage = String.format(template, current_operation, current_fields, value1, value2, calculationAnswer);
        return answerMessage;
    }
}