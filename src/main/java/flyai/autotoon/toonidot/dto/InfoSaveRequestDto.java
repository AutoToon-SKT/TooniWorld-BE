package flyai.autotoon.toonidot.dto;

import flyai.autotoon.toonidot.entity.Info;
import flyai.autotoon.toonidot.entity.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class InfoSaveRequestDto {

    private String toonName;

    private String place;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate toonDate;

    private String partner;

    private String mood;

    private String weather;

    private String toonStyle;


    @Builder
    public InfoSaveRequestDto(String toonName, String place, LocalDate toonDate, String partner,
                              String mood, String weather, String toonStyle){
        this.toonName = toonName;
        this.place = place;
        this.toonDate = toonDate;
        this.partner = partner;
        this.mood = mood;
        this.weather = weather;
        this.toonStyle = toonStyle;
    }


    public Info toEntity(Users users) {
        return Info.builder()
                .users(users)
                .toonName(toonName)
                .place(place)
                .toonDate(toonDate)
                .partner(partner)
                .mood(mood)
                .weather(weather)
                .toonStyle(toonStyle)
                .build();
    }
}
