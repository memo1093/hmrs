package kodlamaio.hmrs.entities.concretes;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="job_position_advertisements")
@AllArgsConstructor
@NoArgsConstructor

public class JobPositionAdvertisement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="min_salary")
	private BigDecimal minSalary;
	
	@Column(name="max_salary")
	private BigDecimal maxSalary;
	
	
	@Column(name="active_positions")
	private int activePositions;
	

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name="last_application_date")
	private LocalDate lastApplicationDate;
	
	@JsonIgnore
	@Column(name="is_still_active")
	private boolean isStillActive=true;
	
	@JsonIgnore
	@Column(name="is_approved")
	private boolean isApproved=false;
	

	@CreatedDate
	@Column(name="release_date")
	private LocalDate releaseDate =LocalDate.now();
	
	
	@ManyToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	
	@ManyToOne
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name="job_types_id")
	private JobType jobType;
	
	@ManyToOne
	@JoinColumn(name="job_times_id")
	private JobTime jobTime;
	
	
	

}
