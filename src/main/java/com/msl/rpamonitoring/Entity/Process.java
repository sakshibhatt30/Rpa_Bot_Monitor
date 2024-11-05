package com.msl.rpamonitoring.Entity;


import java.time.LocalTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Process {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String development;
    private String codeReview;
    private String uat;
    private String support;
    private LocalTime time;
    private int executionTime;
    private String schedule;

}
