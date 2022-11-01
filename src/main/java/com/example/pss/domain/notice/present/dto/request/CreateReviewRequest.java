package com.example.pss.domain.notice.present.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class CreateReviewRequest {
    @Size(min = 20, message = "최소 20글자는 써야합니다")
    private String content;
    private String imageUrl;
}
