package flyai.autotoon.toonidot.dto;

import flyai.autotoon.toonidot.entity.Info;
import flyai.autotoon.toonidot.entity.Story;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StorySaveRequestDto {

    private String storyContent;

    @Builder
    public  StorySaveRequestDto(String storyContent){
        this.storyContent=storyContent;
    }

    public Story toEntity(Info info){
        return Story.builder()
                .info(info)
                .storyContent(storyContent)
                .build();
    }
}
