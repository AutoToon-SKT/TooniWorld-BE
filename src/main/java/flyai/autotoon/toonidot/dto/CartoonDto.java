package flyai.autotoon.toonidot.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CartoonDto {
    private Long infoId;
    private String cartoonURL;
    private String storyContent;
}
