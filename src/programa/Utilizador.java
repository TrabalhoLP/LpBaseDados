package programa;
import java.util.Scanner;

public class Utilizador {
	
	private Scanner ler = new Scanner(System.in);
	

	public Utilizador() {
		
	}
	
	public void iniciar() {
		
		int opcao=0;
		
		System.out.println("Olá Bem vindo á base dados alternativa");
		System.out.println("\nOpção 1 --> Entrar na base de dados, com uma conexão já existente");
		System.out.println("\nOpção 2 --> Criar uma nova conexão");
		
		System.out.print("Introduz o valor da opção");
		ler.nextInt();


	}
}
