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

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_times")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPositionAdvertisements"})
public class JobTime {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="type")
	private String type;
	@OneToMany(mappedBy = "jobTime")
	private List<JobPositionAdvertisement> jobPositionAdvertisements;

}
