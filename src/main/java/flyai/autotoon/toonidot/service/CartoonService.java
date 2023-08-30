package flyai.autotoon.toonidot.service;

import flyai.autotoon.toonidot.dto.CartoonResponseDto;
import flyai.autotoon.toonidot.dto.CartoonSaveResponseDto;
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
    public List<CartoonResponseDto> getCartoon(Long infoId) {
        List<Cartoon> cartoons = cartoonRepository.findByInfoInfoId(infoId);
        return cartoons.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private CartoonResponseDto mapToDTO(Cartoon cartoon){
        Info info = cartoon.getInfo();
        Hibernate.initialize(info);
        return CartoonResponseDto.builder()
                .toonCut(cartoon.getToonCut())
                .toonCutSubTitle(cartoon.getToonCutSubTitle())
                .toonOption(cartoon.getToonOption())
                .cartoonURL(cartoon.getCartoonURL())
                .build();
    }


}
