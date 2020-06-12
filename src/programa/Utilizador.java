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
	

	private Scanner ler = new Scanner(System.in);
	private ArrayList<User> users = new ArrayList<User>();
	// substuir isto pela classe user. ou seja depois temos um array de objectos user
	private int contaRegisto;
	
	private ArrayList <User> registosEverybody;
	
	
	public Utilizador() {
		contaRegisto=0;
		registosEverybody= new ArrayList<User>();
	}
	
	
	// HÃ¡ um utilizador no array? temos de criar um user
	

	
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


	private boolean verificaPassword(User user, String pass) {
		
		return user.getPassword().compareTo(pass)==0;
	}


	public void iniciar() {
		
		int opcao=0;
		
		System.out.println("OlÃ¡ Bem vindo Ã¡ base dados alternativa");
		System.out.println("\nOpÃ§Ã£o 1 --> Entrar na base de dados, com uma conexÃ£o jÃ¡ existente");
		System.out.println("\nOpÃ§Ã£o 2 --> Criar um utilizador");
		
		System.out.println("\nIntroduz o valor da opÃ§Ã£o");
		opcao=ler.nextInt();
		
		if(opcao==1) {
			// introduz a password
			System.out.println(users);
			readData(users);
			
			if(readData(users).equals(null)) {
				menuUtilizador();
				
			}else {
				iniciar();
			}
			
			
		}
		
		if(opcao==2) {// criar novo utilizador
			System.out.println(users);
			storeData(users);
			System.out.println("Registo efetuado com sucesso");
			iniciar();
		}

	}
	public String readData(ArrayList<User> paraLer) {
		
    System.out.println("Username:");
	String username= ler.next();
	System.out.println("Password");
	String password= ler.next();
    
    try {
      FileReader arq = new FileReader("userpass.txt");
      BufferedReader lerArq = new BufferedReader(arq);
 
      String linha = lerArq.readLine(); // lê a primeira linha
// a variável "linha" recebe o valor "null" quando o processo
// de repetição atingir o final do arquivo texto
      while (linha != null) {
    	for(int i=0; i<paraLer.size();i++) {
    //    System.out.printf("%s\n", linha);
    	if(linha.compareTo(procurarUsername(username, password))==0) {
    		return "Username e Password corretos";
    	};
        linha = lerArq.readLine(); // lê da segunda até a última linha
      }
      }
      arq.close();
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }
 
    System.out.println();
	return null;
  }
	
	
	
	
	
	
	
	
	
	
	

	
			
		public void storeData(ArrayList<User> paraGravar) {
		    String username,password ;
		    int i;
		    System.out.printf("Username:\n");
		    username= ler.next();
		    
		    System.out.printf("Password:\n");
		    password= ler.next();
		 
		    FileWriter	arq = null ;
			try {
				arq = new FileWriter("userspass.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    PrintWriter gravarArq = new PrintWriter(arq);
		 
		    gravarArq.printf("-----Users/Pass---");
		    for (i=1; i<=10; i++) {
		      gravarArq.printf("Username/Password",username,password);
		    }
		    gravarArq.printf("+-----------------");
		 
		    try {
				arq.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		    System.out.println("Registo efetuado com sucesso! ");
		    iniciar();
		  }
		// este Ã© o novo menu depois da palavra pass
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
			System.out.print("Comando escrito de forma incorreta ou não existente");
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
		
		System.out.println("Qual o nome que pretende dar à tabela?");
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
