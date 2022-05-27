/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cisuc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Diogo Miguel Henriques Correia | 2016219825
 */
abstract class Investigador implements Serializable {

    //Atributos
    private String nome;
    private String email;
    private GrupoInvestigacao grupoInvest;
    private ArrayList<Publicacao> listaPublicacoes;

    //Construtor
    public Investigador() {
        listaPublicacoes = new ArrayList<Publicacao>();
    }

    //Metodos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GrupoInvestigacao getGrupoInvest() {
        return grupoInvest;
    }

    public void setGrupoInvest(GrupoInvestigacao grupoInvest) {
        this.grupoInvest = grupoInvest;
    }

    public ArrayList<Publicacao> getListaPublicacoes() {
        return listaPublicacoes;
    }

    public void setListaPublicacoes(ArrayList<Publicacao> listaPublicacoes) {
        this.listaPublicacoes = listaPublicacoes;
    }

    public abstract boolean eEfetivo();

    @Override
    public String toString() {
        return this.getNome() + ", " + this.getEmail() + ", " + this.getGrupoInvest();
    }

}
