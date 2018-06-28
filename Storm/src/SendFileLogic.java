import java.io.File;
import java.awt.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class SendFileLogic {
	
	JFileChooser fileChooser = new JFileChooser();
	public SendFileLogic() {
		
	}
	
	public String PartnerID;

	public File getFile() {
		File selectedFile = null;
		//JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(fileChooser);
		if (result == JFileChooser.APPROVE_OPTION) {
		    selectedFile = fileChooser.getSelectedFile();
		} else {
			JOptionPane.showMessageDialog(fileChooser,
				    "Please choose a file.",
				    "No file selected",
				    JOptionPane.ERROR_MESSAGE);
		}
		return selectedFile;
	}
	
	
	
	public void setPartnerID(String PID) {
		PartnerID = PID;
	}
	
	public String getPartnerID() {
		return PartnerID;
	}
	
	public void sendFile(String hostName, String fileName) {
    	ClientLogic client = new ClientLogic(hostName, fileName);
    	client.runClient();
	}
	
	
//	public String getPin() {
//		boolean pinValid = false;
//		String pin = "";
//		while (pinValid == false) {
//			pin = JOptionPane.showInputDialog(this, "Please enter partner's ID");
//			if (pin == null || pin.isEmpty()) {
//				///In future add pin length checks to ensure a valid pin has been entered 
//				JOptionPane.showMessageDialog(
//					    null, "Please enter a valid PIN.",
//					    "Invalid PIN",
//					    JOptionPane.ERROR_MESSAGE);
//			} else {
//				pinValid = true;
//			}
//		}
//		return pin;
//		
//	}
	
	
}
