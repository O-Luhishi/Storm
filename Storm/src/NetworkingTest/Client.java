package NetworkingTest;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class Client {
		private Socket socket;
		
		public Client(String host, int port, String file) {
			try {
				socket = new Socket(host, port);
				sendFile(file);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void sendFile(String file) throws IOException{
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			FileInputStream fis = new FileInputStream(file);
			byte[] buffer = new byte[4096];
			
	    	System.out.println("[STATUS] : Running Process");
			while (fis.read(buffer) > 0) {
				dos.write(buffer);
			}
			fis.close();
			dos.close();
	    	System.out.println("[STATUS] : Process Completed");
		}
		
		
	    public static void main(String[] args) throws IOException {
	    	System.out.println("[STATUS] : Sending Over File From Client To Server");
	    	Client client = new Client("192.168.0.102", 1988, "/Users/oluhishi/Documents/osama-compute.txt");
	    }
	}

