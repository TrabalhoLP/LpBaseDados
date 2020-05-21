package programa;
//ainda nao esta terminado, 
public class Registo {

	private String [] arrayRegisto;
	
	public Registo(int tamanho) {
		arrayRegisto= new String [tamanho];
	}

	public String[] getArrayRegisto() {
		return arrayRegisto;
	}

	public void setArrayRegisto(String[] arrayRegisto) {
		this.arrayRegisto = arrayRegisto;
	}
	
	public void adicionarRegisto(String registo) {// adiciona o registo no arrayResgisto
			deslocarDireita();
			arrayRegisto[0]=registo;
		
		}
		
		
	private void deslocarDireita() {// desloca o array de modo a permitir a insercao de um novo registo
	String [] novo= new String[arrayRegisto.length+1];
	int i=1;
	for(String registo: arrayRegisto) {
		novo[i]=registo;
		i++;
	}
	arrayRegisto=novo;
}

	}
	

