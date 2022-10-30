package com.example.pss.domain.star.facade;

import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.star.domain.Star;
import com.example.pss.domain.star.domain.repository.StarRepository;
import com.example.pss.domain.star.exception.StarNotFoundException;
import com.example.pss.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class StarFacade {
    private final StarRepository starRepository;

    public float findAllByNotice(Notice notice) {

        float result = 0;
        List<Star> stars = starRepository.findAllByNotice(notice);

        for(int i=0; i<stars.size(); i++) {
            result = (result + stars.get(i).getStars());
        }

        if(stars.isEmpty()) {
            return 0;
        }

        float rst = (result/(float)stars.size());

        return rst;
    }

    public float findByNoticeAndUser(Notice notice, User user) {
            Star star = starRepository.findByNoticeAndUser(notice, user)
                    .orElseThrow(() -> StarNotFoundException.EXCEPTION);

            return star.getStars();
    }
    
    public List<Notice> findNoticesByStar(User user) {
        List<Notice> notices = new ArrayList<>();

        for(int i=0; i<starRepository.findAllByUser(user).size(); i++) {
            notices.add(starRepository.findAllByUser(user).get(i).getNotice());
        }

        return notices;
    }
}
