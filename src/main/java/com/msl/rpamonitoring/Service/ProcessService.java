package com.msl.rpamonitoring.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.msl.rpamonitoring.Repository.ProcessRepository;
import com.msl.rpamonitoring.Entity.Process;

@Service
public class ProcessService {

    @Autowired
    private ProcessRepository processRepository;

    public List<Process> getAllProcesses() {
        return processRepository.findAll();
    }

    public List<Process> getUpcomingProcesses() {
        LocalTime now = LocalTime.now();
        return processRepository.findAll().stream()
                .filter(process -> isUpcoming(process, now))
                .collect(Collectors.toList());
    }

    public List<Process> getOngoingProcesses() {
        LocalTime now = LocalTime.now();
        return processRepository.findAll().stream()
                .filter(process -> isOngoing(process, now))
                .collect(Collectors.toList());
    }

    public List<Process> getCompletedProcesses() {
        return processRepository.findAll().stream()
                .filter(this::isCompleted)
                .collect(Collectors.toList());
    }

    private boolean isUpcoming(Process process, LocalTime now) {
        return process.getTime().isAfter(now);
    }

    private boolean isOngoing(Process process, LocalTime now) {
        return process.getTime().equals(now) && process.getTime().plusMinutes(process.getExecutionTime()).isAfter(now);
    }

    private boolean isCompleted(Process process) {
        return process.getTime().plusMinutes(process.getExecutionTime()).isBefore(LocalTime.now());
    }
}
