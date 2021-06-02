package kodlamaio.hmrs.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="graduations")
public class Graduation {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="school_name")
	private String schoolName;
	@Column(name="school_department")
	private String schoolDepartment;
	@Column(name="school_degree")
	private String schoolDegree;
	@Column(name="still_studying")
	private boolean stillStudying;
	@Column(name="start_date")
	private LocalDate startDate;
	@Column(name="end_date")
	private LocalDate endDate;
	@ManyToOne
	@JoinColumn(name="resume_id")
	private Resume resume;
	
	
}
