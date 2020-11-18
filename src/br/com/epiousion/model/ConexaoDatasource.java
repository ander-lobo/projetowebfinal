package br.com.epiousion.model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConexaoDatasource {
	
	@SuppressWarnings("unused")
	private Connection conexao;
	
	//esse metodo vai devolver uma conexao pegando do datasource
	public static Connection getConexao() {
		try {
			Context context = new InitialContext();
			Context env = (Context)context.lookup("java:comp/env");
			DataSource ds = (DataSource)env.lookup("jdbc/epiousion");
			try {
				Connection c = ds.getConnection();
				return c;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
