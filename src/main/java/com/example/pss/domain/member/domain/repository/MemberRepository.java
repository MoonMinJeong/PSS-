package com.example.pss.domain.member.domain.repository;

import com.example.pss.domain.member.domain.Member;
import com.example.pss.domain.notice.domain.Notice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MemberRepository extends CrudRepository<Member, UUID> {
    List<Member> findAllByNotice(Notice notice);
    Optional<Member> findByNicknameAndNotice(String nickname, Notice notice);
}
