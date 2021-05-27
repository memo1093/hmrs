package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate,Integer>{

}
