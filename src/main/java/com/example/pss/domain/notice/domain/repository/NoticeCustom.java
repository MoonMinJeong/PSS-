package com.example.pss.domain.notice.domain.repository;

import com.example.pss.domain.notice.domain.Notice;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoticeCustom {
    List<Notice> findAllByStarAndTitleOrderByCreateTime(float star, @Param("title") String title);
    List<Notice> findAllByStarAndTitleOrderByStar(float star, @Param(("title")) String title);
    List<Notice> findAllByStarOrderByCreateTime(float star);
    List<Notice> findAllByStarOrderByStar(float star);
}
