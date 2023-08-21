package flyai.autotoon.toonidot.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class StoryUpdateRequestDto {
    private String storyContent;

    //Entity 클래스를 반환해주는 과정에서 클래스의 JSON Serialize 과정에서 오류 -> 빈 생성자 생성으로 해결
    public  StoryUpdateRequestDto(){}
    @Builder
    public StoryUpdateRequestDto(String storyContent){
        this.storyContent = storyContent;
    }
}
