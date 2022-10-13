package com.example.pss.domain.stack.domain;

import com.example.pss.domain.notice.domain.Notice;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_stack")
@Entity
public class Stack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String techName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_id", nullable = false)
    private Notice notice;

    @Builder
    public Stack(String techName, Notice notice) {
        this.techName = techName;
        this.notice = notice;
    }
}
