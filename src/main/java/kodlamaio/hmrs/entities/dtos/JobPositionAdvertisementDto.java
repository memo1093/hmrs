package kodlamaio.hmrs.entities.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPositionAdvertisementDto {
	
	
	private int id;
		
	@NotNull(message = "Açıklama kısmı boş bırakılamaz")
	@Length(min = 10,message = "Açıklama kısmı 10 karakterden fazla olmalıdır")
	private String description;
	
	
	private BigDecimal minSalary;
	
	
	private BigDecimal maxSalary;
	
	@NotNull(message = "Aktif pozisyon bırakılamaz")
	@Min(1)
	private int activePositions;
	
	@NotNull(message = "İlan sahibi kısmı bırakılamaz")
	@Min(1)
	private int employerId;
	
	@NotNull(message = "Pozisyon kısmı boş bırakılamaz")
	@Min(1)
	private int jobPositionId;
	
	@NotNull(message = "Şehir boş bırakılamaz")
	@Min(1)
	private int cityId;
	
	@NotNull(message = "Çalışma tipi bırakılamaz")
	@Min(1)
	private int jobTypeId;
	
	@NotNull(message = "Çalışma zamanı bırakılamaz")
	@Min(1)
	private int jobTimeId;
	
	@NotNull(message = "Son başvuru tarihi bırakılamaz")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate lastApplicationDate;
	
	
	
}
