package kodlamaio.hmrs.business.abstracts;

import java.util.List;


import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.JobPositionAdvertisement;
import kodlamaio.hmrs.entities.dtos.JobPositionAdvertisementDto;

public interface JobPositionAdvertisementService {
	DataResult<List<JobPositionAdvertisement>> getAll(int pageNo, int pageSize,int cityId);
	DataResult<List<JobPositionAdvertisement>> getAllSorted(int pageNo, int pageSize);
	DataResult<List<JobPositionAdvertisement>> getByIsStillActiveTrue(int pageNo, int pageSize);
	DataResult<List<JobPositionAdvertisement>> getByIsStillActiveTrueAndByDate(int pageNo, int pageSize);
	DataResult<List<JobPositionAdvertisement>> getByIsStillActiveTrueAndCompanyName(int pageNo, int pageSize,String companyName);
	DataResult<List<JobPositionAdvertisement>> getByJobPosition(int pageNo, int pageSize,int id);
	DataResult<List<JobPositionAdvertisement>> getByIsStillActiveAndPositionIdSorted(int pageNo, int pageSize,List<Integer> positionIds);
	DataResult<List<JobPositionAdvertisement>> getAllIsStillActiveByCityIdAndPositionIdIn(int pageNo,int pageSize,int cityId,List<Integer> ids);
	
	DataResult<JobPositionAdvertisement> getById(int id);
	Result add(JobPositionAdvertisementDto jobPositionAdvertisementDto);
	Result changeApproveJobPositionAdvetisement(int jobAdvertisemementId);
	
}
