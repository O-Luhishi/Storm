import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class ClientLogic {
		private Socket socket;
		
		private String hostName;
		private String fileName;
		
		// Host And File Passed Through The UI - Port Automatically Assigned
		public ClientLogic(String host, String file) {
			hostName = host;
			fileName = file;
		}
		
		public void runClient() {
			try {
				socket = new Socket(hostName, 1988);
				sendFile(fileName);
		    		System.out.println("Running");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void sendFile(String file) throws IOException{
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			FileInputStream fis = new FileInputStream(file);
			byte[] buffer = new byte[4096];
			
			while (fis.read(buffer) > 0) {
				dos.write(buffer);
			}
			fis.close();
			dos.close();
		}
		
		
	    public static void main(String[] args) throws IOException {
	    	ClientLogic client = new ClientLogic("192.168.0.102", "/Users/oluhishi/Documents/osama-compute.txt");
	    	client.runClient();
	    }
	}
