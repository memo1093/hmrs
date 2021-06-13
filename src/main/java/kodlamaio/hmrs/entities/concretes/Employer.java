package kodlamaio.hmrs.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employers")
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")

public class Employer extends User{
	@NotNull
	@NotBlank
	@Size(min = 2)
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_address")
	@NotNull
	@NotBlank
	@Size(min = 2)
	private String webAddress;
	
	@Column(name="phone_number")
	@NotNull
	@NotBlank
	@Size(min = 10,max=10)
	private String phoneNumber;
	
	@Pattern(regexp = "[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)",message = "Type of address does not match.")
	@Column(name="company_picture")
	private String companyPicture;
	
	
	@Column(name="is_activated")
	private boolean isActivated=false;
	
	
	@OneToMany(mappedBy="employer",cascade = CascadeType.ALL)
	private List<JobPositionAdvertisement> jobPositionAdvertisements;
}
