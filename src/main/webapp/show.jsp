<%@page import="org.hibernate.cfg.Configuration" %>
<%@page import="org.hibernate.Session" %>
<%@page import="hibdemo.Student" %>
<%
	int rno=Integer.parseInt(request.getParameter("rno"));
	Configuration conf=new Configuration().configure();
	Session ses=conf.buildSessionFactory().openSession();
	Student stud=ses.get(Student.class, rno);
%>

<html>
<body>
<h2>Student-Data-Management</h2>
<h4>Student-Details</h4>
<hr>
<pre>
	Roll No .	: <%=stud.getRno() %>
	Stud Name	: <%=stud.getName() %>
	Branch  .	: <%=stud.getBranch() %>
	Semester	: <%=stud.getSem() %>
</pre>
<hr>
<a href="search.jsp">Search-More</a><br>
<a href="index.jsp">Home</a><br>
</body>
</html>