package com.example.pss.domain.notice.present.dto.request;

import com.example.pss.global.enums.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateRequest {

    private String title;

    private String content;

    private String imageUrl;

    private Type projectType;
    
    private String introduction;
}
