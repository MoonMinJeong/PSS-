package com.example.pss.domain.comment.domain;

import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.user.domain.User;
import com.example.pss.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_comment")
@Entity
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column
    private String content;

    @Column
    private boolean isMine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_id")
    private Notice notice;

    @Builder
    public Comment(String content, boolean isMine, User user, Notice notice) {
        this.content = content;
        this.isMine = isMine;
        this.user = user;
        this.notice = notice;
    }

    public void update(String content) {
        this.content = content;
    }
}
