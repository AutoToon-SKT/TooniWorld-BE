package flyai.autotoon.toonidot.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import flyai.autotoon.toonidot.dto.CartoonSaveRequestDto;
import flyai.autotoon.toonidot.dto.CartoonSaveResponseDto;
import flyai.autotoon.toonidot.entity.Cartoon;
import flyai.autotoon.toonidot.entity.Info;
import flyai.autotoon.toonidot.entity.Users;
import flyai.autotoon.toonidot.repository.CartoonRepository;
import flyai.autotoon.toonidot.repository.InfoRepository;
import flyai.autotoon.toonidot.repository.UserRepository;
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
    private final UserRepository userRepository;
    private final InfoRepository infoRepository;
    private final AmazonS3 s3Client;
    private final Logger logger = LoggerFactory.getLogger(S3UploadService.class);

    @Value("${cloud.aws.s3.bucket}")
    String bucket;

    @Autowired
    public S3UploadService(CartoonRepository cartoonRepository,
                           InfoRepository infoRepository,
                           UserRepository userRepository,
                           @Qualifier("amazonS3Client") AmazonS3 s3Client) {
        this.cartoonRepository = cartoonRepository;
        this.userRepository = userRepository;
        this.infoRepository = infoRepository;
        this.s3Client = s3Client;
    }

    public String uploadToS3(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());  //Set the Content Length

        s3Client.putObject(bucket, fileName, file.getInputStream(), metadata);
        return s3Client.getUrl(bucket, fileName).toString();
    }

    @Transactional
    public CartoonSaveResponseDto saveUrlToDB(Long userId, Long infoId, CartoonSaveRequestDto requestDto) throws IOException {
        Users users = userRepository.findById(userId)
                .orElseThrow(()-> new IllegalArgumentException("해당 사용자가 존재하지 않습니다. user_id = "+userId));

        Info relatedInfo;
        try {
            relatedInfo = infoRepository.getById(infoId);
        } catch (EntityNotFoundException ex) {
            throw new IllegalArgumentException("Invalid infoId - S3 : " + infoId);
        }

        Cartoon savedCartoon = cartoonRepository.save(requestDto.toEntity(relatedInfo));
        logger.info("Complete Saving");

        return CartoonSaveResponseDto.builder()
                .infoId(savedCartoon.getInfo().getInfoId())
                .cartoonURL(savedCartoon.getCartoonURL())
                .build();

    }
}

