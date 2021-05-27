package kodlamaio.hmrs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

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
	@Column(name="company_name")
	private String companyName;
	@Column(name="web_address")
	private String webAddress;
	@Column(name="phone_number")
	private String phoneNumber;
	@Column(name="is_activated",columnDefinition = "boolean default false")
	private boolean isActivated;
}
