package programa;

import java.util.ArrayList;
import java.io.*;

public class NoTabela implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private ArrayList<Registo> registos;
	private int contaRegisto;
	private ArrayList info;

	public NoTabela(String nome) {
		this.nome = nome;
		this.info = new ArrayList();
		this.contaRegisto = 0;
		/*
		 * este contrutor recebe o nome da tabela e o numero de colunas(campos) que a
		 * tabela tem Este NumColunas, serve para criar uma lista String colunas Para
		 * que o utilizador depois diga o nome de cada campo
		 */
		this.registos = new ArrayList();

	}

	public void setRegistos(ArrayList<Registo> registos) {
		this.registos = registos;
	}

	public ArrayList getRegistos() {

		return this.registos;
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

	

	public void registo() {

		registos.add(new Registo());
		contaRegisto++;
	}
	

	@Override
	public String toString() {
		return "\nNome da tabela:" + nome +"\n"+ "Conteudo da tabela:"+"\n" + registos.toString().replace("[", " ").replace("]", " ").replace(",", "") ;
	}

}
