package kodlamaio.hmrs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employees")
@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Employee extends User{
	@NotNull(message = "Ad kısmı boş bırakılamaz")
	@NotBlank(message = "Ad kısmı boş bırakılamaz")
	@Length(min = 2,message = "Ad kısmı min 2 karakter içermelidir")
	@Column(name="first_name")
	private String firstName;
	
	@NotNull(message = "Soyad kısmı boş bırakılamaz")
	@NotBlank(message = "Soyad kısmı boş bırakılamaz")
	@Length(min = 2,message = "Ad kısmı min 2 karakter içermelidir")
	@Column(name="last_name")
	private String lastName;
	
}
