package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.EmployerActivationByEmployee;

public interface EmployerActivationByEmployeeDao extends JpaRepository<EmployerActivationByEmployee,Integer>{

}
