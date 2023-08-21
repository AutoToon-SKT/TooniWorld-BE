package flyai.autotoon.toonidot.dto;

import flyai.autotoon.toonidot.entity.Cartoon;
import flyai.autotoon.toonidot.entity.Info;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@NoArgsConstructor
public class CartoonSaveRequestDto {
    private MultipartFile cartoonFile;
    private String fileName;
    private Long infoId;

    @Builder
    public CartoonSaveRequestDto(String fileName, MultipartFile cartoonFile, Long infoId) {
        this.fileName = fileName;
        this.cartoonFile = cartoonFile;
        this.infoId = infoId;
    }

}
