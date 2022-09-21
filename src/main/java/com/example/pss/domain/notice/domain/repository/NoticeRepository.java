package com.example.pss.domain.notice.domain.repository;

import com.example.pss.domain.notice.domain.Notice;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface NoticeRepository extends CrudRepository<Notice, UUID> {
}
