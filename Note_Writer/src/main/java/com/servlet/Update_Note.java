package com.servlet;

import java.io.IOException;
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

@WebServlet("/UpdateNote")
public class Update_Note extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		int id=Integer.parseInt(req.getParameter("NoteID"));
		
		Session session = FactoryProvider.getFactory().openSession();
		Transaction tx=session.beginTransaction();
		
		Note note = session.get(Note.class, id);
		
		note.setTitle(title);
		note.setContent(content);
        note.setAddedDate(new Date());
		
		tx.commit();
		session.close();
		
		res.sendRedirect("All_Notes.jsp");
	}

}
