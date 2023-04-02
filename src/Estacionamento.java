import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class Estacionamento {
	
	private String[] placas; // Armazena as placas inseridas no estacionamento.
	
	public Estacionamento(int vagas) throws Exception {
		if (vagas <= 0) {
			throw new Exception("Número de vagas inválido."); // Deve ser de ao menos 1.
		}
		
		placas = new String[vagas]; // Define o número de vagas do estacionamento.
		
		for (int i = 0; i < placas.length; i++) {
			placas[i] = "livre"; //Popula o array com vagas "livres";
		}
	}
	
	//Método para validar placa, só permite placas no formato YYY0000 ou YYY0X00"
	private boolean validarPlaca(String placa) {
		if(placa.length() != 7) {
			return false;
		} //Verifica se a placa possui 7 dígitos.
		
		String letras = placa.substring(0,3);
		String numeros = placa.substring(3,4) + placa.substring(5);
		String letraOuNumero = placa.substring(4,5);
		
		System.out.println(letras + numeros + ":" + letraOuNumero);
		
		
		if(! letras.matches("[A-Z]*")) {
			return false;
		} //Verifica se os 3 primeiros dígitos da placa são letras.
		
		
		if(! numeros.matches("[0-9]*")) {
			return false;
		} //Verifica se o 4º digito e os 2 ultimos digitos são números.
		
		if (letraOuNumero.matches("[A-Z]*") || letraOuNumero.matches("[0-9]*"))
			return true;
		//Verifica se o 5º digito é número (placa antiga) ou letra (placa nova), se sim, a placa já foi 100% validada e retorna true.
		
		return false; //Se falhar na última validacao retorna false.
	}
	
	
	public void entrar(String placa, int vaga) throws Exception {
		placa = placa.toUpperCase();
		
		if(! validarPlaca(placa)) { //Validação da placa (verifica se ela tem formato YYY0000 ou YYY0X00"). 
			throw new Exception("Placa inválida, a placa deve ter formato YYY0000 ou YYY0X00");
		}
		
		if (vaga-1 < 0 || vaga-1 >= placas.length ) { // Checa se a vaga existe.
			throw new Exception("Número de vaga fora do limite do estacionamento, escolha uma vaga entre 1 e " + placas.length);
		}
		else if (!(placas[vaga-1].equals("livre"))) { // Checa se a vaga está ocupada.
			throw new Exception("Vaga não está livre.");
		}
		
		placas[vaga-1] = placa; // Caso passe nos testes a vaga é ocupada.
		
		// Registro da movimentação:
		LocalDateTime timestamp = LocalDateTime.now(); 
		DateTimeFormatter timestampFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String dataFormatada = timestamp.format(timestampFormat);
		
		FileWriter arquivo = new FileWriter(new File("historico.csv"), true); //Abre ou cria o arquivo.
		arquivo.write(dataFormatada + ";" + vaga + ";" + placa + ";" + "entrada\n"); //Escreve no csv com o formato data;vaga;placa;entrada
		arquivo.close(); //Salva alteracoes e fecha arquivo
	}
	
	
	public void sair(int vaga) throws Exception {
		if (vaga-1 < 0 || vaga-1 >= placas.length ) { // Verifica se a vaga existe.
			throw new Exception("Número de vaga fora do limite do estacionamento, escolha uma vaga entre 1 e " + placas.length);
		}
		else if (placas[vaga-1].equals("livre")) { // Verifica se a vaga já estava livre.
			throw new Exception("Vaga não está ocupada.");
		}
		
		String placa = placas[vaga-1]; //Guarda a placa pra gravar no csv. 
		placas[vaga-1] = "livre"; // Caso passe nos testes a vaga é liberada.
		
		// Registro da movimentação:
		LocalDateTime timestamp = LocalDateTime.now(); 
		DateTimeFormatter timestampFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String dataFormatada = timestamp.format(timestampFormat);
		
		FileWriter arquivo = new FileWriter(new File("historico.csv"), true); //Abre o arquivo.
		arquivo.write(dataFormatada + ";" + vaga + ";" + placa + ";" + "saida\n"); //Escreve no csv com o formato data;vaga;placa;saida
		arquivo.close(); //Salva alteracoes e fecha arquivo
	}
	
	
	public int consultarPlaca(String placa) {
		placa = placa.toUpperCase();
		
		for (int i = 0; i < placas.length; i++) { // Percorre as vagas.
			if (placas[i].equals(placa)) { // Testa se é a vaga onde está a placa informada.
				return i+1; // Retorna o número da vaga.
				
			}
		}
		return -1; //A confirmar: deve retornar esse valor padrão ou subir uma exceção?
	}
	
	
	public void transferir(int vaga1, int vaga2) throws Exception {
		if (vaga1 - 1 < 0 || vaga1 - 1 >= placas.length ) { // Verifica se a vaga existe.
			throw new Exception("Número da primeira vaga informada fora do limite do estacionamento, escolha uma vaga entre 1 e " + placas.length);
		}
		
		if (vaga2 - 1 < 0 || vaga2 - 1 >= placas.length ) { // Verifica se a vaga existe.
			throw new Exception("Número da segunda vaga informada fora do limite do estacionamento, escolha uma vaga entre 1 e " + placas.length);
		}
		
		if (!(placas[vaga2 - 1].equals("livre"))) { // Checa se a vaga está ocupada.
			throw new Exception("Segunda vaga não está livre.");
		}
		
		if (placas[vaga1 - 1].equals("livre")) { // Verifica se a vaga já estava livre.
			throw new Exception("Primeira vaga não está ocupada.");
		}
		
		placas[vaga2 - 1] = placas[vaga1 - 1]; // Realiza a transferência para vaga2.
		placas[vaga1 - 1] = "livre"; // Libera a vaga1.
		
	}
	
	
	public String[] listarGeral() {
		return placas.clone();
		
		/*String[] listagem = new String[placas.length]; // Inicializa a lista a ser exibida.
		
		for (int i = 0; i < placas.length; i++) {
			if (placas[i].equals("livre")) { // Testa se a vaga está livre.
				listagem[i] = "livre";
			}
			else { // Caso ocupada, insere a placa ocupante da vaga.
				listagem[i] = placas[i];
			}
		}
		return listagem;*/
	}

	
	public ArrayList<Integer> listarLivres() {
		ArrayList<Integer> listagemLivre = new ArrayList<>(); // Inicializa a lista a ser exibida.
		
		for (int i = 0; i < placas.length; i++) {
			if (placas[i].equals("livre")) { // Testa se a vaga está livre
				listagemLivre.add(i+1);
				
			}
		}
		return listagemLivre;
	}
	
	
	public void gravarDados() {
		try {
			FileWriter arquivo = new FileWriter(new File("placas.csv")); //Cria ou abre arquivo
			
			for (int i = 0; i < placas.length; i++) {
				if (! placas[i].equals("livre")) { //Checa se há um carro estacionado na vaga
					arquivo.write( (i + 1) + ";" + placas[i] + "\n" ); //Salva no csv no formato vaga;placa
					
				}
			}
			
			arquivo.close(); //Salva alteracões no arquivo e o fecha
			
		} catch (Exception e) {
			// Nào sei o que por aqui. O que diabos poderia causar uma excecao nisso?
			
		}
	}
	
	
	public void lerDados() {
		try {
			Scanner arquivo = new Scanner(new File("placas.csv")); //Tenta abrir arquivo para leitura
		
			while(arquivo.hasNextLine()) { 
				String[] vagaPlaca = arquivo.nextLine().split(";"); // Salva um conjunto vaga;placa em um array
				int vaga = Integer.parseInt(vagaPlaca[0]);
				
				if (vaga > placas.length) {
					break; // N faz nada, o estacionamento terá menos carros, lide-se com isso :P
				}
				
				placas[vaga - 1] = vagaPlaca[1]; 
					
			}
			
			arquivo.close();
			
		} catch (Exception e) {
			try {
				FileWriter arquivo = new FileWriter(new File("placas.csv")); //Cria arquivo caso n exista
				arquivo.close();
				
			} catch (Exception e2) {
				// Nào sei o que por aqui. O que diabos poderia causar uma excecao nisso?
				
			}
		}
	}
	
}
