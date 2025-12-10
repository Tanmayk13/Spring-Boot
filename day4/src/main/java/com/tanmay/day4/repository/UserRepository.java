package com.tanmay.day4.repository;

import com.tanmay.day4.entity.User;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<@NonNull User, @NonNull Integer> {}
