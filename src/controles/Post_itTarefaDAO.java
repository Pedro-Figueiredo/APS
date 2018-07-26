package controles;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import post_it.Post_itA;
import post_it.Post_itTarefa;


public class Post_itTarefaDAO {
	private ConexaoBD conexao = new ConexaoBD();
	
	public void criarPost_itTarefa(Post_itTarefa p) {
		conexao.conectar();
		try {
			PreparedStatement pst = conexao.getConexao().prepareStatement("insert into \"user\".usuario(descricao, tags, arq,deadline) values(?,?,?,?)");
			pst.setString(1,p.getDescricao());
			pst.setString(2,p.getTags());
			pst.setBoolean(3,p.isArq());
			pst.setDate(4, (Date) p.getDeadline());
			pst.execute();
			System.out.println("Post-it Tarefa cadastrado com sucesso!! :v");
		}catch(SQLException e){
			System.out.println("Erro ao cadastrar post-it do tipo Tarefa:"+e);			
		}finally {
				conexao.desconectar();
		}
	}
	
	public ArrayList<Post_itA> buscarpost_itsTarefa(String tag) {
		conexao.conectar();
		ResultSet resultado = conexao.executarSQL("select * from \"atvdd\".post_itTarefa where tags like \'%"+ tag +"%\'");
		ArrayList<Post_itA> post_its = new ArrayList<>();		
		try {
			while (resultado.next()) {
				String descricao = resultado.getString("descricao");
				String tags = resultado.getString("tags");
				Date deadline = resultado.getDate("deadline");
				post_its.add(new Post_itTarefa(descricao,tags,deadline));
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
		return post_its;
	}
	
	public ArrayList<Post_itA> arq() {
		conexao.conectar();
		ResultSet resultado = conexao.executarSQL("select * from \"atvdd\".post_itTarefa where arquivado = true");
		ArrayList<Post_itA> post_its = new ArrayList<>();		
		try {
			while (resultado.next()) {
				String descricao = resultado.getString("descricao");
				String tags = resultado.getString("tags");
				int id= resultado.getInt("id");
				Date deadline = resultado.getDate("deadline");
				boolean arq = resultado.getBoolean("arquivado");
				post_its.add(new Post_itTarefa(descricao,tags,deadline,arq,id));
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
		return post_its;
	}
	
	public ArrayList<Post_itA> exibir() {
		conexao.conectar();
		ResultSet resultado = conexao.executarSQL("select * from \"atvdd\".post_itTarefa");
		ArrayList<Post_itA> post_its = new ArrayList<>();		
		try {
			while (resultado.next()) {
				String descricao = resultado.getString("descricao");
				String tags = resultado.getString("tags");
				int id= resultado.getInt("id");
				Date deadline=resultado.getDate("deadline");
				boolean arq= resultado.getBoolean("arquivado");
				post_its.add(new Post_itTarefa(descricao,tags,deadline, arq, id));
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
		return post_its;
	}
	public void arquivar(int id){
		conexao.conectar();
		try {
			PreparedStatement pst = conexao.getConexao().prepareStatement("update \"atvdd\".post_itTarefa set arquivado = TRUE where id="+ id);
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
			
		}finally {
			conexao.desconectar();
		}
	}
}