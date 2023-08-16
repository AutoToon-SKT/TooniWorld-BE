package flyai.autotoon.toonidot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class S3UploadService {
    @Autowired
    private S3UploadService s3UploadService;

    @Test
    public void testFileUpload() {
        // 업로드할 파일과 버킷 정보 설정
        String bucketName = "your-bucket-name";
        String key = "test-file.txt";
        String content = "Hello, S3!";

        // 업로드 메소드 호출
        s3UploadService.uploadFile(bucketName, key, content.getBytes());
    }
}
