package kodlamaio.hmrs.entities.dtos;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDto {
	
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

	@NotNull(message="Şirket adı kısmı boş bırakılamaz")
	@NotBlank(message="Şirket adı kısmı boş bırakılamaz")
	@Length(min = 2,message="Şirket adı kısmı minimum 2 karakter olmalıdır")
	private String companyName;
	
	@NotNull(message="Şirket internet adresi kısmı boş bırakılamaz")
	@NotBlank(message="Şirket internet adresi boş bırakılamaz")
	@Length(min = 3,message="Şirket internet adresi 3 karakterden az olamaz")
	@Pattern(regexp = "[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)",message = "Lütfen geçerli bir internet adresi giriniz")
	private String webAddress;
	
	@NotNull(message="Şirket telefon numarası boş bırakılamaz")
	@NotBlank(message="Şirket telefon numarası boş bırakılamaz")
	@Length(min = 10,max=10,message="Şirket telefon numarası 10 karakterli olmalıdır")
	private String phoneNumber;
	


}
