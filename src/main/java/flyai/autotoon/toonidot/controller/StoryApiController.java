package flyai.autotoon.toonidot.controller;

import flyai.autotoon.toonidot.dto.*;
import flyai.autotoon.toonidot.entity.Info;
import flyai.autotoon.toonidot.exception.Success;
import flyai.autotoon.toonidot.service.StoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class StoryApiController {

    private final StoryService storyService;
    @PostMapping("/{infoId}/story")
    public SuccessResponse<StorySaveResponseDto> saveStory(
            @PathVariable("infoId") Long infoId,
            @RequestBody StorySaveRequestDto storySaveRequestDto)
    {
        return SuccessResponse.success(Success.SAVE_STORY_SUCCESS, storyService.saveStory(infoId, storySaveRequestDto));
    }


    @PutMapping("/{infoId}/story/{storyId}")
    public SuccessResponse<Long> updateStory(
            @PathVariable("storyId") Long storyId,
            @RequestBody StoryUpdateRequestDto storyUpdateRequestDto)
    {
        return  SuccessResponse.success(Success.UPDATE_STORY_SUCCESS, storyService.updateStory(storyId, storyUpdateRequestDto));
    }


}
