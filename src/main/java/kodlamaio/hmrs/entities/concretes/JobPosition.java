package kodlamaio.hmrs.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="job_positions")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPositionAdvertisements"})
public class JobPosition {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="position")
	private String position;
	@OneToMany(mappedBy="jobPosition")
	List<JobPositionAdvertisement> jobPositionAdvertisements;
	
}	
