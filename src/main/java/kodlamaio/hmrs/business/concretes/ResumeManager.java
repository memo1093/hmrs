package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.ResumeService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorDataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.GraduationDao;
import kodlamaio.hmrs.dataAccess.abstracts.LanguageDao;
import kodlamaio.hmrs.dataAccess.abstracts.ResumeDao;
import kodlamaio.hmrs.dataAccess.abstracts.TalentDao;
import kodlamaio.hmrs.entities.concretes.Graduation;
import kodlamaio.hmrs.entities.concretes.Language;
import kodlamaio.hmrs.entities.concretes.Resume;
import kodlamaio.hmrs.entities.concretes.Talent;

@Service
public class ResumeManager implements ResumeService {
    
	private ResumeDao resumeDao;
	private GraduationDao graduationDao;
	private TalentDao talentDao;
	private LanguageDao languageDao;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao, GraduationDao graduationDao, TalentDao talentDao,
			LanguageDao languageDao) {
		super();
		this.resumeDao = resumeDao;
		this.graduationDao = graduationDao;
		this.talentDao = talentDao;
		this.languageDao = languageDao;
	}

	@Override
	public Result Add(Resume resume) {
		//if (!resume.getGraduations().isEmpty()) {
//		for (Graduation graduation : resume.getGraduations()) {
//			graduationDao.save(graduation);
//			
//			}
//		//}
//		if (!resume.getLanguages().equals(null)) {
//			for (Language language : resume.getLanguages()) {
//				languageDao.save(language);
//				
//			}
//		}
//		if (!resume.getTalents().equals(null)) {
//			for (Talent talent : resume.getTalents()) {
//				talentDao.save(talent);
//				
//			}
//		}
		resumeDao.save(resume);
		
		return new SuccessResult("Özgeçmiş girişi başarılı!");
	}

	@Override
	public DataResult<List<Resume>> getByCandidateId(int id) {
		if (id==0) {
			return new ErrorDataResult<List<Resume>>(null, "Veri getirme başarısız. Lütfen id yi kontrol ediniz.");
		}
		return new SuccessDataResult<List<Resume>>(resumeDao.getByCandidate_Id(id),"Veri listeleme başarılı!");
	}

}
