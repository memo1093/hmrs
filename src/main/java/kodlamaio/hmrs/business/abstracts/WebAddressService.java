package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.WebAddress;

public interface WebAddressService {
	DataResult<List<WebAddress>> getByResumeId(int id);
	Result add(WebAddress webAddress);
}
