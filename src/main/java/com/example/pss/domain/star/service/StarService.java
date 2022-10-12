package com.example.pss.domain.star.service;

import com.example.pss.domain.notice.facade.NoticeFacade;
import com.example.pss.domain.star.domain.Star;
import com.example.pss.domain.star.domain.repository.StarRepository;
import com.example.pss.domain.star.present.dto.StarRequest;
import com.example.pss.domain.user.domain.User;
import com.example.pss.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class StarService {
    private final StarRepository starRepository;
    private final UserFacade userFacade;
    private final NoticeFacade noticeFacade;

    public void create(StarRequest request, UUID noticeId) {
        User user = userFacade.getCurrentUser();

        starRepository.save(
                Star.builder()
                        .stars(request.getStars())
                        .user(user)
                        .notice(noticeFacade.findById(noticeId))
                        .build()
        );
    }
}
