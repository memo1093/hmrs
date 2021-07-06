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
	public DataResult<Language> add(Language language) {
		
		Language savedLanguage =  languageDao.save(language);
		return new SuccessDataResult<Language>(savedLanguage,"Dil ekleme işlemi başarılı!");
	}

	@Override
	public DataResult<List<Language>> getByResumeId(int resumeId) {
		
		return new SuccessDataResult<List<Language>>(languageDao.getByResume_Id(resumeId), "Özgeçmişe göre dillerin getirilmesi işlemi başarılı!");
	}

	@Override
	public Result delete(int id) {
		languageDao.deleteById(id);
		return new SuccessResult("Dilleri silme işlemi başarılı!");
	}

	

}
