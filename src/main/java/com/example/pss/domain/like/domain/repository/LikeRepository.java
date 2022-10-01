package com.example.pss.domain.like.domain.repository;

import com.example.pss.domain.like.domain.Like;
import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.user.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LikeRepository extends CrudRepository<Like, Long> {
    Optional<Like> findByNotice_Id(UUID noticeId);
    Optional<Like> findByUserAndNotice(User user, Notice notice);

    @Query("SELECT l FROM Like l where l.likeCheck=true")
    List<Like> findAllByLikeCheckTrue();
}
