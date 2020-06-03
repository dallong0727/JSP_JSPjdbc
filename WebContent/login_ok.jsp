<%@page import="com.jdbc.model.MemberVO"%>
<%@page import="com.jdbc.model.MemberDAO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	/*
	1. DAO에 logion메서드를 만들고 필요한 값을 전달합니다.
	2. login메서드 안에서는 DB연결작업을 처리하고 결과를 반환합니다.
	3. 결과에 따라서 성공시 세션을 생성하고 login_welcome페이지로 리다이렉트 처리
	4. 실패시에는 login_fail 페이지로 리다이렉트 처리.
	*/
	
	MemberDAO dao = MemberDAO.getInstance();
	
	boolean result = dao.login(id, pw);
	
	if(result) {
		session.setAttribute("id", id);
		response.sendRedirect("login_welcome.jsp");
	} else {
		response.sendRedirect("login_fail.jsp");
	}
	
	/* 
	String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	String uid = "JSP";
	String upw = "JSP";
	
	String sql= "select * from members where id = ? and pw=?";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, uid, upw);
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		
		//sql문 실행
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			session.setAttribute("id", id);
			response.sendRedirect("login_welcome.jsp");
		} else {
			response.sendRedirect("login_fail.jsp");
		}
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if(conn != null) conn.close();
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		} catch(Exception e2) {
			e2.printStackTrace();
		}
	} 
	*/
	
%>   
