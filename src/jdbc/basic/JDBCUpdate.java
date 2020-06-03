package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBCUpdate {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("수정할 아이디를 입력하세요>");
		String id = scan.next();
		
		System.out.print("수정할 이름을 입력하세요>");
		String name = scan.next();
		
		System.out.print("수정할 이메일을 입력하세요>");
		String email = scan.next();
		
		System.out.print("수정할 주소를 입력하세요>");
		String address = scan.next();
		
		//1. DB연동에 필요한 변수 선언
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid = "test01";
		String upw = "test01";
		
		String sql = "update member01 set name = ?, email = ?, address = ? where id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
				
		try {
			//2. JDBC드라이버 호출
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//3. 커넥션 생성
			conn = DriverManager.getConnection(url, uid, upw);
			
			//4. SQL문 전달 객체 pstmt생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, address);
			pstmt.setString(4, id);
			
			//5. sql문 실행
			int result = pstmt.executeUpdate();
			if(result == 1) {
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

}
