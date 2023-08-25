package flyai.autotoon.toonidot.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import flyai.autotoon.toonidot.dto.CartoonSaveRequestDto;
import flyai.autotoon.toonidot.dto.CartoonSaveResponseDto;
import flyai.autotoon.toonidot.entity.Cartoon;
import flyai.autotoon.toonidot.entity.Info;
import flyai.autotoon.toonidot.repository.CartoonRepository;
import flyai.autotoon.toonidot.repository.InfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.io.IOException;

@Service
public class S3UploadService {
    private final CartoonRepository cartoonRepository;
    private final InfoRepository infoRepository;
    private final AmazonS3 s3Client;
    private final Logger logger = LoggerFactory.getLogger(S3UploadService.class);

    @Value("${cloud.aws.s3.bucket}")
    String bucket;

    @Autowired
    public S3UploadService(CartoonRepository cartoonRepository,
                           InfoRepository infoRepository,
                           @Qualifier("amazonS3Client") AmazonS3 s3Client) {
        this.cartoonRepository = cartoonRepository;
        this.infoRepository = infoRepository;
        this.s3Client = s3Client;
    }

    public String uploadToS3(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        s3Client.putObject(bucket, fileName, file.getInputStream(), new ObjectMetadata());
        return s3Client.getUrl(bucket, fileName).toString();
    }

    @Transactional
    public CartoonSaveResponseDto saveUrlToDB(CartoonSaveRequestDto requestDto) throws IOException {
        Long infoId = requestDto.getInfoId();

        System.out.println(infoId);

        Info relatedInfo;
        try {
            relatedInfo = infoRepository.getById(requestDto.getInfoId());
        } catch (EntityNotFoundException ex) {
            throw new IllegalArgumentException("Invalid infoId - S3 : " + requestDto.getInfoId());
        }

        //Info relatedInfo = infoRepository.findById(requestDto.getInfoId())
        //        .orElseThrow(() -> new IllegalArgumentException("Invalid infoId - S3 : " + requestDto.getInfoId()));

        logger.info("Uploading cartoon with infoId: {}", infoId);

        String cartoonUrl = uploadToS3(requestDto.getCartoonFile());


        Cartoon cartoon = Cartoon.builder()
                .info(relatedInfo)
                .cartoonURL(cartoonUrl)
                .build();

        Cartoon savedCartoon = cartoonRepository.save(cartoon);

        return CartoonSaveResponseDto.builder()
                .infoId(savedCartoon.getInfo().getInfoId())
                .cartoonURL(savedCartoon.getCartoonURL())
                .build();

        }
    }

    /*@Transactional
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
                .orElseThrow(()->new IllegalArgumentException("Info not found with ID: " + requestDto.getInfoId()));

        Cartoon cartoon = new Cartoon();
        cartoon.setInfo(info);
        cartoon.setCartoonURL(cartoonUrl);
        cartoonRepository.save(cartoon);

        return new CartoonSaveResponseDto(info.getInfoId(), cartoonUrl);
    }
}
*/