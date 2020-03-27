package com.example.Application1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController
{
    private static final String template = "Результат операции '%s' при параметрах %s равных %d и %d равен %d!";
    private int counter = 0;
    int answer;

    String current_operation, current_fields;
    String operation0 = "Узнать массу раствора", operation1 = "Узнать массу сухого вещества";
    String field0 = "Масса раствора", field1 = "Процентное содержание", field2 = "Масса сухого вещества";

    @GetMapping("/greeting")
    public Answer answer(@RequestParam(value = "mode") int mode, @RequestParam(value = "number1") int number1, @RequestParam(value = "number2") int number2)
    {
        counter++;
        switch (mode) //mode - режим работы. 0 - Узнать массу раствора, 1 - Узнать массу сухого вещества
        {
            case 0:
                {
                    current_operation = operation0;
                    answer = (number2 * 100) / number1;
                    current_fields = field1 + " и " + field2;
                    break;
                }
                case 1:
                {
                    current_operation = operation1;
                    answer = (number1 * number2) / 100;
                    current_fields = field0 + " и " + field1;
                    break;
                }
            }

        return new Answer(counter, String.format(template, current_operation, current_fields, number1, number2, answer));
    }
}