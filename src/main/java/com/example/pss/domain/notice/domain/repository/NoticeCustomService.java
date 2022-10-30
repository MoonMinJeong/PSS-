package com.example.pss.domain.notice.domain.repository;

import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.notice.domain.type.NoticeType;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.pss.domain.notice.domain.QNotice.notice;

@RequiredArgsConstructor
public class NoticeCustomService implements NoticeCustom{
    private final JPAQueryFactory query;

    @Override
    public List<Notice> findAllByStarAndTitleOrderByCreateTime(String title, float star) {
        return query.selectFrom(notice)
                .where(notice.title.contains(title).and(notice.star.goe(star)).and(notice.noticeType.eq(NoticeType.POST)))
                .orderBy(notice.createTime.desc())
                .fetch();
    }

    @Override
    public List<Notice> findAllByStarAndTitleOrderByStar(String title, float star) {
        return query.selectFrom(notice)
                .where(notice.title.contains(title).and(notice.star.goe(star)))
                .orderBy(notice.star.desc())
                .fetch();
    }

    @Override
    public List<Notice> findAllByStarOrderByCreateTime(float star) {
        return query.selectFrom(notice)
                .where(notice.star.goe(star))
                .orderBy(notice.createTime.desc())
                .fetch();
    }

    @Override
    public List<Notice> findAllByStarOrderByStar(float star) {
        return query.selectFrom(notice)
                .where(notice.star.goe(star))
                .orderBy(notice.star.desc())
                .fetch();
    }
}
