package programa;

import java.io.Serializable;
import java.io.*;

public class ChaveValor  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String chave;
	private String valor;
	
	public ChaveValor(String chave, String valor) {
		this.chave = chave;
		this.valor = valor;
	}
	
	public ChaveValor (String valor) {
		this.chave = null;
		this.valor = valor;
		
	}
	
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return " (chave=" + chave + ", valor=" + valor + ")";
	}
	
}
