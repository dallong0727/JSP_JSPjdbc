package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import jdbc.command.Board01;

public class JDBCSelect3 {

	public static void main(String[] args) {
		
		ArrayList<Board01> list = new ArrayList<>();
		
		Scanner scan = new Scanner(System.in);
		System.out.print("조회할 시작 데이터행 : ");
		int start = scan.nextInt();
		
		System.out.print("조회할 끝 데이터행 : ");
		int end = scan.nextInt();
		
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid = "test01";
		String upw = "test01";		
		
		String sql = "select * "
				+ "from(select rownum as rn, num, id, title, content "
				+ "from(select num, id, title, content from board01 order by num desc)) "
				+ "where rn > ? and rn <= ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start-1);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			while(rs.next()) {			
				Board01 board = new Board01(rs.getInt("num"), rs.getString("id"), rs.getString("title"), rs.getString("content"));
				list.add(board);
			}
			System.out.println(list.size());
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
