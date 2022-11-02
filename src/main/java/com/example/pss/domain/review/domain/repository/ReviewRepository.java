package com.example.pss.domain.review.domain.repository;

import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.review.domain.Review;
import com.example.pss.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface ReviewRepository extends CrudRepository<Review, UUID> {
    Optional<Review> findByUserAndNotice(User user, Notice notice);
}
