package com.jdbc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
	
	/*
	 * 1. DAO는 클래스를 단순히 DB연동기능을 수행하면 되기 때문에
	 * 불필요하게 여러개 생성되도록 구성할 필요가 없기 때문에 싱글톤 패턴으로 생성합니다.
	 */
	
	//1. 스스로 객체를 생성하고 1개로 제한
	private static MemberDAO instance = new MemberDAO();
	
	//2. 직접 생성할 수 없도록 생성자에 private 을 붙임
	private MemberDAO() {
		//객체가 생성될 때 JDBC드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("클래스 로딩중 에러");
		}
	}
	
	//3. 외부에서 객체생성을 요구할 때 getter메서드를 통해 반환함
	public static MemberDAO getInstance() {
		return instance;
	}
	
	//DAO에 회원관리에 필요한 기능을 메서드로 생성, DB관련변수를 멤버변수로 선언
	private String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	private String uid = "JSP";
	private String upw = "JSP";
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//회원가입 메서드
	public int join(MemberVO vo) {
		int result = 0;
		
		String sql = "insert into members values(?,?,?,?,?,?,?)";
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhone1());
			pstmt.setString(5, vo.getPhone2());
			pstmt.setString(6, vo.getPhone3());
			pstmt.setString(7, vo.getGender());
			
			result = pstmt.executeUpdate();
						
		} catch(Exception e) {
			
		} finally {
			try {
				if(conn != null) conn.close(); 
				if(pstmt != null) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public boolean login(String id, String pw) {
		boolean result = false;
		
		String sql= "select * from members where id = ? and pw=?";
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close(); 
				if(pstmt != null) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public MemberVO getInfo(String id) {
		MemberVO vo = null;
		
		String sql = "select * from members where id = ?";
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String phone3 = rs.getString("phone3");
				String gender = rs.getString("gender");
				
				vo = new MemberVO(id, pw, name, phone1, phone2, phone3, gender);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close(); 
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return vo;
	}
	
	public int update(MemberVO vo) {
		int result = 0;
		
		String sql = "update members set name = ?, phone1 = ?, phone2 = ?, phone3 =?, gender = ? where id = ?";
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPhone1());
			pstmt.setString(3, vo.getPhone2());
			pstmt.setString(4, vo.getPhone3());
			pstmt.setString(5, vo.getGender());
			pstmt.setString(6, vo.getId());
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close(); 
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int delete(String id) {
		int result = 0;
		
		String sql= "delete from members where id = ?";
		
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
		
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close(); 
				if(pstmt != null) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
