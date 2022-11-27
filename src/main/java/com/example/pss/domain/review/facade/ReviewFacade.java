package com.example.pss.domain.review.facade;

import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.review.domain.Review;
import com.example.pss.domain.review.domain.repository.ReviewRepository;
import com.example.pss.domain.review.exception.ReviewNotFoundException;
import com.example.pss.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReviewFacade {
    private final ReviewRepository reviewRepository;

    public Review findByUserAndNotice(User user, Notice notice) {
        return reviewRepository.findByUserAndNotice(user, notice)
                .orElseThrow(() -> ReviewNotFoundException.EXCEPTION);
    }
}