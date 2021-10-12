package projeto;


public class Revista extends Publicaçao{
     protected int numRev;
     protected String dataRev, nomeRev;
     public Revista() {}
     public Revista(String []a , String t,int an, int dim , String[] c,String nome,  String data, int numero) {
        super(a,t,"Artigo de Revista",an,dim,c);
        numRev = numero;
        dataRev = data;
        nomeRev= nome;
        Grupo.increaseCountRev();
        setFator(dim);
   
     }

    public int getNumRev() {
        return numRev;
    }

    public void setNumRev(int numRev) {
        this.numRev = numRev;
    }

    public String getDataRev() {
        return dataRev;
    }

    public void setDataRev(String dataRev) {
        this.dataRev = dataRev;
    }

    public String getNomeRev() {
        return nomeRev;
    }

    public void setNomeRev(String nomeRev) {
        this.nomeRev = nomeRev;
    }

    @Override
    public String toString() {
        return ano+" - Artigo de Revista -"+ "-- Título: '" + titulo + "'\nAutores - "+ getNomeAutores()+"---Impacto: "+fator+"--- Nome da Revista - '"+nomeRev+"'  nº: "+numRev  +"-- "+dataRev;
    }
     /**Define o fator do artigo de revista de acordo com a sua audiência.
     *
     */  
      private void setFator (int audiencia){
         if (audiencia< 500)
             fator =  'C';
         else if (audiencia >= 500 && audiencia < 1000)
             fator =  'B';
         else if (audiencia >= 1000)
             fator =  'A';
     }
      /**Imprime o número total de artigos de revista.
     *
     */  
      public static void revistaCount(){
        System.out.println("Artigos de Revista: "+Grupo.getCountRev());
    }
      
}
