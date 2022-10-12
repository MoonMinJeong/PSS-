package com.example.pss.domain.star.domain.repository;

import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.star.domain.Star;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StarRepository extends CrudRepository<Star, Long> {
    List<Star> findAllByNotice(Notice notice);
}
