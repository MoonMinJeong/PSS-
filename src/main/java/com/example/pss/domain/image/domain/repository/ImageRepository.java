package com.example.pss.domain.image.domain.repository;

import com.example.pss.domain.image.domain.Image;
import com.example.pss.domain.notice.domain.Notice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ImageRepository extends CrudRepository<Image, UUID> {
    List<Image> findAllByNotice(Notice notice);
    Optional<Image> findImageById(UUID imageId);

    Optional<Image> findByNoticeAndImageUrl(Notice notice, String imageUrl);
}
