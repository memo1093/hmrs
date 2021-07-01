package kodlamaio.hmrs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "favorite_job_advertisements")

public class FavoriteJobAdvertisement {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	@Column(name = "id")
	private int id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	@ManyToOne
	@JoinColumn(name = "job_position_advertisement_id")
	private JobPositionAdvertisement jobPositionAdvertisement;

}
