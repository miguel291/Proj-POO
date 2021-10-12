package projeto;
import java.io.Serializable;
import java.util.*;
import static projeto.Grupo.grupos;

public class Publicaçao implements Serializable {
    protected String titulo, tipo;
    protected char fator;
    protected int ano, dim;
    protected String[] chave;
    public ArrayList<Investigador> aut = new ArrayList<>();
    public Publicaçao() {}
    public Publicaçao(String []a, String t, String ty,int an, int dim , String[] c) {
        titulo= t;
        ano = an;
        tipo = ty;
        this.dim = dim;
        chave = c;
        for (String n : a) {
          for (Grupo g : grupos){
              for (Investigador i : g.mem){
                    if (i.getNome().equals(n.trim())){
                       // System.out.println(i.getNome());
                        aut.add(i);
                        addPub(i); 
                        //System.out.println("adicionado com sucesso");
                        break;
            }        
        }
      }
    }
    }   
    
    public ArrayList<Investigador> getAut() {
        return aut;
    }

    public void setAut(ArrayList<Investigador> aut) {
        this.aut = aut;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getDim() {
        return dim;
    }

    public void setDim(int dim) {
        this.dim = dim;
    }

    public String[] getChave() {
        return chave;
    }

    public void setChave(String[] chave) {
        this.chave = chave;
    }
    
    public char getFator() {
        return fator;
    }

    public void setFator(char fator) {
        this.fator = fator;
    }
    
    /**Devolve um ArrayList com o nome dos autores de uma publicação.
     *
     */   
    public ArrayList<String>  getNomeAutores(){
        ArrayList<String> names = new ArrayList<>(); 
        for (Investigador i : aut){
            if (i.getType()== 0){
                String[] output = i.getNome().split(" ");
                String primeira = String.valueOf(output[0].charAt(0));
                names.add(primeira+". "+output[output.length-1]);
            }  
            if (i.getType()== 1){
                names.add("Professor(a) "+i.getNome());
            }           
            }
        return names;
    }
    
    /**Adiciona publicação à lista de publicações dos seu(s) autor(es) e à lista de publicações do(s) grupo(s) a que o(s) autor(es) pertence(m).
     *
     */
    private void addPub (Investigador i){  
            i.addPubInv(this);
            for (Grupo g : grupos){
                if ( i.getGrupo().equals(g.getNome())||i.getGrupo().equals(g.getAcr())){
                    if (g.publ.contains(this) != true){
                        g.addPub(this);
                }
            }   
        }
    }
    
    
    /**Lista as publicações de um investigador ou grupo ordenadas por ano, tipo e fator. No caso do grupo, só lista publicações dos últimos 5 anos.
     *
     */
    static public void publicaçoes5AnosOrdenar(ArrayList<Publicaçao> pub, int flag){
        List<Publicaçao> titulos = new ArrayList<>(); 
        for (Publicaçao p : pub){
            if (flag == 0){
                titulos.add(p);
            }
            else{
                if (p.getAno()>= 2016){
                titulos.add(p);
                }}}
         Collections.sort(titulos, new Comparator<Publicaçao>() {
            @Override
            public int compare(Publicaçao p1, Publicaçao p2) {
                return p1.getAno() - p2.getAno();
            }
            
        });
         Collections.sort(titulos, new Comparator<Publicaçao>() {
            @Override
            public int compare(Publicaçao p1, Publicaçao p2) {
                if(p1.getAno() == p2.getAno()){
                    return p1.getTipo().compareTo(p2.getTipo());
            }   else
                    return 0;}
            
        });
         Collections.sort(titulos, new Comparator<Publicaçao>() {
            @Override
            public int compare(Publicaçao p1, Publicaçao p2) {
                if(p1.getAno() == p2.getAno() && p1.getTipo().equals(p2.getTipo())){
                    return Character.compare(p1.getFator(),p2.getFator());     
            }   else
                    return 0;}
            
        });    
        for (Publicaçao p : titulos){
            System.out.println(p);
            System.out.println();
        }
        
       }
}