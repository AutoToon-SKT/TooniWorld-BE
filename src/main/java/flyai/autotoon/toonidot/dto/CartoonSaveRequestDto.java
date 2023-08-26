package flyai.autotoon.toonidot.dto;

import flyai.autotoon.toonidot.entity.Cartoon;
import flyai.autotoon.toonidot.entity.Info;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@NoArgsConstructor
public class CartoonSaveRequestDto {

    private Long toonCut;
    private String toonCutSubtitle;
    private Long toonOption;
    @Setter
    private String cartoonURL;
    @Setter
    private MultipartFile cartoonFile;
    @Builder
    public CartoonSaveRequestDto(MultipartFile cartoonFile,
                                 Long toonCut, String toonCutSubtitle, Long toonOption,
                                 String cartoonURL) {
        this.cartoonFile = cartoonFile;
        this.toonCut=toonCut;
        this.toonCutSubtitle=toonCutSubtitle;
        this.toonOption=toonOption;
        this.cartoonURL = cartoonURL;
    }

    public Cartoon toEntity(Info info){
        return Cartoon.builder()
                .info(info)
                .toonCut(toonCut)
                .toonCutSubTitle(toonCutSubtitle)
                .toonOption(toonOption)
                .cartoonURL(cartoonURL)
                .build();
    }

}
