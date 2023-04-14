

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

//Grupo: Amanda Cruz de Araújo, George Barbosa de Lima, Ian Ribeiro de Mendonça.

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class Interface2 {

	private JFrame frame;
	private JLabel label_placa;
	private JTextField Placa;
	private JTextField Vaga;
	private JLabel label_vaga;
	private JButton button_entrar;
	
	private Estacionamento estacionamento;
	private JLabel label_mensagens;
	private JButton button_sair;
	private JButton button_consultar;
	private JLabel label_vagaOrigem;
	private JTextField VagaOrigem;
	private JTextField VagaDestino;
	private JLabel label_vagaDestino;
	private JButton button_transferir;
	private JButton button_listarVagas;
	private JButton button_listarVagasLivres;
	//private JButton button_gravarDados;
	//private JButton button_lerDados;
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
				estacionamento = new Estacionamento(10);	//estacionamento com 10 vagas
				estacionamento.lerDados();					//Lendo os dados registrados
				System.out.println("Dados lidos");
		 
			}catch (Exception e) {System.out.println("exceção0--->"+e.getMessage());}
				
		frame = new JFrame();
		frame.setTitle("Estacionamento");
		frame.setBounds(100, 100, 608, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label_placa = new JLabel("Placa:");
		label_placa.setForeground(new Color(255, 255, 255));
		label_placa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_placa.setBounds(87, 22, 68, 39);
		frame.getContentPane().add(label_placa);
		
		Placa = new JTextField();
		Placa.setBounds(157, 24, 96, 39);
		frame.getContentPane().add(Placa);
		Placa.setColumns(10);
		
		Vaga = new JTextField();
		Vaga.setColumns(10);
		Vaga.setBounds(375, 24, 96, 39);
		frame.getContentPane().add(Vaga);
		
		label_vaga = new JLabel("Vaga:");
		label_vaga.setForeground(new Color(255, 255, 255));
		label_vaga.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_vaga.setBounds(312, 22, 68, 39);
		frame.getContentPane().add(label_vaga);
		
		label_vagaOrigem = new JLabel("Vaga origem:");
		label_vagaOrigem.setForeground(new Color(255, 255, 255));
		label_vagaOrigem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_vagaOrigem.setBounds(60, 127, 107, 51);
		frame.getContentPane().add(label_vagaOrigem);
		
		VagaOrigem = new JTextField();
		VagaOrigem.setColumns(10);
		VagaOrigem.setBounds(167, 135, 96, 39);
		frame.getContentPane().add(VagaOrigem);
		
		VagaDestino = new JTextField();
		VagaDestino.setColumns(10);
		VagaDestino.setBounds(385, 135, 96, 39);
		frame.getContentPane().add(VagaDestino);
		
		label_vagaDestino = new JLabel("Vaga destino:");
		label_vagaDestino.setForeground(new Color(255, 255, 255));
		label_vagaDestino.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_vagaDestino.setBounds(283, 127, 107, 51);
		frame.getContentPane().add(label_vagaDestino);
		
		/*
		//Permite gravar os dados
		button_gravarDados = new JButton("Gravar Dados");
		button_gravarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					estacionamento.gravarDados();
					label_mensagens.setText("Dados gravados.");
				}
				catch (Exception e1) {label_mensagens.setText(e1.getMessage());}
				
				
			}
		});
		button_gravarDados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_gravarDados.setBounds(321, 259, 119, 45);
		frame.getContentPane().add(button_gravarDados);
		*/
		
		
		/*
		//Permite listar os dados
		button_lerDados = new JButton("Ler Dados");
		button_lerDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					estacionamento.lerDados();
					label_mensagens.setText("Dados lidos?????");
				}
				catch (Exception e1) {label_mensagens.setText(e1.getMessage());}
				
			}
		});
		button_lerDados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_lerDados.setBounds(442, 259, 107, 45);
		frame.getContentPane().add(button_lerDados);
		*/
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 64));
		panel.setBounds(24, 10, 531, 111);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		//Permite registro de saída de veículos
		button_sair = new JButton("Sair Veículo");
		button_sair.setBounds(183, 59, 147, 42);
		panel.add(button_sair);
		button_sair.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		//Permite consultar em qual vaga está o veículo de determinada placa
		
		button_consultar = new JButton("Consultar Placa");
		button_consultar.setBounds(340, 59, 147, 42);
		panel.add(button_consultar);
		button_consultar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		//Permite registro de entrada de veículos
		
		button_entrar = new JButton("Entrar Veículo");
		button_entrar.setBounds(25, 59, 147, 42);
		panel.add(button_entrar);
		button_entrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String placa = Placa.getText();
					int numerovaga = Integer.parseInt(Vaga.getText());
					estacionamento.entrar(placa,numerovaga);
					label_mensagens.setText("Entrada registrada");	
					
					//Gravando os novos dados
					estacionamento.gravarDados();
					System.out.println("Dados gravados.");
					
				}
				catch (Exception e1) {
					String mensagemEntrada = e1.getMessage();
					if (mensagemEntrada.equals("For input string: \"\"")){
						label_mensagens.setText("");
						JOptionPane.showMessageDialog(frame,"É preciso preencher os campus.", "", JOptionPane.WARNING_MESSAGE);
						//label_mensagens.setText("É preciso preencher os campus.");
						}
					else {label_mensagens.setText("");
						JOptionPane.showMessageDialog(frame,mensagemEntrada, "Titulo", JOptionPane.WARNING_MESSAGE);}
						//label_mensagens.setText(mensagemEntrada);}
					
				}
			}
							
		});
		button_consultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String placa = Placa.getText();
				String vagaPlaca = Integer.toString(estacionamento.consultarPlaca(placa));
				
				if(vagaPlaca.equals("-1")) {
					label_mensagens.setText("");
					JOptionPane.showMessageDialog(frame,"A placa não está registrada.", "", JOptionPane.WARNING_MESSAGE);}
					//label_mensagens.setText("A placa não está registrada.");}
				
				else {
					label_mensagens.setText("O veículo de placa " + placa + " está na vaga " + vagaPlaca);}
			}
				
			
		});
		button_sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					int numerovaga = Integer.parseInt(Vaga.getText());
					estacionamento.sair(numerovaga);
					label_mensagens.setText("Saída registrada");
					
					//Gravando os novos dados
					estacionamento.gravarDados();
					System.out.println("Dados gravados.");
				}
				catch (Exception e1) {
					String mensagemSaida = e1.getMessage();
					if (mensagemSaida.equals("For input string: \"\"")){
						label_mensagens.setText("");
						JOptionPane.showMessageDialog(frame,"É preciso preencher os campus.", "", JOptionPane.WARNING_MESSAGE);}
						//label_mensagens.setText("É preciso preencher os campus.");}
					else {
						label_mensagens.setText("");
						JOptionPane.showMessageDialog(frame,mensagemSaida, "", JOptionPane.WARNING_MESSAGE);}
						//label_mensagens.setText(mensagemSaida);}
				}
			}
					
		});
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 64));
		panel_1.setBounds(24, 127, 531, 111);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		//Permite transferir o veículo de vaga
		button_transferir = new JButton("Transferir Veículo");
		button_transferir.setBounds(183, 59, 163, 42);
		panel_1.add(button_transferir);
		button_transferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					int vagaOrigem = Integer.parseInt(VagaOrigem.getText());
					int vagaDestino = Integer.parseInt(VagaDestino.getText());
					
					estacionamento.transferir(vagaOrigem,vagaDestino);
					label_mensagens.setText("Transferência registrada");
					
					//Gravando os novos dados
					estacionamento.gravarDados();
					System.out.println("Dados gravados.");
				}
				
				catch (Exception e1) {
					String mensagemTransf = e1.getMessage();
					if (mensagemTransf.equals("For input string: \"\"")){
						label_mensagens.setText("");
						JOptionPane.showMessageDialog(frame,"É preciso preencher os campus.", "", JOptionPane.WARNING_MESSAGE);}
						//label_mensagens.setText("É preciso preencher os campus.");}
					else {
						label_mensagens.setText("");
						JOptionPane.showMessageDialog(frame,mensagemTransf, "", JOptionPane.WARNING_MESSAGE);}
						//label_mensagens.setText(mensagemTransf);}
				}
			}
		});
		button_transferir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 64));
		panel_2.setBounds(24, 248, 531, 56);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
						
		//Permite listar as vagas livres
		button_listarVagasLivres = new JButton("Listar Vagas Livres");
		button_listarVagasLivres.setBounds(267, 10, 163, 36);
		panel_2.add(button_listarVagasLivres);
		button_listarVagasLivres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {						
					String vagasLivres = "";
																				
					for(int i : estacionamento.listarLivres()) {
						vagasLivres += i + " ";
					}
					label_mensagens.setText("Vagas livres: " + vagasLivres);
				}
				catch (Exception e1) {label_mensagens.setText(e1.getMessage());}
			}
					
		});
		button_listarVagasLivres.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		//Permite listar as vagas, informa se está livre e, se não, informa a placa do carro da vaga
		
		button_listarVagas = new JButton("Listar Vagas");
		button_listarVagas.setBounds(94, 10, 163, 36);
		panel_2.add(button_listarVagas);
		button_listarVagas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String sitVagas = "";
																				
					for(String s : estacionamento.listarGeral()) {
						sitVagas += s + " ";}
					label_mensagens.setText("Vagas: " + sitVagas);
				
			}
		});
		button_listarVagas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		label_mensagens = new JLabel("");
		label_mensagens.setBounds(60, 314, 475, 13);
		frame.getContentPane().add(label_mensagens);
	}
}
