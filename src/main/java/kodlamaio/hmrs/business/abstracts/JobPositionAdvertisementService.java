package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.JobPositionAdvertisement;

public interface JobPositionAdvertisementService {
	DataResult<List<JobPositionAdvertisement>> getAll();
	DataResult<List<JobPositionAdvertisement>> getAllSorted();
	DataResult<List<JobPositionAdvertisement>> getByIsStillActiveTrue();
	DataResult<List<JobPositionAdvertisement>> getByIsStillActiveTrueAndByDate();
	DataResult<List<JobPositionAdvertisement>> getByIsStillActiveTrueAndCompanyName(String companyName);
	DataResult<JobPositionAdvertisement> getById(int id);
	Result add(JobPositionAdvertisement jobPositionAdvertisement);
	Result changeApproveJobPositionAdvetisement(int jobAdvertisemementId);
	
}
