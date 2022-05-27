/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cisuc;

import java.util.ArrayList;

/**
 *
 * @author Diogo Miguel Henriques Correia | 2016219825
 */
public class CapituloLivro extends Livro {

    //Atributos
    private String nomeCapitulo;
    private int pagIni;
    private int pagFim;

    //Construtores
    public CapituloLivro() {
        super();
        this.setTipoPublicacao("Capitulo Livro");
    }

    public CapituloLivro(ArrayList<Investigador> autores, String titulo,
            int anoPublicacao, int dimAudiencia, String nomeCapitulo,
            int pagIni, int pagFim) {
        super(autores, titulo, anoPublicacao, dimAudiencia);
        this.setTipoPublicacao("Capitulo Livro");
        this.setNomeCapitulo(nomeCapitulo);
        this.setPagIni(pagIni);
        this.setPagFim(pagFim);

    }

    //Metodos
    public String getNomeCapitulo() {
        return nomeCapitulo;
    }

    public void setNomeCapitulo(String nomeCapitulo) {
        this.nomeCapitulo = nomeCapitulo;
    }

    public int getPagIni() {
        return pagIni;
    }

    public void setPagIni(int pagIni) {
        this.pagIni = pagIni;
    }

    public int getPagFim() {
        return pagFim;
    }

    public void setPagFim(int pagFim) {
        this.pagFim = pagFim;
    }

    @Override
    public String toString() {
        return "CapLivro{" + "nomeCapitulo=" + nomeCapitulo + ", pagIni=" + pagIni + ", pagFim=" + pagFim + '}';
    }

}
