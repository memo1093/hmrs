package kodlamaio.hmrs.entities.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	private int id;
	
	@NotBlank(message = "Email boş bırakılamaz")
	@NotNull(message = "Email boş bırakılamaz")
	@Email(message = "Lütfen geçerli bir email adresi giriniz")
	private String email;
	
	
	private String password;
	
	
	private String repassword;
	
	@NotNull(message="Ad kısmı boş bırakılamaz")
	@NotBlank(message="Ad kısmı boş bırakılamaz")
	@Length(min = 2,message = "Ad alanı minimum 2 karakter olmalıdır")
	private String firstName;
	
	@NotNull(message="Soyad kısmı boş bırakılamaz")
	@NotBlank(message="Soyad kısmı boş bırakılamaz")
	@Length(min = 2,message = "Soyad alanı minimum 2 karakter olmalıdır")
	private String lastName;
	
}
