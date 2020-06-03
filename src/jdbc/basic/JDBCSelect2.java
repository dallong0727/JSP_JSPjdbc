package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class JDBCSelect2 {

	public static void main(String[] args) {

		/*
		 * 회원 ID를 입력받아서 해당 ID의 회원정보를 모두 출력하는 JDBC코드를 작성
		 */

		Scanner scan = new Scanner(System.in);

		System.out.println("아이디>");
		String id2 = scan.next();

		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid = "test01";
		String upw = "test01";

		//		String sql = "select * from member01 where id='" + id2 + "'";
		String sql = "select * from member01 where id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id2);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				System.out.println(rs.getString("id"));
				System.out.println(rs.getString("pw"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("email"));
				System.out.println(rs.getString("address"));	
			} else {
				System.out.println("해당 회원은 존재하지 않습니다.");
			}			
		} catch (Exception e) {

		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {

			}
		}
	}
}
