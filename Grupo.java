package projeto;
import java.util.ArrayList;
import java.util.Scanner;
import static projeto.Publicaçao.publicaçoes5AnosOrdenar;
import java.io.Serializable;

public class Grupo implements Serializable {
    private int count =0;
    private int countEfe =0;
    public static int countEf, countEs, countLivro, countRev, countConf, countLivConf, countCap;
    private int countEst =0;
    public static ArrayList<Grupo> grupos = new ArrayList<Grupo>();
    protected String nome, acr, resp;
    public ArrayList<Investigador> mem = new ArrayList<>();
    public ArrayList<Publicaçao> publ = new ArrayList<>();
    protected MembroEfetivo responsavel;
    public Grupo() {}
    public Grupo(String n, String a, String r ) {
    nome = n;
    acr= a;
    resp=r;
    addG();
    }
    
    /**Adiciona um grupo à lista de grupos.
     *
     */
   private void addG (){
        grupos.add(this);
    }

    
    @Override
    public String toString() {
        if (responsavel == null){
            return "\nGrupo\nNome: " + nome + "\nAcrónimo: " + acr + "\nResponsável: " + resp + "\nMembros:\n " + mem ;
        }
        else{
            return "\nGrupo\nNome: " + nome + "\nAcrónimo: " + acr + "\nResponsável: " +  responsavel+ "\nMembros:\n " + mem ;
        }    
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAcr() {
        return acr;
    }

    public void setAcr(String acr) {
        this.acr = acr;
    }

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCountEfe() {
        return countEfe;
    }

    public void setCountEfe(int countEfe) {
        this.countEfe = countEfe;
    }

    public int getCountEst() {
        return countEst;
    }

    public void setCountEst(int countEst) {
        this.countEst = countEst;
    }

    public static ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public static void setGrupos(ArrayList<Grupo> grupos) {
        Grupo.grupos = grupos;
    }

    public ArrayList<Publicaçao> getPubl() {
        return publ;
    }

    public void setPubl(ArrayList<Publicaçao> publ) {
        this.publ = publ;
    }

    public MembroEfetivo getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(MembroEfetivo responsavel) {
        this.responsavel = responsavel;
    }

    public ArrayList<Investigador> getMem() {
        return mem;
    }

    public void setMem(ArrayList<Investigador> Mem) {
        this.mem = Mem;
    }

    /**Lista todas as publicações de um grupo.
     *
     */
    public void printPub() {
        int j = 1;
        for(Publicaçao i : publ) {
            //System.out.println(j);
            System.out.println(i);
            j++;
   }}

    /**Lista todas as publicações no CISUC dos últimos cinco anos.
     *
     */
    static public void printPubYear() {
        ArrayList<String> titulos = new ArrayList<>(); 
        for ( Grupo g : grupos){
            for (Publicaçao p : g.publ){
                if(titulos.contains(p.getTitulo())){
                    //System.out.println("Contido"); 
                }
                else if (p.getAno()>= 2016){
                        System.out.println(p);
                        System.out.println();
                        titulos.add(p.getTitulo());
                }}   
            }
        }      
    
    /**Mostra os membros do grupo ordenados por tipo.
     *
     */
    public void printGrupoTipo() {
        System.out.println("\nEstudantes do grupo "+ getAcr());
        for (Investigador i : mem){
            if (i.getType()== 0)
                System.out.println(i); }
        System.out.println("\nMembros efetivos do grupo "+ getAcr());
        for (Investigador i : mem){
            if (i.getType()== 1)
                System.out.println(i); }
            
    }
    
     /**Permite escolher um grupo.
     *Dependendo da flag passada à função, chama uma função que imprime todos os membros do grupo selecionado ordenados por tipo (flag=0) ou então chama uma função que lista todas as publicações do grupo nos últimos 5 anos, ordenadas por ano, tipo e fator(flag=1).
     */
     static public void choose(int flag) {
         System.out.println("Que grupo pretende ver ?");
         for(Grupo h: grupos){
             System.out.println(" -"+h.getAcr());
         }
         Scanner input = new Scanner(System.in);
         String cho = input.nextLine();
         String ch = cho.toUpperCase();
         int m = 0;
         for(Grupo g: grupos){
            if( cho.equals(g.getAcr()) || cho.equals(g.getAcr()) || ch.equals(g.getAcr())|| ch.equals(g.getNome())){
                System.out.println("\n"+g.getNome()+"\n");
                m = 1;
                if (flag == 0 )
                    g.printGrupoTipo();
                if (flag == 1){
                    publicaçoes5AnosOrdenar(g.getPubl(),1);
                }  
                break;
         }
       }
       if ( m == 0)
           System.out.println("\nGrupo não encontrado");
     }
     /**Permite selecionar o investigador que se pretende, invocando de seguida a função que apresenta a lista de obras ordenadas desse investigador. 
     *
     */
     static public void chooseInvestigador() {
         int num = 0;
         String[] str = new String[Grupo.getCountEs()+Grupo.getCountEf()];
         System.out.println("Que investigador ?");
         for(Grupo g: grupos){
             //System.out.println(g.getAcr());
             for(Investigador i: g.mem){
                 System.out.println(i.getNome() + " ("+num+")");
                 str[num]=i.getNome();
                 num++;
         }}
         System.out.println("\nEscreva o número correspondente ao investigador pretendido");
         try{
         Scanner input = new Scanner(System.in);
         int cho = input.nextInt();
         for(Grupo g: grupos){
             for(Investigador i: g.mem){
                 if(str[cho].equals(i.getNome())){
                     publicaçoes5AnosOrdenar(i.getPub(),0);
                 }
            }
        }  
        }catch (Exception ex) {
                System.out.println("Opção inválida!");
            }}
     
     /**Imprime para todos os grupos o número de membros total, o número de membros de cada tipo e as publicações dos últimos 5 anos, ordenadas por ano, tipo e fator.
     *
     */
     static public void option5() {
         for(Grupo g: grupos){
             System.out.println("--------------"+g.nome+"--------------\n");
             g.membrosGrupo();
             g.efetivosGrupo();
             g.estudantesGrupo();
             System.out.println("\n-----Publicações nos últimos 5 anos----\n");
             publicaçoes5AnosOrdenar(g.getPubl(),1);
         }
     }
     /**Adiciona uma publicação à lista de publicações do grupo.
     *
     */ 
     public void addPub (Publicaçao i){
        publ.add(i);
        }
     
     /**Lista as informações de todos os grupos( nome, acrónimo, responsável, membros).
     *
     */
    static public void printGrupos() {
        System.out.println("\n"+grupos);
    }
    
    /**Adiciona um investigador à lista de membros de um grupo. Incrementa o contador de membros do grupo em 1.
     *
     */
    public void addMe (Investigador i){
        mem.add(i);
        count++;
    }
    /**Incrementa o contador de membros efetivos do grupo em 1.
     *
     */
    public void addEf(){
        countEfe++;
    }
    
    /**Incrementa o contador de membros efetivos do grupo em 1.
     *
     */
    public void addEst(){
        countEst++;
    }
    /**Imprime o número de membros do grupo.
     *
     */
    public void membrosGrupo(){
        System.out.println("Número de membros no grupo "+acr+ " : "+count);
    }
    
    /**Imprime o número de membros efetivos do grupo.
     *
     */
    public void efetivosGrupo(){
        System.out.println("Número de membros efetivos no grupo "+acr+ " : "+countEfe);
    }
    
    /**Imprime o número de estudantes do grupo.
     *
     */
    public void estudantesGrupo(){
        System.out.println("Número de estudantes no grupo "+acr+ " : "+countEst);
    }
    
    /**Recebe um membro efetivo como argumenta e define-o como investigador principal do grupo.
     *
     */
    public void setPrin (MembroEfetivo i){
        responsavel=i;
    }
    
    public static int getCountEs() {
        return countEs;
    }
    
    public static void setCountEs() {
        for(Grupo g: grupos){
            countEs = countEs + g.countEst;
        }
    }
    
    public static int getCountEf() {
        return countEf;
    }
    
    public static void setCountEf() {
        for(Grupo g: grupos){
            countEf = countEf + g.countEfe;
        }
    }
     static void increaseCountEs(){
         countEs = countEs +1;
     }
     static void increaseCountEf(){
         countEf = countEf +1;
     }
     
    public static int getCountRev() {
        return countRev;
    }
    
    public static void setCountRev() {
        countRev = 0;
        ArrayList<String> titles = new ArrayList<>();
        for(Grupo g: grupos){
           for(Publicaçao p: g.publ){
               if (p.getTipo().equals("Artigo de Revista") && !(titles.contains(p.getTitulo()))){
                   countRev = countRev + 1;
                   titles.add(p.getTitulo());
                }
            } 
        }
    }
    
    static void increaseCountRev(){
         countRev = countRev +1;
     }
    public static int getCountLivro() {
        return countLivro;
    }
    
    public static void setCountLivro() {
        countLivro = 0;
        ArrayList<String> titles = new ArrayList<>();
        for(Grupo g: grupos){
           for(Publicaçao p: g.publ){
               if (p.getTipo().equals("Livro") && !(titles.contains(p.getTitulo()))){
                   countLivro = countLivro + 1;
                   titles.add(p.getTitulo());
                }
            } 
        }
    }
    
    static void increaseCountLivro(){
         countLivro = countLivro +1;
     }
    public static int getCountCap() {
        return countCap;
    }
    
    public static void setCountCap() {
        countCap = 0;
        ArrayList<String> titles = new ArrayList<>();
        for(Grupo g: grupos){
           for(Publicaçao p: g.publ){
               if (p.getTipo().equals("Capitulo de livro") && !(titles.contains(p.getTitulo()))){
                   countCap = countCap + 1;
                   titles.add(p.getTitulo());
                }
            } 
        }
    }
    
    static void increaseCountCap(){
         countCap = countCap +1;
     }
    public static int getCountConf() {
        return countConf;
    }
    
    public static void setCountConf() {
        countConf = 0;
        ArrayList<String> titles = new ArrayList<>();
        for(Grupo g: grupos){
           for(Publicaçao p: g.publ){
               if (p.getTipo().equals("Artigo de Conferência") && !(titles.contains(p.getTitulo()))){
                   countConf = countConf + 1;
                   titles.add(p.getTitulo());
                }
            } 
        }
    }
    
    static void increaseCountConf(){
         countConf = countConf +1;
     }
    
    public static int getCountLivConf() {
        return countLivConf;
    }
    
    public static void setCountLivConf() {
        countLivConf = 0;
        ArrayList<String> titles = new ArrayList<>();
        for(Grupo g: grupos){
           for(Publicaçao p: g.publ){
               if (p.getTipo().equals("Livro de artigos de Conferência") && !(titles.contains(p.getTitulo()))){
                   countLivConf = countLivConf + 1;
                   titles.add(p.getTitulo());
                }
            } 
        }
    }
    
    static void increaseCountLivConf(){
         countLivConf= countLivConf +1;
     }
}

