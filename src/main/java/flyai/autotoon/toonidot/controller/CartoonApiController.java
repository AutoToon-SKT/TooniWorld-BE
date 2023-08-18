package flyai.autotoon.toonidot.controller;

import flyai.autotoon.toonidot.dto.CartoonDto;
import flyai.autotoon.toonidot.service.CartoonService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/cartoons")
public class CartoonApiController {
    private final CartoonService cartoonService;

    public CartoonApiController(CartoonService cartoonService) {
        this.cartoonService = cartoonService;
    }

    @GetMapping("/{userId}")
    public List<CartoonDto> getUserCartoonsAndStories(@PathVariable Long userId){
        return cartoonService.getAllCartoonsAndStory(userId);
    }
}
