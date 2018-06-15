import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
public class StormGUI extends JFrame{
	
	
	SendFileLogic sendFileLogic = new SendFileLogic();
	
	public JTextArea txtArea;
	public JButton btnRecvFile, btnSendFile;
	public JPanel recievePanel, sendPanel;
	public JTextField txtValidateID;
	public JLabel lblFileName, lblEnterPartnersId, lblChooseFile, lblFileSelected;
	public JButton btnValidateId;
	
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
		btnSendFile.setText("Select");
		btnSendFile.setBounds(10, 117, 120, 25);
		sendPanel.add(btnSendFile);
		btnSendFile.setEnabled(false);
		
		lblEnterPartnersId = new JLabel("Enter Partner's ID:");
		lblEnterPartnersId.setBounds(10, 23, 120, 14);
		sendPanel.add(lblEnterPartnersId);
		
		txtValidateID = new JTextField();
		txtValidateID.setBounds(10, 45, 86, 20);
		sendPanel.add(txtValidateID);
		txtValidateID.setColumns(10);
		
		btnValidateId = new JButton("Validate ID");
		btnValidateId.setBounds(148, 44, 126, 23);
		sendPanel.add(btnValidateId);
		
		lblChooseFile = new JLabel("Choose File:");
		lblChooseFile.setBounds(10, 96, 92, 14);
		sendPanel.add(lblChooseFile);
		
		lblFileSelected = new JLabel("File Selected:");
		lblFileSelected.setBounds(10, 153, 114, 14);
		sendPanel.add(lblFileSelected);
		
		lblFileName = new JLabel("");
		lblFileName.setBounds(107, 153, 105, 14);
		sendPanel.add(lblFileName);
		
		btnSendFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnSendFileActionPerformed(evt);
			}
			
		});
		
		// Gets ID Entered From Text Field
		btnValidateId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String inputID = txtValidateID.getText();
				setPin(evt, inputID);
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
		lblFileName.setText(file.getName());
	}
	
	// When Button Is Pressed:
		// - Checks For Empty or Non-Int Value Entered
		// - Makes Button Disabled
	private void setPin(ActionEvent evt, String inputPin) {
		String tmp = inputPin;
		if (inputPin.isEmpty()) {
			return;
		}else {
			btnSendFile.setEnabled(true);
		sendFileLogic.setPartnerID(tmp);
		}
	}
	
	private String getPin() {
		return sendFileLogic.getPartnerID();
	}
	
	private File getFile() {
		return sendFileLogic.getFile();
	}
	
	///Receive File Event Actions
	
	private void btnRecieveFileActionPerformed(ActionEvent evt){
		txtArea.setText("234893124");
	}
}
