package com.example.pss.domain.image.present;

import com.example.pss.domain.image.present.dto.ImageDto;
import com.example.pss.domain.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

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
