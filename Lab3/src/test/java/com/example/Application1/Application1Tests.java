package com.example.Application1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
class Application1Tests
{
    @Test
    public void GreetingServiceTest()
    {
        GreetingService service = new GreetingService();
        GreetingResponse response = new GreetingResponse(service.getAnswerMessage(0,80,40));
        String message = "Результат операции 'Узнать массу раствора' при параметрах Процентное содержание и Масса сухого вещества равных 80 и 40 равен 50!";
        assertEquals(message, response.getAnswer(), message);
    }
}
