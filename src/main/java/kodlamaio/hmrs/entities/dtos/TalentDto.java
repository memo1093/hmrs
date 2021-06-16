package kodlamaio.hmrs.entities.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TalentDto {
	@NotBlank(message = "Yetenek adı boş bırakılamaz")
	@NotNull(message = "Yetenek adı boş bırakılamaz")
	@Length(min=2,message = "Yetenek adı minimum 2 karakter olmalıdır.")
	private String name;
	
	@Min(1)
	private int resumeId;
}
