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
    @JoinColumn(name = "infoId",unique = true) //중복생성 막기위해 unique값 설정
    private Info info;

    @Column(nullable = false)
    private String cartoonURL;

    public void setInfo(Info info) {
        this.info = info;
    }

    public void setCartoonURL(String cartoonURL) {
        this.cartoonURL = cartoonURL;
    }
}
