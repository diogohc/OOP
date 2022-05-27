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
public class ArtigoRevista extends Publicacao {

    //Atributos
    private String nomeRevista;
    private String dataRevista;
    private int nrRevista;

    //Construtor
    public ArtigoRevista() {
        super();
        this.setTipoPublicacao("Artigo Revista");
    }

    public ArtigoRevista(ArrayList<Investigador> autores, String titulo,
            int anoPublicacao, int dimAudiencia, String nomeRevista,
            String dataRevista, int nrRevista) {
        super(autores, titulo, anoPublicacao, dimAudiencia);
        this.setTipoPublicacao("Artigo Revista");
        this.setNomeRevista(nomeRevista);
        this.setDataRevista(dataRevista);
        this.setNrRevista(nrRevista);

    }

    //Metodos
    public String getNomeRevista() {
        return nomeRevista;
    }

    public void setNomeRevista(String nomeRevista) {
        this.nomeRevista = nomeRevista;
    }

    public String getDataRevista() {
        return dataRevista;
    }

    public void setDataRevista(String dataRevista) {
        this.dataRevista = dataRevista;
    }

    public int getNrRevista() {
        return nrRevista;
    }

    public void setNrRevista(int nrRevista) {
        this.nrRevista = nrRevista;
    }

    @Override
    public String fatorImpacto() {
        if (this.getDimAudiencia() >= 1000) {
            return "A";
        } else if (this.getDimAudiencia() < 500) {
            return "C";
        } else {
            return "B";
        }
    }

    @Override
    public String toString() {
        return "ArtigoRevista{" + "nomeRevista=" + nomeRevista + ", dataRevista=" + dataRevista + ", nrRevista=" + nrRevista + '}';
    }
}
