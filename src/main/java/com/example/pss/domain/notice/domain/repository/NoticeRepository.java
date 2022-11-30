package com.example.pss.domain.notice.domain.repository;

import com.example.pss.domain.member.domain.Member;
import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.notice.domain.type.NoticeType;
import com.example.pss.domain.stack.domain.Stack;
import com.example.pss.domain.user.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NoticeRepository extends JpaRepository<Notice, UUID>, NoticeCustom {
    Optional<Notice> findById(UUID noticeId);

    List<Notice> findAllByNoticeTypeAndUser(NoticeType noticeType, User user);

    List<Notice> findAllByUserAndNoticeType(User user, NoticeType noticeType);

    List<Notice> findAllByTitleContainsAndNoticeTypeAndStarGreaterThanEqualOrderByCreateTimeDesc(String title, NoticeType noticeType, float star);

    List<Notice> findAllByStarGreaterThanEqualAndNoticeTypeOrderByCreateTimeDesc(float star, NoticeType noticeType);

    List<Notice> findAllByTitleContainsAndNoticeTypeAndStarGreaterThanEqualOrderByStarDesc(String title, NoticeType noticeType, float star);

    List<Notice> findAllByStarGreaterThanEqualAndNoticeTypeOrderByStarDesc(float star, NoticeType noticeType);
}

// 그 유저와