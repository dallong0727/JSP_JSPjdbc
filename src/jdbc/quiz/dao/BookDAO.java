package jdbc.quiz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import jdbc.quiz.vo.BookVO;

public class BookDAO implements IBookDAO {

	private List<BookVO> list = new ArrayList<>();
	private List<BookVO> list2 = new ArrayList<>();
	private List<BookVO> list3 = new ArrayList<>();
	Scanner scan = new Scanner(System.in);
	@Override
	public List<BookVO> getBooks() {
		return list;
	}
	BookVO vo = new BookVO();
	
	@Override
	public void ELogin() {
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid = "test01";
		String upw = "test01";
		
		
		System.out.print("직원번호를 입력하세요>");
		String id = scan.next();
		System.out.print("비밀번호를 입력하세요>");
		String pw = scan.next();
		

		String sql = "select * from Employee where Employee_Num = ? and Employee_Pw = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("Employee_Num").equals(id) && rs.getString("Employee_Pw").equals(pw)) {
					System.out.println("로그인 성공!");	
				} else {
					System.out.println("로그인 실패! 아이디와 패스워드를 확인하세요");
				}
			} else {
				System.out.println("회원정보가 존재하지 않습니다.");
			}
			System.out.println("=====================================================================================");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void Bupdate() {
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid = "test01";
		String upw = "test01";
		
		String sql = "update Rend set Rend_Late_Fee = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
				
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, LateFee());
			int result = pstmt.executeUpdate();
			if(result != 0) {
				System.out.println("DB 업데이트 성공");
			} else {
				System.out.println("DB 업데이트 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close(); 
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void Tsearch() {
		
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid = "test01";
		String upw = "test01";

		String sql = "select * from book";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int Rend_Num = rs.getInt("Rend_Num");
				
				System.out.println("도서 번호 : " + rs.getInt("Book_Num") +  ", 도서 제목 " + rs.getString("Book_Name") 
				+ ", 출판사 : " + rs.getString("Book_Publisher") + ", 도서 장르 : " + rs.getString("Book_Genre")
				+ ", 작가 : " +  rs.getString("Book_Writer") + ", 도서 가격 : " + rs.getInt("Book_Price") 
				+ ", 대출 유무 : " + rs.getString("Book_Management_Status"));			
										
				BookVO book = new BookVO(rs.getInt("Book_Num"), rs.getString("Book_Name"), rs.getString("Book_Publisher"), 
						rs.getString("Book_Genre"), rs.getString("Book_Writer"), 
						rs.getInt("Book_Price"), rs.getString("Book_Management_Status"));
				list.add(book);
			}
			System.out.println("=====================================================================================");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
	@Override
	public void Bsearch() {
	
		System.out.print("도서번호를 입력하세요>");
		int bno = scan.nextInt();
		
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid = "test01";
		String upw = "test01";

		String sql = "select * from book where Book_Num = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			int Rend_Num = 0;
			if(rs.next()) {
				System.out.println("도서 번호 : " + rs.getInt("Book_Num") +  ", 도서 제목 " + rs.getString("Book_Name") 
				+ ", 출판사 : " + rs.getString("Book_Publisher") + ", 도서 장르 : " + rs.getString("Book_Genre")
				+ ", 작가 : " +  rs.getString("Book_Writer") + ", 도서 가격 : " + rs.getInt("Book_Price") 
				+ ", 대출 유무 : " + rs.getString("Book_Management_Status"));
								
				BookVO book = new BookVO(rs.getInt("Book_Num"), rs.getString("Book_Name"), rs.getString("Book_Publisher"), 
						rs.getString("Book_Genre"), rs.getString("Book_Writer"), 
						rs.getInt("Book_Price"), rs.getString("Book_Management_Status"));
				list.add(book);
				if(rs.getString("Book_Management_Status").equals("Y")) {
					Rend_Num = rs.getInt("Rend_Num");
					System.out.print("대여정보를 확인하시겠습니까? [Y/N]");
					System.out.print(">");
					String reply = scan.next();
					if(reply.equals("Y")) {
						RendInfo();
					} else if(reply.equals("N")) {
						System.out.println("메뉴로 돌아갑니다.");
						return;
					}
				} else {
					System.out.println(rs.getString("Book_Name") + "은 대여 가능합니다.");
				}
			}
			System.out.println("=====================================================================================");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	@Override
	public void RendInfo() {
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid = "test01";
		String upw = "test01";
		
		System.out.print("대여번호를 입력하세요>");
		int bno = scan.nextInt();
		
		String sql = "select * from book where Rend_Num = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			pstmt.setInt(1, bno);
		
			if(rs.next()) {
				int Client_Num = rs.getInt("Client_Num");
				Bupdate();
				System.out.println("대여 번호 : " + rs.getInt("Rend_Num") +  ", 대여 수량 " + rs.getInt("Rend_Count") 
				+ ", 대여일 : " + rs.getDate("Rend_Start_Date") + ", 반납일 : " + rs.getDate("Rend_End_Date")
				+ ", 대여료 : " +  rs.getString("Book_Writer") + ", 연체료 : " + rs.getInt("Rend_Late_Fee") 
				+ ", 대출 유무 : " + rs.getInt("Rend_Late_Fee") + ", 대여한 고객 번호 : " + rs.getInt("Client_Num")
				+ ", 대여한 고객 이름 : " + rs.getString("Client_Name"));
				
				BookVO rendinfo = new BookVO(rs.getInt("Client_Num"), rs.getString("Client_Name"), rs.getInt("Rend_Num"), 
						rs.getInt("Rend_Count"), rs.getDate("Rend_Start_Date"), 
						rs.getDate("Rend_End_Date"), rs.getInt("Rend_Rental_Fee"), 
						rs.getInt("Rend_Late_Fee"));
				list2.add(rendinfo);
				System.out.print("고객정보를 확인하시겠습니까? [Y/N]");
				System.out.print(">");
				String reply = scan.next();
				if(reply.equals("Y")) {
					Csearch();
				} else if(reply.equals("N")) {
					System.out.println("메뉴로 돌아갑니다.");
					return;
				}
			}
			System.out.println("=====================================================================================");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public void Csearch() {
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid = "test01";
		String upw = "test01";
	
		
		System.out.println("회원번호를 입력하세요>");
		int cno = scan.nextInt();
		
		String sql = "select * from book where Client_Num = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			pstmt.setInt(1, cno);			
			
			if(rs.next()) {
			System.out.println("회원 번호 : " + rs.getInt("Client_Num") +  ", 회원 이름 " + rs.getString("Client_Name") 
				+ ", 성별 : " + rs.getString("Client_Sex") + ", 전화 번호 : " + rs.getInt("Client_Phone_Num")
				+ ", 주소 : " +  rs.getString("Client_Address"));
				
			BookVO csearch = new BookVO(rs.getInt("Client_Num"), rs.getString("Client_Name"), rs.getString("Client_Sex"), 
						rs.getInt("Client_Phone_Num"),	rs.getString("Client_Address"));
			list3.add(csearch);
			}
			System.out.println("=====================================================================================");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public int LateFee() {
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid = "test01";
		String upw = "test01";
		
		String sql = "select trunc(sysdate-to_date(Rend_End_Date)) as \"date\" from Rend";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int LateFee = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
					
			while(rs.next()) {
				int result = rs.getInt("date");
				LateFee = result * 1000;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return LateFee;
	}
}
