package kodlamaio.hmrs.business.abstracts;


import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Resume;
import kodlamaio.hmrs.entities.dtos.GraduationDto;
import kodlamaio.hmrs.entities.dtos.JobExperienceDto;
import kodlamaio.hmrs.entities.dtos.LanguageDto;
import kodlamaio.hmrs.entities.dtos.ResumeDto;
import kodlamaio.hmrs.entities.dtos.TalentDto;
import kodlamaio.hmrs.entities.dtos.WebAddressDto;


public interface ResumeService {
	DataResult<List<Resume>> getAll();
	DataResult<Resume> getById(int id);
	DataResult<List<Resume>> getByCandidateId(int id);
	DataResult<List<Resume>> getByTalentName(String name);
	DataResult<List<Resume>> getByLanguageName(String name);
	DataResult<List<Resume>> getByGraduationDegree(String name);
	DataResult<List<Resume>> getByWorkedJobPosition(String name);
	
	Result add(Resume resume);
	Result addOrUpdateResume(ResumeDto resumeDto);
	Result addOrUpdateGraduation(GraduationDto graduationDto);
	Result addOrUpdateJobExperience(JobExperienceDto jobExperienceDto);
	Result addOrUpdateTalent(TalentDto talentDto);
	Result addOrUpdateWebAddress(WebAddressDto webAddressDto);
	Result addOrUpdateLanguage(LanguageDto languageDto);
	
	
	
	
	
	
}
