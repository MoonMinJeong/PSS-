package com.example.pss.domain.notice.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Embeddable
public class TechStackEntityId implements Serializable {
    @Column(nullable = false)
    private UUID noticeId;

    @Column(nullable = false)
    private UUID stackId;
}
