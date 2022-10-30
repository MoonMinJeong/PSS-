package com.example.pss.domain.notice.domain.repository;

import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.notice.domain.type.NoticeType;
import com.example.pss.domain.user.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NoticeRepository extends CrudRepository<Notice, UUID>, NoticeCustom {
    Optional<Notice> findById(UUID noticeId);
    List<Notice> findAllByNoticeTypeAndUser(NoticeType noticeType, User user);
    List<Notice> findAllByUserAndNoticeType(User user, NoticeType noticeType);
}
