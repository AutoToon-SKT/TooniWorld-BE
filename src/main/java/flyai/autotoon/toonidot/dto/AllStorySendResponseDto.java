package flyai.autotoon.toonidot.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AllStorySendResponseDto {
    private Long userId;
    private Long infoId;
    private String allStory;

    @Builder
    public AllStorySendResponseDto (Long userId, Long infoId, String allStory){
        this.userId = userId;
        this.infoId = infoId;
        this.allStory = allStory;
    }
}
