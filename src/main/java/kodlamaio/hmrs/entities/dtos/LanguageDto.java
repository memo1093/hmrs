package kodlamaio.hmrs.entities.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageDto {

	@NotNull
	@NotBlank
	@Size(min = 2)
	private String language;
	@NotNull
	@Min(value = 1,message = "Derece 1-5 arasında olmalıdır.")
	@Max(value = 5,message = "Derece 1-5 arasında olmalıdır.")
	private int rate;
	@Min(1)
	private int resumeId;
}
