package faxada;

import java.util.Date;
import faxada.Faxada;

public class Teste {
	public static void main(String[] args) {
		Faxada f = new Faxada();
		f.criarPost_it("terminar atividade o mais rapido p�ssivel", "APS - OO");
		f.criarPost_itTarefa("t� atrasado aaaaaaaaah", "APS- OO", new Date(2018/07/26));
		f.exibir();
		f.arquivar(1);
		f.pesquisar("oo");
		
	}
}