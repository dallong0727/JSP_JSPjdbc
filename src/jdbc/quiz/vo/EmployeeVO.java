package jdbc.quiz.vo;

public class EmployeeVO {
	
	private int Employee_Num;
	private int Employee_Pw;
	private String Employee_Name;
	private int Employee_Phone_Num;
	
	public EmployeeVO() {
		// TODO Auto-generated constructor stub
	}
	public EmployeeVO(int employee_Num, int employee_Pw, String employee_Name, int employee_Phone_Num) {
		super();
		Employee_Num = employee_Num;
		Employee_Pw = employee_Pw;
		Employee_Name = employee_Name;
		Employee_Phone_Num = employee_Phone_Num;
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
	
	
}
