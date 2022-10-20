package com.example.pss.domain.reply.domain;

import com.example.pss.domain.comment.domain.Comment;
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
@Table(name = "tbl_reply")
@Entity
public class Reply extends BaseTimeEntity {
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
    @JoinColumn(name = "notice_id", nullable = false)
    private Notice notice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id", nullable = false)
    private Comment comment;

    @Builder
    public Reply(String content, boolean isMine, Notice notice, User user, Comment comment) {
        this.notice = notice;
        this.content = content;
        this.isMine = isMine;
        this.user = user;
        this.comment = comment;
    }

    public void update(String content) {
        this.content = content;
    }
}
