package br.com.epiousion.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.epiousion.model.LivrosDAO;

/**
 * Servlet implementation class InserirLivro
 */
@WebServlet("/inserirLivro")
public class InserirLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserirLivro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		int ano = Integer.valueOf(request.getParameter("ano"));
		String autor = request.getParameter("autor");
		
		LivrosDAO livro = new LivrosDAO();
		boolean inseriu = livro.inserir(nome, ano, autor);
		
		RequestDispatcher rd;
		
		if(inseriu) {
			// se inserido com sucesso
			request.setAttribute("nome", nome);
			rd = request.getRequestDispatcher("jsp/livrocadastrado.jsp");
		} else {
			// se não
			rd = request.getRequestDispatcher("jsp/livronaocadastrado.jsp");
		}
		rd.forward(request, response);
	}

}
