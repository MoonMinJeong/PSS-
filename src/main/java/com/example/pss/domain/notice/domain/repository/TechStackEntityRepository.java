package com.example.pss.domain.notice.domain.repository;

import com.example.pss.domain.notice.domain.TechStackEntity;
import com.example.pss.domain.notice.domain.TechStackEntityId;
import org.springframework.data.repository.CrudRepository;

public interface TechStackEntityRepository extends CrudRepository<TechStackEntity, TechStackEntityId> {
}
