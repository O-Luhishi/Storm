import java.net.UnknownHostException;

import javax.swing.JFrame;
public class Main {

	public static void main(String[] args) throws UnknownHostException {
		
		// Calling GUI Class & Setting Size Of The Screen	
		StormGUI mainFrame = new StormGUI();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(460,300);
		mainFrame.setVisible(true);
	

		
	}

}
