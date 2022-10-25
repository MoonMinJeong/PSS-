package com.example.pss.domain.image.facade;

import com.example.pss.domain.image.domain.Image;
import com.example.pss.domain.image.domain.repository.ImageRepository;
import com.example.pss.domain.notice.domain.Notice;
import com.example.pss.domain.stack.domain.Stack;
import com.example.pss.domain.stack.exception.StackNotFoundException;
import com.example.pss.global.exception.ImageNotValueException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class ImageFacade {
    private final ImageRepository imageRepository;

    public List<String> findAllByNotice(Notice notice) {
        List<String> list = new ArrayList<>();

        for(int i = 0; i<imageRepository.findAllByNotice(notice).size(); i++) {
            list.add(imageRepository.findAllByNotice(notice)
                    .get(i)
                    .getImageUrl());
        }
        return list;
    }

    public List<Image> findByList(List<String> list, Notice notice) {
        List<Image> images = new ArrayList<>();

        for(String imageUrl : list) {
            if(imageRepository.findByNoticeAndImageUrl(notice, imageUrl).isEmpty()) {
                images.add(
                        imageRepository.save(
                                Image.builder()
                                        .notice(notice)
                                        .imageUrl(imageUrl)
                                        .build()
                        )
                );
            } else {
                Image image = imageRepository.findByNoticeAndImageUrl(notice, imageUrl)
                        .orElseThrow(() -> ImageNotValueException.EXCEPTION);

                images.add(image);
            }
        }

        return images;
    }
}
