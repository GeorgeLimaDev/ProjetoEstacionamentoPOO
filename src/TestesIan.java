import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class TestesIan {

	public static void main(String[] args) throws Exception {
		String[] nomes = new String[10];
		System.out.println(Arrays.toString(nomes) + "\n");
		
		LocalDateTime timestamp = LocalDateTime.now();
		DateTimeFormatter timestampFormat;
		timestampFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		System.out.println("Horário da entrada: " + timestamp.format(timestampFormat) + "\n"); // Print temporário para acompanhar a implementação.
		
	
		Estacionamento e1 = new Estacionamento(10);
		e1.entrar("as", 1);
		e1.entrar("asad", 5);
		String[] safadenho = e1.listarGeral();
		
		for (int i = 0; i < safadenho.length; i++) {
			safadenho[i] = "Tentou fazer o q n devia né?";
		}
		
		System.out.println("Safadenho: " + Arrays.toString(safadenho));
		System.out.println("e1: " + Arrays.toString(e1.listarGeral()) + "\n");
		
		String s1 = "ola";
		String s2 = "ola";
		
		System.out.println(s1.length() + "+" + s2.length());
		System.out.println("Como o profe ensinou: " + s1.equals(s2));
		System.out.println("Do jeito antigo: " + (s1 == s2) + "\n"); //UÉ. PQ ISSO TBM FUNCIONA????? O PROFE N TINHA DITO Q N ERA PRA FUCNIONAR????
		//System.out.println(! s1.equals(s2)); //O ! funciona sem parenteses tbm
		
		//e1.transferir(0, 10); //V1 Fora do limite
		//e1.transferir(1, 11); //V2 Fora do limite
		//e1.transferir(2, 3); //Transferir de vaga livre para livre
		//e1.transferir(2, 5); //Transferir de vaga livre para ocupada
		//e1.transferir(1, 5); //Transferir de vaga ocupada para ocupada
		//e1.transferir(5, 5); //Transferir pra mesma vaga

		System.out.println("e1 antes da transferencia: " + Arrays.toString(e1.listarGeral()));
		e1.transferir(1, 10); //Transferir de vaga ocupada para livre, era pra da certo :P
		System.out.println("e1 depois da transferencia: " + Arrays.toString(e1.listarGeral()) + "\n");
		
		//e1.sair(10);
		//e1.sair(5);
		
		System.out.println("Vagas livres: " + e1.listarLivres() + "\n");
		
		
		/*
		try {
			FileWriter arquivo = new FileWriter("arquivo.csv");
			arquivo.write("as");
			arquivo.close();
			System.out.println("deu certo");
		} catch (Exception e) {
			System.out.println("pena");
		}*/
		
		e1.gravarDados();
		e1.lerDados();
	}

}
