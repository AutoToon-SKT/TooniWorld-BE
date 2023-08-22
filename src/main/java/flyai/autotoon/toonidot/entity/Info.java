package flyai.autotoon.toonidot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


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

    @Column(nullable = false)
    private LocalDateTime toonDate;

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
    @OneToOne(mappedBy = "info")
    private Cartoon cartoon;

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
