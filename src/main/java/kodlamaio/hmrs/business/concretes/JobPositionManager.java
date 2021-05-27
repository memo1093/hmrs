package kodlamaio.hmrs.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.JobPositionService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorDataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hmrs.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
		
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll(),"Veri çekme işlemi başarılı");
	}

	@Override
	public DataResult<Optional<JobPosition>> get(int id) {
		if (id==0) {
			return new ErrorDataResult<Optional<JobPosition>>(null,"Geçerli bir id girilmelidir!");
		}
		return new SuccessDataResult<Optional<JobPosition>>(jobPositionDao.findById(id),"Veri getirme işlemi başarılı!");
	}

	@Override
	public Result add(JobPosition entity) {
		List<JobPosition> data = jobPositionDao.findAll();
		for (JobPosition jobPosition : data) {
			if (jobPosition.getPosition().trim().toLowerCase().equals(entity.getPosition().trim().toLowerCase()))
				return new ErrorResult("Böyle bir pozisyon zaten mevcut.");
				
		}
		jobPositionDao.save(entity);
		
		return new SuccessResult(String.format("%s adlı pozisyonun kayıt işlemi başarılı!",entity.getPosition()));
	}

	

	

	

}
