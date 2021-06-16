package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
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
import kodlamaio.hmrs.entities.dtos.JobPositionDto;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	private ModelMapper modelMapper;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao, ModelMapper modelMapper) {
		super();
		this.jobPositionDao = jobPositionDao;
		this.modelMapper = modelMapper;
	}

	

	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll(),"Veri çekme işlemi başarılı");
	}

	@Override
	public DataResult<JobPosition> get(int id) {
		if (id==0) {
			return new ErrorDataResult<JobPosition>(null,"Geçerli bir id girilmelidir!");
		}
		return new SuccessDataResult<JobPosition>(jobPositionDao.getOne(id),"Veri getirme işlemi başarılı!");
	}

	@Override
	public Result add(JobPositionDto jobPositionDto) {
		
		JobPosition jobPosition = modelMapper.map(jobPositionDto, JobPosition.class);
		List<JobPosition> data = jobPositionDao.findAll();
		for (JobPosition _jobPosition : data) {
			if (_jobPosition.getPosition().trim().toLowerCase().equals(jobPosition.getPosition().trim().toLowerCase()))
				return new ErrorResult("Böyle bir pozisyon zaten mevcut.");
				
		}
		jobPositionDao.save(jobPosition);
		
		return new SuccessResult(String.format("%s adlı pozisyonun kayıt işlemi başarılı!",jobPosition.getPosition()));
	}

	

	

	

}
