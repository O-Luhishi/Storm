import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.io.File;
public class StormGUI extends JFrame{


	SendFileLogic sendFileLogic = new SendFileLogic();
	RecieveFileLogic recieveFileLogic = new RecieveFileLogic();
	
	public String fName;
	public JButton btnRecvFile, btnSelectFile;
	public JPanel recievePanel, sendPanel;
	public JTextField txtValidateID;
	public JLabel lblFileName, lblEnterPartnersId, lblChooseFile, lblFileSelected, lblIPV4;
	public JButton btnSendFile;
	public JButton btnValidateId;
	private JButton btnGenerateIp;

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

		btnSelectFile = new JButton();
		btnSelectFile.setText("Select");
		btnSelectFile.setBounds(10, 117, 120, 25);
		sendPanel.add(btnSelectFile);
		btnSelectFile.setEnabled(false);

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

		btnSendFile = new JButton("Send File");
		btnSendFile.setBounds(157, 180, 117, 29);
		sendPanel.add(btnSendFile);

		// Action Once Select File Has Been Activated
		btnSelectFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnSelectFileActionPerformed(evt);
			}

		});
		
		// Action Event When Send File Button Is Selected
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
		btnRecvFile.setBounds(151, 164, 117, 25);
		recievePanel.add(btnRecvFile);
		
		btnGenerateIp = new JButton("Generate IP");
		btnGenerateIp.setBounds(22, 62, 117, 29);
		recievePanel.add(btnGenerateIp);
		
		lblIPV4 = new JLabel("");
        Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 1);
        lblIPV4.setBorder(border);
		lblIPV4.setBounds(221, 67, 95, 16);
		recievePanel.add(lblIPV4);

		btnRecvFile.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnRecieveFileActionPerformed(evt);
			}
		});
		
		btnGenerateIp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnGetIPV4AddressActionPerformed(evt);
			}
		});



	}

	///Send File Event Actions

	private void btnSelectFileActionPerformed(ActionEvent evt) {
		try {
			String pin = getPin();
			File file = getFile();
			setFileName(file.getAbsolutePath());
			String result = ("PIN: "+ pin + " File to upload: " + file.getAbsolutePath());
			JOptionPane.showMessageDialog(this, result);
			lblFileName.setText(file.getName());
		}catch (Exception e){
			System.out.println("ERROR: NO FILE SELECTED");
		}
	}


	// When Button Is Pressed:
	// - Checks For Empty or Non-Int Value Entered
	// - Makes Button Disabled
	private void setPin(ActionEvent evt, String inputPin) {
		String tmp = inputPin;
		if (inputPin.isEmpty()) {
			return;
		}else {
			btnSelectFile.setEnabled(true);
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

	// Try To Find File Name And Set It To A String From The Above Methods.
	private void setFileName(String fileName) {
		fName = fileName;
	}
	
	private String getFileName() {
		return fName;
	}

	private void btnSendFileActionPerformed(ActionEvent evt) {
		sendFileLogic.sendFile(getPin(), getFileName());
	}

	
	
	/**
	 * Receive File Event Actions
	 */

	private void btnGetIPV4AddressActionPerformed(ActionEvent evt) {
		
		String IP = recieveFileLogic.returnIPV4();
		lblIPV4.setText(IP);
	}
	
	
	private void btnRecieveFileActionPerformed(ActionEvent evt){
		recieveFileLogic.RecieveLogic();
		
	}
}
