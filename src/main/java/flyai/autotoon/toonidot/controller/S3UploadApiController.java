package flyai.autotoon.toonidot.controller;

import flyai.autotoon.toonidot.dto.CartoonSaveRequestDto;
import flyai.autotoon.toonidot.dto.CartoonSaveResponseDto;
import flyai.autotoon.toonidot.service.S3UploadService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/upload")
public class S3UploadApiController {

    private final Logger logger = LoggerFactory.getLogger(S3UploadApiController.class);
    private final S3UploadService s3UploadService;

    @PostMapping(value = "/user/{userId}/info/{infoId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CartoonSaveResponseDto> saveCartoon(@PathVariable Long userId, // 경로 변수 추가
                                                              @PathVariable Long infoId, // 경로 변수로 받아옴
                                                              @RequestPart CartoonSaveRequestDto cartoonSaveRequestDto,
                                                              @RequestPart("file") MultipartFile cartoonFile) {

        try {
            String uploadedUrl = s3UploadService.uploadToS3(cartoonFile);
            cartoonSaveRequestDto.setCartoonURL(uploadedUrl);

            CartoonSaveResponseDto responseDto = s3UploadService.saveUrlToDB(userId, infoId, cartoonSaveRequestDto);

            return ResponseEntity.ok(responseDto);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
