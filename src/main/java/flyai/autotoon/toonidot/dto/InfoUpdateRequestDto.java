package flyai.autotoon.toonidot.dto;

import lombok.Builder;
import lombok.Getter;


@Getter
public class InfoUpdateRequestDto {

    private String toonName;

    private String place;

    private String partner;

    private String mood;

    private String weather;

    private String toonStyle;


    @Builder
    public InfoUpdateRequestDto( String toonName, String place,  String partner,
                               String mood, String weather, String toonStyle){
        this.toonName = toonName;
        this.place = place;
        this.partner = partner;
        this.mood = mood;
        this.weather = weather;
        this.toonStyle = toonStyle;
    }

}
