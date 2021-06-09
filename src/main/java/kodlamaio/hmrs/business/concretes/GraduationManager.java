package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.GraduationService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.GraduationDao;
import kodlamaio.hmrs.entities.concretes.Graduation;

@Service
public class GraduationManager implements GraduationService {
	
	private GraduationDao graduationDao;

	@Autowired
	public GraduationManager(GraduationDao graduationDao) {
		super();
		this.graduationDao = graduationDao;
	}

	@Override
	public DataResult<List<Graduation>> getBySchoolNameContains(String schoolName) {
		
		return new SuccessDataResult<List<Graduation>>(this.graduationDao.getBySchoolNameContains(schoolName));
	}

	@Override
	public DataResult<List<Graduation>> getBySchoolDegree(String degree) {
	
		return new SuccessDataResult<List<Graduation>>(this.graduationDao.getBySchoolDegree(degree));
	}

	@Override
	public DataResult<List<Graduation>> getBySchoolDepartment(String department) {
		
		return new SuccessDataResult<List<Graduation>>(this.graduationDao.getBySchoolDegree(department));
	}

	@Override
	public DataResult<List<Graduation>> getByStillStudyingFalse() {
		
		return new SuccessDataResult<List<Graduation>>(this.graduationDao.getByStillStudyingFalse());
	}

	@Override
	public DataResult<List<Graduation>> getByStillStudyingTrue() {
		
		return new SuccessDataResult<List<Graduation>>(this.graduationDao.getByStillStudyingTrue());
	}

	@Override
	public DataResult<List<Graduation>> getByEndDate() {
		
		return new SuccessDataResult<List<Graduation>>(this.graduationDao.getByEndDate());
	}


	@Override
	public Result add(Graduation graduation) {
		
		graduationDao.save(graduation);
		return new SuccessResult("Okul bilgisi giriş işlemi başarılı!");
	}

}
