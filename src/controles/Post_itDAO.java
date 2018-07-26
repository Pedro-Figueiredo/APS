package controles;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import post_it.Post_it;
import post_it.Post_itA;




public class Post_itDAO {
	private ConexaoBD conexao = new ConexaoBD();
	
	public void criarPost_it(Post_it p) {
		conexao.conectar();
		try {
			PreparedStatement pst = conexao.getConexao().prepareStatement("insert into \"user\".usuario(descricao, tags, arq) values(?,?,?)");
			pst.setString(1,p.getDescricao());
			pst.setString(2,p.getTags());
			pst.setBoolean(3,p.isArq());
			pst.execute();
			System.out.println("Post-it cadastrado com sucesso!! :v");
		}catch(SQLException e){
			System.out.println("Erro ao cadastrar post-it:"+e);			
		}finally {
			conexao.desconectar();
		}
	}
	public ArrayList<Post_itA> buscarpost_its(String tag) {
		conexao.conectar();
		ResultSet resultado = conexao.executarSQL("select * from \"atvdd\".post_itTarefa where tags like \'%"+ tag +"%\'");
		ArrayList<Post_itA> post_its = new ArrayList<>();		
		try {
			while (resultado.next()) {
				String descricao = resultado.getString("descricao");
				String tags = resultado.getString("tags");
				post_its.add(new Post_it(descricao,tags));
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
				boolean arq = resultado.getBoolean("arquivado");
				post_its.add(new Post_it(descricao,tags,arq));
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
				boolean arq= resultado.getBoolean("arquivado");
				post_its.add(new Post_it(descricao,tags,arq,id));
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
