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
import java.util.Stack;

import jdk.jshell.spi.ExecutionControl.UserException;

public class Utilizador {

	private Arvore arvore; // o objecto
	private Scanner ler = new Scanner(System.in);
	private ArrayList<User> users = new ArrayList<User>();
	// substuir isto pela classe user. ou seja depois temos um array de objectos
	// user
	private int contaRegisto;

	private ArrayList<User> registosEverybody;

	public Utilizador() {
		arvore = new Arvore();
		contaRegisto = 0;
		registosEverybody = new ArrayList<User>();
	}

	// Há um utilizador no array? temos de criar um user

	public String procurarUsername(String username, String password) {// procurar username no arraylist onde se
																		// encontram os usernames
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i));
			if (username.compareTo(users.get(i).getUsername()) == 0) {
				if (verificaPassword(users.get(i), password)) {
					return users.get(i).getUsername() + users.get(i).getPassword();
				}
			}
		}
		return "Username nao encontrado ou palavra pass incorreta";
	}

	public void inserirNoArrayList(String username, String password) {// procurar username no arraylist onde se
																		// encontram os usernames

		User novoUser = new User(username, password);
		users.add(novoUser);

	}

	private boolean verificaPassword(User user, String pass) {

		return user.getPassword().compareTo(pass) == 0;
	}

	public void iniciar() {

		int opcao = 0;

		System.out.println("Olá Bem vindo á base dados alternativa");
		System.out.println("\nOpção 1 --> Entrar na base de dados, com uma conexão já existente");
		System.out.println("\nOpção 2 --> Criar um utilizador");

		System.out.println("\nIntroduz o valor da opção");
		opcao = ler.nextInt();

		if (opcao == 1) {
			// introduz a password
			System.out.println(users);
			//ler();
			menuUtilizador();

		}

		if (opcao == 2) {// criar novo utilizador
			System.out.println(users);
			ler();

		}

	}

	public void ler() {
		System.out.println("Username:");
		String username = ler.next();
		System.out.println("Password");
		String password = ler.next();
		User novoUser = new User(username, password);

		try {
			String file = "userspass.txt";
			Path path = Paths.get(
					"\\\\kLAPTOP-GK358VHC\\Users\\Cristiana Modesto\\projetoLP\\LpBaseDados\\src\\programa\\pastaficheiros",
					file);
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


	public void menuUtilizador() {
		saveData();
		int opcao;
		System.out.println("------------------Menu do utilizador-----------------------");
		System.out.println("1: Manipular registos");
		System.out.println("2:Voltar ao menu iniciar");
		opcao = ler.nextInt();
		if (opcao == 1) {
			obterRegistos();
		}
		if (opcao == 2) {
			iniciar();
		}

	}

	private void obterRegistos() {// caso seja selecionada a primeira opcao
		String query;
		int opcao;
		System.out.println("1-Manipular registos");

		System.out.println("2-Voltar ao Menu do Utilizador");
		opcao = ler.nextInt();
		if (opcao == 1) {
			System.out.println("1-COMANDOS POSSIVEIS: CONSULTAR REGISTO");
			System.out.println("\t ELIMINAR REGISTO");
			System.out.println("\t CRIAR REGISTO");
			ler.hasNextLine();
			query = ler.nextLine();
			if (query.compareTo("CONSULTAR REGISTO")==0) {// o que fazer no caso da escrita deste comando
				consultarRegistos();
			} else if (query.compareTo("ELIMINAR REGISTO")==0) { // o que fazer no caso da escrita deste comando

			} else if (query.compareTo("CRIAR REGISTO")==0) {

				// criaRegisto();
			} else if (query.compareTo("CRIAR TABELA")==0) { // o que fazer no caso da escrita deste comando
				System.out.println("Introduza o nome da tabela");
				String nomeTabela = ler.next();
				criarTabela(nomeTabela);

			} else if (query.compareTo("CONSULTAR TABELA ")==0) {
				System.out.println("Nome da tabela a consultar");
				String nome = ler.next();
				consultarTabela(nome);
			}

			else {// caso o comando seja escrito de forma incorreta
				System.out.print("Comando escrito de forma incorreta ou n�o existente");
				obterRegistos();
			}
		}

		if (opcao == 2) {
			menuUtilizador();
		}
	}

	/*
	 * private void criaRegisto() { String nomeTabela; int tamanhoTabela; ArrayList
	 * <Registo> registos= new ArrayList <Registo>(); registos.setID();
	 * System.out.println("Qual o nome que pretende dar � tabela?");
	 * nomeTabela=ler.next();
	 * System.out.println("Qual o tamanho da tabela que pretende criar?");
	 * tamanhoTabela=ler.nextInt(); Arvore escola = new Arvore("Escola");
	 * escola.criaTabela(nomeTabela, tamanhoTabela);//dar nome a tabela
	 * escola.getTabela().registo();//registar tabela obterRegistos();
	 * 
	 * }
	 */

	private void consultarTabela(String nome) {
		
		NoTabela tabela = arvore.getTabela(); // vai buscar ao metodo da arvore que ainda não esta totalmente otimizado
		
		System.out.println(tabela.toString());
		menuUtilizador();
	}
	
	private void criarTabela(String nome) {
		arvore.criaTabela(nome);
	}

	private void consultarRegistos() {
		String nomeRegisto;
		System.out.println("Qual o nome do registo que pretende consultar?");
		nomeRegisto = ler.nextLine();

	}

	private void eliminarRegisto() {

	}

	public void saveData() {

		try {
			FileOutputStream f = new FileOutputStream(new File("dados.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);

			o.writeObject(arvore);

			o.close();
			f.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}

	}

}
