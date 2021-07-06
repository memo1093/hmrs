package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Language;

public interface LanguageService {
	DataResult<List<Language>> getByLanguageContains(String name);
	DataResult<List<Language>> getByResumeId(int resumeId);
	
	DataResult<Language> add(Language language);
	Result delete(int id);
}
