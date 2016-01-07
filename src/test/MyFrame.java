package test;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
public class MyFrame extends JFrame {
	private JTextField useridbox;
	private JTextField resultbox;
	public MyFrame() {
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Naver Band GetAuthCode");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Type User ID");
		lblNewLabel.setBounds(12, 10, 89, 21);
		getContentPane().add(lblNewLabel);
		
		useridbox = new JTextField();
		useridbox.setBounds(91, 10, 188, 21);
		getContentPane().add(useridbox);
		useridbox.setColumns(10);
		
		JButton btnNewButton = new JButton("\uC0DD\uC131");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String result = useridbox.getText().toString();//.getText().toString();
			
				if(result.equals(""))
				{
						JOptionPane.showMessageDialog(null,"데이터가 입력되지않았습니다");
				
				}
				else
					
				{
				
		
				}
			}
		});
		btnNewButton.setBounds(295, 9, 63, 23);
		getContentPane().add(btnNewButton);
		
		resultbox = new JTextField();
		resultbox.setText("no");
		resultbox.setEditable(false);
		resultbox.setBounds(53, 54, 226, 21);
		resultbox.setColumns(10);
		getContentPane().add(resultbox);
		
		setLocation(400, 130);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setBounds(12, 57, 35, 15);
		getContentPane().add(lblResult);
		
		JButton button = new JButton("\uBCF5\uC0AC");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String result = resultbox.getText().toString();
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				if(result.equals("no"))
				{
						JOptionPane.showMessageDialog(null,"User Not Logined");
				
				}
				else
					
				{JOptionPane.showMessageDialog(null,"Sucess");
				StringSelection contents = new StringSelection(result);
					clipboard.setContents(contents, null);
				}
			}
		});
		button.setBounds(295, 53, 63, 23);
		getContentPane().add(button);
		setVisible(true);
	}
}
