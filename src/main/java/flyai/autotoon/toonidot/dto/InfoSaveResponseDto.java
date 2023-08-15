package flyai.autotoon.toonidot.dto;

import flyai.autotoon.toonidot.entity.User;
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
