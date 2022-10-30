package com.example.pss.domain.notice.domain;

import com.example.pss.domain.member.domain.Member;
import com.example.pss.domain.notice.domain.type.NoticeType;
import com.example.pss.domain.stack.domain.Stack;
import com.example.pss.domain.user.domain.User;
import com.example.pss.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @NotNull
    @Column
    private String imageUrl;

    @NotNull
    @Column
    @Size(min = 20, max = 2000)
    private String content;

    @Column
    private float star;

    @Column
    private Integer viewCount;

    @Column
    private String introduction;

    @Column
    private boolean isMine;

    @Column(name = "notice_type")
    @Enumerated(EnumType.STRING)
    private NoticeType noticeType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "notice", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Stack> stacks = new ArrayList<>();

    @OneToMany(mappedBy = "notice", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Member> members = new ArrayList<>();


    @Builder
    public Notice(String title, String content, String imageUrl, float star, Integer viewCount, String introduction, boolean isMine, User user, NoticeType noticeType) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.introduction = introduction;
        this.star = star;
        this.viewCount = viewCount;
        this.isMine = isMine;
        this.user = user;
        this.noticeType = noticeType;
    }

    public void UpdateNotice(String title, String content, List<Stack> stacks, List<Member> members) {
        this.title = title;
        this.content = content;
        this.stacks = stacks;
        this.members = members;
    }

    public void UpViewCount() {
        this.viewCount++;
    }

    public void updateList(List<Stack> stacks, List<Member> members) {
        this.stacks = stacks;
        this.members = members;
    }

    public void updateStar(float star) {
        this.star = star;
    }
}
