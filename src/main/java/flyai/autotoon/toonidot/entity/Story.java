package flyai.autotoon.toonidot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storyId;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "infoId")//없으면 두개 생성 가능
    private Info info;

    @Column(nullable = false)
    private String storyContent;
}
