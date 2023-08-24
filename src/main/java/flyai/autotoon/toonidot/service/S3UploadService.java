package flyai.autotoon.toonidot.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class    S3UploadService {
    private final AmazonS3 amazonS3;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public String uploadImage(MultipartFile imageFile, String fileName) throws IOException {
        String originalFilename = fileName + ".jpg"; // 이미지 확장자에 맞게 설정

        // 이미지 파일을 S3에 업로드
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(imageFile.getSize());
        metadata.setContentType("image/jpeg"); // 이미지 타입에 맞게 설정
        amazonS3.putObject(bucket, originalFilename, imageFile.getInputStream(), metadata);

        // 업로드된 이미지의 URL 반환
        String imageUrl = amazonS3.getUrl(bucket, originalFilename).toString();
        System.out.println("Uploaded file URL:" + imageUrl);
        return imageUrl;
    }
}
