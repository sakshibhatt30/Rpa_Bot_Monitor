package com.msl.rpamonitoring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.msl.rpamonitoring.Entity.Process;

@Repository
public interface ProcessRepository extends JpaRepository<Process, Long> {
    // Custom queries can be added here if necessary
}
