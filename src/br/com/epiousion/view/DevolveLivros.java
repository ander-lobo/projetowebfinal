package br.com.epiousion.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.epiousion.model.Livro;
import br.com.epiousion.model.LivrosDAO;

@WebServlet("/devolveLivros")
public class DevolveLivros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DevolveLivros() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LivrosDAO livrosDB = new LivrosDAO();
        List<Livro> listaLivros = null;
        try {
            listaLivros = livrosDB.consultar(0);
            
            request.setAttribute("livros", listaLivros);
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/devolvelivros.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.valueOf(request.getParameter("id"));
		LivrosDAO livro = new LivrosDAO();
		boolean inseriu = livro.atualizar(id, 1);
		String devolvido = "devolvido";
		RequestDispatcher rd;
		
		if(inseriu) {
			// se inserido com sucesso
			request.setAttribute("devolvido", devolvido);
			rd = request.getRequestDispatcher("jsp/requisicaolivro.jsp");
		} else {
			// se não
			rd = request.getRequestDispatcher("jsp/requisicaolivroerro.jsp");
		}
		rd.forward(request, response);
	}

}
