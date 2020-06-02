package com.example.Application1;


import org.springframework.data.repository.CrudRepository;

public interface IdRepository extends CrudRepository<ProcessId, Integer> {
    boolean existsByProcessId(Long processId);
}