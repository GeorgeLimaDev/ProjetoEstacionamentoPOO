import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;

public class Interface2 {

	private JFrame frame;
	private JLabel label;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel label_1;
	private JButton button;
	
	private Estacionamento estacionamento;
	private JLabel label_2;
	private JButton button_1;
	private JButton button_2;
	private JLabel label_3;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel label_4;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface2 window = new Interface2();
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
	public Interface2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//Criando o objeto estacionamento
			try {
				estacionamento = new Estacionamento(10);	//10 vagas
		 
			}catch (Exception e) {System.out.println("exceção0--->"+e.getMessage());}
				
				
		frame = new JFrame();
		frame.setTitle("Estacionamento2");
		frame.setBounds(100, 100, 608, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label = new JLabel("Placa:");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(87, 22, 68, 39);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(157, 24, 96, 39);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(375, 24, 96, 39);
		frame.getContentPane().add(textField_1);
		
		label_1 = new JLabel("Vaga:");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(312, 22, 68, 39);
		frame.getContentPane().add(label_1);
		
		//Permite registro de entrada de veículos
		
		//Algumas exception não possuem texto, fica estranho 
		
		
		button = new JButton("Entrar Veículo");
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String placaVaga = textField.getText();
					int numerovaga = Integer.parseInt(textField_1.getText());
					estacionamento.entrar(placaVaga,numerovaga);
					label_2.setText("Entrada registrada");
				}
				catch (Exception e1) {label_2.setText(e1.getMessage());}
			}
							
		});
		button.setBounds(50, 72, 147, 45);
		frame.getContentPane().add(button);
		
		label_2 = new JLabel("");
		label_2.setBounds(87, 314, 419, 39);
		frame.getContentPane().add(label_2);
		
		//Permite registro de saída de veículos
		button_1 = new JButton("Sair Veículo");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					int numerovaga = Integer.parseInt(textField_1.getText());
					estacionamento.sair(numerovaga);
					label_2.setText("Saída registrada");
				}
				catch (Exception e1) {label_2.setText(e1.getMessage());}
				}
						
			
		});
		button_1.setBounds(207, 73, 147, 42);
		frame.getContentPane().add(button_1);
		
		//Permite consultar em qual vaga está o veículo de determinada placa
		
		//Aqui o localPlaca é um inteiro, para colocar no label a solução foi transformar em string. Tem forma melhor?
		
		//Precisa de try catch nesse caso? já que não possui exception. E como tratar o -1, deixa assim? Ele aparece, se der "erro"
		
		button_2 = new JButton("Consultar Placa");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String placaVaga = textField.getText();
					int localPlaca = estacionamento.consultarPlaca(placaVaga);
					String localPlaca2 = Integer.toString(localPlaca);
					label_2.setText("O veículo de placa " + placaVaga + " está na vaga " + localPlaca2);
					}
				catch (Exception e1) {label_2.setText("localPlaca");}
			}
				
			
		});
		button_2.setBounds(362, 71, 144, 42);
		frame.getContentPane().add(button_2);
		
		label_3 = new JLabel("Vaga origem:");
		label_3.setForeground(new Color(255, 255, 255));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(60, 127, 107, 51);
		frame.getContentPane().add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(167, 135, 96, 39);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(385, 135, 96, 39);
		frame.getContentPane().add(textField_3);
		
		label_4 = new JLabel("Vaga destino:");
		label_4.setForeground(new Color(255, 255, 255));
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(283, 127, 107, 51);
		frame.getContentPane().add(label_4);
		
		//Permite transferir o veículo de vaga
		button_3 = new JButton("Transferir Veículo");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					int vagaOrigem = Integer.parseInt(textField_2.getText());
					int vagaDestino = Integer.parseInt(textField_3.getText());
					
					estacionamento.transferir(vagaOrigem,vagaDestino);
					label_2.setText("Transferência registrada");
				}
				catch (Exception e1) {label_2.setText(e1.getMessage());}
				
			}
		});
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_3.setBounds(217, 184, 167, 45);
		frame.getContentPane().add(button_3);
		
		//Permite listar as vagas, informa se está livre e, se não, informa a placa do carro da vaga
		//Não tem expetion, removemos o try/catch?
		button_4 = new JButton("Listar Vagas");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {						
					String sitVagas = "";
																				
					for(String s : estacionamento.listarGeral()) {
						sitVagas += s + " ";
					}
					label_2.setText("Vagas: " + sitVagas);
				}
				catch (Exception e1) {label_2.setText(e1.getMessage());}
				
			}
		});
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_4.setBounds(37, 259, 119, 45);
		frame.getContentPane().add(button_4);
		
		
		
		
		//Permite listar as vagas livres
		button_5 = new JButton("Listar Vagas Livres");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {						
					String vagasLivres = "";
																				
					for(int i : estacionamento.listarLivres()) {
						vagasLivres += i + " ";
					}
					label_2.setText("Vagas livres: " + vagasLivres);
				}
				catch (Exception e1) {label_2.setText(e1.getMessage());}
			}
					
		});
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_5.setBounds(157, 259, 163, 45);
		frame.getContentPane().add(button_5);
		
		
		//Não sei se está funcionando, não testei bem esse
		button_6 = new JButton("Gravar Dados");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					estacionamento.gravarDados();
					label_2.setText("Dados gravados.");
				}
				catch (Exception e1) {label_2.setText(e1.getMessage());}
				
				
			}
		});
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_6.setBounds(321, 259, 119, 45);
		frame.getContentPane().add(button_6);
		
		
		//Não sei se está funcionando, não testei bem esse!
		button_7 = new JButton("Ler Dados");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					estacionamento.lerDados();
					label_2.setText("Dados lidos?????");
				}
				catch (Exception e1) {label_2.setText(e1.getMessage());}
				
			}
		});
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_7.setBounds(442, 259, 107, 45);
		frame.getContentPane().add(button_7);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 64));
		panel.setBounds(24, 10, 531, 111);
		frame.getContentPane().add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 64));
		panel_1.setBounds(24, 127, 531, 111);
		frame.getContentPane().add(panel_1);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 64));
		panel_2.setBounds(24, 249, 531, 63);
		frame.getContentPane().add(panel_2);
	}
}
