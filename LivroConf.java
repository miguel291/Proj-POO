
package projeto;

public class LivroConf extends Livro {
    protected String nomeConf; 
    protected int numArtigos;
    public LivroConf() {}
    public LivroConf(String[] a,String t,int an, int dim , String[] c,String r, String ed, int ISBN, String nameConf, int numArt) {
        super(a,t,an,dim,c,r,ed,ISBN,3,"Livro de artigos de Conferência");
        nomeConf = nameConf;
        numArtigos = numArt;
        Grupo.increaseCountLivConf();
        setFator(dim);
}

    @Override
    public String toString() {
        return ano+" - Livro de artigos de Conferência - '"+ titulo+"' -- Nº de artigos: " + numArtigos +"\n---Impacto: "+fator+"--- Editora - "+editora+"  ISBN: "+ISBN  +"\nResumo - "+resumo +"\nPalavras-chave: "+getKeyWords();
        
    }
    
    public String getNomeConf() {
        return nomeConf;
    }

    public void setNomeConf(String nomeConf) {
        this.nomeConf = nomeConf;
    }

    public int getNumArtigos() {
        return numArtigos;
    }

    public void setNumArtigos(int numArtigos) {
        this.numArtigos = numArtigos;
    }
    
    /**Mostra o número total de Livros de Conferência no CISUC.
     *
     */
    public static void livroConfCount(){
        System.out.println("Livros de conferências: "+ Grupo.getCountLivConf());
    }
    
    private void setFator (int audiencia){
         if (audiencia< 2500)
             fator =  'C';
         else if (audiencia > 7500 && audiencia < 2500)
             fator =  'B';
         else if (audiencia >= 7500)
             fator =  'A';
     }
    /**Devolve uma String que contêm todas as palavras-chave.
     *
     */
    private String getKeyWords (){
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < chave.length; i++) {
            strBuilder.append(chave[i] + " ");
        }
        String keyWords = strBuilder.toString();
        return keyWords;
    }
}
