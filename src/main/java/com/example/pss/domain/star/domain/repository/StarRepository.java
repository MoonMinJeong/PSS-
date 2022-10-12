package com.example.pss.domain.star.domain.repository;

import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.star.domain.Star;
import com.example.pss.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StarRepository extends CrudRepository<Star, Long> {
    List<Star> findAllByNotice(Notice notice);

    Optional<Star> findByNoticeAndUser(Notice notice, User user);
}
