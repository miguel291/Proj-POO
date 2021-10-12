package projeto;
import java.io.Serializable;
import java.util.*;

public class Investigador implements Serializable {
    protected String nome, email, grupo;
    protected int type;
    private int countLivro, countRevista, countConf;
    protected ArrayList<Publicaçao> pub = new ArrayList<>();
    public Investigador() {}
    public Investigador(String n, String e, String g) {
        nome = n;
        email=e;
        grupo= g;
    }
    public String toString(){
        return("Nome: "+nome+"\nEmail: "+email+"\nGrupo: "+grupo);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getGrupo() {
        return grupo;
    }
        
    public ArrayList<Publicaçao> getPub() {
        return pub;
    }

    public void setPub(ArrayList<Publicaçao> pub) {
        this.pub = pub;
    }
    
    /** Adiciona uma publicação à lista de publicações de um investigador. De acordo com o tipo de publicação, incrementa o contador de tipo.
     *
     */
    public void addPubInv(Publicaçao i) {
        pub.add(i);
        if ("Livro".equals(i.getTipo()) || "Capitulo de livro".equals(i.getTipo())){
            countLivro++;
            //System.out.println("ADICIONADO LIVRO/CAPITULO");
        }
        else if ("Artigo de Conferência".equals(i.getTipo())){
            countConf++;  
            //System.out.println("ADICIONADO CONFERENCIA");
        }
        else if ("Artigo de Revista".equals(i.getTipo())){
            countRevista ++;
             //System.out.println("ADICIONADO REVISTA");
        }
    }
    
    /**Imprime o número total de publicações de um investigador.
     *
     */
    public void publicaçoesPorTipo (){
        int total = countLivro + countConf + countRevista;
        System.out.println("Total de publicaçoes de "+getNome()+": " + total);
    }

    
    /**Devolve o número total de investigadores ( membros efetivos + estudantes) no CISUC.
     *
     */
    static public int total (){
         return Grupo.getCountEs()+Grupo.getCountEf();
     }
    
  
}
    
   
 
    
    

