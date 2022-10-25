package com.example.pss.domain.stack.domain.repository;

import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.stack.domain.Stack;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StackRepository extends CrudRepository<Stack, Long> {
    Optional<Stack> findByTechName(String name);

    List<Stack> findAllByNotice(Notice notice);

    Optional<Stack> findByTechNameAndNotice(String name, Notice notice);
}
