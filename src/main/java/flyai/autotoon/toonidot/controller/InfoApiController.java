package flyai.autotoon.toonidot.controller;


import flyai.autotoon.toonidot.dto.InfoSaveRequestDto;
import flyai.autotoon.toonidot.dto.InfoSaveResponseDto;
import flyai.autotoon.toonidot.dto.SuccessResponse;
import flyai.autotoon.toonidot.exception.Success;
import flyai.autotoon.toonidot.service.InfoService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class InfoApiController {
    private final InfoService infoService;

    @PostMapping("/{userId}/info/")
    public SuccessResponse<InfoSaveResponseDto> saveInfo(
            @PathVariable("userId") Long userId,
            @RequestBody InfoSaveRequestDto infoSaveRequestDto){
        return SuccessResponse.success(Success.SAVE_INFO_SUCCESS, infoService.saveInfo(infoSaveRequestDto));
    }

}
