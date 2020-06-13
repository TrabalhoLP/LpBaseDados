package programa;
import java.util.ArrayList;
import java.util.Scanner;

public class NoTabela {

	private String nome;
	
	private ArrayList <Registo> registos;
	private int contaRegisto;
	private ArrayList info;
	
	public NoTabela(String nome) {
		this.nome = nome;
		this.info = new ArrayList();
		this.contaRegisto = 0;
		/* este contrutor recebe o nome da tabela 
		 * e o numero de colunas(campos) que a tabela tem
		 * Este NumColunas, serve para criar uma lista String colunas
		 * Para que o utilizador depois diga o nome de cada campo */
		this.registos= new ArrayList();// depois temos de alterar este tipo de lista
		
	}

	public void setRegistos(ArrayList<Registo> registos) {
		this.registos = registos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList getColunas() {
		
		return info;
	}
	
/*	public ArrayList getRegistos() {
		return this.registos;
	}*/

	public void registo() {
		
		registos.add(new Registo());
		contaRegisto++;
	}
	/*
	public int procura(String nomeColuna) {
		
		// nome da coluna, fazer funcao para converter o nome num indice da coluna;
		System.out.println("Valor do que procuras?");
		String valor = ler.next();
		
		for (int i = 0; i < registos.size(); i++) {
			
			Registo a = registos.get(qualIndice(nomeColuna)); // qual indice encontrou o indice da coluna
			
			if(a.getCol(i).compareTo(valor)==0) {//se encontrarmos a coluna
				System.out.println(a.getCol(i));//faz-se print da coluna encontrada
			}else {
				System.out.println("Não Há");// essa coluna nao existe
			}
			
			
			
		}
		return -1;// caso nao seja encontrado nenhum indice
	}
	
	
	private int qualIndice(String nome) {
		
		for (int i = 0; i< info.size(); i++) {
			if(info.get(i).compareTo(nome)==0) {// compara o nome da coluna introduzido com o nome das colunas que existe
													// caso a encontre retorna o seu indice
				return i;
			}
		}
	
		return -1;
	}
	
	
	public boolean preencherNomeColunas() {// atribuir nomes as colunas de uma tabela
		
		for (int i = 0; i< colunas.length; i++) {
			System.out.println("Nome da coluna "+ i);
			colunas[i]= ler.next();
		}
		
		return true;
	}
	*/
	
}
