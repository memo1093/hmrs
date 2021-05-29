package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.JobPositionAdvertisementService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.JobPositionAdvertisementDao;
import kodlamaio.hmrs.entities.concretes.JobPositionAdvertisement;

@Service
public class JobPositionAdvertisementManager implements JobPositionAdvertisementService{

	private JobPositionAdvertisementDao jobPositionAdvertisementDao;	
	
	@Autowired
	public JobPositionAdvertisementManager(JobPositionAdvertisementDao jobPositionAdvertisementDao) {
		super();
		this.jobPositionAdvertisementDao = jobPositionAdvertisementDao;
	}

	@Override
	public DataResult<List<JobPositionAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobPositionAdvertisement>>(jobPositionAdvertisementDao.findAll(),"Veri listeleme başarılı!");
	}

	@Override
	public Result add(JobPositionAdvertisement jobPositionAdvertisement) {
		
		jobPositionAdvertisementDao.save(jobPositionAdvertisement);
		return new SuccessResult("Veri kaydetme işlemi başarılı");
	}

	@Override
	public DataResult<List<JobPositionAdvertisement>> getByIsStillActiveTrue() {
		
		return new SuccessDataResult<List<JobPositionAdvertisement>>(jobPositionAdvertisementDao.getByIsStillActiveTrue(),"Veri listeleme başarılı!");
	}

	@Override
	public DataResult<List<JobPositionAdvertisement>> getByIsStillActiveTrueAndByDate() {
		
		return new SuccessDataResult<List<JobPositionAdvertisement>>(jobPositionAdvertisementDao.getByIsStillActiveTrueAndReleaseDate(),"Veri listeleme başarılı!");
	}

	@Override
	public DataResult<List<JobPositionAdvertisement>> getByIsStillActiveTrueAndCompanyName(String companyName) {
		
		return new SuccessDataResult<List<JobPositionAdvertisement>>(jobPositionAdvertisementDao.getByIsStillActiveTrueAndEmployer_companyNameContains(companyName),"Veri listeleme başarılı");
	}

	

	

}
