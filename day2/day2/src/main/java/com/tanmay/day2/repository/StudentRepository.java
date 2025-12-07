package com.tanmay.day2.repository;

import com.tanmay.day2.entity.Student;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<@NonNull Student, @NonNull Integer> {
}
