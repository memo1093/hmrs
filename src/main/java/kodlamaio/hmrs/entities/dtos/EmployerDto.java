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
	private int id;
	
	@NotBlank(message = "Email boş bırakılamaz")
	@NotNull(message = "Email boş bırakılamaz")
	@Email(message = "Lütfen geçerli bir email adresi giriniz")
	private String email;
	
	private String password;
	
	private String repassword;

	@NotNull(message="Şirket adı kısmı boş bırakılamaz")
	@NotBlank(message="Şirket adı kısmı boş bırakılamaz")
	@Length(min = 2,message="Şirket adı kısmı minimum 2 karakter olmalıdır")
	private String companyName;
	
	@NotNull(message="Şirket internet adresi kısmı boş bırakılamaz")
	@NotBlank(message="Şirket internet adresi boş bırakılamaz")
	@Length(min = 3,message="Şirket internet adresi 3 karakterden az olamaz")
	@Pattern(regexp = "^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$",message = "Lütfen geçerli bir internet adresi giriniz")
	private String webAddress;
	
	@NotNull(message="Şirket telefon numarası boş bırakılamaz")
	@NotBlank(message="Şirket telefon numarası boş bırakılamaz")
	@Length(min = 10,max=10,message="Şirket telefon numarası 10 karakterli olmalıdır")
	private String phoneNumber;
	
	
	


}
