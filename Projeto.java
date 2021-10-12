package projeto;
import java.util.Scanner;

public class Projeto {
    public static void main(String[] args) {
        int flag = -1;
        String l ;
        System.out.println("Pretende que os dados sejam carregados diretamente dos ficheiros de texto ?(s/n)");
        Scanner in = new Scanner(System.in);
        l = in.nextLine();
        if (!(l.equals("s")))
            flag = 0;
        int m = Ficheiros.iniciar(flag);
        if ( m == 0 )
            flag = -1;
        
        
        
        int choice = -1;
        OUTER:
        while (true) {
            System.out.println("\n----BEM-VINDO AO CISUC----\n\nO que pretende fazer ?\n -Informações gerais do CISUC(1)\n -Publicações de um grupo nos últimos 5 anos(2)\n -Membros de um grupo agrupados por tipo(3)\n -Publicações de um investigador(4)\n -Número de membros por tipo e publicações nos últimos 5 anos de todos os grupos(5)\n -Sair(0)");
            while (choice ==-1){
                try{
                    Scanner input = new Scanner(System.in);
                    choice = input.nextInt();
                } catch (Exception ex) {
                    System.out.println("Insira o número correspondente à opção que pretende");
                    choice = -1;
                }}
            switch (choice) {
                case 1:
                    System.out.println("\n-----------Informações gerais-----------\nNúmero de membros do CISUC: " + Investigador.total());
                    MembroEfetivo.printCountEfe();
                    Estudante.printCountEst();
                    System.out.println();
                    System.out.println("-----------Publicações dos últimos 5 anos-----------\n");
                    Grupo.printPubYear();
                    System.out.println("-----------Número de publicações por tipo-----------\n");
                    Livro.livroCount();
                    Conf.confCount();
                    Capitulo.capituloCount();
                    Revista.revistaCount();
                    LivroConf.livroConfCount();
                    break;
                case 2:
                    Grupo.choose(1);
                    break;
                case 3:
                    Grupo.choose(0);
                    break;
                case 4:
                    Grupo.chooseInvestigador();
                    break;
                case 5:
                    Grupo.option5();
                    break;
                case 0:
                    if ( flag != 0){
                        Ficheiros.terminar();
                        System.out.println("A criar/atualizar ficheiro de objetos...");
                    }
                    break OUTER;
                default:
                    System.out.println("Opção inválida !");
                    break;
            }
            choice = -1;
        }  
    }
}
    

