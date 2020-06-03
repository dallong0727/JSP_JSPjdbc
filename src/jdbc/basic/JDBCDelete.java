package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBCDelete {

	public static void main(String[] args) {
		
		//회원 아이디를 받아서 해당 아이디를 삭제하는 JDBC코드를 완성
		
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 아이디를 입력하세요>");
		String id2 = scan.next();
		
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid = "test01";
		String upw = "test01";
		
		String sql = "delete from member01 where id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id2);
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("DB 삭제 완료");
			} else {
				System.out.println("DB 삭제 실패");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

}
