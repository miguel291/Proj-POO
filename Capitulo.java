package projeto;


public class Capitulo extends Livro {
    protected String nomeCap; 
    protected int pagI, pagF;
    public Capitulo() {}
    public Capitulo(String []a, String t,int an, int dim , String[] c,String r, String ed, int ISBN, String name, int i, int f) {
    super(a,t,an,dim,c,r,ed,ISBN,3,"Capitulo de livro");
    nomeCap= name;
    pagI = i;
    pagF = f;
    Grupo.increaseCountCap();
    
    }

    @Override
    public String toString() {
        return ano+" - Capitulo de livro - "+ nomeCap+" -- Paginas: " + pagI + "-" + pagF + " ---  '"+titulo+"'"+"\nAutores - "+ getNomeAutores()+"---Impacto: "+fator+"--- Editora - "+editora+"  ISBN: "+ISBN  +"\nResumo - "+resumo;
    }

    public String getNomeCap() {
        return nomeCap;
    }

    public void setNomeCap(String nomeCap) {
        this.nomeCap = nomeCap;
    }

    public int getPagI() {
        return pagI;
    }

    public void setPagI(int pagI) {
        this.pagI = pagI;
    }

    public int getPagF() {
        return pagF;
    }

    public void setPagF(int pagF) {
        this.pagF = pagF;
    }

    /**Mostra o número total de capítulos no CISUC.
     *
     */
    public static void capituloCount(){
        System.out.println("Capitulos de livro: "+Grupo.getCountCap());
    }
}
