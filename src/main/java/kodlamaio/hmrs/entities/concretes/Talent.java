package kodlamaio.hmrs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="talents")
public class Talent {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@NotNull
	@NotBlank
	@Column(name="name")
	private String name;
	@ManyToOne
	@JoinColumn(name="resume_id")
	private Resume resume;
}
