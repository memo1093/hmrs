package kodlamaio.hmrs.entities.dtos;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDto {
	@NotNull
	@NotBlank
	@Size(min = 2)
	private String companyName;
	
	@NotNull
	@NotNull
	@Email
	private String email;
	
	@NotNull
	@NotNull
	private String password;

	private String repassword;
	

	@NotNull
	@NotBlank
	@Size(min = 2)
	@Pattern(regexp = "[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)")
	private String webAddress;
	

	@NotNull
	@NotBlank
	@Size(min = 2)
	private String phoneNumber;
	


}
