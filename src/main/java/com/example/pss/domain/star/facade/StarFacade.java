package com.example.pss.domain.star.facade;

import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.star.domain.Star;
import com.example.pss.domain.star.domain.repository.StarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class StarFacade {
    private final StarRepository starRepository;

    public float findAllByNotice(Notice notice) {
        float result = 0;
        List<Star> stars = starRepository.findAllByNotice(notice);

        for(int i=0; i<stars.size(); i++) {
            result = (result + stars.get(i).getStars()) / (i+1);
        }

        return result;
    }
}
