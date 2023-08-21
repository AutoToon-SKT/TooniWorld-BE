package flyai.autotoon.toonidot.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import flyai.autotoon.toonidot.dto.CartoonSaveRequestDto;
import flyai.autotoon.toonidot.dto.CartoonSaveResponseDto;
import flyai.autotoon.toonidot.entity.Cartoon;
import flyai.autotoon.toonidot.entity.Info;
import flyai.autotoon.toonidot.repository.CartoonRepository;
import flyai.autotoon.toonidot.repository.InfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class S3UploadService {
    private final AmazonS3 amazonS3;
    private final CartoonRepository cartoonRepository;
    private final InfoRepository infoRepository;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;


    public CartoonSaveResponseDto saveCartoon(CartoonSaveRequestDto requestDto) throws IOException{
        String originalFilename = requestDto.getFileName() + ".jpg";

        // S3에 업로드
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(requestDto.getCartoonFile().getSize());
        metadata.setContentType("image/jpeg");
        amazonS3.putObject(bucket, originalFilename, requestDto.getCartoonFile().getInputStream(), metadata);

        // Url 반환
        String cartoonUrl = amazonS3.getUrl(bucket, originalFilename).toString();
        System.out.println("Uploaded file URL : " + cartoonUrl);

        Info info = infoRepository.findById(requestDto.getInfoId())
                .orElseThrow(()->new RuntimeException("Webtoon Upload Fail"));

        Cartoon cartoon = new Cartoon();
        cartoon.setInfo(info);
        cartoon.setCartoonURL(cartoonUrl);
        cartoonRepository.save(cartoon);

        return new CartoonSaveResponseDto(info.getInfoId(), cartoonUrl);
    }
}
