package com.example.pss.domain.image.present.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ImageDto {
    private final List<String> images;
}
