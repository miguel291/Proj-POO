package projeto;
import static projeto.Grupo.grupos;

public class Estudante extends Investigador {
    protected String tese, orientador, conclusao;
    public Estudante() {}
    public Estudante(String n, String e, String g, String t, String o, String c) {
        super(n,e,g);
        tese = t;
        orientador = o;
        type=0;
        conclusao = c;
        Grupo.increaseCountEs();
        addI(this);
    }
    @Override
    public String toString(){
        return("\nNome: "+nome+"\nEmail: "+email+"\nGrupo: "+grupo+"\nTítulo da tese: '"+tese+"'\nOrientador: "+orientador+"\nData prevista de conclusão: "+conclusao);
    }

    public String getTese() {
        return tese;
    }

    public void setTese(String tese) {
        this.tese = tese;
    }

    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    public String getConclusao() {
        return conclusao;
    }

    public void setConclusao(String conclusao) {
        this.conclusao = conclusao;
    }
   
    

    
    
    /**Imprime o número de estudantes no CISUC.
     *
     */
    static public void printCountEst() {
        System.out.println("Número de estudantes no CISUC: "+ Grupo.getCountEs());
    }
    
    /**Adiciona um estudante à lista de membros do grupo a que o estudante pertence. Incrementa a contagem de estudantes nesse grupo.
     *
     */
    private void addI(Estudante i){
        for (Grupo g : grupos){
            if ( g.getNome().equals(grupo)||g.getAcr().equals(grupo) ){
                g.addMe(i);
                g.addEst();
                break;
            }        
        }
    }
}
