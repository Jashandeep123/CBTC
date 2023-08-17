<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import = "java.sql.*" %>
<%@page import = "java.io.*" %>
<%
response.setContentType("text/html");
PrintWriter pw=response.getWriter();
String si=request.getParameter("sid");
ResultSet rs;
int i=Integer.parseInt(si);
try
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fst","root","root");
	PreparedStatement ps=con.prepareStatement("select * from student where id=?");
	ps.setInt(1, i);
	 rs=ps.executeQuery();
	 pw.print("<table width=75% border=1>");
	 pw.print("<caption> <h2> Student Record</h2></caption>");
	 ResultSetMetaData rsmd=rs.getMetaData();
	 int colcount=rsmd.getColumnCount();
	 pw.print("<tr>");
	 for(int j=1;j<=colcount;j++)
	 {
		 pw.print("<th>"+rsmd.getColumnName(j)+"</th>");
		 
	 }
	 pw.print("</tr>");
	 while(rs.next())
	{
		pw.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td></tr>");
	}
	pw.close();
}
catch(Exception e)
{
	out.println(e);
}
%>
</body>
</html>