package flyai.autotoon.toonidot.dto;

import flyai.autotoon.toonidot.entity.Info;
import flyai.autotoon.toonidot.entity.Story;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@AllArgsConstructor
public class StorySaveRequestDto {

    @Setter
    private Info info;

    private String storyContent;

    public Story toEntity(){
        return Story.builder()
                .info(info)
                .storyContent(storyContent)
                .build();
    }
}
