package kodlamaio.hmrs.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.json.JsonType;

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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPositionAdvertisements"})
@TypeDefs({
    @TypeDef(name = "json", typeClass = JsonType.class)
})
public class Employer extends User{
	
	@Column(name="company_name")
	private String companyName; 
	
	@Column(name="web_address")
	private String webAddress;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="company_picture")
	private String companyPicture;
	
	
	@Column(name="is_activated")
	private boolean isActivated=false;
	
	@OneToMany(mappedBy="employer",cascade = CascadeType.ALL)
	private List<JobPositionAdvertisement> jobPositionAdvertisements;
	
	@Type(type = "json")
	@Column(columnDefinition = "json",name = "updated_data")
	private Employer updatedData;
	
	
	
	
}
