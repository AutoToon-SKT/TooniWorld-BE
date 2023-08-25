package flyai.autotoon.toonidot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long infoId;

    @Column(nullable = false)
    private String toonName;

    @Column(nullable = false)
    private String place;

    @Column(nullable = true)
    private LocalDate toonDate;

    @Column(nullable = true)
    private String partner;

    @Column(nullable = true)
    private String mood;

    @Column(nullable = true)
    private String weather;

    @Column(nullable = false)
    private String toonStyle;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "userId")
    private Users users;


    // OneToOne은 컬렉션 타입 안됨
    @JsonManagedReference
    @OneToMany(mappedBy = "info")
    private List<Cartoon> cartoonList = new ArrayList <>();

    @JsonManagedReference
    @OneToOne(mappedBy = "info")
    private Story story;

    public void update(String toonName, String place, String partner, String mood, String weather,String toonStyle){
        this.toonName = toonName;
        this.place = place;
        this.partner = partner;
        this.mood = mood;
        this.weather = weather;
        this. toonStyle = toonStyle;
    }

}
