package kodlamaio.hmrs.entities.dtos;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class GraduationDto {
	
	@NotNull(message = "Okul adı boş bırakılamaz")
	@NotBlank(message = "Okul adı boş bırakılamaz")
	@Length(min = 2,message = "Okul adı minimum 2 haneli olmalıdır")
	private String schoolName;
	
	@NotNull(message = "Okul bölümü boş bırakılamaz")
	@NotBlank(message = "Okul bölümü boş bırakılamaz")
	@Length(min = 2)
	private String schoolDepartment;
	
	@NotNull(message = "Mezuniyet derecesi boş bırakılamaz")
	@NotBlank(message = "Mezuniyet derecesi boş bırakılamaz")
	@Length(min = 2,message="Mezuniyet derece adı minimum 2 haneli olmalıdır")
	private String schoolDegree;
	
	private boolean stillStudying;
	@NotNull(message = "Başlangıç tarihi boş bırakılamaz")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate startDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate endDate;
	@Min(1)
	private int resumeId;
	
}
