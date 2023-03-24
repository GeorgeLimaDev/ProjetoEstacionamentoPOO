import java.util.ArrayList;

public class Estacionamento {
	
	private String[] placas; // Armazena as placas inseridas no estacionamento.
	
	public Estacionamento(int vagas) throws Exception {
		if (vagas <= 0) {
			throw new Exception("Número de vagas inválido."); // Deve ser de ao menos 1.
		}
		placas = new String[vagas]; // Define o número de vagas do estacionamento.
		
		for (int i = 0; i < placas.length; i++) {
			placas[i] = "livre";
		}
	}
	
	public void entrar(String placa, int vaga) throws Exception {
		if (vaga-1 < 0 || vaga-1 > placas.length ) { // Checa se a vaga existe.
			throw new Exception("Número de vaga inválido.");
		}
		else if (!(placas[vaga-1].equals("livre"))) { // Checa se a vaga está livre.
			throw new Exception("Vaga não está livre.");
		}
		
		placas[vaga-1] = placa; // Caso passe nos testes a vaga é ocupada.
	}
	
	public void sair(int vaga) throws Exception {
		if (vaga-1 < 0 || vaga-1 > placas.length ) { // Verifica se a vaga existe.
			throw new Exception("Número de vaga inválido.");
		}
		else if (placas[vaga-1].equals("livre")) { // Verifica se a vaga estava ocupada.
			throw new Exception("Vaga não está ocupada.");
		}
		
		placas[vaga-1] = "livre"; // Caso passe nos testes a vaga é liberada.
	}
	
	public int consultarPlaca(String placa) {
		for (int i = 0; i < placas.length; i++) { // Percorre as vagas.
			if (placas[i].equals(placa)) { // Testa se é a vaga onde está a placa informada.
				return i+1; // Retorna o número da vaga.
			}
		}
		return -1;
	}
	
	public void transferir(int vaga1, int vaga2) throws Exception{
		if (!(placas[vaga1-1].equals("livre"))) { // Checa se a vaga1 está ocupada.
			if (placas[vaga2-1].equals("livre")) { // Checa se a vaga2 está livre.
				placas[vaga2-1] = placas[vaga1-1]; // Realiza a transferência para vaga2
				placas[vaga1-1] = "livre"; // Libera a vaga1.
			}
		}
		else {
			throw new Exception("Pelo menos uma das vagas informada é inválida.");
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
				listagemLivre.add(i);
			}
		}
		return listagemLivre;
	}
	
}
