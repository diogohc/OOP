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
public class LeituraFicheiroGrupos extends LeituraFicheiro {

    //Construtor
    public LeituraFicheiroGrupos(File f, ArrayList<Investigador> listaMembros,
            ArrayList<GrupoInvestigacao> grupos) {
        super();
        this.setListaMembros(listaMembros);
        this.setListaGrupos(grupos);
        this.setF(f);
    }

    //Metodos
    @Override
    public void leFicheiro() {
        File f = new File("grupos.txt");
        int nrLinha = 0, indiceGrupo = 0;
        try {
            FileReader fr = new FileReader(this.getF());
            BufferedReader br = new BufferedReader(fr);

            String line;

            String[] arr;
            while ((line = br.readLine()) != null) {
                arr = linhaFich(line);
                //se nrLinha for par, corresponde a informacao de um grupo
                if (nrLinha % 2 == 0) {
                    GrupoInvestigacao gp = linhaGrupoInves(arr);
                    this.getListaGrupos().add(gp);
                } //se for impar corresponde aos membros do grupo indiceGrupo   
                else {
                    adicionaMembrosGrupoInves(getListaGrupos().get(indiceGrupo), arr);
                    indiceGrupo++;
                }
                nrLinha++;
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a abrir ficheiro de texto");
        } catch (IOException ex) {
            System.out.println("Erro a ler ficheiro de texto");
        }
    }

    /**
     * Metodo para criar um grupo de investigacao com as informcaoes contidas no
     * array a
     *
     * @param a array com informacoes
     * @return grupo de investigacao com informacoes
     */
    private GrupoInvestigacao linhaGrupoInves(String a[]) {
        GrupoInvestigacao g = new GrupoInvestigacao();
        g.setNome(a[0].trim());
        g.setAcronimo(a[1].trim());
        g.setInvestigadorResp((Efetivo) procuraInvestigador(a[2].trim()));
        return g;
    }

    /**
     * Metodo para adicionar membros a arraylist de membros de um grupo de
     * investigacao
     *
     * @param gi grupo de investigacao ao qual queremos adicionar os membros
     * @param a array com nomes de membros
     */
    private void adicionaMembrosGrupoInves(GrupoInvestigacao gi, String[] a) {
        for (int i = 0; i < a.length; i++) {
            Investigador iv = procuraInvestigador(a[i]);
            if (iv.eEfetivo()) {
                Efetivo ef = (Efetivo) iv;
                ef.setGrupoInvest(gi);   //colocar o grupo de investigacao completo   
                gi.getListaMembros().add(ef);
            } else {
                Estudante e = (Estudante) iv;
                e.setGrupoInvest(gi);
                gi.getListaMembros().add(e);
            }

        }

    }

}
