package com.example.pss.domain.notice.domain.repository;

import com.example.pss.domain.notice.domain.Notice;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.pss.domain.notice.domain.QNotice.notice;

@RequiredArgsConstructor
public class NoticeCustomService implements NoticeCustom{
    private final JPAQueryFactory query;

    @Override
    public List<Notice> findByStar(Float stars) {
        return query.selectFrom(notice)
                .where(notice.star.goe(stars))
                .fetch();
    }
}
