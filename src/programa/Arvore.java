package programa;

public class Arvore {
	
	// conexao
	
	private String nome;
	private NoTabela tabelas[];
	private int contaTabelas;
	
	private User user []; // depois vemos se vale a pena implementar
	// este user, seria uma lista que guarda os utilizadores.
	public Arvore () {
		
		contaTabelas = 0;
		tabelas = new NoTabela [10]; //  default para a quantidade de tabelas
	}

	public void criaTabela(String nome) {
		
		tabelas[contaTabelas] = new NoTabela(nome); //cria a tabela, ja na lista de tabelas
		contaTabelas++;
		System.out.println("Tabela <"+ nome + "> Criada com sucesso ");
	}
	
	public NoTabela getTabela() {
		return tabelas[0];
	}
	
	//remover tabela //tem de se ver se tem coisas ou não;
	
	
}

