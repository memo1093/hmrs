package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.TalentService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.TalentDao;
import kodlamaio.hmrs.entities.concretes.Talent;

@Service
public class TalentManager implements TalentService {

	@Autowired
	private TalentDao talentDao;
	
	@Override
	public DataResult<List<Talent>> getByNameContains(String name) {
		
		return new SuccessDataResult<List<Talent>>(talentDao.getByNameContains(name));
	}

	@Override
	public Result add(Talent talent) {
		talentDao.save(talent);
		return new SuccessResult("Veri ekleme işlemi başarılı!");
	}

}
