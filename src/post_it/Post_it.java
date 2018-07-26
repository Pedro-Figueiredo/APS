package post_it;

public class Post_it extends Post_itA {

	public Post_it(String descricao, String tags) {
		this.descricao=descricao;
		this.tags=tags;
	}
	public Post_it(String descricao, String tags, boolean arq) {
		this.descricao=descricao;
		this.tags=tags;
		this.arq=arq;
	}
	public Post_it(String descricao, String tags, boolean arq, int id) {
		this.descricao=descricao;
		this.tags=tags;
		this.arq=arq;
		this.id=id;
	}
}
