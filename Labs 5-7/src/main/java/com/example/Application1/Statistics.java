package com.example.Application1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Statistics {
    private Integer min;
    private Integer max;
    private Integer mostPopular;
    private Integer amount;
    private List<Integer> response = new ArrayList<>();

    public Integer getMax() {
        return max;
    }

    public Integer getMin() {
        return min;
    }

    public Integer getMostPopular() {
        return mostPopular;
    }

    public Integer getAmount() {
        return amount;
    }

    public List<Integer> getResponse() {
        return response;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public void setMostPopular(Integer mostPopular) {
        this.mostPopular = mostPopular;
    }

    public void setResponse(List<Integer> response) {
        this.response = response;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void update()
    {
        for (Integer number : response)
        {
            if (min == null || number.compareTo(min) < 0){
                min = number;
            }
            if (max == null || number.compareTo(max) > 0){
                max = number;
            }
            if (mostPopular == null || mostPopular < Collections.frequency(response, number)) {
                mostPopular = number;
            }
            amount = response.size();
        }
    }
}