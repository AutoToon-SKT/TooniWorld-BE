package flyai.autotoon.toonidot.controller;

import flyai.autotoon.toonidot.dto.CartoonResponseDto;
import flyai.autotoon.toonidot.dto.CartoonSaveResponseDto;
import flyai.autotoon.toonidot.dto.SuccessResponse;
import flyai.autotoon.toonidot.exception.Success;
import flyai.autotoon.toonidot.service.CartoonService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class CartoonApiController {
    private final CartoonService cartoonService;
    @GetMapping("/{infoId}/cartoon")
    public SuccessResponse<List<CartoonResponseDto>> getCartoon(@PathVariable Long infoId){
        return SuccessResponse.success(Success.GET_CARTOONS_SUCCESS,cartoonService.getCartoon(infoId));
    }

}
