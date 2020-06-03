package jdbc.command;

import java.util.ArrayList;

public class MemberBoard {

	//주 테이블에 컬럼을 멤버변수, 부 테이블에 대한 컬럼을 List표현
	
	private String id;
	private String pw;
	private String name;
	private String email;
	private String address;
	
	private ArrayList<Board01> list = new ArrayList<>();
	
	public MemberBoard() {
	}

	public MemberBoard(String id, String pw, String name, String email, String address) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public ArrayList<Board01> getList() {
		return list;
	}

	public void setList(ArrayList<Board01> list) {
		this.list = list;
	}

	
}
