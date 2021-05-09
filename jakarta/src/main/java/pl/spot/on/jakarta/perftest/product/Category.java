package pl.spot.on.jakarta.perftest.product;

import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String code;
    private String name;

    public Category(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
