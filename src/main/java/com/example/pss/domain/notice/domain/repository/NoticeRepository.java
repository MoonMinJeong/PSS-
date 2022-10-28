package com.example.pss.domain.notice.domain.repository;

import com.example.pss.domain.notice.domain.Notice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NoticeRepository extends CrudRepository<Notice, UUID>, NoticeCustom {
    Optional<Notice> findById(UUID noticeId);

    @Query("SELECT p FROM Notice p ORDER BY p.createTime DESC ")
    List<Notice> findAllDesc();

    @Query("SELECT f from Notice f ORDER BY f.star DESC ")
    List<Notice> findAllAndOrderByStarDesc();

    @Query("SELECT p from Notice p where p.title like %:title% ORDER BY p.star DESC ")
    List<Notice> findAllByTitleOrderByStarDesc(String title);

    @Query("SELECT p from Notice p where p.title like %:title% ORDER BY p.createTime DESC ")
    List<Notice> findAllByTitleOrderByCreateTimeDesc(String title);
}
