package flyai.autotoon.toonidot.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AllStorySendRequestDto {

    private String allStory;


    @Builder
    public AllStorySendRequestDto(String allStory){
        this.allStory=allStory;
    }

}
