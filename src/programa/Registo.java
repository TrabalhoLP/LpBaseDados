package programa;

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
	
	public void adicionarRegisto(String registo) {
			deslocarDireita();
			arrayRegisto[0]=registo;
		
		}
		
		
	private void deslocarDireita() {
	String [] novo= new String[arrayRegisto.length+1];
	int i=1;
	for(String registo: arrayRegisto) {
		novo[i]=registo;
		i++;
	}
	arrayRegisto=novo;
}

	}
	

