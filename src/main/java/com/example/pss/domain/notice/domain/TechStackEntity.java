package com.example.pss.domain.notice.domain;

import com.example.pss.domain.stack.domain.Stack;
import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(
        name = "tbl_techStack",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"notice_id", "stack_id"}
                )
        }
)
@Entity
public class TechStackEntity {

    @EmbeddedId
    private TechStackEntityId id;

    @MapsId("noticeId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_id", nullable = false, columnDefinition = "BINARY(16)")
    private Notice notice;

    @MapsId("stackId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stack_id", nullable = false)
    private Stack stack;
}