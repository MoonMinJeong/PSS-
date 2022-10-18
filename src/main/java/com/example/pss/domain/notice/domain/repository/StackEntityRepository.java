package com.example.pss.domain.notice.domain.repository;

import com.example.pss.domain.notice.domain.StackEntity;
import com.example.pss.domain.notice.domain.StackEntityId;
import org.springframework.data.repository.CrudRepository;

public interface StackEntityRepository extends CrudRepository<StackEntity, StackEntityId> {
}
