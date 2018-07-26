package post_it;

public abstract class Post_itA{	
	protected int id;
	protected String descricao;
	protected String tags;
	protected boolean arq = false;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public boolean isArq() {
		return arq;
	}
	public void setArq(boolean arq) {
		this.arq = arq;
	}
	public String toString(){
		return "id:"+id+"  decrição:"+ descricao+ "  tags:"+tags+"  arquivado:"+arq;
	 }
}
