package kodlamaio.hmrs.entities.dtos;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPositionDto {

	private int id;
	
	@NotBlank(message = "Pozisyon ismi boş bırakılamaz")
	@NotNull(message = "Pozisyon ismi boş bırakılamaz")
	@Length(min = 2,message = "Pozisyon adı en az iki karakter içermelidir")
	private String position;
	
}
