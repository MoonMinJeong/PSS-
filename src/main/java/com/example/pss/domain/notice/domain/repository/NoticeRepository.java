package com.example.pss.domain.notice.domain.repository;

import com.example.pss.domain.notice.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NoticeRepository extends JpaRepository<Notice, UUID> {
    Optional<Notice> findById(UUID uuid);

    @Query("SELECT p FROM Notice p ORDER BY p.createTime DESC ")
    List<Notice> findAllDesc();

    @Query("SELECT f from Notice f ORDER BY f.star DESC ")
    List<Notice> findAll();

    @Query("SELECT p from Notice p where p.title like %:title%")
    List<Notice> findAllByTitle(String title);
}
