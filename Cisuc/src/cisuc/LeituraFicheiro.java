/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cisuc;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Diogo Miguel Henriques Correia | 2016219825
 */
abstract class LeituraFicheiro {

    //Atributo
    private File f;
    private ArrayList<Investigador> listaMembros;
    private ArrayList<GrupoInvestigacao> listaGrupos;
    private ArrayList<Publicacao> listaPublicacoes;

    //Construtor
    public LeituraFicheiro() {
        listaMembros = new ArrayList<Investigador>();
        listaGrupos = new ArrayList<GrupoInvestigacao>();
        listaPublicacoes = new ArrayList<Publicacao>();

    }

    public LeituraFicheiro(File f) {
        this.f = f;
    }

    //Metodos
    public File getF() {
        return f;
    }

    public void setF(File f) {
        this.f = f;
    }

    public ArrayList<Investigador> getListaMembros() {
        return listaMembros;
    }

    public void setListaMembros(ArrayList<Investigador> listaMembros) {
        this.listaMembros = listaMembros;
    }

    public ArrayList<GrupoInvestigacao> getListaGrupos() {
        return listaGrupos;
    }

    public void setListaGrupos(ArrayList<GrupoInvestigacao> listaGrupos) {
        this.listaGrupos = listaGrupos;
    }

    public ArrayList<Publicacao> getListaPublicacoes() {
        return listaPublicacoes;
    }

    public void setListaPublicacoes(ArrayList<Publicacao> listaPublicacoes) {
        this.listaPublicacoes = listaPublicacoes;
    }

    public abstract void leFicheiro();

    /**
     * Metodo para criar um array com as informacoes de uma linha do ficheiro de
     * texto
     *
     * @param s linha do ficheiro
     * @return array com informacoes
     */
    public String[] linhaFich(String s) {
        String[] arr;
        arr = s.split(",");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].trim();
        }
        return arr;
    }

    /**
     * Metodo para procurar um investigador
     *
     * @param nomeInvestigador nome do investigador que queremos encontrar
     * @return investigador com nome=nomeInvestigador
     */
    public Investigador procuraInvestigador(String nomeInvestigador) {
        Investigador inv;
        for (int i = 0; i < getListaMembros().size(); i++) {
            inv = getListaMembros().get(i);
            //se o investigador existir
            if (inv.getNome().equalsIgnoreCase(nomeInvestigador)) {
                return inv;
            }
        }
        System.out.println("ERRO! Investigador nao foi encontrado");
        return null;
    }

}
