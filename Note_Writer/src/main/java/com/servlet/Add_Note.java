package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.FactoryProvider.FactoryProvider;
import com.entity.Note;

@WebServlet("/AddNote")
public class Add_Note extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			res.setContentType("text/html");
			
			String title = req.getParameter("title");
			String content = req.getParameter("content");

			Note note = new Note(title, content, new Date());

//			System.out.println(note.getId()+" "+note.getTitle());

			Session session = FactoryProvider.getFactory().openSession();
			Transaction tx = session.beginTransaction();
			
			session.persist(note);
			
			tx.commit();
			session.close();
			
			PrintWriter out = res.getWriter();
			out.println("<h2 style='color:aqua; text-align:center'>Note is Added successfully !!</h2>");
			out.println("<h2 style='text-align:center;'><a href='All_Notes.jsp'>View all Notes </a></h2>");
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
