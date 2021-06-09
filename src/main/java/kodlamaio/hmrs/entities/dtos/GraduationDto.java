package kodlamaio.hmrs.entities.dtos;

import java.time.LocalDate;

import javax.validation.constraints.Min;
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
public class GraduationDto {
	
	@NotNull(message = "Okul adı boş bırakılamaz.")
	@NotBlank(message = "Okul adı boş bırakılamaz.")
	@Size(min = 2)
	private String schoolName;
	@NotNull(message = "Okul bölümü boş bırakılamaz.")
	@NotBlank(message = "Okul bölümü boş bırakılamaz.")
	@Size(min = 2)
	private String schoolDepartment;
	@NotNull(message = "Mezuniyet derecesi boş bırakılamaz.")
	@NotBlank(message = "Mezuniyet derecesi boş bırakılamaz.")
	@Size(min = 2)
	private String schoolDegree;
	private boolean stillStudying=false;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate startDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate endDate;
	@Min(1)
	private int resumeId;
	
}
