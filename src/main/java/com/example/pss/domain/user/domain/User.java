package com.example.pss.domain.user.domain;

import com.example.pss.global.entity.BaseTimeEntity;
import com.example.pss.global.enums.Authority;
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
public class User extends BaseTimeEntity {
    @Id @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @NotNull
    @Column
    private String nickname;

    @NotNull
    @Column
    private String imageUrl;

    @Column
    private String email;

    @NotNull
    @Column
    private Authority authority;

    @Builder
    public User(String nickname, String imageUrl, String email, Authority authority) {
        this.nickname = nickname;
        this.imageUrl = imageUrl;
        this.email = email;
        this.authority = authority;
    }
}
