package programa;
//ainda nao esta terminado, 
public class Registo {

	private String [] arrayRegisto;
	
	public Registo() {
		arrayRegisto= new String [] {};
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
	public void eliminarRegisto(String registo) {
		if(arrayRegisto.length==0) {// se nao houver nada dentro do array nao podemos remover nada
			return;
		}else {
		int index=aRetirar(registo);
		if(index!=-1) {// se encontramos o indice
			deslocarEsquerda(index);// reescrevemos o array sem essa string 
		}if(index==-1) {
		return ;// caso nao seja encontrado nenhum indice 
		}
		}
	}
	private int aRetirar(String sair) {
		for(int i=0;i<arrayRegisto.length;i++) {
			if(arrayRegisto[i].equalsIgnoreCase(sair)) {// vai descobrir dentro do array a que indice corresponde a string que queremos retirar
				return i;// caso encontremos uma correspondencia dentro do array retorna o indice onde essa string se encontra dentro do array
			}
				
			}
		return -1;// caso nao seja encontrado nenhum indice
		}
		

	private void deslocarEsquerda(int index)
	{
		String[] novo = new String[arrayRegisto.length - 1];
		for(int i = 1; i < arrayRegisto.length; i++ )
		{
			if(i==index) { continue;}// caso encontremos o indice da string que pretendemos remover esse nao vai ser iterado
			novo[i]=arrayRegisto[i];
			
		}
		arrayRegisto = novo;
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
	

