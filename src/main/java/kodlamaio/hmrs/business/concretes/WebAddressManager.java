package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import kodlamaio.hmrs.business.abstracts.WebAddressService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.WebAddressDao;
import kodlamaio.hmrs.entities.concretes.WebAddress;

@Service
public class WebAddressManager implements WebAddressService {

	@Autowired
	private WebAddressDao webAddressDao;
	
	@Override
	public DataResult<List<WebAddress>> getByResumeId(@RequestParam int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<WebAddress>>(webAddressDao.getByResume_Id(id), "Özgeçmişe göre internet adreslerinin lislemesi başarılı!");
	}

	@Override
	public DataResult<WebAddress> add(WebAddress webAddress) {
		WebAddress savedWebAddress = webAddressDao.save(webAddress);
		return new SuccessDataResult<WebAddress>(savedWebAddress,"İnternet adresi kayıt işlemi başarılı!");
	}

	@Override
	public Result delete(int id) {
		webAddressDao.deleteById(id);
		return new SuccessResult("Web adresleri silindi!");
	}

}
