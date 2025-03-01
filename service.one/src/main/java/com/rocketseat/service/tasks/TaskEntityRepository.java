package com.rocketseat.service.tasks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskEntityRepository
        extends JpaRepository<TaskEntity, Long> {

    @Query("SELECT t FROM Task t where t.dueDate <= :deadline AND t.notified = false")
    List<TaskEntity> findTasksDueWithinDeadLine(LocalDateTime deadline);
}
