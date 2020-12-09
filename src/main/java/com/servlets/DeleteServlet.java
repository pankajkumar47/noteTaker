package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Helper.FactoryProvider;
import com.entites.Todo;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id= Integer.parseInt(request.getParameter("id").trim());
			Session s= FactoryProvider.getFactory().openSession();
			Todo note=s.get(Todo.class, id);
			Transaction tx= s.beginTransaction();
			s.delete(note);
			tx.commit();
			s.close();
			response.sendRedirect("show_notes.jsp");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
