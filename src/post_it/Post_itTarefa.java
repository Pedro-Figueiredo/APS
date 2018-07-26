package post_it;

import java.util.Date;

public class Post_itTarefa extends Post_itA {
	private Date deadline;
	
	public Post_itTarefa(String descricao, String tags, Date deadline) {
		this.descricao=descricao;
		this.tags=tags;
		this.deadline= deadline;
	}
	
	public Post_itTarefa(String descricao, String tags, Date deadline, boolean arq) {
		this.descricao=descricao;
		this.tags=tags;
		this.deadline= deadline;
		this.arq=arq;
	}
	public Post_itTarefa(String descricao, String tags, Date deadline, boolean arq, int id) {
		this.descricao=descricao;
		this.tags=tags;
		this.deadline= deadline;
		this.arq=arq;
		this.id=id;
	}
	
	public Date getDeadline() {
		return this.deadline;
	}
	
	public void setDeadline(Date date){
		this.deadline= date;
	}
	public String toString(){
		return "id:"+id+"  decrição:"+ descricao+ "  tags:"+tags+"  arquivado:"+arq+" deadline:"+deadline;
	 }
}
