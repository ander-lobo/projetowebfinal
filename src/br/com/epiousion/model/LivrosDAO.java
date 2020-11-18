package br.com.epiousion.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivrosDAO {
	
    public void deletar() {
		
	}
	
	public boolean inserir(String nome, int ano, String autor) {
		Connection c = ConexaoDatasource.getConexao();
		PreparedStatement s;
		try {
			s = c.prepareStatement("insert into livros(nome, ano, autor) " + "values (?, ?, ?)");
			s.setString(1, nome);
			s.setInt(2, ano);
			s.setString(3, autor);
			int numeroLinhas = s.executeUpdate();
			s.close();
			c.close();
			if(numeroLinhas > 0){
				return true;				
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean atualizar(int id, int disponivel) {
		Connection c = ConexaoDatasource.getConexao();
		PreparedStatement s;
		try {
			s = c.prepareStatement("update livros set disponivel= ? WHERE id= ?;");
			s.setInt(1, disponivel);
			s.setInt(2, id);
			int numeroLinhas = s.executeUpdate();
			s.close();
			c.close();
			if(numeroLinhas > 0){
				return true;				
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Livro> consultar(int disponivel) {
		List<Livro> listaLivros = new ArrayList<Livro>();
		ResultSet rs = null;
		Connection c = ConexaoDatasource.getConexao();
		PreparedStatement s;
        try {            
            s = c.prepareStatement("select id, nome, ano, autor from livros where disponivel = ?");
            s.setInt(1, disponivel);
            rs = s.executeQuery();
            while (rs.next()) {
            	int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String autor = rs.getString("autor");
                int ano = rs.getInt("ano");
                Livro p = new Livro(id, nome, autor, ano);
                listaLivros.add(p);
            }
            s.close();
            c.close();
        } catch (SQLException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        }
        return listaLivros;
	}
	
	public List<Livro> consultarTodos() {
		List<Livro> listaLivros = new ArrayList<Livro>();
		ResultSet rs = null;
		Connection c = ConexaoDatasource.getConexao();
		PreparedStatement s;
        try {            
            s = c.prepareStatement("select * from livros");
            rs = s.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String autor = rs.getString("autor");
                int ano = rs.getInt("ano");
                Livro p = new Livro(id, nome, autor, ano);
                listaLivros.add(p);
            }
            s.close();
            c.close();
        } catch (SQLException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        }
        return listaLivros;
	}

}
