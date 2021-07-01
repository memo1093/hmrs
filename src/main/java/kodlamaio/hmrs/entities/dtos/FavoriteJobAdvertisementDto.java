package kodlamaio.hmrs.entities.dtos;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FavoriteJobAdvertisementDto {
	
	@JsonIgnore
	private int id;
	
	@NotNull(message = "İş arayan alanı boş bırakılamaz")
	private int candidateId;
	
	@NotNull(message = "İş ilanı alanı boş bırakılamaz")
	private int jobPositionAdvertisementId;
}
