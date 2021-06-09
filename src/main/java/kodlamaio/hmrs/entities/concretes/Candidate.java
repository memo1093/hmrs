package kodlamaio.hmrs.entities.concretes;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="candidates")
@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resumes"})
@PrimaryKeyJoinColumn(name = "id")
public class Candidate extends User{
	@NotNull
	@NotBlank
	@Size(min = 2)
	@Column(name="first_name")
	private String firstName;
	
	@NotNull
	@NotBlank
	@Size(min = 2)
	@Column(name="last_name")
	private String lastName;
	
	@NotNull
	@NotBlank
	@Size(min = 11,max = 11)
	@Column(name="identity_number")
	private String identityNumber;
	
	@NotNull
	@NotBlank
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name="birthdate")
	private LocalDate birthDate;
	
	@JsonIgnore
	@OneToMany(mappedBy="candidate",cascade = CascadeType.ALL)
	private List<Resume> resumes;
	
	
	
	 
}
