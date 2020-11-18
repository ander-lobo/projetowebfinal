package br.com.epiousion.view;

import br.com.epiousion.model.Livro;
import br.com.epiousion.model.LivrosDAO;

import java.util.List;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/emprestaLivros")
public class EmprestaLivros extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LivrosDAO livrosDB = new LivrosDAO();
        List<Livro> listaLivros = null;
        try {
            listaLivros = livrosDB.consultar(1);
            
            request.setAttribute("livros", listaLivros);
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/emprestalivros.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
        
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.valueOf(request.getParameter("id"));
		LivrosDAO livro = new LivrosDAO();
		boolean inseriu = livro.atualizar(id, 0);
		String emprestado = "emprestado";
		RequestDispatcher rd;
		
		if(inseriu) {
			// se inserido com sucesso
			request.setAttribute("emprestado", emprestado);
			rd = request.getRequestDispatcher("jsp/requisicaolivro.jsp");
		} else {
			// se não
			rd = request.getRequestDispatcher("jsp/requisicaolivroerro.jsp");
		}
		rd.forward(request, response);
	}
}
