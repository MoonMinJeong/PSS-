package com.example.pss.domain.like.domain;

import com.example.pss.domain.notice.domain.Notice;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int likes;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_id")
    private Notice notice;

    @Builder
    public Like(int likes, Notice notice) {
        this.likes = likes;
        this.notice = notice;
    }

    public void updateLikes(int likes) {
        this.likes = likes;
    }
}
