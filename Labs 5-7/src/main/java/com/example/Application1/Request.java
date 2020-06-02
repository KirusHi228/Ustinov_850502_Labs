package com.example.Application1;

import javax.persistence.*;

@Entity
@Table(name = "lab7")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "mode")
    private int mode;

    @Column(name = "number1")
    private int number1;

    @Column(name = "number2")
    private int number2;

    @Column(name = "answer")
    private String answer;

    public int getId() {
        return id;
    }
    public void setId(int id) { this.id = id; }

    public int getMode() {
        return mode;
    }
    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getNumber1() {
        return number1;
    }
    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }
    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public void setAnswer(String answer) { this.answer = answer; }

    public String getAnswer() {
        return answer;
    }
}