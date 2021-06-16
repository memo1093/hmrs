package kodlamaio.hmrs.entities.dtos;

import java.time.LocalDate;

import javax.validation.constraints.Email;
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
public class CandidateDto {
	
	@NotBlank(message = "Email boş bırakılamaz")
	@NotNull(message = "Email boş bırakılamaz")
	@Email(message = "Lütfen geçerli bir email adresi giriniz")
	private String email;
	
	@NotBlank(message = "Şifre kısmı boş bırakılamaz")
	@NotNull(message = "Şifre kısmı boş bırakılamaz")
	private String password;
	
	@NotBlank(message="Şifre tekrarı kısmı boş bırakılamaz")
	@NotNull(message="Şifre tekrarı kısmı boş bırakılamaz")
	private String repassword;
	
	@NotNull(message="Ad kısmı boş bırakılamaz")
	@NotBlank(message="Ad kısmı boş bırakılamaz")
	@Length(min = 2,message = "Ad alanı minimum 2 karakter olmalıdır")
	private String firstName;
	
	@NotNull(message="Soyad kısmı boş bırakılamaz")
	@NotBlank(message="Soyad kısmı boş bırakılamaz")
	@Length(min = 2,message = "Soyad alanı minimum 2 karakter olmalıdır")
	private String lastName;
	
	@NotNull(message="Kimlik numarası mutlaka girilmelidir")
	@NotBlank(message="Kimlik numarası mutlaka girilmelidir")
	@Length(min = 11,max = 11,message = "Kimlik numarası 11 karakter olmalıdır")
	private String identityNumber;
	
	@NotNull(message="Doğum tarihi girilmelidir")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate birthDate;
	

}
