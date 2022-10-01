package com.example.pss.domain.like.domain;

import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.user.domain.User;
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
    private boolean likeCheck;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_id")
    private Notice notice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Like(boolean likeCheck, Notice notice, User user) {
        this.likeCheck = likeCheck;
        this.notice = notice;
        this.user = user;
    }

    public void likeUpdate(boolean likeCheck) {
        this.likeCheck = likeCheck;
    }
}
