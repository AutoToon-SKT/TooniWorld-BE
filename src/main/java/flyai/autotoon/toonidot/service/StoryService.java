package flyai.autotoon.toonidot.service;

import flyai.autotoon.toonidot.dto.StorySaveRequestDto;
import flyai.autotoon.toonidot.dto.StorySaveResponseDto;
import flyai.autotoon.toonidot.entity.Info;
import flyai.autotoon.toonidot.entity.Story;
import flyai.autotoon.toonidot.repository.InfoRepository;
import flyai.autotoon.toonidot.repository.StoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class StoryService {
    private final StoryRepository storyRepository;
    private final InfoRepository infoRepository;

    @Transactional
    public StorySaveResponseDto saveStory(Long infoId, StorySaveRequestDto storySaveRequestDto){

        Info info = infoRepository.findById(infoId)
                .orElseThrow(()-> new IllegalArgumentException("해당 웹툰 정보가 존재하지 않습니다. user_id = "+ infoId));
        Story newStory = storyRepository.save(storySaveRequestDto.toEntity(info));

        return StorySaveResponseDto.builder()
                .storyId(newStory.getStoryId())
                .infoId(newStory.getInfo().getInfoId())
                .build();
    }
}
