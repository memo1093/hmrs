package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Talent;

public interface TalentService {
	DataResult<List<Talent>> getByNameContains(String name);
	Result add(Talent talent);
}