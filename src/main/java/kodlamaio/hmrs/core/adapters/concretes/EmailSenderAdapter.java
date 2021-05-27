package kodlamaio.hmrs.core.adapters.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hmrs.core.adapters.abstracts.EmailSenderService;

@Service
public class EmailSenderAdapter implements EmailSenderService{

	@Override
	public void sendEmail(String uuid) {
		System.out.println(String.format("%s aktivasyon kodu yollandı!", uuid));
		
	}

}
