package br.com.epiousion.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

@WebFilter("/jsp/*")
public class ControleDeAcesso implements Filter {
    
    @SuppressWarnings("unused")
	private FilterConfig fc;
    
    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("[FILTER] Inicializando o filtro LogAccess");
        this.fc = config;
    }
    
    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws ServletException, IOException {
        
        // Colocamos aqui qualquer operacao de filtro de request
        System.out.println("[FILTER] Executando o filtro de log de acesso");
        HttpServletRequest request = (HttpServletRequest) req;
        System.out.println("[FILTER] URL requisitada :" + request.getRequestURI());
        
        //Se o cliente tiver feito login, um objeto de nome cliente existe na sessão.
        String user = (String) request.getSession().getAttribute("user");
        
        if(user.equals("admin")){
            System.out.println("*** " + user + " ***");
            // Prossegue a requisição original
            chain.doFilter(req, res);
        }else{
            System.out.println("[FILTER] Redirecionando para a tela de login...");
            HttpServletResponse response = (HttpServletResponse) res;
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
        
    }
    
    @Override
    public void destroy() {
        System.out.println("[FILTER] Destruindo o filtro LogAccess");
    }
}
