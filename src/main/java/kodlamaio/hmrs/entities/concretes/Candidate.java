package kodlamaio.hmrs.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resumes","webAddresses"})
@PrimaryKeyJoinColumn(name = "id")
public class Candidate extends User{
	
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="identity_number")
	private String identityNumber;
	@Column(name="birthdate")
	private LocalDate birthDate;
	@OneToMany(mappedBy="candidate",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Resume> resumes;
	@OneToMany(mappedBy="candidate",cascade=CascadeType.ALL, orphanRemoval = true)
	private List<WebAddress> webAddresses;
	
	
	 
}
