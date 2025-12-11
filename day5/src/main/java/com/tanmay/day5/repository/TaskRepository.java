package com.tanmay.day5.repository;

import com.tanmay.day5.entity.Task;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<@NonNull Task, @NonNull Integer> {
}
