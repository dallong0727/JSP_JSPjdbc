package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBCInsert {

	public static void main(String[] args) {
		
		//스캐너
		Scanner scan = new Scanner(System.in);
		
		System.out.println("아이디>");
		String id = scan.next();
		
		System.out.println("비밀번호>");
		String pw = scan.next();
		
		System.out.println("이름>");
		String name = scan.next();
		
		System.out.println("이메일>");
		String email = scan.next();
		
		System.out.println("주소>");
		String address = scan.next();
		
		//1. DB연결에 필요한 변수
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid = "test01";
		String upw = "test01";
		
		String sql = "insert into member01 values(?,?,?,?,?)";
		
		//2. DB연동에 사용할 클래스변수들을 선언
		//ResultSet은 select구문이 아니라면 필요 없습니다~
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//3. JDBC연결 드라이버 호출
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//4. 커넥션객체 생성
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			//5. SQL문전송을 위한 pstmt객체 생성
			//SQL문의 ?의 순서대로 인덱스 번호를 가지고 1부터 시작합니다. 
			//pstmt에 전달되 SQL문의 ?를 채우는 작업
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.setString(5, address);
			
			//6. SQL문의 실행 (insert, delete, update 문은 Update()문을 실행합니다.
			int result = pstmt.executeUpdate(); //인서트 성공시 1을 반환, 실패하면 0을 반환
			
			if(result == 1) {
				System.out.println("DB입력 성공");
			} else {
				System.out.println("DB입력 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
}
