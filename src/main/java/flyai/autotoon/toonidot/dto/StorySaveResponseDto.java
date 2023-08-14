package flyai.autotoon.toonidot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class StorySaveResponseDto {
    private Long infoId;
    private Long storyId;
}
