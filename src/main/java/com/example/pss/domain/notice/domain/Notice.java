package com.example.pss.domain.notice.domain;

import com.example.pss.domain.user.domain.User;
import com.example.pss.global.enums.Type;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Notice {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @NotNull
    @Column
    private String title;
    
    @Column
    private String imageUrl;

    @NotNull
    @Column
    private String content;

    @Column
    private Type projectType;

    @Column
    private int likes;

    @Column
    private int viewCount;

    @Column
    private float star;

    @Column
    private String introduction;

    @Column
    private boolean isMine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public Notice(String title, String content, String imageUrl, Type projectType, int likes, int viewCount, float star, String introduction, boolean isMine, User user) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.introduction = introduction;
        this.projectType = projectType;
        this.likes = likes;
        this.viewCount = viewCount;
        this.star = star;
        this.isMine = isMine;
        this.user = user;
    }

    public void UpdateNotice(String title, String content, String imageUrl, String introduction) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.introduction = introduction;
    }
}
