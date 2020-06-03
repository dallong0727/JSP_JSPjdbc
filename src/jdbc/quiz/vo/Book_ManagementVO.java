package jdbc.quiz.vo;

public class Book_ManagementVO {

	private int Book_Management;
	private String Book_Management_Position;
	private String Book_Management_Status;
	
	public Book_ManagementVO() {
		// TODO Auto-generated constructor stub
	}
	public Book_ManagementVO(int book_Management, String book_Management_Position, String book_Management_Status) {
		super();
		Book_Management = book_Management;
		Book_Management_Position = book_Management_Position;
		Book_Management_Status = book_Management_Status;
	}
	public int getBook_Management() {
		return Book_Management;
	}
	public void setBook_Management(int book_Management) {
		Book_Management = book_Management;
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
}
