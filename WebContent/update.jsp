<%@page import="com.jdbc.model.MemberVO"%>
<%@page import="com.jdbc.model.MemberDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("id") == null) {
		response.sendRedirect("login.jsp");
	}
	
	//회원정보를 조회해서 가지고 오는 코드
	//id는 세션에서 얻는다.
	request.setCharacterEncoding("utf-8");
	String id = (String) session.getAttribute("id");
	String pw ="";
	String name ="";
	String phone1 ="";
	String phone2 ="";
	String phone3 ="";
	String gender ="";
	
	//1. DAO객체 생성
	MemberDAO dao = MemberDAO.getInstance();
	MemberVO vo = dao.getInfo(id);
	
	name = vo.getName();
	phone1 = vo.getPhone1();
	phone2 = vo.getPhone2();
	phone3 = vo.getPhone3();
	gender = vo.getGender();
	/* 
	//DB연결에 필요한 변수 선언
	1. id 기반으로 데이터 베이스 select구문으로 값을 조회해서 가지고 옵니다.
	2. 조회한 결과를 태그안에 미리 갖도록 하는 코드를 작성하세요.
	
	String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	String uid = "JSP";
	String upw = "JSP";

	String sql = "select * from members where id = ?";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		//3, 드라이버 호출
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//4. conn 생성
		conn = DriverManager.getConnection(url, uid, upw);
		
		//5. pstmt생성
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {	
			name = rs.getString("name");
			phone1 = rs.getString("phone1");
			phone2 = rs.getString("phone2");
			phone3 = rs.getString("phone3");
			gender = rs.getString("gender");	
		}
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if(conn != null) conn.close(); 
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		} 
	} 
	*/
	
%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<!-- 
	input태그에 미리 값을 갖게 하려면 value속성을 이욯합니다.
	input태그에 읽기만 허용하는 옵션은 readonly
	select를 미리선택되게 하는 옵션은 selected
	radio, checkbox를 미리 선택하는 옵션은 checked
	태그의 사용을 막는 옵션은 disabled
	 -->
	<h2>정보수정 연습</h2>
	
	<form action="update_ok.jsp" method="post">
		아이디 : <input type="text" name="id" size="10" value="<%= id %>" readonly><br>
		이름 : <input type="text" name="name" size="10" value="<%= name %>"><br>
		전화번호 
		<select name="phone1">	
			<option <%=phone1.equals("010") ? "selected" : "" %>>010</option>
			<option <%=phone1.equals("031") ? "selected" : "" %>>031</option>
			<option <%=phone1.equals("02") ? "selected" : "" %>>02</option>
		</select>
		- <input type="text" name="phone2" size="10" value="<%= phone2 %>">
		- <input type="text" name="phone3" size="10" value="<%= phone3 %>"><br>
		성별 :
		<% if(gender == null || gender.equals("m")) { %>
			<input type="radio" name="gender" value="m" checked>남자
			<input type="radio" name="gender" value="w" >여자
		<% } else { %>
			<input type="radio" name="gender" value="m" >남자
			<input type="radio" name="gender" value="w" checked>여자
		<% } %>
		<br>
		<input type="submit" value="수정"><br/>
	</form>

</body>
</html>