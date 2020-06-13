package programa;

import java.io.*;
import java.util.ArrayList;

public class Arvore implements Serializable{
	
	// conexao
	
	private static final long serialVersionUID = 1L;
	private String nome;
	private ArrayList <NoTabela> tabelas;
	private int contaTabelas;
	
	private User user []; // depois vemos se vale a pena implementar
	// este user, seria uma lista que guarda os utilizadores.
	public Arvore () {
		
		contaTabelas = 0;
		tabelas = new ArrayList(); //  default para a quantidade de tabelas
	}

	public void criaTabela(String nome) {
		
		tabelas.add(new NoTabela(nome)); //cria a tabela, ja na lista de tabelas
		contaTabelas++;
		System.out.println("Tabela <"+ nome + "> Criada com sucesso ");
	}
	
	public NoTabela getTabela() {
		return tabelas.get(0);// temos de mudar isto para encontrar a tabela pelo o nome
	}
	
	//remover tabela //tem de se ver se tem coisas ou não;
	
	
}

