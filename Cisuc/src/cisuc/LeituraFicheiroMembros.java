/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cisuc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Diogo Miguel Henriques Correia | 2016219825
 */
public class LeituraFicheiroMembros extends LeituraFicheiro {

    //Construtor
    public LeituraFicheiroMembros(File f, ArrayList<Investigador> listaMembros) {
        super();
        this.setListaMembros(listaMembros);
        this.setF(f);
    }

    //Metodos 
    @Override
    public void leFicheiro() {
        File f = new File("membros.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String line;

            String[] arr;
            while ((line = br.readLine()) != null) {
                arr = linhaFich(line);
                Investigador aux;
                aux = linhaInves(arr);
                this.getListaMembros().add(aux);

            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a abrir ficheiro de texto");
        } catch (IOException ex) {
            System.out.println("Erro a ler ficheiro de texto");
        }
    }

    /**
     * Metodo para tratar a linha do ficheiro de membros
     *
     * @param a array com as informacoes de uma linha
     * @return investigador com as suas informacoes
     */
    private Investigador linhaInves(String[] a) {
        /*se o ultimo indice do array arr for um inteiro(nr de telefone)
         entao temos um investigador efetivo*/
        if (eNumero(a[a.length - 1])) {
            Efetivo ef = new Efetivo();
            ef.setNome(a[0]);
            ef.setEmail(a[1]);
            //grupo de investigacao temporario apenas com nome
            ef.setGrupoInvest(new GrupoInvestigacao(a[2]));
            ef.setNumeroGab(Integer.parseInt(a[3]));
            ef.setNumeroTelDei(Integer.parseInt(a[4]));
            return ef;
        } else {
            Estudante es = new Estudante();
            es.setNome(a[0]);
            es.setEmail(a[1]);
            es.setGrupoInvest(new GrupoInvestigacao(a[2]));
            es.setTituloTese(a[3]);
            es.setDataConclusao(a[4]);
            es.setInvestigadorOrient((Efetivo) super.procuraInvestigador(a[5]));
            return es;
        }
    }

    /**
     * Metodo que verifica se uma string e um inteiro
     *
     * @param s string que podera conter um inteiro
     * @return true se for inteiro e false se nao for
     */
    private boolean eNumero(String s) {
        boolean b = true;
        int x;
        try {
            x = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            b = false;
        }
        return b;
    }

}
