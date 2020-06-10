package programa;

import java.util.Scanner;

//ainda nao esta terminado, 
public class Registo {

	private Scanner ler = new Scanner(System.in);
	private int id; // timestamp hashed para criar um id que mais ninguem tem
	private String[] arrayRegisto;
	


	public Registo(int numColunas) {

		arrayRegisto = new String[numColunas];
		utilizador();
	}

	public void utilizador() {// para introduzir registos numa tabela
		
		for (int i = 0; i < (arrayRegisto.length); i++) { 
			System.out.println("Introduz o valor para "+i);
			arrayRegisto[i]= ler.next();
		}
		
	}

	public String[] getArrayRegisto() {
		return arrayRegisto;
	}

	public void setArrayRegisto(String[] arrayRegisto) {
		this.arrayRegisto = arrayRegisto;
	}

	public void adicionarRegisto(String registo) {// adiciona o registo no arrayResgisto
		deslocarDireita();
		arrayRegisto[0] = registo;

	}

	public void eliminarRegisto(String registo) {
		if (arrayRegisto.length == 0) {// se nao houver nada dentro do array nao podemos remover nada
			return;
		} else {
			int index = procura(registo);
			if (index != -1) {// se encontramos o indice
				deslocarEsquerda(index);// reescrevemos o array sem essa string
			}
			if (index == -1) {
				return;// caso nao seja encontrado nenhum indice
			}
		}
	}

	private int procura(String sair) {
		for (int i = 0; i < arrayRegisto.length; i++) {
			if (arrayRegisto[i].equalsIgnoreCase(sair)) {// vai descobrir dentro do array a que indice corresponde a
															// string que queremos retirar
				return i;// caso encontremos uma correspondencia dentro do array retorna o indice onde
							// essa string se encontra dentro do array
			}

		}
		return -1;// caso nao seja encontrado nenhum indice
	}

	private void deslocarEsquerda(int index) {
		String[] novo = new String[arrayRegisto.length + 1];
		for(int i = 0; i < arrayRegisto.length-1; i++ )
		{
				
			if(i>=index) {// se i for igual ao index, como e esse que pretendemos remover vamos dizer que vai ser igual ao proximo elemento do arrayRegisto
							// sendo que temos de fazer isto para todos os elementos que se encontrem nos indices posteriores ao index
				novo[i]=arrayRegisto[i+1];
			}else {
				novo[i]=arrayRegisto[i]; 
			}
			
			}
		arrayRegisto = novo;
	}

	private void deslocarDireita() {// permite a insercao dos registos, ver se e necessaria
		String[] novo = new String[arrayRegisto.length + 1];
		int i = 1;
		for (String registo : arrayRegisto) {
			novo[i] = registo;
			i++;
		}
		arrayRegisto = novo;
	}
	
	//update no registo, procurar a posicao do registo no array e alterar para o valor introduzido
	
	// Procura
	public String getCol(int a) {
		return arrayRegisto[a];
	}

}
