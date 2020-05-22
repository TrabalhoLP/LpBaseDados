package programa;

public class Arvore {
	
	// conexao
	
	private String nome;
	private NoTabela tabelas[];
	private int contaTabelas;
	
	private User user []; // depois vemos se vale a pena implementar
	// este user, seria uma lista que guarda os utilizadores.
	public Arvore (String nome) {
		this.nome = nome;
		contaTabelas = 0;
		tabelas = new NoTabela [10]; //  default para a quantidade de tabelas
	}

	public void criaTabela(String nome, int numColunas) {
		
		tabelas[contaTabelas] = new NoTabela(nome,numColunas); //cria a tabela, ja na lista de tabelas
		contaTabelas++;
		System.out.println("Tabela <"+ nome + "> Criada com sucesso ");
	}
	
	public NoTabela getTabela() {
		return tabelas[0];
	}
}
