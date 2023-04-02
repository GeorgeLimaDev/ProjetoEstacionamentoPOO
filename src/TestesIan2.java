import java.util.Arrays;

public class TestesIan2 {

	public static void main(String[] args) throws Exception {
		//Rodar TestesIan antes de rodar o 2º pra garantir que o arquivo placas.csv exista e esteja preenchido.
		
		Estacionamento e2 = new Estacionamento(10);
		System.out.println("Antes e2: " + Arrays.toString(e2.listarGeral()));
		e2.lerDados();
		System.out.println("Depois e2: " + Arrays.toString(e2.listarGeral()));
		
		System.out.println();
		
		Estacionamento e3 = new Estacionamento(30);
		System.out.println("Antes e3: " + Arrays.toString(e3.listarGeral()));
		e3.lerDados();
		System.out.println("Depois e3: " + Arrays.toString(e3.listarGeral()));
		
		System.out.println();
		
		Estacionamento e4 = new Estacionamento(8);
		System.out.println("Antes e4: " + Arrays.toString(e4.listarGeral()));
		e4.lerDados();
		System.out.println("Depois e4: " + Arrays.toString(e4.listarGeral()));
	
	}

}
