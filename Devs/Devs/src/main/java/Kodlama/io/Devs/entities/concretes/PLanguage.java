package Kodlama.io.Devs.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "planguage")
public class PLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prog_id", nullable = false)
    private int progId;
    @Column(name = "prog_name")
    private String progName;
    @Column(name = "prog_description")
    private String progDescription;


}
