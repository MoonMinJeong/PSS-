package com.example.pss.infrastructure.s3;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.pss.global.exception.ImageNotValueException;
import com.example.pss.global.exception.SaveImageFailedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class S3Facade implements ImageUtil{
    private final S3Properties s3Properties;
    private final AmazonS3Client amazonS3Client;

    @Override
    public String upload(MultipartFile file) {
        if (file.isEmpty()) {
            throw ImageNotValueException.EXCEPTION;
        }

        String fileName = s3Properties.getS3Bucket() + "/" + UUID.randomUUID() + file.getOriginalFilename();

        try {
            PutObjectRequest putObjectRequest = new PutObjectRequest(
                    s3Properties.getS3Bucket(),
                    fileName,
                    file.getInputStream(),
                    getObjectMetadata(file)
            );
            amazonS3Client.putObject(putObjectRequest.withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (Exception e) {
            e.printStackTrace();
            throw SaveImageFailedException.EXCEPTION;
        }
        return getFileUrl(fileName);
    }

    private ObjectMetadata getObjectMetadata(MultipartFile file) {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(file.getSize());
        objectMetadata.setContentType(file.getContentType());

        return objectMetadata;
    }

    public String getFileUrl(String fileName) {
        return amazonS3Client.getUrl(s3Properties.getS3Bucket(), fileName).toString();
    }
}