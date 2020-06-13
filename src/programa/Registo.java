package programa;
import java.util.Scanner;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
//ainda nao esta terminado, 
public class Registo {

	private Scanner ler = new Scanner(System.in);
	private String id; // timestamp hashed para criar um id que mais ninguem tem
	private ArrayList arrayRegisto;
	


	public static String  setUniqueID(){
	    Date data = new Date();
	    Timestamp paraTimestamp = new Timestamp(data.getTime());
	    Date timestampParaData= new Date(paraTimestamp.getTime());
	    String timeStamptostring=timestampParaData.toString();
	    String id= timeStamptostring;
	    System.out.println(id);
	    return id;   
	}
	
	
	
	public String getId() {
		return id;
	}



	public void setId() {
		this.id = setUniqueID() ;
	}



	public Registo() {

		arrayRegisto = new ArrayList();
		utilizador();
	}

	public void utilizador() {// para introduzir registos numa tabela
		int a;
		String valor;
		System.out.println("Quantos campos vai introduzir");
		a=ler.nextInt();
		
			
		for (int i = 0; i < a; i++) { 
			System.out.println("Introduz o valor para "+i);
			valor = ler.next();
			arrayRegisto.add(valor);
		}
		
	}

	public ArrayList getArrayRegisto() {
		return arrayRegisto;
	}

	public void setArrayRegisto(ArrayList arrayRegisto) {
		this.arrayRegisto = arrayRegisto;
	}

/*	public void adicionarRegisto(String registo) {// adiciona o registo no arrayResgisto
		deslocarDireita();
		
		arrayRegisto.get(i)= registo;

	}*/

	public void eliminarRegisto(String registo) {
		if (arrayRegisto.size() == 0) {// se nao houver nada dentro do array nao podemos remover nada
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
		for (int i = 0; i < arrayRegisto.size(); i++) {
			if ((arrayRegisto.get(i))==sair) {// vai descobrir dentro do array a que indice corresponde a
															// string que queremos retirar
				return i;// caso encontremos uma correspondencia dentro do array retorna o indice onde
							// essa string se encontra dentro do array
			}

		}
		return -1;// caso nao seja encontrado nenhum indice
	}

	private void deslocarEsquerda(int index) {
		ArrayList novo = new ArrayList();
		for(int i = 0; i < arrayRegisto.size()-1; i++ )
		{
				
			if(i>=index) {// se i for igual ao index, como e esse que pretendemos remover vamos dizer que vai ser igual ao proximo elemento do arrayRegisto
							// sendo que temos de fazer isto para todos os elementos que se encontrem nos indices posteriores ao index
				
				novo.set(i, arrayRegisto.get(i+1));
			}else {
				
				novo.set(i, arrayRegisto.get(i));
			}
			
			}
		arrayRegisto = novo;
	}

	private void deslocarDireita() {// permite a insercao dos registos, ver se e necessaria
		ArrayList novo = new ArrayList(arrayRegisto.size() + 1);
		int i = 1;
		for (Object registo : arrayRegisto) {
			novo.set(i, registo);
			i++;
		}
		arrayRegisto = novo;
	}
	
	//update no registo, procurar a posicao do registo no array e alterar para o valor introduzido
	
	// Procura
	public Object getCol(int a) {
		return arrayRegisto.get(a);
	}

}
