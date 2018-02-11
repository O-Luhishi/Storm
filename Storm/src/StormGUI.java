import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
public class StormGUI extends JFrame{
	
	
	RecieveFileLogic recieveFileLogic = new RecieveFileLogic();
	
	private JTextArea txtArea;
	private JButton btnRecvFile, btnSendFile;
	private JPanel recievePanel, sendPanel;
	
	public StormGUI(){
		super("Storm");
		setVisible(true);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		
		createGui();
	}
	
	public void createGui(){
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		tabbedPane.setBounds(0, 0, 444, 261);
		getContentPane().add(tabbedPane);
		
		///Send Panel Interface 
		
		sendPanel = new JPanel();
		tabbedPane.addTab("Send File", null, sendPanel, "Send Files From Here");
		sendPanel.setLayout(null);
		
		btnSendFile = new JButton();
		btnSendFile.setText("Send File");
		btnSendFile.setBounds(10, 50, 120, 25);
		sendPanel.add(btnSendFile);
		
		btnSendFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnSendFileActionPerformed(evt);
			}
		});
		
		///Receive Panel Interface 
		
		recievePanel = new JPanel();
		tabbedPane.addTab("Recieve File", null, recievePanel, "Recieve File From Here");
		recievePanel.setLayout(null);
		
		btnRecvFile = new JButton();
		btnRecvFile.setText("Recieve File");
		btnRecvFile.setBounds(12, 54, 117, 25);
		recievePanel.add(btnRecvFile);
		
		txtArea = new JTextArea();
		txtArea.setText("Test");
		txtArea.setBounds(247, 40, 100, 105);
		recievePanel.add(txtArea);
		
		btnRecvFile.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnRecieveFileActionPerformed(evt);
			}
		});

		
		
	}
	
	///Send File Event Actions
	
	private void btnSendFileActionPerformed(ActionEvent evt) {
		String pin = getPin();
		File file = getFile();
		String result = ("PIN: "+ pin + " File to upload: " + file.getAbsolutePath());
		JOptionPane.showMessageDialog(this, result);
	}
	
	private String getPin() {
		return recieveFileLogic.getPin();
	}
	
	private File getFile() {
		return recieveFileLogic.getFile();
	}
	
	///Receive File Event Actions
	
	private void btnRecieveFileActionPerformed(ActionEvent evt){
		txtArea.setText("234893124");
	}
}
