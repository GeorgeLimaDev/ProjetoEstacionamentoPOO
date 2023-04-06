package Interface;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SairCarro {

	private JFrame frame;
	private JLabel label;
	private JButton button;
	private JLabel label_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SairCarro window = new SairCarro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SairCarro() {
		initialize();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Impede o fechamento de outras janelas
		}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Registrar saída de veículos");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label = new JLabel("Informe qual vaga será desocupada:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(67, 28, 360, 46);
		frame.getContentPane().add(label);
		
		button = new JButton("Registrar saída");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Apenas um teste para ver a interação
				
				try {
					int entrarvaga = Integer.parseInt(textField.getText());
										if(entrarvaga == 2)
						label_1.setText("ok");
					else
						label_1.setText("Não é esse :p");
					}
			
				catch(NumberFormatException e1) {
					label_1.setText("erro");
				}
			}
		});
		
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(153, 153, 142, 40);
		frame.getContentPane().add(button);
		
		label_1 = new JLabel("Resultado:");
		label_1.setBounds(55, 191, 354, 31);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setBounds(153, 88, 142, 52);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
