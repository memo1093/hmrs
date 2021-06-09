package kodlamaio.hmrs.entities.dtos;

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
public class TalentDto {
	@NotBlank
	@NotNull
	@Size(min=2)
	private String name;
	@Min(1)
	private int resumeId;
}
