/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cisuc;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Diogo Miguel Henriques Correia | 2016219825
 */
public class Livro extends Publicacao {

    //Atributos
    private String editora;
    private int isbn;

    //Construtores
    public Livro() {
        super();
        this.setTipoPublicacao("Livro");
    }

    public Livro(ArrayList<Investigador> autores, String titulo,
            int anoPublicacao, int dimAudiencia) {
        super(autores, titulo, anoPublicacao, dimAudiencia);
        this.setTipoPublicacao("Livro");
        this.setEditora(editora);
        this.setIsbn(isbn);
    }

    public Livro(ArrayList<Investigador> autores, String titulo,
            int anoPublicacao, int dimAudiencia, String editora, int isbn) {
        super(autores, titulo, anoPublicacao, dimAudiencia);
        this.setTipoPublicacao("Livro");

    }

    //Metodos
    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    @Override
    public String fatorImpacto() {
        if (this.getDimAudiencia() >= 10000) {
            return "A";
        } else if (this.getDimAudiencia() < 5000) {
            return "C";
        } else {
            return "B";
        }
    }

    @Override
    public String toString() {
        return "Livro{" + "editora=" + editora + ", isbn=" + isbn + '}';
    }
}
