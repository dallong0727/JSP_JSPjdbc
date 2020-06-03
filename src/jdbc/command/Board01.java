package jdbc.command;

public class Board01 {
	
	private int num;
	private String id;
	private String title;
	private String content;
	public Board01(int num, String id, String title, String content) {
		super();
		this.num = num;
		this.id = id;
		this.title = title;
		this.content = content;
	}
	
	public Board01(int num, String title, String content) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
	}
	
	public Board01() {
		// TODO Auto-generated constructor stub
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
