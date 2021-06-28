package kodlamaio.hmrs.core.utilities.specifications.criterias;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteria {
	private String key;
    private String operation;
    private Object value;
    
}
