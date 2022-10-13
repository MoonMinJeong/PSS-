package com.example.pss.domain.notice.domain;

import com.example.pss.domain.like.domain.Like;
import com.example.pss.domain.stack.domain.Stack;
import com.example.pss.domain.star.domain.Star;
import com.example.pss.domain.user.domain.User;
import com.example.pss.global.entity.BaseTimeEntity;
import com.example.pss.global.enums.Type;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "notice")
@Entity
public class Notice extends BaseTimeEntity {
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
    private int viewCount;

    @Column
    private String introduction;

    @Column
    private boolean isMine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "notice", cascade = CascadeType.ALL)
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "notice", cascade = CascadeType.ALL)
    private List<Star> stars = new ArrayList<>();

    @OneToMany(mappedBy = "notice", cascade = CascadeType.ALL)
    private List<Stack> stacks = new ArrayList<>();

    @Builder
    public Notice(String title, String content, String imageUrl, Type projectType, int viewCount, String introduction, boolean isMine, User user) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.introduction = introduction;
        this.projectType = projectType;
        this.viewCount = viewCount;
        this.isMine = isMine;
        this.user = user;
    }

    public void UpdateNotice(String title, String content, String imageUrl, String introduction) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.introduction = introduction;
    }

    public void UpViewCount() {
        this.viewCount++;
    }
}
