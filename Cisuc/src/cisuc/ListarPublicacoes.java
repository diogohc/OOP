/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cisuc;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Diogo Miguel Henriques Correia | 2016219825
 */
public class ListarPublicacoes {

    //Atributos
    private ArrayList<Publicacao> lista;

    //Construtor
    public ListarPublicacoes() {
        lista = new ArrayList<Publicacao>();
    }

    public ListarPublicacoes(ArrayList<Publicacao> lista) {
        this();
        this.setLista(lista);
    }

    //Metodos
    public ArrayList<Publicacao> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Publicacao> lista) {
        this.lista = lista;
    }

    /**
     * Metodo para listar as publicacoes organizadas por ano
     */
    public void listarPubAno() {
        ArrayList<Publicacao> aux = new ArrayList<>(this.getLista());

        //eliminar publicacoes com mais de 5 anos da lista aux
        for (int i = 0; i < aux.size(); i++) {
            Publicacao p = aux.get(i);
            if (p.getAnoPublicacao() < 2015) {
                aux.remove(p);
            }
        }
        Collections.sort(aux);
        for (Publicacao p : aux) {
            System.out.println(p.getAnoPublicacao() + " " + p.getTitulo());
        }

    }

    /**
     * Metodo para listar as publicacoes organizadas por tipo
     */
    public void listarPubTipo() {
        ArrayList<Publicacao> listaArtConf = new ArrayList<>();
        ArrayList<Publicacao> listaArtRev = new ArrayList<>();
        ArrayList<Publicacao> listaCapLiv = new ArrayList<>();
        ArrayList<Publicacao> listaLivro = new ArrayList<>();
        ArrayList<Publicacao> listaLivroArtConf = new ArrayList<>();
        //guardar as publicacoes em arraylists separadas
        for (Publicacao p : this.getLista()) {
            if (p.getTipoPublicacao().equals("Artigo Conferencia")) {
                listaArtConf.add(p);
            } else if (p.getTipoPublicacao().equals("Artigo Revista")) {
                listaArtRev.add(p);
            } else if (p.getTipoPublicacao().equals("Capitulo Livro")) {
                listaCapLiv.add(p);
            } else if (p.getTipoPublicacao().equals("Livro")) {
                listaLivro.add(p);
            } else {
                listaLivroArtConf.add(p);
            }
        }

        for (Publicacao p : listaArtConf) {
            System.out.println(p.getTipoPublicacao() + " - " + p.getTitulo());
        }
        for (Publicacao p : listaArtRev) {
            System.out.println(p.getTipoPublicacao() + " - " + p.getTitulo());
        }
        for (Publicacao p : listaCapLiv) {
            System.out.println(p.getTipoPublicacao() + " - " + p.getTitulo());
        }
        for (Publicacao p : listaLivro) {
            System.out.println(p.getTipoPublicacao() + " - " + p.getTitulo());
        }
        for (Publicacao p : listaLivroArtConf) {
            System.out.println(p.getTipoPublicacao() + " - " + p.getTitulo());
        }

    }

    /**
     * Metodo para listar as publicacoes por fator de impacto
     */
    public void listarPubFator() {
        ArrayList<Publicacao> listaA = new ArrayList<>();
        ArrayList<Publicacao> listaB = new ArrayList<>();
        ArrayList<Publicacao> listaC = new ArrayList<>();

        for (Publicacao p : this.getLista()) {
            if (p.fatorImpacto().equals("A")) {
                listaA.add(p);
            } else if (p.fatorImpacto().equals("B")) {
                listaB.add(p);
            } else {
                listaC.add(p);
            }
        }

        for (Publicacao p : listaA) {
            System.out.println(p.fatorImpacto() + " - " + p.getTitulo());
        }
        for (Publicacao p : listaB) {
            System.out.println(p.fatorImpacto() + " - " + p.getTitulo());
        }
        for (Publicacao p : listaC) {
            System.out.println(p.fatorImpacto() + " - " + p.getTitulo());
        }

    }

}
