package com.example.pss.domain.image.present;

import com.example.pss.domain.image.present.dto.ImageDto;
import com.example.pss.domain.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("image")
public class ImageController {
    private final ImageService imageService;

    @PostMapping
    public ImageDto upload(@RequestPart List<MultipartFile> files) {
        return imageService.upload(files);
    }
}
