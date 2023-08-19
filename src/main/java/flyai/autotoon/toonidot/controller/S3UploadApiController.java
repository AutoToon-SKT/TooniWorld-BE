package flyai.autotoon.toonidot.controller;

import flyai.autotoon.toonidot.service.S3UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class S3UploadApiController {
    private final S3UploadService s3UploadService;

    @Autowired
    public S3UploadApiController(S3UploadService s3UploadService) {
        this.s3UploadService = s3UploadService;
    }

    @PostMapping("/upload-image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile imageFile,
                                              @RequestParam("fileName") String fileName) {
        try {
            String imageUrl = s3UploadService.uploadImage(imageFile, fileName);
            return ResponseEntity.ok("Uploaded image URL: " + imageUrl);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Image upload failed");
        }
    }
}