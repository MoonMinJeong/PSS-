package com.example.pss.domain.notice.domain.repository;

import com.example.pss.domain.notice.domain.Notice;

import java.util.List;

public interface NoticeCustom {
    List<Notice> findByStar(Float stars);
}
