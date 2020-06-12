package programa;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Utilizador {
	
	private Arvore arvore = new Arvore();


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
					return users.get(i).getUsername()+users.get(i).getPassword();
				}
			}		
		}
		return "Username nao encontrado ou palavra pass incorreta";
	}

	public void inserirNoArrayList(String username, String password) {// procurar username no arraylist onde se encontram os usernames
		
			
			User novoUser = new User(username,password);
			users.add(novoUser);
					
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
		//	readData(users);
			menuUtilizador();
			
			
		}
		
		if(opcao==2) {// criar novo utilizador
			System.out.println(users);
			storeData();
			
		}

	}

	public void readData(ArrayList<User> paraLer) {
		
    System.out.println("Username:");
	String username= ler.next();
	System.out.println("Password");
	String password= ler.next();
    
    try {
      FileReader arq = new FileReader("userspass.txt");
      BufferedReader lerArq = new BufferedReader(arq);
 
      String linha = lerArq.readLine(); // l� a primeira linha
// a vari�vel "linha" recebe o valor "null" quando o processo
// de repeti��o atingir o final do arquivo texto
      while (linha != null) {
    	
    	System.out.printf("%s\n", linha);
    /*	if(linha.compareTo(procurarUsername(username, password))==0) {
    		return "Username e Password corretos";
    	};*/
        linha = lerArq.readLine(); // l� da segunda at� a �ltima linha
      
      }
      arq.close();
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }
 
    System.out.println();
	
  }
	
	
	public void storeData() {
		    String username,password ;
		    int i;
		    System.out.printf("Username:\n");
		    username= ler.next();
		    
		    System.out.printf("Password:\n");
		    password= ler.next();
		    
		    inserirNoArrayList(username, password);
		    
		    FileWriter	arq = null ;
			try {
				arq = new FileWriter("userspass.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    PrintWriter gravarArq = new PrintWriter(arq);
		 
		    gravarArq.printf("-----Users/Pass---");
		    gravarArq.printf("Username:",username);
		    gravarArq.printf("Password:",password);
		    
		    gravarArq.printf("--------------------");
		 
		    try {
				arq.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		    System.out.println("Registo efetuado com sucesso! ");
		    iniciar();
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
		System.out.println("1-COMANDOS POSSIVEIS: \nCRIAR TABELA \nCONSULTAR REGISTO \nELIMINAR REGISTO \nCRIAR REGISTO");

		ler.nextLine();
		
		query=ler.nextLine();
		
		System.out.println(query);
		if(query.compareTo("CONSULTAR REGISTO")==0) {// o que fazer no caso da escrita deste comando
			consultarRegistos();
		}else if(query.compareTo("CRIAR TABELA")==0) {
			criaTabela();
		
		}else if(query.compareTo("ELIMINAR REGISTO")==0) { // o que fazer no caso da escrita deste comando
			
		}else if(query.compareTo("CRIAR REGISTO")==0) {
		
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
	
		
	}
	
	public void criaTabela() {
		String nomeTabela;
		
		System.out.println("Qual o nome que pretende dar � tabela?");
		nomeTabela=ler.next();
	
		arvore.criaTabela(nomeTabela);//dar nome a tabela
		menuUtilizador();
	}


	private void consultarRegistos() {
		
		
	}
}
