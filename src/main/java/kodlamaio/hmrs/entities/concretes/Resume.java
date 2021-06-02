package kodlamaio.hmrs.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","graduations","languages","talents"})
@AllArgsConstructor
@NoArgsConstructor
@Table(name="resumes")
public class Resume {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="cover_letter")
	private String coverLetter;
	@Column(name="created_at")
	private LocalDate createdAt=LocalDate.now();
	@OneToMany(mappedBy="resume")
	private List<Graduation> graduations;
	@OneToMany(mappedBy="resume")
	private List<Language> languages;
	@OneToMany(mappedBy="resume")
	private List<Talent> talents;
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
}
