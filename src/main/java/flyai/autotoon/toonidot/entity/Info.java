package flyai.autotoon.toonidot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
    private String style;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    // OneToOne은 컬렉션 타입 안됨
    @JsonManagedReference
    @OneToOne(mappedBy = "info")
    private Webtoon webtoon;

    @JsonManagedReference
    @OneToOne(mappedBy = "info")
    private Story story;

}
