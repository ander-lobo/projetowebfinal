package br.com.epiousion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Home")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		if(user.equals("admin") && password.equals("admin")){
		
		HttpSession session = request.getSession();
		
		session.setAttribute("user", user);
		session.setAttribute("password", password);
		
		response.getWriter().append("Bem vindo Bibliotecário!");
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/homeadmin.jsp");
		rd.forward(request, response);
		
		} else if(user.equals("cliente") && password.equals("cliente")){
			
			HttpSession session = request.getSession();
			
			session.setAttribute("user", user);
			session.setAttribute("password", password);
			
			response.getWriter().append("Bem vindo Cliente!");
			RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
			rd.forward(request, response);
			
		} else {
			response.getWriter().append("Usuário não cadastrado ou senha incorreta!");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
