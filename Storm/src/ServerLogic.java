
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * This class serves as the Server for the FTP program. 
 * This will look for any incoming connections on the server.
 * Once a connection has been established it will expect the client to send over data through sockets.
 */

public class ServerLogic extends Thread {
	
	private ServerSocket ss;
	
	public ServerLogic() {
		
	}
	
	public void ServerLogics(int port) {
		try {
			ss = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("SERVER STOPPED");
		}
	}
	
	public void run() {
		while (true) {
			try {
				Socket clientSock = ss.accept();
				saveFile(clientSock);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("SERVER STOPPED");
			}
		}
	}

	// This takes the file and send them over the network on an exposed 32 bit connection as bits
	// Then used to be saved by the client and makes sure each bit is not lost 
	// TO WORK ON: THE FILE NEEDS TO BE SENT AS ITS OWN PROGRAMMED PROTOCOL:
				// - SO THAT WE CAN ALLOW THE NAME TO BE SENT OVER THE NETWORK AS OPPOSED TO MANUALLY ENTERING IT
				// - FILE SIZE DOES NOT GET AFFETCED SO THAT BIGGER FILES DO NOT HAVE WORSE AFFECTS.
	private void saveFile(Socket clientSock) throws IOException {
		DataInputStream dis = new DataInputStream(clientSock.getInputStream());
		FileOutputStream fos = new FileOutputStream("D:\\My Document\\testfile.txt");
		byte[] buffer = new byte[4096];
		
		int filesize = 15123; // Send file size in separate msg
		int read = 0;
		int totalRead = 0;
		int remaining = filesize;
		while((read = dis.read(buffer, 0, Math.min(buffer.length, remaining))) > 0) {
			totalRead += read;
			remaining -= read;
			System.out.println("read " + totalRead + " bytes.");
			fos.write(buffer, 0, read);
		}
		
		fos.close();
		dis.close();
	}
	
	// Runs the server through the use of threads - Make Sure To Test On Individual PC
	public void runServer() {
		ServerLogics(1988);
		start();
		System.out.print("Server Is Running");
	}

}
