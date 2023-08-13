package flyai.autotoon.toonidot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Webtoon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long webtoonId;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "infoId")
    private Info info;

    @Column
    private String webtoonURL;
}
