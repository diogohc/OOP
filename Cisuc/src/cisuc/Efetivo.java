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
public class Efetivo extends Investigador {

    //Atributos
    private int numeroGab;
    private int numeroTelDei;

    //Construtor
    public Efetivo() {
        super();
    }

    public Efetivo(String nome) {
        setNome(nome);
    }

    //Metodos
    public int getNumeroGab() {
        return numeroGab;
    }

    public void setNumeroGab(int numeroGab) {
        this.numeroGab = numeroGab;
    }

    public int getNumeroTelDei() {
        return numeroTelDei;
    }

    public void setNumeroTelDei(int numeroTelDei) {
        this.numeroTelDei = numeroTelDei;
    }

    public boolean eEfetivo() {
        return true;
    }

    @Override
    public String toString() {
        return "(Efetivo) " + this.getNome() + ", tel:" + this.getNumeroTelDei();
    }

}
