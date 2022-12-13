package com.example.pss.domain.user.domain;

import com.example.pss.global.entity.BaseTimeEntity;
import com.example.pss.global.enums.Authority;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Table(name = "tbl_user")
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @NotNull
    @Column(unique = true)
    private String nickname;

    @NotNull
    @Column
    private String imageUrl;

    @Column
    private String email;

    @NotNull
    @Column
    private Authority authority;
}
