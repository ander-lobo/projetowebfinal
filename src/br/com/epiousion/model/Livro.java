package br.com.epiousion.model;

public class Livro {

    private String nome;
    private String autor;
    private int ano;
    private int id;

    public Livro(String nome, String autor, int ano) {
        this.nome = nome;
        this.autor = autor;
        this.ano = ano;
    }

    public Livro(int id, String nome, String autor, int ano) {
        this(nome, autor, ano);
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public void setId(int i) {
        id = i;
    }

    @Override
    public String toString() {
        String pNome = " Nome     :" + nome + "\n";
        String pId = " ID    :" + id + "\n";
        String pAutor = " Autor:" + autor + "\n";
        String pAno = " Ano    :" + ano + "\n";
        String dados = pNome + pId + pAutor + pAno + "\n";
        return dados;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Livro) {
            Livro oLivro = (Livro) o;
            return this.id == oLivro.id;
        } else
            return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        return hash;
    }
}