package flyai.autotoon.toonidot.dto;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;

@Getter
public class StoryUpdateRequestDto {
    private String storyContent;
    private String storyFirst;
    private String storySecond;
    private String storyThird;
    private String storyFourth;
    //Entity 클래스를 반환해주는 과정에서 클래스의 JSON Serialize 과정에서 오류 -> 빈 생성자 생성으로 해결
    public  StoryUpdateRequestDto(){}
    @Builder
    public StoryUpdateRequestDto(String storyContent, String storyFirst,
                                 String storySecond, String storyThird, String storyFourth){
        this.storyContent = storyContent;
        this.storyFirst = storyFirst;
        this.storySecond = storySecond;
        this.storyThird = storyThird;
        this.storyFourth = storyFourth;
    }
}
