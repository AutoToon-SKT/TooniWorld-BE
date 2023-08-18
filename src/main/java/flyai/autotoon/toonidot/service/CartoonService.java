package flyai.autotoon.toonidot.service;

import flyai.autotoon.toonidot.dto.CartoonDto;
import flyai.autotoon.toonidot.entity.Cartoon;
import flyai.autotoon.toonidot.entity.Info;
import flyai.autotoon.toonidot.repository.CartoonRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CartoonService {
    private final CartoonRepository cartoonRepository;

    @Transactional
    public List<CartoonDto> getAllCartoonsAndStory(Long userID){
        List<Cartoon> cartoons = cartoonRepository.findByInfoUserUserId(userID);
        return cartoons.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private CartoonDto mapToDTO(Cartoon cartoon){
        Info info = cartoon.getInfo();
        Hibernate.initialize(info);
        return CartoonDto.builder()
                .infoId(cartoon.getCartoonId())
                .cartoonURL(cartoon.getCartoonURL())
                .storyContent(cartoon.getInfo().getStory().getStoryContent())
                .build();
    }
}
