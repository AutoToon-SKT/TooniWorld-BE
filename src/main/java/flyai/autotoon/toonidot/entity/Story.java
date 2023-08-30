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
    @JoinColumn(name = "infoId", unique = true)//없으면 두개 생성 가능
    private Info info;

    @Column(nullable = false, length=2000)
    private String storyContent;

    @Column(nullable = true)
    private String storyFirst;

    @Column(nullable = true)
    private String storySecond;

    @Column(nullable = true)
    private String storyThird;

    @Column(nullable = true)
    private String storyFourth;


    public void update(String storyContent, String storyFirst, String storySecond,
                       String storyThird, String storyFourth){
        this.storyContent=storyContent;
        this.storyContent = storyContent;
        this.storyFirst = storyFirst;
        this.storySecond = storySecond;
        this.storyThird = storyThird;
        this.storyFourth = storyFourth;
    }
}
