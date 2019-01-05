package com.ssi;

import hibdemo.Student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveStudent extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		String s1=request.getParameter("rno");
		String s2=request.getParameter("sname");
		String s3=request.getParameter("branch");
		String s4=request.getParameter("sem");
		//storing the data using hibernate
		Configuration conf=new Configuration().configure();
		SessionFactory factory=conf.buildSessionFactory();
		Session ses=factory.openSession();
		
		Student stud=new Student();
		stud.setRno(Integer.parseInt(s1));
		stud.setName(s2);
		stud.setBranch(s3);
		stud.setSem(Integer.parseInt(s4));
		
		ses.save(stud);
		ses.beginTransaction().commit();
		
		out.println("<h3>Record Stored</h3>");
		out.println("<h4><a href=entry.jsp>Add-More</a></h4>");
		out.println("<h4><a href=index.jsp>Home</a></h4>");
		
		
	}

}
