package kodlamaio.hmrs.entities.filters;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPositionAdvertisementFilter {
	private LocalDate date;
	
	private List<Integer> cityId;
	
	private List<Integer> jobPositionId;
	
	private List<Integer> jobTypeId;
	
	private List<Integer> jobTimeId;
}
