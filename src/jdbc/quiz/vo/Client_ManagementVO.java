package jdbc.quiz.vo;

public class Client_ManagementVO {

	private int Client_Management_Num;
	private String Client_Management_Date;
	
	public Client_ManagementVO() {
		// TODO Auto-generated constructor stub
	}
	
	public Client_ManagementVO(int client_Management_Num, String client_Management_Date) {
		super();
		Client_Management_Num = client_Management_Num;
		Client_Management_Date = client_Management_Date;
	}

	public int getClient_Management_Num() {
		return Client_Management_Num;
	}
	public void setClient_Management_Num(int client_Management_Num) {
		Client_Management_Num = client_Management_Num;
	}
	public String getClient_Management_Date() {
		return Client_Management_Date;
	}
	public void setClient_Management_Date(String client_Management_Date) {
		Client_Management_Date = client_Management_Date;
	}
	
	
}
