package programa;

import java.io.*;
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
	private User user;
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
					menuUtilizador();

					return users.get(i).getUsername() + users.get(i).getPassword();
				}
			}
		}
		return "Username nao encontrado ou palavra pass incorreta";
	}

	public void inserirNoArrayList(String username, String password) {// procurar username no arraylist onde se
																		// encontram os usernames

		user = new User(username, password);
		users.add(user);

	}

	private boolean verificaPassword(User user, String pass) {

		return user.getPassword().compareTo(pass) == 0;
	}

	public void iniciar() {

		int opcao = 0;

		System.out.println("Olá Bem vindo á base dados alternativa");
		System.out.println("\nOpção 1 --> Entrar na base de dados, com utilizador existente");
		System.out.println("\nOpção 2 --> Criar um utilizador");

		System.out.println("\nIntroduz o valor da opção");
		opcao = ler.nextInt();

		if (opcao == 1) {
			// introduz a password
			String username, password;
			System.out.println(users.toString());
			// ler();
			System.out.println("Username?");
			ler.nextLine();
			username = ler.nextLine();
			System.out.println("Password?");
			password = ler.nextLine();
			
			System.out.println(procurarUsername(username, password));
			iniciar();
			
		}

		if (opcao == 2) {// criar novo utilizador
			System.out.println(users);
			escrever();

		}

	}
	public void escrever() {
		
		System.out.println("Username:");
		String username = ler.next();
		System.out.println("Password");
		String password = ler.next();
		user = new User(username, password);
		users.add(user);
		try {
			FileOutputStream file = new FileOutputStream(new File("users.txt"));
			ObjectOutputStream output = new ObjectOutputStream(file);

			output.writeObject(users);

			output.close();
			file.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}

	}

	public void ler() {


		try {

			FileInputStream fi = new FileInputStream(new File("users.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects

			users = (ArrayList) oi.readObject();

			System.out.println(users.toString());

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
		System.out.println(arvore.getTabela("Tabela1"));
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
			System.out.println("1-COMANDOS POSSIVEIS: \nCRIAR TABELA \nCONSULTAR TABELA \nCONSULTAR REGISTO");
			System.out.println("ELIMINAR REGISTO");
			System.out.println("CRIAR REGISTO");
			ler.nextLine();
			query = ler.nextLine();
			if (query.compareTo("CONSULTAR REGISTO") == 0) {// o que fazer no caso da escrita deste comando
				consultarRegistos();
			} else if (query.compareTo("ELIMINAR REGISTO") == 0) { // o que fazer no caso da escrita deste comando
				eliminarRegisto();
			} else if (query.compareTo("CRIAR REGISTO") == 0) {
				System.out.println("Qual o nome da tabela onde pretende criar o registo?");
				String nomeTabela = ler.nextLine();
				System.out.println("Para deixar de introduzir Escreva EXIT\n");

				criarRegisto(nomeTabela);

			} else if (query.compareTo("CRIAR TABELA") == 0) { // o que fazer no caso da escrita deste comando
				System.out.println("Introduza o nome da tabela");
				String nomeTabela = ler.next();
				criarTabela(nomeTabela);

			} else if (query.compareTo("CONSULTAR TABELA") == 0) {
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

		NoTabela tabela = arvore.getTabela(nome); // vai buscar ao metodo da arvore que ainda não esta totalmente
													// otimizado
		System.out.println(tabela.toString());
		menuUtilizador();
	}

	private void criarTabela(String nome) {
		arvore.criaTabela(nome);
		menuUtilizador();

	}

	private void criarRegisto(String nomeTabela) {
		int elementos = 0;

		String valorChave = "";
		String valor = "";
		Registo registoAtual = new Registo();
		registoAtual.setUniqueID();

		while (valor.compareTo("EXIT") != 0) {

			System.out.println("Nome do Campo?");
			valorChave = ler.nextLine();
			if (valorChave.compareTo("EXIT") == 0) {
				if (elementos == 0) {
					menuUtilizador();
				}
				arvore.getTabela(nomeTabela).getRegistos().add(registoAtual);
				System.out.println("Registo criado com sucesso!");
				elementos = 0;
				menuUtilizador();
			}
			System.out.println("Valor?");
			valor = ler.nextLine();

			if (valorChave.compareTo("EXIT") != 0 || valor.compareTo("EXIT") != 0) {
				if (valorChave.compareTo("") == 0) {
					valorChave = null;
				}
				if (valor.compareTo("") == 0) {
					valor = null;
				}

				registoAtual.getArrayRegisto().add(new ChaveValor(valorChave, valor));
				elementos++;

			}
		}

		arvore.getTabela(nomeTabela).getRegistos().add(registoAtual);
		elementos = 0;
		System.out.println("Registo criado com sucesso!");
		menuUtilizador();
	}

	private void consultarRegistos() {
		String nomeRegisto, nomeTabela;
		int escolha;
		System.out.println("Qual o nome da tabela que pretende consultar?");
		nomeTabela = ler.nextLine();
		System.out.println("Introduz chave e depois valor chave:valor separado com :");
		nomeRegisto = ler.nextLine();
		String chaveEvalor[] = splice(nomeRegisto);

		ArrayList TodosRegistos = arvore.getTabela(nomeTabela).getRegistos();

		for (int i = 0; i < TodosRegistos.size(); i++) {
			Registo registoAtual = (Registo) TodosRegistos.get(i);
			ArrayList dados = registoAtual.getArrayRegisto();

			for (int y = 0; y < registoAtual.getArrayRegisto().size(); y++) {
				ChaveValor dado = (ChaveValor) dados.get(y);

				if (dado.getChave().compareTo(chaveEvalor[0]) == 0) {
					if (dado.getValor().compareTo(chaveEvalor[1]) == 0) {
						System.out.println("enter para sair");
						System.out.println(dados.toString() + "\n--------------------------------------"); // aqui é que
																											// temos de
																											// comparar
																											// a chave
																											// com a
																											// chave que
					}
				} else {
					System.out.println("Nada encontrado");
				}

			}
		}

		menuUtilizador();

	}

	private void eliminarRegisto() {
		int escolha;
		String nomeTabela, nomeRegisto;
		System.out.println("Qual o nome da tabela na qual pretende eliminar o registo?");
		nomeTabela = ler.nextLine();
		System.out.println("chave:valor separa a chave do valor com : ");
		nomeRegisto = ler.nextLine();

		String chaveEvalor[] = splice(nomeRegisto);

		ArrayList TodosRegistos = arvore.getTabela(nomeTabela).getRegistos();

		for (int i = 0; i < TodosRegistos.size(); i++) {
			Registo registoAtual = (Registo) TodosRegistos.get(i);
			ArrayList dados = registoAtual.getArrayRegisto();

			for (int y = 0; y < registoAtual.getArrayRegisto().size(); y++) {
				ChaveValor dado = (ChaveValor) dados.get(y);

				if (dado.getChave().compareTo(chaveEvalor[0]) == 0) {
					if (dado.getValor().compareTo(chaveEvalor[1]) == 0) {
						System.out.println("Encontramos este registo deseja eliminar? 0-Para não  ----  1-para sim");
						System.out.println(dados.toString()); // aqui é que temos de comparar a chave com a chave que
																// recebemos;
						escolha = ler.nextInt();
						if (escolha == 1) {
							dados.remove(y); // remover o objecto que lá esta
						} else {
							return;
						}
					}
				} else {
					System.out.println("Nada encontrado");
				}

			}
		}
		menuUtilizador();
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

	public void iniciaDados() {
		
		try {

			FileInputStream fi = new FileInputStream(new File("dados.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			arvore = (Arvore) oi.readObject();

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

		System.out.println("Dados carregados com sucesso..");
		System.out.println(arvore.getTabela("Tabela1"));
		/*
		 * System.out.println(arvore.getTabela("Tabela1").getRegistos().get(0).getClass(
		 * ));
		 * 
		 * Registo cena = (Registo) arvore.getTabela("Tabela1").getRegistos().get(0);
		 * ChaveValor chave = (ChaveValor) cena.getArrayRegisto().get(0);
		 * System.out.println(chave.getChave());
		 */
		ler();

	}

	public String[] splice(String frase) {

		int start = 0, end = 0, start1 = 0, end1 = 0;
		String resultado[] = new String[2];

		for (int a = 0; a < frase.length(); a++) {
			if (frase.charAt(a) == ':') {
				start = 0;
				end = a;
				start1 = a + 1;
				end1 = frase.length();
			}
		}

		resultado[0] = frase.substring(start, end);
		resultado[1] = frase.substring(start1, end1);
		return resultado;

	}

}
