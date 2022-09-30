package com.example.pss.domain.like.domain.repository;

import com.example.pss.domain.like.domain.Like;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface LikeRepository extends CrudRepository<Like, Long> {
    Optional<Like> findByNotice_Id(UUID noticeId);
}
