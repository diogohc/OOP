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
public class GrupoInvestigacao implements Serializable {

    //Atributos
    private String nome;
    private String acronimo;
    private Efetivo investigadorResp;
    private ArrayList<Investigador> listaMembros;
    private ArrayList<Publicacao> listaPublicacoes;
    

    //Construtor
    public GrupoInvestigacao() {
        listaMembros = new ArrayList<Investigador>();
        listaPublicacoes = new ArrayList<Publicacao>();
    }

    public GrupoInvestigacao(String nome) {
        this();
        setNome(nome);
    }

    //Metodos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAcronimo() {
        return acronimo;
    }

    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    public Efetivo getInvestigadorResp() {
        return investigadorResp;
    }

    public void setInvestigadorResp(Efetivo investigadorResp) {
        this.investigadorResp = investigadorResp;

        this.investigadorResp.setGrupoInvest(this);
        //adicionar o investigador responsavel a lista de membros
        this.getListaMembros().add(investigadorResp);
    }

    public ArrayList<Investigador> getListaMembros() {
        return listaMembros;
    }

    public void setListaMembros(ArrayList<Investigador> listaMembros) {
        this.listaMembros = listaMembros;
    }

    public ArrayList<Publicacao> getListaPublicacoes() {
        return listaPublicacoes;
    }

    public void setListaPublicacoes(ArrayList<Publicacao> listaPublicacoes) {
        this.listaPublicacoes = listaPublicacoes;
    }

    public int nrMembrosEstudantes() {
        int nrEstudantes = 0;
        for (Investigador i : this.getListaMembros()) {
            if (!i.eEfetivo()) {
                nrEstudantes++;
            }
        }
        return nrEstudantes;
    }

    public int nrMembrosEfetivos() {
        int nrEfetivos = 0;
        for (Investigador i : this.getListaMembros()) {
            if (i.eEfetivo()) {
                nrEfetivos++;
            }
        }
        return nrEfetivos;
    }

    /**
     * Metodo para listar o nome dos membros efetivos
     */
    public void listaMembrosEfetivos() {
        System.out.println("Membros efetivos:");
        for (Investigador inv : this.getListaMembros()) {
            if (inv.eEfetivo()) {
                System.out.println(inv.getNome());
            }
        }
    }

    /**
     * Metodo para listar o nome dos membros estudantes
     */
    public void listaMembrosEstudantes() {
        System.out.println("Membros estudantes:");
        for (Investigador inv : this.getListaMembros()) {
            if (!inv.eEfetivo()) {
                System.out.println(inv.getNome());
            }
        }
    }

    /**
     * Metodo que verifica se uma publicacao esta na arraylist de publicacoes
     *
     * @param nomePub publicacao que queremos verificar se esta na arraylist
     * @return verdadeiro se ja estiver e falso se nao estiver
     */
    private boolean verificaPub(String nomePub) {
        for (Publicacao pub : getListaPublicacoes()) {
            if (pub.getTitulo().equals(nomePub)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que adiciona publicacoes dos membros a arraylist de publicacoes do
     * grupo
     */
    public void addPub() {
        for (Investigador i : getListaMembros()) {
            for (Publicacao p : i.getListaPublicacoes()) {
                //se a publicacao nao estiver na arraylist
                if (!verificaPub(p.getTitulo())) {
                    this.getListaPublicacoes().add(p);
                }
            }
        }
    }

    @Override
    public String toString() {
        String s = "GrupoInvestigacao:\n" + "Nome:" + this.nome + "\n"
                + "Acronimo: " + this.acronimo + "\n"
                + "Investigador Responsavel: " + this.investigadorResp.getNome() + "\n"
                + "Membros:\n";
        Investigador inv;
        for (int i = 0; i < listaMembros.size(); i++) {
            inv = listaMembros.get(i);
            s += inv.getNome() + "\n";
        }
        return s;
    }

}
