package kodlamaio.hmrs.entities.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPositionAdvertisementDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@NotBlank
	@Size(min = 10)
	private String description;
	
	@Column(name="min_salary")
	private BigDecimal minSalary;
	
	@Column(name="max_salary")
	private BigDecimal maxSalary;
	
	@NotNull
	@NotBlank
	private int activePositions;
	@NotNull
	@NotBlank
	private int employerId;
	@NotNull
	@NotBlank
	private int jobPositionId;
	@NotNull
	@NotBlank
	private int cityId;
	@NotNull
	@NotBlank
	@Size(min=1,max=2)
	private int jobTypeId;
	@NotNull
	@NotBlank
	@Size(min=1,max=2)
	private int jobTimeId;
	
	@NotNull
	@NotBlank
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate lastApplicationDate;
	
	
	
}
