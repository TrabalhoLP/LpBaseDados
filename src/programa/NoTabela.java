package programa;
import java.util.ArrayList;

public class NoTabela {
	
	private String nome;
	
	private ArrayList <Registo> registos;
	private int contaRegisto;
	private String [] colunas;
	
	public NoTabela(String nome, int numColunas) {
		this.nome = nome;
		this.colunas = new String [numColunas]; 
		this.contaRegisto = 0;
		/* este contrutor recebe o nome da tabela 
		 * e o numero de colunas(campos) que a tabela tem
		 * Este NumColunas, serve para criar uma lista String colunas
		 * Para que o utilizador depois diga o nome de cada campo */
		this.registos= new ArrayList();// depois temos de alterar este tipo de lista
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String[] getColunas() {
		
		return colunas;
	}
	
	public int getRegistos() {
		
		return this.contaRegisto;
	}

	public void registo() {
		
		registos.add(new Registo(colunas.length));
		contaRegisto++;
	}
	
}
