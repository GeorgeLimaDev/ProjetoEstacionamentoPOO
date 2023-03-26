import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
	
	public void entrar(String placa, int vaga) throws Exception {
		if (vaga-1 < 0 || vaga-1 > placas.length ) { // Checa se a vaga existe.
			throw new Exception("Número de vaga inválido.");
		}
		else if (!(placas[vaga-1].equals("livre"))) { // Checa se a vaga está ocupada.
			throw new Exception("Vaga não está livre.");
		}
		
		placas[vaga-1] = placa; // Caso passe nos testes a vaga é ocupada.
		
		// Registro da movimentação:
		LocalDateTime timestamp = LocalDateTime.now();
		DateTimeFormatter timestampFormat;
		timestampFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		System.out.println("Horário da entrada: " + timestamp.format(timestampFormat)); // Print temporário para acompanhar a implementação.
	}
	
	public void sair(int vaga) throws Exception {
		if (vaga-1 < 0 || vaga-1 > placas.length ) { // Verifica se a vaga existe.
			throw new Exception("Número de vaga inválido.");
		}
		else if (placas[vaga-1].equals("livre")) { // Verifica se a vaga já estava livre.
			throw new Exception("Vaga não está ocupada.");
		}
		
		placas[vaga-1] = "livre"; // Caso passe nos testes a vaga é liberada.
		
		// Registro da movimentação:
		LocalDateTime timestamp = LocalDateTime.now();
		DateTimeFormatter timestampFormat;
		timestampFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		System.out.println("Horário da saída: " + timestamp.format(timestampFormat)); // Print temporário para acompanhar a implementação.
	}
	
	public int consultarPlaca(String placa) {
		for (int i = 0; i < placas.length; i++) { // Percorre as vagas.
			if (placas[i].equals(placa)) { // Testa se é a vaga onde está a placa informada.
				return i+1; // Retorna o número da vaga.
			}
		}
		return -1; //A confirmar: deve retornar esse valor padrão ou subir uma exceção?
	}
	
	public void transferir(int vaga1, int vaga2) throws Exception{
		if (vaga1 == vaga2) { // Checa se as vagas de origem e destino são as mesmas.
			throw new Exception("Tentativa de mover para a mesma posição.");
		}
		else if (!(placas[vaga1-1].equals("livre"))) { // Checa se a vaga1 está ocupada.
				if (placas[vaga2-1].equals("livre")) { // Checa se a vaga2 está livre.
					placas[vaga2-1] = placas[vaga1-1]; // Realiza a transferência para vaga2.
					placas[vaga1-1] = "livre"; // Libera a vaga1.
					
					// Registro da movimentação:
					// Dúvida: transferências devem ser registradas como entradas e saídas?
					LocalDateTime timestamp = LocalDateTime.now();
					DateTimeFormatter timestampFormat;
					timestampFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
					System.out.println("Horário da alteração: " + timestamp.format(timestampFormat)); // Print temporário para acompanhar a implementação.
			}
		}
		else {
			throw new Exception("Pelo menos uma das vagas informadas é inválida.");
		}
	}
	
	public String[] listarGeral() {
		String[] listagem = new String[placas.length]; // Inicializa a lista a ser exibida.
		
		for (int i = 0; i < placas.length; i++) {
			if (placas[i].equals("livre")) { // Testa se a vaga está livre.
				listagem[i] = "livre";
			}
			else { // Caso ocupada, insere a placa ocupante da vaga.
				listagem[i] = placas[i];
			}
		}
		return listagem;
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
	
}