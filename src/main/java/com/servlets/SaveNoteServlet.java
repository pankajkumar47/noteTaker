package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Helper.FactoryProvider;
import com.entites.Todo;

public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String title= request.getParameter("title");
			String note= request.getParameter("content");
			Todo newTodo= new Todo(title,note,new Date());
			Session session= FactoryProvider.getFactory().openSession();
			Transaction tx= session.beginTransaction();
			session.save(newTodo);
			tx.commit();
			session.close();
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<h1 style='text-align:center'>data saved successfully</h1>");
			out.println("<h1 style='text-align:center'><a href='show_notes.jsp' >view all notes</a></h1>");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
