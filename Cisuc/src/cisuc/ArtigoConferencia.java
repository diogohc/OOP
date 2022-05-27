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
public class ArtigoConferencia extends Publicacao {

    //Atributos
    private String nomeConferencia;
    private String dataConferencia;
    private String localConferencia;

    //Construtores
    public ArtigoConferencia() {
        super();
        this.setTipoPublicacao("Artigo Conferencia");
    }

    public ArtigoConferencia(ArrayList<Investigador> autores, String titulo,
            int anoPublicacao, int dimAudiencia, String nomeConferencia,
            String dataConferencia, String localConferencia) {
        super(autores, titulo, anoPublicacao, dimAudiencia);
        this.setNomeConferencia(nomeConferencia);
        this.setDataConferencia(dataConferencia);
        this.setLocalConferencia(localConferencia);
        this.setTipoPublicacao("Artigo Conferencia");
    }

    //Metodos
    public String getNomeConferencia() {
        return nomeConferencia;
    }

    public void setNomeConferencia(String nomeConferencia) {
        this.nomeConferencia = nomeConferencia;
    }

    public String getDataConferencia() {
        return dataConferencia;
    }

    public void setDataConferencia(String dataConferencia) {
        this.dataConferencia = dataConferencia;
    }

    public String getLocalConferencia() {
        return localConferencia;
    }

    public void setLocalConferencia(String localConferencia) {
        this.localConferencia = localConferencia;
    }

    @Override
    public String fatorImpacto() {
        if (this.getDimAudiencia() >= 500) {
            return "A";
        } else if (this.getDimAudiencia() < 200) {
            return "C";
        } else {
            return "B";
        }
    }

    @Override
    public String toString() {
        return "ArtigoConferencia{" + ", nomeConferencia=" + nomeConferencia + ", dataConferencia=" + dataConferencia + ", localConferencia=" + localConferencia + '}';
    }

}
