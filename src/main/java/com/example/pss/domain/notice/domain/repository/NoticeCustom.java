package com.example.pss.domain.notice.domain.repository;

import com.example.pss.domain.notice.domain.Notice;

import java.util.List;

public interface NoticeCustom {
    List<Notice> findAllByStarAndTitleOrderByCreateTime(String title, float star);
    List<Notice> findAllByStarAndTitleOrderByStar(String title, float star);
    List<Notice> findAllByStarOrderByCreateTime(float star);
    List<Notice> findAllByStarOrderByStar(float star);
}
