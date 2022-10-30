package com.example.pss.domain.like.domain.repository;

import com.example.pss.domain.like.domain.Like;
import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByNotice_Id(UUID noticeId);

    Optional<Like> findByUserAndNotice(User user, Notice notice);

    List<Like> findAllByNotice(Notice notice);
}
