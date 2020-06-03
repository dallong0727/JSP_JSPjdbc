package jdbc.quiz.vo;

public class ClientVO {

	private int Client_Num;
	private String Client_Name;
	private String Client_Sex;
	private int Client_Phone_Num;
	private String Client_Address;
	
	public ClientVO() {
		// TODO Auto-generated constructor stub
	}
	
	public ClientVO(int client_Num, String client_Name, String client_Sex, int client_Phone_Num,
			String client_Address) {
		super();
		Client_Num = client_Num;
		Client_Name = client_Name;
		Client_Sex = client_Sex;
		Client_Phone_Num = client_Phone_Num;
		Client_Address = client_Address;
	}

	public int getClient_Num() {
		return Client_Num;
	}
	public void setClient_Num(int client_Num) {
		Client_Num = client_Num;
	}
	public String getClient_Name() {
		return Client_Name;
	}
	public void setClient_Name(String client_Name) {
		Client_Name = client_Name;
	}
	public String getClient_Sex() {
		return Client_Sex;
	}
	public void setClient_Sex(String client_Sex) {
		Client_Sex = client_Sex;
	}
	public int getClient_Phone_Num() {
		return Client_Phone_Num;
	}
	public void setClient_Phone_Num(int client_Phone_Num) {
		Client_Phone_Num = client_Phone_Num;
	}
	public String getClient_Address() {
		return Client_Address;
	}
	public void setClient_Address(String client_Address) {
		Client_Address = client_Address;
	}
	
	
	
}
