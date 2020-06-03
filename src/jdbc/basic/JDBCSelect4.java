package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import jdbc.command.Board01;
import jdbc.command.MemberBoard;

public class JDBCSelect4 {

	public static void main(String[] args) {
		
		ArrayList<Board01> list = new ArrayList<>();
		MemberBoard mb = new MemberBoard();
		
		Scanner scan = new Scanner(System.in);
		System.out.print("아이디>");
		String search = scan.next();
	
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid = "test01";
		String upw = "test01";		

		String sql = "select m.id,pw,name,email,address,num,title,content from member01 m join board01 b on m.id=b.id where m.id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
	
			rs = pstmt.executeQuery();
			
			while(rs.next()) {	
				//1번 회전할 때마다 글에 대한 정보를 list에 추가
				mb.setId(rs.getString("id"));
				mb.setPw(rs.getString("pw"));
				mb.setName(rs.getString("name"));
				mb.setEmail(rs.getString("email"));
				mb.setAddress(rs.getString("address"));
				
				Board01 board = new Board01(rs.getInt("num"), rs.getString("title"), rs.getString("content"));
				list.add(board);
			}
			System.out.println(list.size());
			mb.setList(list);
			
			System.out.println("아이디 : " + mb.getId());
			System.out.println("비밀번호 : " + mb.getPw());
			System.out.println("이름 : " + mb.getName());
			System.out.println("이메일 : " + mb.getEmail());
			System.out.println("주소 : " + mb.getAddress());
			System.out.println("크기 : " + mb.getList().size());
		} catch (Exception e) {
			e.printStackTrace();
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