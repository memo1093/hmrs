package kodlamaio.hmrs.entities.concretes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="resumes")
public class Resume {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@JsonIgnore
	private int id;
	
	@NotNull
	@NotBlank
	@Column(name="cover_letter")
	private String coverLetter;
	
	@JsonIgnore
	@Column(name="created_at")
	private LocalDate createdAt = LocalDate.now();
	
	@Column(name="profile_picture")
	private String profilePicture;
	
	@JsonIgnoreProperties("resume")
	@OneToMany(mappedBy="resume",cascade = CascadeType.ALL)
	private List<Graduation> graduations=new ArrayList<Graduation>();
	
	@JsonIgnoreProperties("resume")
	@OneToMany(mappedBy="resume",cascade = CascadeType.ALL)
	private List<Language> languages=new ArrayList<Language>();
	
	@JsonIgnoreProperties("resume")
	@OneToMany(mappedBy="resume",cascade = CascadeType.ALL)
	private List<Talent> talents=new ArrayList<Talent>();
	
	@JsonIgnoreProperties("resume")
	@OneToMany(mappedBy="resume",cascade = CascadeType.ALL)
	private List<WebAddress> webAddresses=new ArrayList<WebAddress>();
	
	@JsonIgnoreProperties("resume")
	@OneToMany(mappedBy="resume",cascade = CascadeType.ALL)
	private List<JobExperience> jobExperiences=new ArrayList<JobExperience>();
	
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
}
