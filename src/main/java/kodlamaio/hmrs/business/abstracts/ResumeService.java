package kodlamaio.hmrs.business.abstracts;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Graduation;
import kodlamaio.hmrs.entities.concretes.JobExperience;
import kodlamaio.hmrs.entities.concretes.Language;
import kodlamaio.hmrs.entities.concretes.Resume;
import kodlamaio.hmrs.entities.concretes.Talent;
import kodlamaio.hmrs.entities.concretes.WebAddress;
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
	DataResult<Resume> addOrUpdateResume(ResumeDto resumeDto);
	DataResult<Graduation> addOrUpdateGraduation(GraduationDto graduationDto);
	DataResult<JobExperience> addOrUpdateJobExperience(JobExperienceDto jobExperienceDto);
	DataResult<Talent> addOrUpdateTalent(TalentDto talentDto);
	DataResult<WebAddress> addOrUpdateWebAddress(WebAddressDto webAddressDto);
	DataResult<Language> addOrUpdateLanguage(LanguageDto languageDto);
	Result saveImage(MultipartFile file,int resumeId);
	
	Result deleteResume(int id);
	Result deleteGraduation(int graduationId);
	Result deleteTalent(int talentId);
	Result deleteLanguage(int languageId);
	Result deleteWebAddress(int webAddressId);
	Result deleteJobExperience(int jobExperienceId);
	
	
	
	
	
	
}
