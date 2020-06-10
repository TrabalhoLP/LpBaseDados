package programa;
import java.util.ArrayList;
import java.util.Scanner;

public class Utilizador {
	

	private Scanner ler = new Scanner(System.in);
	private ArrayList<User> users = new ArrayList<User>();
	// substuir isto pela classe user. ou seja depois temos um array de objectos user

	public Utilizador() {
		
	}
	
	
	// Há um utilizador no array? temos de criar um user
	

	
	public String procurarUsername(String username, String password) {// procurar username no arraylist onde se encontram os usernames
		for(int i=0;i<users.size();i++) {
			if(username.compareTo(users.get(i).getUsername())==0) {
				if(verificaPassword(users.get(i), password)) {
					return "Bem vindo/a " + users.get(i).getUsername();
				}
			}		
		}
		return "Username nao encontrado ou palavra pass incorreta";
	}


	private boolean verificaPassword(User user, String pass) {
		
		return user.getPassword().compareTo(pass)==0;
	}


	public void iniciar() {
		
		int opcao=0;
		
		System.out.println("Olá Bem vindo á base dados alternativa");
		System.out.println("\nOpção 1 --> Entrar na base de dados, com uma conexão já existente");
		System.out.println("\nOpção 2 --> Criar um utilizador");
		
		System.out.println("\nIntroduz o valor da opção");
		opcao=ler.nextInt();
		
		if(opcao==1) {
			// introduz a password
			System.out.println("Username:");
			String username= ler.next();
			System.out.println("Password");
			String password= ler.next();
			System.out.println(procurarUsername(username, password));
			
		}
		
		if(opcao==2) {// criar novo utilizador
			
			System.out.println("Introduza um username:");
			String novoUsername= ler.next();
			System.out.println("Introduza um password");
			String novaPassword=ler.next();
			User novo = new User(novoUsername, novaPassword);
			users.add(novo);

			System.out.println("Registo efetuado com sucesso");
			System.out.println(users.toString());

			iniciar();
		}

	}
	
	// este é o novo menu depois da palavra pass
	public void menuUtilizador() {
		
		
	}
}
