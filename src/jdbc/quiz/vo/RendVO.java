package jdbc.quiz.vo;

public class RendVO {

	private int Rend_Num;
	private int Rend_Count;
	private String Rend_Start_Date;
	private String Rend_End_Date;
	private int Rend_Rental_Fee;
	private int Rend_Late_Fee;
	
	public RendVO() {
		// TODO Auto-generated constructor stub
	}
	
	public RendVO(int rend_Num, int rend_Count, String rend_Start_Date, String rend_End_Date, int rend_Rental_Fee,
			int rend_Late_Fee) {
		super();
		Rend_Num = rend_Num;
		Rend_Count = rend_Count;
		Rend_Start_Date = rend_Start_Date;
		Rend_End_Date = rend_End_Date;
		Rend_Rental_Fee = rend_Rental_Fee;
		Rend_Late_Fee = rend_Late_Fee;
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

	public String getRend_Start_Date() {
		return Rend_Start_Date;
	}

	public void setRend_Start_Date(String rend_Start_Date) {
		Rend_Start_Date = rend_Start_Date;
	}

	public String getRend_End_Date() {
		return Rend_End_Date;
	}

	public void setRend_End_Date(String rend_End_Date) {
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
