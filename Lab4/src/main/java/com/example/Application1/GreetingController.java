package com.example.Application1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController
{
    @Autowired
    private PreviousAnswersCache cache;
    @Autowired
    private RequestsCounter counter;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/counter")
    public Integer showCounter()
    {
        return counter.getCounter();
    }

    @GetMapping("/calculate")
    public GreetingResponse checkValues(@RequestParam(value = "mode") String mode, @RequestParam(value = "number1") String number1, @RequestParam(value = "number2") String number2) throws BadRequestException, InternalServiceException
    {
        counter.increaseCounter();
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
        
        String parameters = value1 + " " + value2 + " " + work_mode;
        if (cache.checkPresenceInCache(parameters))
        {
            logger.info("Значение считано из кэша");
            return cache.getValue(parameters);
        }

        GreetingService service = new GreetingService();
        GreetingResponse response = new GreetingResponse(service.getAnswerMessage(work_mode, value1, value2));
        cache.setValue(response, parameters);
        logger.info("Значение вычислено и записано в кэш");
        return response;

    }
}