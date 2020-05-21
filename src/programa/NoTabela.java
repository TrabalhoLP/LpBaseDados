package programa;

public class NoTabela {
	
	private String nome;
	private Registo [] registos;
	
	private String [] colunas;
	
	public NoTabela(String nome, int numColunas) {
		this.nome = nome;
		this.colunas = new String [numColunas]; 
		/* este contrutor recebe o nome da tabela 
		 * e o numero de colunas(campos) que a tabela tem
		 * Este NumColunas, serve para criar uma lista String colunas
		 * Para que o utilizador depois diga o nome de cada campo */
		
	}
}
