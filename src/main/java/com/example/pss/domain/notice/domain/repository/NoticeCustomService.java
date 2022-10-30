package com.example.pss.domain.notice.domain.repository;

import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.notice.domain.type.NoticeType;
import com.example.pss.domain.star.facade.StarFacade;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static com.example.pss.domain.notice.domain.QNotice.notice;

@RequiredArgsConstructor
public class NoticeCustomService implements NoticeCustom{
    private final JPAQueryFactory query;
    private final StarFacade starFacade;

    @Override
    public List<Notice> findAllByStarAndTitleOrderByCreateTime(float star, @Param("title") String title) {
        return query.selectFrom(notice)
                .where(notice.title.contains(title)
                        .and(notice.star.goe(star))
                        .and(notice.noticeType.ne(NoticeType.SAVE))
                )
                .orderBy(notice.createTime.desc())
                .fetch();
    }

    @Override
    public List<Notice> findAllByStarAndTitleOrderByStar(float star, @Param("title") String title) {
        return query.selectFrom(notice)
                .where(notice.title.contains(title)
                        .and(notice.star.goe(star))
                        .and(notice.noticeType.ne(NoticeType.SAVE))
                )
                .orderBy(notice.star.desc())
                .fetch();
    }

    @Override
    public List<Notice> findAllByStarOrderByCreateTime(float star) {
        return query.selectFrom(notice)
                .where(notice.star.goe(star).and(notice.noticeType.ne(NoticeType.SAVE)))
                .orderBy(notice.createTime.desc())
                .fetch();
    }

    @Override
    public List<Notice> findAllByStarOrderByStar(float star) {
        return query.selectFrom(notice)
                .where(notice.star.goe(star).and(notice.noticeType.ne(NoticeType.SAVE)))
                .orderBy(notice.star.desc())
                .fetch();
    }
}
