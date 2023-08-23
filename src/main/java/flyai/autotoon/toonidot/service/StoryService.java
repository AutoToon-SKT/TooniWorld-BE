package flyai.autotoon.toonidot.service;

import flyai.autotoon.toonidot.dto.*;
import flyai.autotoon.toonidot.entity.Info;
import flyai.autotoon.toonidot.entity.Story;
import flyai.autotoon.toonidot.repository.InfoRepository;
import flyai.autotoon.toonidot.repository.StoryRepository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

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

    @Transactional
    public Long updateStory(Long storyId, StoryUpdateRequestDto storyUpdateRequestDto){
        Story story = storyRepository.findById(storyId)
                .orElseThrow(()->new IllegalArgumentException("해당하는 이야기가 존재하지 않습니다. story_id = "+storyId));
        story.update(storyUpdateRequestDto.getStoryContent());
        return storyId;
    }


    @Transactional
    public AllStorySendResponseDto sendAllStory (Long userId, Long infoId, StorySaveRequestDto requestDto){
        Info info = infoRepository.findById(infoId)
                .orElseThrow(()->new IllegalArgumentException("해당 웹툰 정보가 존재하지 않습니다. info_id = " + infoId));

        String allStory = new String(
                        "누구와 : " + info.getPartner() + "\n"
                        + "장소 : " + info.getPlace() + "\n"
                        + "분위기 : " + info.getMood() + "\n"
                        + "날씨 : " + info.getWeather() + "\n"
                        + "그림체 : " + info.getToonStyle() + "\n"
                        + requestDto.getStoryContent());


        AllStorySendRequestDto allStorySendRequestDto = new AllStorySendRequestDto();
        allStorySendRequestDto.setAllStory(allStory);

        WebClient webclient = WebClient.builder().baseUrl("http://localhost:8000").build();
        AllStorySendResponseDto allStorySendResponseDto= webclient.post()
                .uri("/{userId}/{infoId}/allstory", userId, infoId)
                .bodyValue(allStorySendRequestDto)
                .retrieve()
                .bodyToMono(AllStorySendResponseDto.class)
                .block();


        return allStorySendResponseDto;
    }



}

