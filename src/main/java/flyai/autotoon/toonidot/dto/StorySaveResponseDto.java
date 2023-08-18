package flyai.autotoon.toonidot.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StorySaveResponseDto {
    private Long infoId;
    private Long storyId;

    @Builder
    public StorySaveResponseDto(Long infoId, Long storyId){
        this.infoId = infoId;
        this.storyId = storyId;
    }
}
