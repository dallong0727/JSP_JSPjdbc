package jdbc.quiz.vo;

import java.util.Date;

public class BookVO {
	
	private int Book_Num;
	private String Book_Name;
	private String Book_Publisher; 
	private String Book_Genre;
	private String Book_Writer;
	private int Book_Price;
	private int Book_Management_Num;
	private String Book_Management_Position;
	private String Book_Management_Status;
	private int Client_Management_Num;
	private String Client_Management_Date;
	private int Client_Num;
	private String Client_Name;
	private String Client_Sex;
	private int Client_Phone_Num;
	private String Client_Address;
	private int Employee_Num;
	private int Employee_Pw;
	private String Employee_Name;
	private int Employee_Phone_Num;
	private int Rend_Num;
	private int Rend_Count;
	private Date Rend_Start_Date;
	private Date Rend_End_Date;
	private int Rend_Rental_Fee;
	private int Rend_Late_Fee;
	
	public BookVO() {
		// TODO Auto-generated constructor stub
	}
	public BookVO(int book_Num, String book_Name, String book_Publisher, String book_Genre, String book_Writer,
			int book_Price, String book_Management_Status) {
		super();
		Book_Num = book_Num;
		Book_Name = book_Name;
		Book_Publisher = book_Publisher;
		Book_Genre = book_Genre;
		Book_Writer = book_Writer;
		Book_Price = book_Price;
		Book_Management_Status = book_Management_Status;
	}
	
	public String toString1() {
		return "BookVO [Book_Num=" + Book_Num + ", Book_Name=" + Book_Name + ", Book_Publisher=" + Book_Publisher
				+ ", Book_Genre=" + Book_Genre + ", Book_Writer=" + Book_Writer + ", Book_Price=" + Book_Price
				+ ", Book_Management_Status=" + Book_Management_Status + "]";
	}

	public BookVO(int client_Num, String client_Name, int rend_Num, int rend_Count, 
			Date rend_Start_Date, Date rend_End_Date, int rend_Rental_Fee, int rend_Late_Fee) {
		super();
		Client_Num = client_Num;
		Client_Name = client_Name;
		Rend_Num = rend_Num;
		Rend_Count = rend_Count;
		Rend_Start_Date = rend_Start_Date;
		Rend_End_Date = rend_End_Date;
		Rend_Rental_Fee = rend_Rental_Fee;
		Rend_Late_Fee = rend_Late_Fee;
	}
	
	public String toString2() {
		return "BookVO [Client_Num=" + Client_Num + ", Client_Name=" + Client_Name + ", Rend_Num=" + Rend_Num
				+ ", Rend_Count=" + Rend_Count + ", Rend_Start_Date=" + Rend_Start_Date + ", Rend_End_Date="
				+ Rend_End_Date + ", Rend_Rental_Fee=" + Rend_Rental_Fee + ", Rend_Late_Fee=" + Rend_Late_Fee + "]";
	}
	
	public BookVO(int client_Num, String client_Name, String client_Sex, int client_Phone_Num,
			String client_Address) {
		super();
		Client_Num = client_Num;
		Client_Name = client_Name;
		Client_Sex = client_Sex;
		Client_Phone_Num = client_Phone_Num;
		Client_Address = client_Address;
	}
	
	public String toString3() {
		return "BookVO [Client_Num=" + Client_Num + ", Client_Name=" + Client_Name + ", Client_Sex=" + Client_Sex
				+ ", Client_Phone_Num=" + Client_Phone_Num + ", Client_Address=" + Client_Address + "]";
	}
	
	public int getBook_Num() {
		return Book_Num;
	}
	public void setBook_Num(int book_Num) {
		Book_Num = book_Num;
	}
	public String getBook_Name() {
		return Book_Name;
	}
	public void setBook_Name(String book_Name) {
		Book_Name = book_Name;
	}
	public String getBook_Publisher() {
		return Book_Publisher;
	}
	public void setBook_Publisher(String book_Publisher) {
		Book_Publisher = book_Publisher;
	}
	public String getBook_Genre() {
		return Book_Genre;
	}
	public void setBook_Genre(String book_Genre) {
		Book_Genre = book_Genre;
	}
	public String getBook_Writer() {
		return Book_Writer;
	}
	public void setBook_Writer(String book_Writer) {
		Book_Writer = book_Writer;
	}
	public int getBook_Price() {
		return Book_Price;
	}
	public void setBook_Price(int book_Price) {
		Book_Price = book_Price;
	}
	public int getBook_Management_Num() {
		return Book_Management_Num;
	}
	public void setBook_Management_Num(int book_Management_Num) {
		Book_Management_Num = book_Management_Num;
	}
	public String getBook_Management_Position() {
		return Book_Management_Position;
	}
	public void setBook_Management_Position(String book_Management_Position) {
		Book_Management_Position = book_Management_Position;
	}
	public String getBook_Management_Status() {
		return Book_Management_Status;
	}
	public void setBook_Management_Status(String book_Management_Status) {
		Book_Management_Status = book_Management_Status;
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
	public int getEmployee_Num() {
		return Employee_Num;
	}
	public void setEmployee_Num(int employee_Num) {
		Employee_Num = employee_Num;
	}
	public int getEmployee_Pw() {
		return Employee_Pw;
	}
	public void setEmployee_Pw(int employee_Pw) {
		Employee_Pw = employee_Pw;
	}
	public String getEmployee_Name() {
		return Employee_Name;
	}
	public void setEmployee_Name(String employee_Name) {
		Employee_Name = employee_Name;
	}
	public int getEmployee_Phone_Num() {
		return Employee_Phone_Num;
	}
	public void setEmployee_Phone_Num(int employee_Phone_Num) {
		Employee_Phone_Num = employee_Phone_Num;
	}
	public int getRend_Num() {
		return Rend_Num;
	}
	public void setRend_Num(int rend_Num) {
		Rend_Num = rend_Num;
	}
	public int getRend_Count() {
		return Rend_Count;
	}
	public void setRend_Count(int rend_Count) {
		Rend_Count = rend_Count;
	}
	public Date getRend_Start_Date() {
		return Rend_Start_Date;
	}
	public void setRend_Start_Date(Date rend_Start_Date) {
		Rend_Start_Date = rend_Start_Date;
	}
	public Date getRend_End_Date() {
		return Rend_End_Date;
	}
	public void setRend_End_Date(Date rend_End_Date) {
		Rend_End_Date = rend_End_Date;
	}
	public int getRend_Rental_Fee() {
		return Rend_Rental_Fee;
	}
	public void setRend_Rental_Fee(int rend_Rental_Fee) {
		Rend_Rental_Fee = rend_Rental_Fee;
	}
	public int getRend_Late_Fee() {
		return Rend_Late_Fee;
	}
	public void setRend_Late_Fee(int rend_Late_Fee) {
		Rend_Late_Fee = rend_Late_Fee;
	}
	
	
	
}
