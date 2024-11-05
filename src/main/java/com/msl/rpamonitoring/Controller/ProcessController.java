package com.msl.rpamonitoring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.msl.rpamonitoring.Service.ProcessService;
import com.msl.rpamonitoring.Entity.Process;
@RestController
@RequestMapping("/api/processes")
public class ProcessController {
@Autowired
    private ProcessService processService;

    @GetMapping("/get")
    public ResponseEntity<List<Process>> getAllProcesses() {
        List<Process> processes = processService.getAllProcesses();
        return ResponseEntity.ok(processes); 
    }

    @GetMapping("/upcoming") 
    public ResponseEntity<List<Process>> getUpcomingProcesses() {
        List<Process> upcomingProcesses = processService.getUpcomingProcesses();
        return ResponseEntity.ok(upcomingProcesses); 
    }
    @GetMapping("/ongoing") 
    public ResponseEntity<List<Process>> getOngoingProcesses() {
        List<Process> ongoingProcesses = processService.getOngoingProcesses();
        return ResponseEntity.ok(ongoingProcesses); 
    }

    @GetMapping("/completed") 
    public ResponseEntity<List<Process>> getCompletedProcesses() {
        List<Process> completedProcesses = processService.getCompletedProcesses();
        return ResponseEntity.ok(completedProcesses);
    }
    

}
