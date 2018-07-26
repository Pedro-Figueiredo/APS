package faxada;

import java.util.ArrayList;
import java.util.Date;
import controles.Post_itDAO;
import controles.Post_itTarefaDAO;
import post_it.Post_it;
import post_it.Post_itA;
import post_it.Post_itTarefa;


public class Faxada {
	private Post_itDAO pd= new Post_itDAO();
	private Post_itTarefaDAO ptd = new Post_itTarefaDAO();
	
	void criarPost_it(String descricao, String tags){
		this.pd.criarPost_it(new Post_it(descricao, tags));
	}
	void criarPost_itTarefa(String descricao, String tags, Date deadline) {
		this.ptd.criarPost_itTarefa(new Post_itTarefa(descricao, tags, deadline));
	}
	void arquivar(int id) {
		this.ptd.arquivar(id);
	}
	ArrayList<Post_itA> exibir(){
		ArrayList<Post_itA> a = new ArrayList<>();
		a.addAll(this.ptd.exibir());
		a.addAll(this.pd.exibir());
		return a;
	}
	ArrayList<Post_itA> pesquisar(String tag){
		ArrayList<Post_itA> a = new ArrayList<>();
		a.addAll(this.ptd.buscarpost_itsTarefa(tag));
		a.addAll(this.pd.buscarpost_its(tag));
		return a;
	}
	ArrayList<Post_itA> exibirArquivados(){
		ArrayList<Post_itA> a = new ArrayList<>();
		a.addAll(this.ptd.arq());
		a.addAll(this.pd.arq());
		return a;
	}
	
}
