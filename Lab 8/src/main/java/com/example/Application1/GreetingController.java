package com.example.Application1;

import Post.PostRequestList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;
import java.util.Random;

@EnableAsync
@RestController
public class GreetingController
{
    Statistics statistics = new Statistics();
    static GreetingResponse response = new GreetingResponse();

    @Autowired
    RequestRepository requestRepository;
    @Autowired
    private PreviousAnswersCache cache;
    @Autowired
    private RequestsCounter counter;
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    IdRepository currentId;

    @Async
    @PostMapping("/calculate")
    public Statistics create(@RequestBody PostRequestList requestList)  {
        requestList.getRequests().stream().forEach(request -> {
            counter.increaseCounter();
            Long newProcessId = generateProcessId();
            ProcessId process = new ProcessId(newProcessId, "calculating", 0);
            Integer number = process.getId();
            currentId.save(process);
            String parametersString;
            parametersString = request.getParametersString();
            GreetingService service = new GreetingService(request.getMode(), request.getNumber1(), request.getNumber2());

            Request newRequest = new Request();
            newRequest.setMode(request.getMode());
            newRequest.setNumber1(request.getNumber1());
            newRequest.setNumber2(request.getNumber2());
            Integer answer;
            if (cache.checkPresenceInCache(parametersString))
            {
                logger.info("Значение считано из кэша");
                statistics.getResponse().add(cache.getValue(parametersString));
                statistics.update();
                answer = cache.getValue(parametersString);
                service.setAnswer(answer);
            }
            else
            {
                answer = service.getAnswer();
                statistics.getResponse().add(answer);
                statistics.update();
                cache.setValue(answer, parametersString);
            }
            response.setAnswer(service.getAnswerMessage());
            newRequest.setAnswer(service.getAnswerMessage());
            requestRepository.save(newRequest);
            process.setStatus("finished");
            process.setAnswer(answer);
            currentId.save(process);
        });

        return statistics;
    }

    private Long generateProcessId(){
        Random random = new Random();
        Long processId;
        do{
            processId = random.nextLong();
        } while(currentId.existsByProcessId(processId));
        return processId;
    }

    @GetMapping("/all")
    public @ResponseBody
    Iterable<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    @RequestMapping("/counter")
    public RequestsCounter getCounter() {
        return counter;
    }

    @RequestMapping("/statistics")
    public Statistics getStatistics() {
        return statistics;
    }
}