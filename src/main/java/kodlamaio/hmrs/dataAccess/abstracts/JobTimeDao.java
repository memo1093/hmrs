package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.JobTime;

public interface JobTimeDao extends JpaRepository<JobTime, Integer> {

}
