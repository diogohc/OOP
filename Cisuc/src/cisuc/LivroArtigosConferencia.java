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
public class LivroArtigosConferencia extends Livro {

    //Atributos
    private String nomeConf;
    private int nrArtigos;

    //Construtor
    public LivroArtigosConferencia() {
        super();
        this.setTipoPublicacao("Livro Artigos Conferencia");
    }

    public LivroArtigosConferencia(ArrayList<Investigador> autores, String titulo,
            int anoPublicacao, int dimAudiencia, String nomeConf, int nrArtigos) {
        super(autores, titulo, anoPublicacao, dimAudiencia);
        this.setTipoPublicacao("Livro Artigos Conferencia");
        this.setNomeConf(nomeConf);
        this.setNrArtigos(nrArtigos);
    }

    //Metodos
    public String getNomeConf() {
        return nomeConf;
    }

    public void setNomeConf(String nomeConf) {
        this.nomeConf = nomeConf;
    }

    public int getNrArtigos() {
        return nrArtigos;
    }

    public void setNrArtigos(int nrArtigos) {
        this.nrArtigos = nrArtigos;
    }

    @Override
    public String fatorImpacto() {
        if (this.getDimAudiencia() >= 7500) {
            return "A";
        } else if (this.getDimAudiencia() < 2500) {
            return "C";
        } else {
            return "B";
        }
    }

    @Override
    public String toString() {
        return "LivroArtigosConferencia{" + "nomeConf=" + nomeConf + ", nrArtigos=" + nrArtigos + '}';
    }
    
    

}
