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
abstract class Publicacao implements Serializable, Comparable<Publicacao> {

    //Atributos
    private ArrayList<Investigador> autores;
    private String titulo;
    private String tipoPublicacao;
    private int dimAudiencia;
    private int anoPublicacao;
    private String[] palavrasChave;
    private String resumo;

    //Construtores
    public Publicacao() {
        autores = new ArrayList<>();
    }

    public Publicacao(ArrayList<Investigador> autores, String titulo,
            int anoPublicacao, int dimAudiencia) {
        this();
        this.setAutores(autores);
        this.setTitulo(titulo);
        this.setAnoPublicacao(anoPublicacao);
        this.setDimAudiencia(dimAudiencia);

    }

    //Metodos
    public ArrayList<Investigador> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Investigador> autores) {
        this.autores = autores;
        //adicionar a publicacao a lista de publicacoes do autor
        for (Investigador inv : this.autores) {
            inv.getListaPublicacoes().add(this);
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String[] getPalavrasChave() {
        return palavrasChave;
    }

    public void setPalavrasChave(String[] palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getTipoPublicacao() {
        return tipoPublicacao;
    }

    public void setTipoPublicacao(String tipoPublicacao) {
        this.tipoPublicacao = tipoPublicacao;
    }

    public int getDimAudiencia() {
        return dimAudiencia;
    }

    public void setDimAudiencia(int dimAudiencia) {
        this.dimAudiencia = dimAudiencia;
    }

    public abstract String fatorImpacto();

    @Override
    public int compareTo(Publicacao p) {
        //ordenar por ordem crescente de ano
        return (this.getAnoPublicacao() > p.getAnoPublicacao() ) ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Publicacao{" + "autores=" + autores + ", titulo=" + titulo 
                + ", tipoPublicacao=" + tipoPublicacao + ", dimAudiencia=" 
                + dimAudiencia + ", anoPublicacao=" + anoPublicacao;
    }


}
