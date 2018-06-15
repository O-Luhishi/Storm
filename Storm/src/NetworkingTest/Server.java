package NetworkingTest;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
	
	private ServerSocket ss;
	
	public Server(int port) {
		try {
			ss = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		while (true) {
			try {
				Socket clientSock = ss.accept();
				saveFile(clientSock);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void saveFile(Socket clientSock) throws IOException {
		DataInputStream dis = new DataInputStream(clientSock.getInputStream());
		FileOutputStream fos = new FileOutputStream("testfile.jpg");
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
	
	public static void main(String[] args) {
		Server fs = new Server(1988);
		fs.start();
	}

}



//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//public class Server {
//
//	
//	
//	public static void main(String[] args) throws IOException{
//		ServerSocket serverSocket = null;
//
//        try {
//            serverSocket = new ServerSocket(4444);
//        } catch (IOException ex) {
//            System.out.println("Can't setup server on this port number. ");
//        }
//
//        Socket socket = null;
//        InputStream in = null;
//        OutputStream out = null;
//
//        try {
//            socket = serverSocket.accept();
//        } catch (IOException ex) {
//            System.out.println("Can't accept client connection. ");
//        }
//
//        try {
//            in = socket.getInputStream();
//        } catch (IOException ex) {
//            System.out.println("Can't get socket input stream. ");
//        }
//
//        try {
//            out = new FileOutputStream("M:\\test2.xml");
//        } catch (FileNotFoundException ex) {
//            System.out.println("File not found. ");
//        }
//
//        byte[] bytes = new byte[16*1024];
//
//        int count;
//        while ((count = in.read(bytes)) > 0) {
//            out.write(bytes, 0, count);
//        }
//
//        out.close();
//        in.close();
//        socket.close();
//        serverSocket.close();
//    }
//
//		
//	}
//	
//
