package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import kodlamaio.hmrs.entities.filters.JobPositionAdvertisementFilter;

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
	public DataResult<List<JobPositionAdvertisement>> getAll(int pageNo,int pageSize,int cityId) {
		
		//JobPositionAdvertisementSpecification spec1 = new JobPositionAdvertisementSpecification(new SearchCriteria("cityId","=","6"));
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobPositionAdvertisement>>(jobPositionAdvertisementDao.findAll(),"Veri listeleme başarılı!");
	}

	@Override
	public Result add(JobPositionAdvertisementDto jobPositionAdvertisementDto) {
		
		JobPositionAdvertisement jobPositionAdvertisement = modelMapper.map(jobPositionAdvertisementDto, JobPositionAdvertisement.class);
		jobPositionAdvertisementDao.save(jobPositionAdvertisement);
		return new SuccessResult("Veri kaydetme işlemi başarılı");
	}

	@Override
	public DataResult<List<JobPositionAdvertisement>> getByIsStillActiveTrue(int pageNo,int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobPositionAdvertisement>>(jobPositionAdvertisementDao.findAllByIsStillActiveTrue(pageable),"Veri listeleme başarılı!");
	}

	@Override
	public DataResult<List<JobPositionAdvertisement>> getByIsStillActiveTrueAndByDate(int pageNo,int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobPositionAdvertisement>>(jobPositionAdvertisementDao.findAllByIsStillActiveTrueAndReleaseDate(pageable),"Veri listeleme başarılı!");
	}

	@Override
	public DataResult<List<JobPositionAdvertisement>> getByIsStillActiveTrueAndCompanyName(int pageNo,int pageSize,String companyName) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobPositionAdvertisement>>(jobPositionAdvertisementDao.findAllByIsStillActiveTrueAndEmployer_companyNameContains(pageable,companyName),"Veri listeleme başarılı");
	}

	@Override
	public DataResult<Page<JobPositionAdvertisement>> getAllSorted(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize,Sort.by(Sort.Direction.DESC,"releaseDate"));
	
		return new SuccessDataResult<Page<JobPositionAdvertisement>>(jobPositionAdvertisementDao.findAll(pageable),"Veri listeleme başarılı!");
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
	public DataResult<List<JobPositionAdvertisement>> getByJobPosition(int pageNo,int pageSize,int id) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobPositionAdvertisement>>(jobPositionAdvertisementDao.findAllByJobPosition_Id(pageable,id),"Id ye göre verilerin getirme işlemi başarılı!");
	}



	@Override
	public DataResult<List<JobPositionAdvertisement>> getByIsStillActiveAndPositionIdSorted(int pageNo,int pageSize,List<Integer> positionIds) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobPositionAdvertisement>>(jobPositionAdvertisementDao.findAllByIsStillActiveTrueAndJobPosition_idIn(pageable,positionIds));
	}



	@Override
	public DataResult<List<JobPositionAdvertisement>> getAllIsStillActiveByCityIdAndPositionIdIn(int pageNo,int pageSize,
			int cityId, List<Integer> ids) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return new SuccessDataResult<List<JobPositionAdvertisement>>(jobPositionAdvertisementDao.findAllByCity_IdOrJobPosition_IdIn(pageable,cityId,ids));
	}



	@Override
	public DataResult<Page<JobPositionAdvertisement>> getByFilterWithPages(JobPositionAdvertisementFilter jobAdvertisementFilter,
			int pageNo, int pageSize) {
	
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return new SuccessDataResult<Page<JobPositionAdvertisement>>(jobPositionAdvertisementDao.getByFilter(jobAdvertisementFilter, pageable));
	}


	
	

	

	

}
