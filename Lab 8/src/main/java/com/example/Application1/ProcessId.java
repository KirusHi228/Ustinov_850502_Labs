package com.example.Application1;

import javax.persistence.*;

@Entity
@Table(name="processid")
public class ProcessId
{
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "processId")
    private Long processId;

    @Column(name = "status")
    private String status;

    @Column(name = "answer")
    private Integer answer;

    public ProcessId() {}

    public ProcessId(Long processId, String status, Integer answer){
        this.processId = processId;
        this.status = status;
        this.answer = answer;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAnswer()
    {
        return answer;
    }

    public void setAnswer(Integer answer)
    {
        this.answer = answer;
    }
}