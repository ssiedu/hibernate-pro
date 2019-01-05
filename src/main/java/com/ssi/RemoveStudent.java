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

public class RemoveStudent extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		String s1=request.getParameter("rno");
		//storing the data using hibernate
		Configuration conf=new Configuration().configure();
		SessionFactory factory=conf.buildSessionFactory();
		Session ses=factory.openSession();
		
		Student stud=new Student();
		stud.setRno(Integer.parseInt(s1));
		
		ses.remove(stud);
		ses.beginTransaction().commit();
		
		out.println("<h3>Record Removed</h3>");
		out.println("<h4><a href=remove.jsp>Remove-More</a></h4>");
		out.println("<h4><a href=index.jsp>Home</a></h4>");
		
		
	}

}
