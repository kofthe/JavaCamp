package Kodlama.io.Devs.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="frameworks")
@Entity
public class Framework {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "framework_id")
	private int id;
	@Column(name = "framework_name")
	private String frameworkName;

	@ManyToOne
	@JoinColumn(name = "id")
	private PLanguage pLanguage;

}
