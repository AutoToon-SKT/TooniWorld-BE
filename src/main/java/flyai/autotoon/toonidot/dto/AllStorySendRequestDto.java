package flyai.autotoon.toonidot.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class AllStorySendRequestDto {
    @Setter
    private String allStory;

    @Builder
    public AllStorySendRequestDto(String allStory){
        this.allStory=allStory;
    }

}
