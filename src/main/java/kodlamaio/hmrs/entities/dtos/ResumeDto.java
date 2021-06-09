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
public class ResumeDto {
	
	@NotBlank
	@NotNull
	@Size(min = 2)
	private String coverLetter;
	@NotBlank
	@NotNull
	@Size(min = 2)
	private String profilePicture;
	@Min(1)
	private int candidateId;
}
