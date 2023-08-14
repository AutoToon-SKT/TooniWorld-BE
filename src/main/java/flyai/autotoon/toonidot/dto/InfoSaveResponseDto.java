package flyai.autotoon.toonidot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
public class InfoSaveResponseDto {
    private Long infoId;
    private String toonName;

}
