package com.example.Application1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController
{
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @GetMapping("/beginning")
    public GreetingResponse beginning(@RequestParam(value = "mode") String mode, @RequestParam(value = "number1") String number1, @RequestParam(value = "number2") String number2) throws BadRequestException, InternalServiceException {
        int value1, value2;
        int work_mode;
        try
        {
            work_mode = Integer.parseInt(mode);
            value1 = Integer.parseInt(number1);
            value2 = Integer.parseInt(number2);
        }catch (Exception ex4xx)
        {
            throw new BadRequestException(400, "Неверные входные параметры!");
        }

        switch (work_mode) //режим работы. 0 - Узнать массу раствора, 1 - Узнать массу сухого вещества
        {
            case 0:
            {
                if (value1==0)
                {
                    logger.error("В данном режиме работы параметр 1 не может равняться 0!");
                    throw new InternalServiceException(500, "В данном режиме работы параметр 1 не может равняться 0!");
                }

                if (value1<0||value1>100)
                {
                    logger.error("Неверное процентное содержание!");
                    throw new BadRequestException(400, "Неверное процентное содержание!");
                }
                break;
            }
            case 1:
            {
                if (value2<0||value2>100)
                {
                    logger.error("Неверное процентное содержание!");
                    throw new BadRequestException(400, "Неверное процентное содержание!");
                }
                break;
            }
        }
        GreetingService service = new GreetingService(work_mode, value1, value2);
        GreetingResponse response = new GreetingResponse(service.getAnswerMessage());
        return response;
    }
}