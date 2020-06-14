package programa;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.io.*;


public class Registo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id; // timestamp hashed para criar um id que mais ninguem tem


	private ArrayList<ChaveValor> arrayRegisto;

	public String setUniqueID() {// atribuir id aos registos das tabelas
		Date data = new Date();
		Timestamp paraTimestamp = new Timestamp(data.getTime());
		Date timestampParaData = new Date(paraTimestamp.getTime());
		String timeStamptostring = timestampParaData.toString();
		this.id = timeStamptostring;
		System.out.println(id);
		return id;
	}

	public String getId() {
		return id;
	}

	public Registo() {

		arrayRegisto = new ArrayList <ChaveValor>();

	}

	public ArrayList getArrayRegisto() {

		return this.arrayRegisto;
	}

	public void setArrayRegisto(ArrayList arrayRegisto) {
		this.arrayRegisto = arrayRegisto;
	}

	
	public ChaveValor procuraChaveValor(String chave, String valor) {
		return arrayRegisto.get(0);
	}

	@Override
	public String toString() {
		return "ID do Registo=" + id + "\t Registo da tabela:" + arrayRegisto.toString().replace("[", " ").replace("]", " ")+" \n"  ;
	}

	
}
