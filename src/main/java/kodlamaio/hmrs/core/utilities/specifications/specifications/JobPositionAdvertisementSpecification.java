package kodlamaio.hmrs.core.utilities.specifications.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import kodlamaio.hmrs.core.utilities.specifications.criterias.SearchCriteria;
import kodlamaio.hmrs.entities.concretes.JobPositionAdvertisement;

public class JobPositionAdvertisementSpecification implements Specification<JobPositionAdvertisement> {
	
	private SearchCriteria criteria;

	public JobPositionAdvertisementSpecification() {
		super();
	}

	public JobPositionAdvertisementSpecification(SearchCriteria criteria) {
		super();
		this.criteria = criteria;
	}

	@Override
	public Predicate toPredicate(Root<JobPositionAdvertisement> root, CriteriaQuery<?> query,
			CriteriaBuilder criteriaBuilder) {
		if (criteria.getOperation().equals("=") && criteria.getKey().equals("cityId")) {
			return criteriaBuilder.equal(root.get("city").get("id"), criteria.getValue());
		}
				
		return null;
	}
	
	

}
