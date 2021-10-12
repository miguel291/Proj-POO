package projeto;
public class Conf extends Publicaçao{
    protected String resumo, nomeConf, dataConf, local;
    public Conf() {}
    public Conf(String []a, String t,int an, int dim , String[] c,String r, String name, String dat, String l) {
     super(a,t,"Artigo de Conferência",an,dim,c);
     resumo =r;
     nomeConf= name;
     dataConf = dat;
     local=l;
     Grupo.increaseCountConf();
     setFator(dim);
     }
     public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    @Override
    public String toString() {
        return ano+" - Artigo de Conferência --- '" + titulo +"'\nAutores - "+ getNomeAutores()+"  Conferência: " +nomeConf+" "+ dataConf+" Local- "+local+" ---Impacto: "+fator+ "\nResumo - " +resumo ;
    }

    public String getNomeConf() {
        return nomeConf;
    }

    public void setNomeConf(String nomeConf) {
        this.nomeConf = nomeConf;
    }

    public String getDataConf() {
        return dataConf;
    }

    public void setDataConf(String dataConf) {
        this.dataConf = dataConf;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
    /**Imprime o número total de artigos de conferência.
     *
     */ 
    public static void confCount(){
        System.out.println("Artigos de conferência: "+Grupo.getCountConf());
    }
    /**Define o fator do artigo de conferência de acordo com a sua audiência.
     *
     */ 
    private void setFator (int audiencia){
         if (audiencia< 200)
             fator =  'C';
         else if (audiencia >= 200 && audiencia < 500)
             fator =  'B';
         else if (audiencia >= 500)
             fator =  'A';
     }
}
