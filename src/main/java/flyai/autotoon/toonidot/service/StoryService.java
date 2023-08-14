package flyai.autotoon.toonidot.service;

import flyai.autotoon.toonidot.dto.StorySaveRequestDto;
import flyai.autotoon.toonidot.dto.StorySaveResponseDto;
import flyai.autotoon.toonidot.entity.Story;
import flyai.autotoon.toonidot.repository.StoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class StoryService {
    private final StoryRepository storyRepository;

    @Transactional
    public StorySaveResponseDto saveStory(StorySaveRequestDto storySaveRequestDto){
        Story newStory = storyRepository.save(storySaveRequestDto.toEntity());
        return StorySaveResponseDto.builder()
                .storyId(newStory.getStoryId())
                .infoId(newStory.getInfo().getInfoId())
                .build();
    }
}
