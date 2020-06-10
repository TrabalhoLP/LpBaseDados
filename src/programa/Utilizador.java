package programa;
import java.util.ArrayList;
import java.util.Scanner;

public class Utilizador {
	

	private Scanner ler = new Scanner(System.in);
	private ArrayList<String> usernames= new ArrayList<String>();
	private ArrayList<String> passwords= new ArrayList<String>();
	// substuir isto pela classe user. ou seja depois temos um array de objectos user

	public Utilizador() {
		
	}
	
	
	// Há um utilizador no array? temos de criar um user
	
	
	public void Utilizador() {
		this.usernames= new ArrayList<String>();
		this.passwords=new ArrayList<String>();
	}
	
	public String procurarUsername(String username) {// procurar username no arraylist onde se encontram os usernames
		for(int i=0;i<usernames.size();i++) {
			if(username==usernames.get(i)) {
				return "Username correto";
			}
				
		}
		return "Username nao encontrado";
	}
	public String procurarPassword(String password) {// procurar password no arraylist onde se encontra a password
		for(int i=0;i<passwords.size();i++) {
			if(password==passwords.get(i)) {
				return "Password correta";
			}
				
		}
		return "Password nao encontrada";
	}
	public void iniciar() {
		
		int opcao=0;
		
		System.out.println("Olá Bem vindo á base dados alternativa");
		System.out.println("\nOpção 1 --> Entrar na base de dados, com uma conexão já existente");
		System.out.println("\nOpção 2 --> Criar um utilizador");
		
		System.out.println("\nIntroduz o valor da opção");
		opcao=ler.nextInt();
		
		if(opcao==1) {// quando vou a ver o arraylist nao tem nada, mesmo ja tendo adicionado
			System.out.println("Username:");
			String username= ler.next();
			procurarUsername(username);
			System.out.println("Password");
			String password= ler.next();
			procurarPassword(password);
			System.out.println(usernames);
			System.out.println(passwords);
		if(procurarUsername(username).compareTo("Username correto")==0 && procurarPassword(password).compareTo("Password correta")==0 ){
			System.out.println("Bem vindo � base de dados");
		}else if (procurarUsername(username).compareTo("Username correto")==0 && procurarPassword(password).compareTo("Password correta")!=0 ) {
			System.out.println("Password Incorreta");
			return;
		}else if(procurarUsername(username).compareTo("Username correto")!=0 && procurarPassword(password).compareTo("Password correta")==0 ) {
			System.out.println("Username Incorreto");
			return;
		}else {
			System.out.println("Username e password incorretos");
			return;
		}
		}
		if(opcao==2) {// consegue adicionar 
			System.out.println("Introduza um username:");
			String novoUsername= ler.next();
			usernames.add(novoUsername);
			System.out.println(usernames);
			System.out.println("Introduza um password");
			String novaPassword=ler.next();
			passwords.add(novaPassword);
			System.out.println("Registo efetuado com sucesso");
			System.out.println(usernames.toString());
			System.out.println(passwords.toString());

			return;
		}

}
}
