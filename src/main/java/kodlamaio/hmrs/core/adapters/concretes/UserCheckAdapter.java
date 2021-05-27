package kodlamaio.hmrs.core.adapters.concretes;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import kodlamaio.hmrs.core.adapters.abstracts.UserCheckService;
import kodlamaio.hmrs.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;


@Service
public class UserCheckAdapter implements UserCheckService{

	@Override
	public boolean checkUser(Candidate user) {
		//java.lang.NoClassDefFoundError: Could not initialize class org.apache.axis.client.AxisClient error 
//		KPSPublicSoapProxy client = new KPSPublicSoapProxy(); //Service does not works correctly... 
//		long identityNumber = Long.parseLong(user.getIdentityNumber());
//		boolean result=false;
//		try {
//			result=client.TCKimlikNoDogrula(
//						identityNumber, 
//						user.getFirstName().toUpperCase(), 
//						user.getLastName().toUpperCase(), 
//						user.getBirthDate().getYear());
//		} catch (NumberFormatException e) {
//			System.out.println(String.format("Something went wrong!", e.getMessage()));
//		} catch (RemoteException e) {
//			System.out.println(String.format("Something went wrong!", e.getMessage()));
//		}
		return true;	
		 
	}

	
	
}
