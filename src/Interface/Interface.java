package Interface;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class Interface {

	private JFrame frame;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;
	private JMenuItem menuItem_1;
	private JMenuItem menuItem_2;
	private JMenuBar menuBar_1;
	private JMenu menu_1;
	private JMenuItem menuItem_3;
	private JMenuItem menuItem_4;
	private JMenuItem menuItem_5;
	
	
	//private Estacionamento estacionamento;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
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
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
				
		frame = new JFrame();
		frame.setTitle("Estacionamento");
		frame.getContentPane().setBackground(new Color(240, 240, 240));
		frame.setBounds(100, 100, 550, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
		button = new JButton("ENTRAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				EntrarCarro tela = new EntrarCarro();      //Para abrir a tela EntrarCarro
			}
		});

		button.setBounds(130, 115, 147, 62);
		frame.getContentPane().add(button);
		
		button_1 = new JButton("SAIR");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				SairCarro tela = new SairCarro();        //Para abrir a tela SairCarro
			}
		});
		button_1.setBounds(302, 115, 147, 62);
		frame.getContentPane().add(button_1);
		
		button_2 = new JButton("CONSULTAR");
		button_2.setBounds(130, 187, 147, 62);
		frame.getContentPane().add(button_2);
		
		button_3 = new JButton("TRANSFERIR");
		button_3.setBounds(302, 187, 147, 62);
		frame.getContentPane().add(button_3);
		
		button_4 = new JButton("LISTAR VAGAS");
		button_4.setBounds(130, 259, 147, 62);
		frame.getContentPane().add(button_4);
		
		button_5 = new JButton("VAGAS LIVRES");
		button_5.setBounds(302, 259, 147, 62);
		frame.getContentPane().add(button_5);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		menu = new JMenu("Operações");
		menuBar.add(menu);
		
		menuItem = new JMenuItem("Entrada");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntrarCarro tela = new EntrarCarro(); 
							
			}
		});
		menu.add(menuItem);
		
		menuItem_1 = new JMenuItem("Saída");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SairCarro tela = new SairCarro();
			}
		});
		menu.add(menuItem_1);
		
		menuItem_2 = new JMenuItem("Transferência");
		menu.add(menuItem_2);
		
		menu_1 = new JMenu("Consultas");
		menuBar.add(menu_1);
		
		menuItem_3 = new JMenuItem("Listar vagas");
		menu_1.add(menuItem_3);
		
		menuItem_4 = new JMenuItem("Vagas livres");
		menu_1.add(menuItem_4);
		
		menuItem_5 = new JMenuItem("Consultar vaga");
		menu_1.add(menuItem_5);
		
		menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);
		
		
		/*Temporário, criei para tentar instanciar o estacionamento com 10 vagas, não deu certo!
		button_6 = new JButton("INICIAR");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Criando o estacionamento, com 10 vagas
				estacionamento = new Estacionamento(id);
			}
		});
		
		
		button_6.setBounds(224, 31, 120, 38);
		frame.getContentPane().add(button_6);
		*/
	}
}
