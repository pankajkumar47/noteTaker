package com.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Helper.FactoryProvider;
import com.entites.Todo;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Session s= FactoryProvider.getFactory().openSession();
			Transaction tx= s.beginTransaction();
			int id=Integer.parseInt(request.getParameter("id").trim());
			Todo note=s.get(Todo.class, id);
			note.setContent(request.getParameter("content"));
			note.setTitle(request.getParameter("title").trim());
			note.setAddedDate(new Date());
			s.update(note);
			tx.commit();
			s.close();
			
			response.sendRedirect("show_notes.jsp");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
