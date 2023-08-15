package flyai.autotoon.toonidot.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
public class InfoUpdateRequestDto {

    private String toonName;

    private String place;

    private String partner;

    private String mood;

    private String weather;

    private String style;


    @Builder
    public InfoUpdateRequestDto( String toonName, String place,  String partner,
                               String mood, String weather, String style){
        this.toonName = toonName;
        this.place = place;
        this.partner = partner;
        this.mood = mood;
        this.weather = weather;
        this.style = style;
    }

}
