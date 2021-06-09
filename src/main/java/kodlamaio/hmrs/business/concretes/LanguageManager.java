package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.LanguageService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.LanguageDao;
import kodlamaio.hmrs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	@Autowired
	private LanguageDao languageDao;

	@Override
	public DataResult<List<Language>> getByLanguageContains(String name) {
		
		return new SuccessDataResult<List<Language>>(languageDao.getByLanguageContains(name),"Dile göre özgeçmiş listesi getirme işlemi başarılı!") ;
	}

	@Override
	public Result add(Language language) {
		
		languageDao.save(language);
		return new SuccessResult("Dil ekleme işlemi başarılı!");
	}

}
