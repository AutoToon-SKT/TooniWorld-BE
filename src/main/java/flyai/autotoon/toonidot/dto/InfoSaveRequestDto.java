package flyai.autotoon.toonidot.dto;

import flyai.autotoon.toonidot.entity.Info;
import flyai.autotoon.toonidot.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class InfoSaveRequestDto {

    private String toonName;

    private String place;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime toonDate;

    private String partner;

    private String mood;

    private String weather;

    private String style;


    @Builder
    public InfoSaveRequestDto( String toonName, String place, LocalDateTime toonDate, String partner,
                                    String mood, String weather, String style){
        this.toonName = toonName;
        this.place = place;
        this.toonDate = toonDate;
        this.partner = partner;
        this.mood = mood;
        this.weather = weather;
        this.style = style;
    }

    public Info toEntity(User user) {
        return Info.builder()
                .user(user)
                .toonName(toonName)
                .place(place)
                .toonDate(toonDate)
                .partner(partner)
                .mood(mood)
                .weather(weather)
                .style(style)
                .build();
    }
}
