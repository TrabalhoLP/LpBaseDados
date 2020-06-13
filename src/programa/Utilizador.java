package programa;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import jdk.jshell.spi.ExecutionControl.UserException;
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

	public void inserirNoArrayList(String username, String password) {// procurar username no arraylist onde se encontram os usernames
		
			
			User novoUser = new User(username,password);
			users.add(novoUser);
					
	}

	private boolean verificaPassword(User user, String pass) {
		
		return user.getPassword().compareTo(pass)==0;
	}


	public void iniciar()  {
		
		int opcao=0;
		
		System.out.println("OlÃ¡ Bem vindo Ã¡ base dados alternativa");
		System.out.println("\nOpÃ§Ã£o 1 --> Entrar na base de dados, com uma conexÃ£o jÃ¡ existente");
		System.out.println("\nOpÃ§Ã£o 2 --> Criar um utilizador");
		
		System.out.println("\nIntroduz o valor da opÃ§Ã£o");
		opcao=ler.nextInt();
		
		if(opcao==1) {
			// introduz a password
			System.out.println(users);
			ler();
			menuUtilizador();
			
			
		}
		
		if(opcao==2) {// criar novo utilizador
			System.out.println(users);
			ler();
			
		}

	}
	public void ler() {
		 System.out.println("Username:");
			String username= ler.next();
			System.out.println("Password");
			String password= ler.next();
		User novoUser = new User(username,password);
		
		try {
			 String file = "userspass.txt";
			Path path = Paths.get("\\\\kLAPTOP-GK358VHC\\Users\\Cristiana Modesto\\projetoLP\\LpBaseDados\\src\\programa\\pastaficheiros", file);
			FileOutputStream f = new FileOutputStream(path.toFile());
			ObjectOutputStream o = new ObjectOutputStream(f);

			// Write objects to file
			o.writeObject(novoUser);
			

			o.close();
			f.close();

			FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			
			User u1 = (User) oi.readObject();

			System.out.println(u1.toString());
			

			oi.close();
			fi.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

/*	public void readData(ArrayList<User> paraLer) {
		
    System.out.println("Username:");
	String username= ler.next();
	System.out.println("Password");
	String password= ler.next();
	User novoUser = new User(username,password);
	users.add(novoUser);

    Scanner ler = new Scanner(System.in);
 
    String file = "userspass.txt";
    Path path = Paths.get("\\\\LAPTOP-GK358VHC\\Users\\Cristiana Modesto\\projetoLP\\LpBaseDados\\src\\programa\\pastaficheiros", file);
    System.out.println(path);

/*	    try {
		System.out.println(Files.readString(path));
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}*/

//    System.out.printf("Informe o nome de arquivo texto:\n");
  //  String nome = ler.nextLine();
 
   /* System.out.printf("\nConteúdo do arquivo texto:\n");
    try {
      FileReader arq = new FileReader(path.toFile());
      BufferedReader lerArq = new BufferedReader(arq);
 
      String linha = lerArq.readLine(); // lê a primeira linha // a variável "linha" recebe o valor "null" quando o processo	// de repetição atingir o final do arquivo texto
      while (linha != null) {
        System.out.printf("%s\n", linha);
 
        linha = lerArq.readLine(); // lê da segunda até a última linha
      }
 
      arq.close();
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }
 
    System.out.println();
  }*/

   /* try {
    	String file = "userspass.txt";
	    Path path = Paths.get("\\\\LAPTOP-GK358VHC\\Users\\Cristiana Modesto\\projetoLP\\LpBaseDados\\src\\programa\\pastaficheiros", file);
	    System.out.println(path);

	    try {
			System.out.println(Files.readString(path));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	    Files.readString(path).compareTo(procurarUsername(username,password));
 
     /* String linha = lerArq.readLine(); // lê a primeira linha
// a variável "linha" recebe o valor "null" quando o processo
// de repetição atingir o final do arquivo texto
      while (linha != null) {
    	
    	System.out.printf("%s\n", linha);
    /*	if(linha.compareTo(procurarUsername(username, password))==0) {
    		return "Username e Password corretos";
    	};*/
     //   linha = lerArq.readLine(); // lê da segunda até a última linha
  /*    
      }
      arq.close();*/
 
	
	
  
	
	
	
	
/*	public void gravaTxt() throws UserException{
	  String username,password ;
	    
	    System.out.printf("Username:\n");
	    username= ler.next();
	    
	    System.out.printf("Password:\n");
	    password= ler.next();
	    java.net.URL url = getClass().getResource("userspass.txt");
    	File file = new File(url.getPath());
		
		User util = new User(username,password);; // só um exemplo, crie todoas as variaveis que são atributos dos objetos do array list
		String user,pass;
try	{
	        FileWriter f = new FileWriter (file, true);
	 
	        for(int i = 0; i < users.size(); i++){
	        	
	        	util = users.get(i); // chama o atributo do objeto na posição i
                             user = util.getUsername();
                             pass=util.getPassword();
                             String conteudo =user+" "+pass;
	        	conteudo += "\r\n";
	        	f.write(conteudo);
	        	
	        }
	        
	        f.close();

	    }catch (IOException e)  {
	            e.printStackTrace();
	    }
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	public  void storeData() {
		 Scanner ler = new Scanner(System.in);
	    String username,password ;
	    int i;
	    System.out.printf("Username:\n");
	    username= ler.next();
	    
	    System.out.printf("Password:\n");
	    password= ler.next();
	    inserirNoArrayList(username, password);
	    String file = "userspass.txt";
		Path path = Paths.get("\\\\LAPTOP-GK358VHC\\Users\\Cristiana Modesto\\projetoLP\\LpBaseDados\\src\\programa\\pastaficheiros", file);
	    FileWriter arq=null;
		try {
			arq = new FileWriter(path.toFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader in;
		
	     
	    	  
	    try {
	    	in = new BufferedReader(new FileReader(path.toFile()));
	    	PrintWriter gravarArq = new PrintWriter(arq);
	    	 while((path.toFile().toString())!=null) {  
		    gravarArq.println("-----Users/Pass---");
		    gravarArq.println("Username:"+username);
		    gravarArq.println("Password:"+password);
		    gravarArq.println("--------------------");
		    gravarArq.flush();
		    gravarArq.close();
			arq.close();
			iniciar();
	    	 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	 
	    System.out.println("Registo efetuado com sucesso! ");
	   
	  }
	*/
	   public  void leitor() throws IOException {
		   String file = "userspass.txt";
			Path path = Paths.get("\\\\LAPTOP-GK358VHC\\Users\\Cristiana Modesto\\projetoLP\\LpBaseDados\\src\\programa\\pastaficheiros", file);
	        BufferedReader buffRead = new BufferedReader(new FileReader(path.toFile()));
	        String linha = "";
	        while (true) {
	            if (linha != null) {
	                System.out.println(linha);
	 
	            } else
	                break;
	            linha = buffRead.readLine();
	        }
	        buffRead.close();
	        menuUtilizador();
	    }
	   
	   
	   
	   
	   
	   public void escritor() throws IOException {
		   String file = "userspass.txt";
			Path path = Paths.get("\\\\LAPTOP-GK358VHC\\Users\\Cristiana Modesto\\projetoLP\\LpBaseDados\\src\\programa\\pastaficheiros", file);
	        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path.toFile()));
	        String user = "";
	        String pass="";
	        Scanner in = new Scanner(System.in);
	        System.out.println("Username: ");
	        user = in.nextLine();
	        System.out.println("Password:");
	        pass=in.nextLine();
	        buffWrite.write(user+ "\n");
	        buffWrite.write(pass+ "\n");
	        buffWrite.flush();
	        buffWrite.close();
	        iniciar();
	    }
	
	
	
	
/*	public  void storeData() {
		try {
			String file = "userspass.txt";
		    Path path = Paths.get("\\\\LAPTOP-GK358VHC\\Users\\Cristiana Modesto\\projetoLP\\LpBaseDados\\src\\programa\\pastaficheiros", file);
	    	FileWriter o = new FileWriter(path.toFile());
			
			String linha;
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader in = new BufferedReader(isr);
			PrintWriter out = new PrintWriter(o);
			System.out.println("Digite algo no console e tecle enter");
			try {
				while (!(linha = in.readLine()).equals("-1")) {
					System.out.println("Username: " + linha);
					System.out.println("Password: " + linha);
					out.println(linha);
					out.flush();
				}
				// out.flush(); <<<<<<<<
				in.close();
				o.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}*/

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

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
		
		//	criaRegisto();
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


/*	private void criaRegisto() {
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
		
	}*/


	private void consultarRegistos() {
		
		
	}
}
