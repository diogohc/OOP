/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cisuc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Diogo Miguel Henriques Correia | 2016219825
 */
public class Cisuc {

    //Atributos
    private ArrayList<Investigador> membros;
    private ArrayList<GrupoInvestigacao> grupos;
    private ArrayList<Publicacao> publicacoes;
    

    public Cisuc() {
        membros = new ArrayList<Investigador>();
        publicacoes = new ArrayList<Publicacao>();
        grupos = new ArrayList<GrupoInvestigacao>();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cisuc cis = new Cisuc();

        cis.menu();
    }

    /**
     * Metodo menu para interagir com o utilizador
     */
    private void menu() {

        leFicheiros();

        int escolha;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Apresentar indicadores gerais");
            System.out.println("2 - Listar publicacoes de um grupo de investigacao");
            System.out.println("3 - Listar membros de um grupo de investigacao por categoria");
            System.out.println("4 - Listar publicacoes de um investigador por categoria");
            System.out.println("5 - Detalhes de todos os grupos");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");

            escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                    indicadoresGerais();
                    break;
                case 2:
                    listarPublicacoesGrupo();
                    break;
                case 3:
                    listarMembrosGrupo();
                    break;
                case 4:
                    listarPublicacoesInves();
                    break;
                case 5:
                    detalhesGrupos();
                    break;
                case 0:
                    //Escreve no ficheiro objetos
                    guardaFichObjs();
                    System.exit(0);
                    break;
                default:
                    System.out.println("ERRO! Opção invalida");
            }
        } while (escolha != 0);

    }

    /**
     * Metodo para apresentar os indicadores gerais
     */
    private void indicadoresGerais() {
        System.out.println("Indicadores gerais do CISUC:");
        System.out.println("Total de membros: " + membros.size());

        int[] nrMemb = contaMembrosCategoria();
        System.out.println("Total de membros efetivos: " + nrMemb[0]);
        System.out.println("Total de membros estudantes: " + nrMemb[1]);

        System.out.println("Total de publicacoes dos ultimos 5 anos: " + totalPubCinco(publicacoes));

        int[] nrPub = nrPubTipo();
        System.out.println("Numero de artigos de conferencia " + nrPub[0]);
        System.out.println("Numero de artigos de revista " + nrPub[1]);
        System.out.println("Numero de capitulos de livro " + nrPub[2]);
        System.out.println("Numero de livros " + nrPub[3]);
        System.out.println("Numero de livros de artigos de conferencia " + nrPub[4]);
    }

    /**
     * Metodo para contar o numero de membros efetivos e membros estudantes
     *
     * @return array. na primeira posicao esta o numero de membros efetivos e na
     * segunda posicao o numero de membros estudantes
     */
    private int[] contaMembrosCategoria() {
        int[] arr = {0, 0};
        for (Investigador inv : membros) {
            if (inv.eEfetivo()) {
                arr[0]++;
            } else {
                arr[1]++;
            }
        }
        return arr;
    }

    /**
     * Metodo para contar o total de publicacoes dos ultimos 5 anos de uma
     * arraylist de publicacoes
     *
     * @param lista lista de publicacoes
     * @return numero de publicacoes dos ultimos 5 anos
     */
    private int totalPubCinco(ArrayList<Publicacao> lista) {
        int total = 0;
        int ano = Calendar.getInstance().get(Calendar.YEAR);//ano atual
        for (Publicacao p : lista) {
            if (ano - p.getAnoPublicacao() <= 5) {
                total++;
            }
        }
        return total;
    }

    /**
     * Metodo para calcular o numero de publicacoes de cada tipo
     *
     * @return array com numero de publicacoes de cada tipo array[0]- numero de
     * artigos de conferencia; array[1]- numero de artigos de revista; array[2]-
     * numero de capitulos de livro; array[3]- numero de livros; array[4]-
     * numero de livros de artigos de conferencia
     */
    private int[] nrPubTipo() {

        int[] totais = new int[5];

        for (Publicacao p : publicacoes) {
            if (p.getTipoPublicacao().equals("Artigo Conferencia")) {
                totais[0]++;
            } else if (p.getTipoPublicacao().equals("Artigo Revista")) {
                totais[1]++;
            } else if (p.getTipoPublicacao().equals("Capitulo Livro")) {
                totais[2]++;
            } else if (p.getTipoPublicacao().equals("Livro")) {
                totais[3]++;
            } else {
                totais[4]++;
            }
        }

        return totais;
    }
    
    /**
     * Metodo para ler os ficheiros. Tenta ler o ficheiro de objetos e se nao 
     * existir le os ficheiros de texto
     */
    private void leFicheiros() {
        File f = new File("save.obj");

        if (f.exists() && f.isFile()) //se ficheiro de objetos existir
        {
            leFichObjs(f);
        } else //se ficheiro de objetos nao existir
        {
            leFichsTexto();
        }
    }

    /**
     * Metodo que le o ficheiro de objetos
     * @param f ficheiro objetos que queremos ler
     */
    private void leFichObjs(File f) {
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.membros = (ArrayList<Investigador>) ois.readObject();
            this.publicacoes = (ArrayList<Publicacao>) ois.readObject();
            this.grupos = (ArrayList<GrupoInvestigacao>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a abrir ficheiro de objetos ");
        } catch (IOException ex) {
            System.out.println("Erro a ler ficheiro de objetos");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro a converter o objeto");
        }
    }

    /**
     * Metodo para escrever no ficheiro de objetos
     */
    private void guardaFichObjs() {
        File f = new File("save.obj");
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(membros);
            oos.writeObject(publicacoes);
            oos.writeObject(grupos);

            oos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a criar ficheiro de objetos");
        } catch (IOException ex) {
            System.out.println("Erro a escrever para o ficheiro de objetos grupos");
        }
    }

    /**
     * Metodo que le os ficheiros de texto
     */
    private void leFichsTexto() {
        File f1 = new File("membros.txt");
        LeituraFicheiroMembros lfm = new LeituraFicheiroMembros(f1, membros);
        lfm.leFicheiro();

        File f2 = new File("publicacoes.txt");
        LeituraFicheiroPublicacoes lfp = new LeituraFicheiroPublicacoes(f2, membros, publicacoes);
        lfp.leFicheiro();

        File f3 = new File("grupos.txt");
        LeituraFicheiroGrupos lfg = new LeituraFicheiroGrupos(f3, membros, grupos);
        lfg.leFicheiro();

        //colocar as publicacoes dos membros na arraylist de publicacoes de cada grupo
        for (GrupoInvestigacao gi : grupos) {
            gi.addPub();
        }

    }

    /**
     * Metodo que procura um grupo de investigacao na arraylist de grupos
     *
     * @param acro acronimo do grupo que queremos procurar
     * @return grupo se existir e null se nao existir
     */
    private GrupoInvestigacao procuraGrupo(String acro) {
        GrupoInvestigacao aux;
        for (GrupoInvestigacao gi : grupos) {
            if (gi.getAcronimo().equalsIgnoreCase(acro)) {
                aux = gi;
                return aux;
            }
        }
        System.out.println("ERRO! Grupo nao existe");
        return null;

    }

    /**
     * Metodo que lista as publicacoes de um grupo
     */
    private void listarPublicacoesGrupo() {
        String ac;
        Scanner sc = new Scanner(System.in);
        System.out.print("Acronimo do grupo: ");
        ac = sc.nextLine();
        GrupoInvestigacao g = procuraGrupo(ac);
        if (g != null) {
            menuListarPublicacoes(g.getListaPublicacoes());

        }
    }

    /**
     * Metodo que lista os membros de um grupo
     */
    private void listarMembrosGrupo() {
        String ac;
        Scanner sc = new Scanner(System.in);
        System.out.print("Acronimo do grupo: ");
        ac = sc.nextLine();
        GrupoInvestigacao g = procuraGrupo(ac);
        g.listaMembrosEfetivos();
        g.listaMembrosEstudantes();
    }

    /**
     * Metodo que lista as publicacoes de um investigador
     */
    private void listarPublicacoesInves() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nome do investigador: ");
        Investigador i = procuraInvestigador(sc.nextLine());
        if (i != null) {
            menuListarPublicacoes(i.getListaPublicacoes());

        }
    }

    /**
     * Metodo para procurar um investigador
     *
     * @param nomeInvestigador nome do investigador que queremos encontrar
     * @return investigador com nome=nomeInvestigador
     */
    private Investigador procuraInvestigador(String nomeInvestigador) {
        Investigador inv;
        for (int i = 0; i < membros.size(); i++) {
            inv = membros.get(i);
            //se o investigador existir
            if (inv.getNome().equalsIgnoreCase(nomeInvestigador)) {
                return inv;
            }
        }
        System.out.println("ERRO! Investigador nao foi encontrado");
        return null;
    }

    /**
     * Metodo que serve como menu para a listagem de publicacoes de acordo
     * com diferentes opcoes
     * @param listaP arraylist de publicacoes que queremos listar
     */
    private void menuListarPublicacoes(ArrayList<Publicacao> listaP) {
        Scanner sc = new Scanner(System.in);
        int escolha;
        ListarPublicacoes lp = new ListarPublicacoes(listaP);
        System.out.println("Organizar por:");
        System.out.println("1 - Ano");
        System.out.println("2 - Tipo de publicacao");
        System.out.println("3 - Fator de impacto");
        System.out.print("Opcao: ");

        escolha = sc.nextInt();

        switch (escolha) {
            case 1:
                lp.listarPubAno();
                break;
            case 2:
                lp.listarPubTipo();
                break;
            case 3:
                lp.listarPubFator();
                break;
            default:
                System.out.println("ERRO! Opção invalida");
        }
    }

    /**
     * Metodo que imprime os detalhes de todos os grupos de investigacao
     */
    private void detalhesGrupos() {
        for (GrupoInvestigacao g : grupos) {
            System.out.println(g.getNome());
            System.out.println("Total de membros: " + g.getListaMembros().size());
            System.out.println("Numero de membros efetivos: " + g.nrMembrosEfetivos());
            System.out.println("Numero de membros estudantes: " + g.nrMembrosEstudantes());
            System.out.println("Total de publicacoes dos ultimos 5 anos: "
                    + totalPubCinco(g.getListaPublicacoes()));
            ListarPublicacoes lp = new ListarPublicacoes(g.getListaPublicacoes());
            System.out.println("Publicacoes agrupadas por ano:");
            lp.listarPubAno();
            System.out.println("Publicacoes agrupadas por tipo:");
            lp.listarPubTipo();
            System.out.println("Publicacoes agrupadas por fator de impacto:");
            lp.listarPubFator();

            System.out.println("");
        }
    }

}
