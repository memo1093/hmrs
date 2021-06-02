package kodlamaio.hmrs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="web_addresses")
public class WebAddress {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
 private int id;
	@Column(name="linkedin_address")
 private String linkedInAddress;
	@Column(name="github_address")
 private String githubAddress;
	@Column(name="twitter_address")
 private String twitterAddress;
	@Column(name="another_address")
 private String anotherAddress;
	@Column(name="another_address_2")
 private String anotherAddress2;
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
}
