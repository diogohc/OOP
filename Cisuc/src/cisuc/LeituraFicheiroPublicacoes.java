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
public class LeituraFicheiroPublicacoes extends LeituraFicheiro {

    //Construtor
    public LeituraFicheiroPublicacoes(File f, ArrayList<Investigador> listaMembros,
            ArrayList<Publicacao> listaPublicacoes) {
        super();
        this.setF(f);
        this.setListaMembros(listaMembros);
        this.setListaPublicacoes(listaPublicacoes);
    }

    //Metodos
    @Override
    public void leFicheiro() {
        File f = new File("publicacoes.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String line;

            String[] arr;
            while ((line = br.readLine()) != null) {
                arr = linhaFich(line);
                Publicacao aux;
                aux = linhaPublicacao(arr);
                this.getListaPublicacoes().add(aux);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a abrir ficheiro de texto");
        } catch (IOException ex) {
            System.out.println("Erro a ler ficheiro de texto");
        }
    }

    /**
     * Metodo que separa os membros do array e cria a publicacao respetiva
     *
     * @param arr com informacoes
     * @return publicacao com os detalhes
     */
    private Publicacao linhaPublicacao(String[] arr) {
        if (arr[0].trim().equals("Artigo Conferencia")) {
            ArtigoConferencia ac = new ArtigoConferencia(listaAutores(arr[1]),
                    arr[2].trim(), Integer.parseInt(arr[3].trim()),
                    Integer.parseInt(arr[4].trim()), arr[5].trim(),
                    arr[6].trim(), arr[7].trim());
            return ac;
        } else if (arr[0].trim().equals("Artigo Revista")) {
            ArtigoRevista ar = new ArtigoRevista(listaAutores(arr[1]), arr[2].trim(),
                    Integer.parseInt(arr[3].trim()), Integer.parseInt(arr[4].trim()),
                    arr[5].trim(), arr[6].trim(), Integer.parseInt(arr[7].trim()));
            return ar;
        } else if (arr[0].trim().equals("Capitulo Livro")) {
            CapituloLivro cl = new CapituloLivro(listaAutores(arr[1]), arr[2].trim(),
                    Integer.parseInt(arr[3].trim()), Integer.parseInt(arr[4].trim()),
                    arr[5].trim(), Integer.parseInt(arr[6].trim()),
                    Integer.parseInt(arr[7].trim()));
            return cl;
        } else if (arr[0].trim().equals("Livro")) {
            Livro l = new Livro(listaAutores(arr[1]),
                    arr[2].trim(), Integer.parseInt(arr[3].trim()),
                    Integer.parseInt(arr[4].trim()), arr[5].trim(),
                    Integer.parseInt(arr[6].trim()));
            return l;
        } else {
            LivroArtigosConferencia lac = new LivroArtigosConferencia(listaAutores(arr[1]),
                    arr[2].trim(), Integer.parseInt(arr[3].trim()),
                    Integer.parseInt(arr[4].trim()), arr[5].trim(),
                    Integer.parseInt(arr[6].trim()));
            return lac;
        }
    }

    /**
     * Metodo que cria uma arraylist de autores
     *
     * @param s frase com autores separados por "/"
     * @return arraylist com autores
     */
    private ArrayList<Investigador> listaAutores(String s) {
        ArrayList<Investigador> lista = new ArrayList<>();
        String[] str = s.split("/");
        for (int i = 0; i < str.length; i++) {

            String nome;
            String aux[] = str[i].split(" ");
            if (aux[0].equals("Professor")) {
                nome = aux[1] + " " + aux[aux.length - 1];//nome=primeiro+ultimo nome
                Efetivo ef = (Efetivo) procuraInvestigador(nome);
                lista.add(ef);
            } else {

                lista.add(procuraEstudanteAutor(str[i]));

            }
        }
        return lista;
    }

    /**
     * Metodo para procurar um investigador atraves do nome. Semelhante ao
     * procuraInvestigador mas aqui o nome do investigador e alterado
     *
     * @param nomeI do investigador que queremos procurar
     * @return investigador com nome=nomeI
     */
    private Investigador procuraEstudanteAutor(String nomeI) {
        for (int i = 0; i < this.getListaMembros().size(); i++) {
            Investigador inv = getListaMembros().get(i);
            String nomeEst = transformaNome(inv.getNome());
            if (nomeEst.equals(nomeI)) {
                return inv;
            }

        }
        System.out.println("ERRO! Estudante nao foi encontrado");
        return null;
    }

    /**
     * Metodo que recebe uma string para ser transformada
     *
     * @param nome nome a ser transformado
     * @return primeira letra do primeiro nome + ". " + ultimo nome
     */
    private String transformaNome(String nome) {
        String novoNome;
        String[] a, aux;
        a = nome.split(" ");
        aux = a[0].split("");
        novoNome = aux[0] + ". " + a[a.length - 1];
        return novoNome;
    }

}
