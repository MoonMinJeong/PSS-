package com.example.pss.domain.image.service;

import com.example.pss.domain.image.present.dto.ImageDto;
import com.example.pss.infrastructure.s3.S3Facade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ImageService {
    private final S3Facade s3Facade;

    public ImageDto upload(List<MultipartFile> files) {
        List<String> images = files.stream()
                .map(s3Facade::upload)
                .collect(Collectors.toList());

        return ImageDto.builder()
                .images(images)
                .build();
    }
}
