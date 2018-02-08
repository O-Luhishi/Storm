import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class StormGUI extends JFrame{
	
	

	
	private JTextArea txtArea;
	private JButton btnRecvFile;
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
		
		sendPanel = new JPanel();
		tabbedPane.addTab("Send File", null, sendPanel, "Send Files From Here");
		sendPanel.setLayout(null);
		
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
	
	private void btnRecieveFileActionPerformed(ActionEvent evt){
		txtArea.setText("234893124");
	}
}
