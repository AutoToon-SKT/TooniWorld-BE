package flyai.autotoon.toonidot.controller;

import flyai.autotoon.toonidot.entity.Info;
import flyai.autotoon.toonidot.repository.InfoRepository;
import flyai.autotoon.toonidot.service.S3UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class S3UploadApiController {
    private final S3UploadService s3UploadService;
    private final InfoRepository infoRepository;

    @PostMapping("/upload-image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile imageFile,
                                              @RequestParam("fileName") String fileName,
                                              @RequestParam("infoId") Long infoId) {

        try {
            Info info = infoRepository.findById(infoId)
                    .orElseThrow(()->new RuntimeException("Webtoon Info Not Found"));
            String imageUrl = s3UploadService.uploadImage(imageFile, fileName, info);
            return ResponseEntity.ok("Uploaded image URL: " + imageUrl);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Image upload failed");
        }
    }
}