package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.FactoryProvider.FactoryProvider;
import com.entity.Note;

@WebServlet("/DeleteNote")
public class Delete_Note extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("NoteID"));

			Session session = FactoryProvider.getFactory().openSession();
			Transaction tx = session.beginTransaction();

			Note note = (Note) session.get(Note.class, id);
			session.remove(note);
	
			tx.commit();
			session.close();
			res.sendRedirect("All_Notes.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
