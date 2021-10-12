package projeto;

public class Livro extends Publicaçao{
    protected String resumo, editora;
    protected int ISBN;
    public Livro() {}
    public Livro(String []a , String t,int an, int dim , String[] c,String r, String ed, int ISBN) {
     super(a,t,"Livro",an,dim,c);
     resumo =r;
     editora= ed;
     this.ISBN = ISBN;
     Grupo.increaseCountLivro();
     setFator(dim);
   
    }
    //Construtor específico para capítulos de livro e livros de conferencia
    public Livro(String []a , String t,int an, int dim , String[] c,String r, String ed, int ISBN, int s,String tipo) {
     super(a,t,tipo,an,dim,c);
     resumo =r;
     editora= ed;
     this.ISBN = ISBN;
     setFator(dim);
     }

    @Override
    public String toString() {
        return ano+" - Livro -"+ "-- Título: '" + titulo + "'\nAutores - "+ getNomeAutores()+"---Impacto: "+fator+"--- Editora - "+editora+"  ISBN: "+ISBN  +"\nResumo - "+resumo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    
    /**Imprime o número total de livros.
     *
     */ 
    public static void livroCount(){
        System.out.println("Livros: "+Grupo.getCountLivro());
    }
    
    /**Define o fator do livro de acordo com a sua audiência.
     *
     */  
    private void setFator (int audiencia){
         if (audiencia< 5000)
             fator =  'C';
         else if (audiencia >= 5000 && audiencia < 10000)
             fator =  'B';
         else if (audiencia >= 10000)
             fator =  'A';
     }
}
