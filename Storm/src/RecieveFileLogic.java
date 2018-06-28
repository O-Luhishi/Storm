import java.net.Inet4Address;
import java.net.UnknownHostException;

public class RecieveFileLogic {

	public RecieveFileLogic() {
		
	}
	
	public void RecieveLogic() {
		ServerLogic srvrLogic = new ServerLogic();
		srvrLogic.runServer();
		
	}
	
	public String returnIPV4() {
		try {
			return Inet4Address.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println("CHECK INTERNET CONNECTION");
		}
		return null;
	}
	
}
