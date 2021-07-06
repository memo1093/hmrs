package kodlamaio.hmrs.entities.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebAddressDto {
	private int id;
	
	
	private String linkedInAddress;
	
	private String githubAddress;
	
	private String twitterAddress;
	
	private String anotherAddress;
	
	private String anotherAddress2;
	@Min(2)
	private int resumeId;
}
