package flyai.autotoon.toonidot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Getter
@Builder
@AllArgsConstructor
public class CartoonResponseDto {
    private Long toonCut;
    private String toonCutSubTitle;
    private Long toonOption;
    private String cartoonURL;
}
