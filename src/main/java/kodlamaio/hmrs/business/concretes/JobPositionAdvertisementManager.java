package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.JobPositionAdvertisementService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.JobPositionAdvertisementDao;
import kodlamaio.hmrs.entities.concretes.JobPositionAdvertisement;
import kodlamaio.hmrs.entities.dtos.JobPositionAdvertisementDto;

@Service
public class JobPositionAdvertisementManager implements JobPositionAdvertisementService{

	private JobPositionAdvertisementDao jobPositionAdvertisementDao;
	private ModelMapper modelMapper;

	
	@Autowired
	public JobPositionAdvertisementManager(JobPositionAdvertisementDao jobPositionAdvertisementDao,
			ModelMapper modelMapper) {
		super();
		this.jobPositionAdvertisementDao = jobPositionAdvertisementDao;
		this.modelMapper = modelMapper;
	}

	

	@Override
	public DataResult<List<JobPositionAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobPositionAdvertisement>>(jobPositionAdvertisementDao.findAll(),"Veri listeleme başarılı!");
	}

	@Override
	public Result add(JobPositionAdvertisementDto jobPositionAdvertisementDto) {
		
		JobPositionAdvertisement jobPositionAdvertisement = modelMapper.map(jobPositionAdvertisementDto, JobPositionAdvertisement.class);
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

	@Override
	public DataResult<List<JobPositionAdvertisement>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"releaseDate");
		return new SuccessDataResult<List<JobPositionAdvertisement>>(jobPositionAdvertisementDao.findAll(sort),"Veri listeleme başarılı!");
	}

	@Override
	public DataResult<JobPositionAdvertisement> getById(int id) {
		
		return new SuccessDataResult<JobPositionAdvertisement>(jobPositionAdvertisementDao.findById(id).get(),"İş ilanları listeleme işlemi başarılı!");
	}

	@Override
	public Result changeApproveJobPositionAdvetisement(int id) {
		JobPositionAdvertisement jobPositionAdvertisement= jobPositionAdvertisementDao.getOne(id);
		jobPositionAdvertisement.setApproved(!jobPositionAdvertisement.isApproved());
		jobPositionAdvertisementDao.save(jobPositionAdvertisement);
		return new SuccessResult("İş ilanı onay durumu '"+jobPositionAdvertisement.isApproved()+"' olarak değiştirildi!");
	}



	@Override
	public DataResult<List<JobPositionAdvertisement>> getByJobPosition(int id) {
		
		return new SuccessDataResult<List<JobPositionAdvertisement>>(jobPositionAdvertisementDao.getByJobPosition_Id(id),"Id ye göre verilerin getirme işlemi başarılı!");
	}
	

	

	

}
