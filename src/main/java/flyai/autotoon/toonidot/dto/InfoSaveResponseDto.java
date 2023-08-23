package flyai.autotoon.toonidot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class InfoSaveResponseDto {
    private Long infoId;
    private Long userId;
    private String toonName;
}
