/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cisuc;

/**
 *
 * @author Diogo Miguel Henriques Correia | 2016219825
 */
public class Estudante extends Investigador {

    //Atributos
    private String tituloTese;
    private String dataConclusao;
    private Efetivo investigadorOrient;

    //Construtor
    public Estudante() {
        super();

    }

    //Metodos
    public String getTituloTese() {
        return tituloTese;
    }

    public void setTituloTese(String tituloTese) {
        this.tituloTese = tituloTese;
    }

    public String getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(String dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public Efetivo getInvestigadorOrient() {
        return investigadorOrient;
    }

    public void setInvestigadorOrient(Efetivo investigadorOrient) {
        this.investigadorOrient = investigadorOrient;
    }

    public boolean eEfetivo() {
        return false;
    }

    @Override
    public String toString() {
        return "(Estudante) " + this.getNome() + ", Investigador Orientador: " + this.getInvestigadorOrient().getNome();
    }

}
