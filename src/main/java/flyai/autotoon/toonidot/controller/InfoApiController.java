package flyai.autotoon.toonidot.controller;


import flyai.autotoon.toonidot.dto.InfoSaveRequestDto;
import flyai.autotoon.toonidot.dto.InfoSaveResponseDto;
import flyai.autotoon.toonidot.dto.InfoUpdateRequestDto;
import flyai.autotoon.toonidot.dto.SuccessResponse;
import flyai.autotoon.toonidot.exception.Success;
import flyai.autotoon.toonidot.service.InfoService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class InfoApiController {

    private final InfoService infoService;

    @PostMapping("/{userId}/info")
    public SuccessResponse<InfoSaveResponseDto> saveInfo(
            @PathVariable("userId") Long userId,
            @RequestBody InfoSaveRequestDto infoSaveRequestDto)
    {
        return SuccessResponse.success(Success.SAVE_INFO_SUCCESS, infoService.saveInfo(userId, infoSaveRequestDto));
    }

    @PutMapping("/{userId}/info/{infoId}")
    public SuccessResponse<Long> updateInfo(
            @PathVariable("infoId") Long infoId,
            @RequestBody InfoUpdateRequestDto infoUpdateRequestDto)
    {
        return  SuccessResponse.success(Success.UPDATE_INFO_SUCCESS, infoService.updateInfo(infoId, infoUpdateRequestDto));
    }

}
