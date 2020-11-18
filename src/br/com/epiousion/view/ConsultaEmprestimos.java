package br.com.epiousion.view;

import br.com.epiousion.model.Livro;
import br.com.epiousion.model.LivrosDAO;

import java.util.List;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/consultaEmprestimos")
public class ConsultaEmprestimos extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LivrosDAO livrosDB = new LivrosDAO();
        List<Livro> listaLivros = null;
        try {
            listaLivros = livrosDB.consultar(0);

            request.setAttribute("livros", listaLivros);
            RequestDispatcher rd = request.getRequestDispatcher("/consultaemprestimos.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
