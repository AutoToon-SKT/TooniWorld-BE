package flyai.autotoon.toonidot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class CartoonSaveResponseDto {
    private Long infoId;
    private String cartoonURL;
    // private String storyContent;
}
