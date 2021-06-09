package kodlamaio.hmrs.entities.concretes;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@JsonIgnore
	private int id;
	
	@NotNull
	@NotBlank
	@Size(min = 2)
	@Column(name="school_name")
	private String schoolName;
	
	@NotNull
	@NotBlank
	@Size(min = 2)
	@Column(name="school_department")
	private String schoolDepartment;
	
	@NotNull
	@NotBlank
	@Size(min = 2)
	@Column(name="school_degree")
	private String schoolDegree;	
	
	@Column(name="still_studying")
	private boolean stillStudying=false;
	
	@NotNull
	@NotBlank
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name="start_date")
	private LocalDate startDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name="end_date")
	private LocalDate endDate;
	
	
	@ManyToOne
	@JoinColumn(name="resume_id")
	private Resume resume;
	
	
}
