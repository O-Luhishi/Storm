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
			
			while (fis.read(buffer) > 0) {
				dos.write(buffer);
			}
			fis.close();
			dos.close();
		}
		
		
	    public static void main(String[] args) throws IOException {
	    	Client client = new Client("localhost", 1988, "D:\\My Document\\cat.txt");
	    }
	}

