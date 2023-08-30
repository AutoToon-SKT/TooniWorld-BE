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
public class Cartoon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartoonId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "infoId")
    private Info info;

    @Column(nullable = false)
    private Long toonCut; //컷 분별 위함 - 한개의 만화에 4개의 컷 생성

    @Column(nullable = false)
    private String toonCutSubTitle; //각 컷별 소제목

    @Column(nullable = false)
    private Long toonOption; //컷별 사용자가 선택할 이미지 (컷마다 3개)

    @Column(nullable = false)
    private String cartoonURL;

    public void setInfo(Info info) {
        this.info = info;
    }

    public void setCartoonURL(String cartoonURL) {
        this.cartoonURL = cartoonURL;
    }
}
