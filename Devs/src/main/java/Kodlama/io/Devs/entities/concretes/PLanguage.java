package Kodlama.io.Devs.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "planguage")
public class PLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int progId;
    @Column(name = "name")
    private String progName;

    @OneToMany(mappedBy = "pLanguage", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Framework> frameworks;

}
