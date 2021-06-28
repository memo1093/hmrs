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
public class ResumeDto {

	private int id;
	
	@NotBlank(message = "Başlık boş bırakılamaz")
	@NotNull(message = "Başlık boş bırakılamaz")
	@Length(min = 3,message = "Başlık minimum 3 karakter içermelidir")
	private String title;
	
	@NotBlank(message = "Özet bilgi boş bırakılamaz")
	@NotNull(message = "Özet bilgi boş bırakılamaz")
	@Length(min = 10,message = "Özet bilgi minimum 10 karakter içermelidir")
	private String coverLetter;
	
	@NotBlank(message = "Özet bilgi boş bırakılamaz")
	@NotNull(message = "Özet bilgi boş bırakılamaz")
	@Length(min = 2,message = "Özet bilgi minimum 2 karakter içermelidir")
	private String profilePicture;
	
	@Min(1)
	private int candidateId;
}
