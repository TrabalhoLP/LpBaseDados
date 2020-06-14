package programa;

import java.io.*;
import java.util.ArrayList;

public class Arvore implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nome;
	private ArrayList <NoTabela> tabelas;
	private int contaTabelas;
	
	private User user []; 
	
	
	
	
	
	public Arvore () {
		
		contaTabelas = 0;
		tabelas = new ArrayList(); 
	}

	public void criaTabela(String nome) {
		
		tabelas.add(new NoTabela(nome)); //cria a tabela, ja na lista de tabelas
		contaTabelas++;
		System.out.println("Tabela <"+ nome + "> Criada com sucesso ");
	}
	
	public NoTabela getTabela(String nome) {
		for(int i=0; i<tabelas.size();i++) {
			if(tabelas.get(i).getNome().compareTo(nome)==0) {
				return tabelas.get(i);
			}
		}
		return null;
	}



	public ArrayList<NoTabela> getTabelas() {
		// TODO Auto-generated method stub
		 return this.tabelas;
	}
	
	
	
	
}

