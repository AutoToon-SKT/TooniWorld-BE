package flyai.autotoon.toonidot.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@NoArgsConstructor
public class CartoonSaveRequestDto {
    private MultipartFile cartoonFile;
    private Long userId;
    private Long infoId;
    private Long cartoonId;

    @Builder
    public CartoonSaveRequestDto(MultipartFile cartoonFile,Long userId, Long infoId, Long cartoonId) {
        this.cartoonFile = cartoonFile;
        this.userId = userId;
        this.infoId = infoId;
        this.cartoonId = cartoonId;
    }

}
