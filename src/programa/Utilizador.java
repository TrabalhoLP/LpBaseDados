package programa;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Utilizador {
	

	private Scanner ler = new Scanner(System.in);
	private ArrayList<User> users = new ArrayList<User>();
	// substuir isto pela classe user. ou seja depois temos um array de objectos user
	private int contaRegisto;
	
	private ArrayList <User> registosEverybody;
	
	
	public Utilizador() {
		contaRegisto=0;
		registosEverybody= new ArrayList<User>();
	}
	
	
	// Há um utilizador no array? temos de criar um user
	

	
	public String procurarUsername(String username, String password) {// procurar username no arraylist onde se encontram os usernames
		for(int i=0;i<users.size();i++) {
			System.out.println(users.get(i));
			if(username.compareTo(users.get(i).getUsername())==0) {
				if(verificaPassword(users.get(i), password)) {
					return "Bem vindo/a " + users.get(i).getUsername();
				}
			}		
		}
		return "Username nao encontrado ou palavra pass incorreta";
	}

	public String procurarUsername2(String username, String password) {// procurar username no arraylist onde se encontram os usernames
		for(int i=0;i<registosEverybody.size();i++) {
			System.out.println(registosEverybody.get(i));
			if(username.compareTo(registosEverybody.get(i).getUsername())==0) {
				if(verificaPassword(registosEverybody.get(i), password)) {
					return "Bem vindo/a " + registosEverybody.get(i);
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
			System.out.println(users);
			System.out.println("Username:");
			String username= ler.next();
			System.out.println("Password");
			String password= ler.next();
			System.out.println(procurarUsername(username, password));
			if(procurarUsername(username, password).equals("Username nao encontrado ou palavra pass incorreta")) {
				iniciar();
			}else {
				menuUtilizador();
			}
			
			
		}
		
		if(opcao==2) {// criar novo utilizador
			System.out.println(users);
			System.out.println("Introduza um username:");
			String novoUsername= ler.next();
			System.out.println("Introduza um password");
			String novaPassword=ler.next();
			User novo = new User(novoUsername, novaPassword);
			users.add(novo);
			

			String component_doc = "C:\\Users\\Cristiana Modesto\\Desktop\\userspass.txt";

			Scanner inFile = null;
			try 
			{
			    inFile = new Scanner(new File(component_doc));
			} 
			catch (FileNotFoundException e) 
			{
			    e.printStackTrace();
			}
			
			while(inFile.hasNextLine())
			{
			    registosEverybody.add(inFile.nextLine());
			}
			System.out.println("Registo efetuado com sucesso");

			iniciar();
		}

	}
	
	// este é o novo menu depois da palavra pass
	public void menuUtilizador() {
		int opcao;
		System.out.println("------------------Menu do utilizador-----------------------");
		System.out.println("1: Manipular registos");
		System.out.println("2:Voltar ao menu iniciar");
		opcao=ler.nextInt();
		if(opcao==1) {
			obterRegistos();
		}
		if(opcao==2) {
			iniciar();
		}
		
	}


	private void obterRegistos() {// caso seja selecionada a primeira opcao
		String query;
		int opcao;
		System.out.println("1-Manipular registos");
		
		System.out.println("2-Voltar ao Menu do Utilizador");
		opcao=ler.nextInt();
		if(opcao==1) {
		System.out.println("1-COMANDOS POSSIVEIS: CONSULTAR REGISTO");
		System.out.println("\t ELIMINAR REGISTO");
		System.out.println("\t CRIAR REGISTO");
		query=ler.next();
		if(query.equals("CONSULTAR REGISTO")) {// o que fazer no caso da escrita deste comando
			consultarRegistos();
		}
		else if(query.contentEquals("ELIMINAR REGISTO")) { // o que fazer no caso da escrita deste comando
			
		}else if(query.contentEquals("CRIAR REGISTO")) {
		
			criaRegisto();
		}
		
		
		else {// caso o comando seja escrito de forma incorreta
			System.out.print("Comando escrito de forma incorreta ou n�o existente");
			obterRegistos();
		}
		}
		
		if(opcao==2) {
			menuUtilizador();
		}
	}


	private void criaRegisto() {
		String nomeTabela;
		int tamanhoTabela;
		ArrayList <Registo> registos= new ArrayList();
		
		System.out.println("Qual o nome que pretende dar � tabela?");
		nomeTabela=ler.next();
		System.out.println("Qual o tamanho da tabela que pretende criar?");
		tamanhoTabela=ler.nextInt();
		Arvore escola = new Arvore("Escola");
		escola.criaTabela(nomeTabela, tamanhoTabela);//dar nome a tabela
		escola.getTabela().registo();//registar tabela
		obterRegistos();
		
	}


	private void consultarRegistos() {
		
		
	}
}
