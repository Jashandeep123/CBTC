package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class guessing {

	private static JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guessing window = new guessing();
					window.frame.setVisible(true);
					frame.setSize(400, 350);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public guessing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label2 = new JLabel("Guess The Number");
		label2.setBackground(new Color(224, 255, 255));
		label2.setForeground(new Color(250, 250, 210));
		label2.setFont(new Font("Times New Roman", Font.BOLD, 28));
		label2.setBounds(71, 11, 250, 49);
		frame.getContentPane().add(label2);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the number between 1 and 100");
		lblNewLabel_1.setForeground(new Color(255, 215, 0));
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 81, 278, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Show the number");
		lblNewLabel_2.setForeground(new Color(139, 0, 0));
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		lblNewLabel_2.setBounds(71, 169, 132, 23);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBackground(new Color(152, 251, 152));
		textField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField.setBounds(288, 87, 86, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Guess");
		btnNewButton.setBackground(new Color(216, 191, 216));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num=Integer.parseInt(textField.getText());
				int num2=(int)(Math.random()*100 + 1);
				if(num==num2) {
					textField_2.setText("You guessed the correct number !!!");
				}
				else if(num+1==num2 || num-1==num2) {
					textField_2.setText("You were too close !!!");
				}
				else {
					textField_2.setText("You guessed the wrong number !!!");
				}
				textField_1.setText(Integer.toString(num2));
			}
		});
		btnNewButton.setBounds(142, 129, 100, 29);
		frame.getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setBackground(new Color(135, 206, 250));
		textField_1.setBounds(213, 169, 75, 29);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(0, 0, 205));
		textField_2.setBackground(new Color(245, 222, 179));
		textField_2.setBounds(10, 219, 364, 29);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Note : Maximum trial = 10.");
		lblNewLabel_4.setForeground(new Color(245, 255, 250));
		lblNewLabel_4.setFont(new Font("Monotype Corsiva", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(235, 364, 149, 17);
		frame.getContentPane().add(lblNewLabel_4);
	}
}
