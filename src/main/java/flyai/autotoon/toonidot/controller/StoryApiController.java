package flyai.autotoon.toonidot.controller;

import flyai.autotoon.toonidot.dto.StorySaveRequestDto;
import flyai.autotoon.toonidot.dto.StorySaveResponseDto;
import flyai.autotoon.toonidot.dto.SuccessResponse;
import flyai.autotoon.toonidot.entity.Info;
import flyai.autotoon.toonidot.exception.Success;
import flyai.autotoon.toonidot.service.StoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class StoryApiController {

    private final StoryService storyService;
    @PostMapping("/{infoId}/story")
    public SuccessResponse<StorySaveResponseDto> saveStory(
            @PathVariable("infoId") Info infoId,
            @RequestBody StorySaveRequestDto storySaveRequestDto
            )
    {
        storySaveRequestDto.setInfo(infoId);
        return SuccessResponse.success(Success.SAVE_STORY_SUCCESS, storyService.saveStory(storySaveRequestDto));
    }

}
