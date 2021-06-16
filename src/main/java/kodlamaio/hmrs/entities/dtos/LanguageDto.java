package kodlamaio.hmrs.entities.dtos;

import javax.validation.constraints.Max;
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
public class LanguageDto {

	@NotNull(message = "Dil kısmı boş bırakılamaz")
	@NotBlank(message = "Dil kısmı boş bırakılamaz")
	@Length(min = 2,message = "")
	private String language;
	
	@NotNull(message = "Derece kısmı boş bırakılamaz")
	@NotBlank(message = "Derece kısmı boş bırakılamaz")
	@Min(value = 1,message = "Derece 1-5 arasında olmalıdır")
	@Max(value = 5,message = "Derece 1-5 arasında olmalıdır")
	private int rate;
	
	@Min(1)
	private int resumeId;
}
