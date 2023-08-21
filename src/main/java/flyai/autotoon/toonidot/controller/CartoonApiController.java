package flyai.autotoon.toonidot.controller;

import flyai.autotoon.toonidot.dto.CartoonSaveResponseDto;
import flyai.autotoon.toonidot.service.CartoonService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/cartoons")
@RequiredArgsConstructor
public class CartoonApiController {
    private final CartoonService cartoonService;

    @GetMapping("/{userId}")
    public List<CartoonSaveResponseDto> getUserCartoonsAndStories(@PathVariable Long userId){
        return cartoonService.getAllCartoonsAndStory(userId);
    }
}
