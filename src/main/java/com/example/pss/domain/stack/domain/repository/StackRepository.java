package com.example.pss.domain.stack.domain.repository;

import com.example.pss.domain.stack.domain.Stack;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StackRepository extends CrudRepository<Stack, Long> {
    Optional<Stack> findByTechName(String name);
}
