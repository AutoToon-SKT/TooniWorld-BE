package flyai.autotoon.toonidot.controller;

import flyai.autotoon.toonidot.dto.CartoonSaveRequestDto;
import flyai.autotoon.toonidot.dto.CartoonSaveResponseDto;
import flyai.autotoon.toonidot.service.S3UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class S3UploadApiController {

    private final S3UploadService s3UploadService;

    @PostMapping(value = "/upload-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CartoonSaveResponseDto> saveCartoon(@RequestParam("file") MultipartFile cartoonFile,
                                                              @RequestParam("fileName") String fileName,
                                                              @RequestParam("infoId") Long infoId) {

        try {
            CartoonSaveRequestDto requestDto = CartoonSaveRequestDto.builder()
                    .fileName(fileName)
                    .cartoonFile(cartoonFile)
                    .infoId(infoId)
                    .build();
            CartoonSaveResponseDto responseDto = s3UploadService.saveCartoon(requestDto);
            return ResponseEntity.ok(responseDto);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}