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
public class JobExperienceDto {
	private int id;
	
	@NotBlank(message = "Şirket adı boş bırakılamaz")
	@NotNull(message = "Şirket adı boş bırakılamaz")
	@Length(min = 2,message = "Şirket adı minimum 2 karakter içermelidir")
	private String companyName;
	
	@NotBlank(message = "Pozisyon adı boş bırakılamaz")
	@NotNull(message = "Pozisyon adı boş bırakılamaz")
	private String position;
	
	@NotNull(message = "Başlangıç tarihi bırakılamaz")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate startDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate endDate;
	
	private boolean stillWorking;
	
	@Min(1)
	private int resumeId;
}
