package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.JobPositionAdvertisement;
import kodlamaio.hmrs.entities.dtos.JobPositionAdvertisementDto;

public interface JobPositionAdvertisementService {
	DataResult<List<JobPositionAdvertisement>> getAll();
	DataResult<List<JobPositionAdvertisement>> getAllSorted();
	DataResult<List<JobPositionAdvertisement>> getByIsStillActiveTrue();
	DataResult<List<JobPositionAdvertisement>> getByIsStillActiveTrueAndByDate();
	DataResult<List<JobPositionAdvertisement>> getByIsStillActiveTrueAndCompanyName(String companyName);
	DataResult<List<JobPositionAdvertisement>> getByJobPosition(int id);
	DataResult<JobPositionAdvertisement> getById(int id);
	Result add(JobPositionAdvertisementDto jobPositionAdvertisementDto);
	Result changeApproveJobPositionAdvetisement(int jobAdvertisemementId);
	
}
