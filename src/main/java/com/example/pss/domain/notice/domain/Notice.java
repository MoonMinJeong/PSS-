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
@Table(name = "tbl_notice")
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
    private float star;

    @Column
    private Integer viewCount;

    @Column
    private String introduction;

    @Column
    private boolean isMine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "notice")
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "notice")
    private List<Star> stars = new ArrayList<>();

    @OneToMany(mappedBy = "notice")
    private List<Stack> stacks = new ArrayList<>();

    @Builder
    public Notice(String title, String content, String imageUrl, Type projectType, float star, Integer viewCount, String introduction, boolean isMine, User user) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.introduction = introduction;
        this.projectType = projectType;
        this.star = star;
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

    public void updateStar(float star) {
        this.star = star;
    }
}
