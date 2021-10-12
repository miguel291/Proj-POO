package projeto;

import static projeto.Grupo.grupos;

public class MembroEfetivo extends Investigador {

    protected int numeroGab, tel;
    public MembroEfetivo() {}
    public MembroEfetivo(String n, String e, String g, int gab,int t) {
        super(n,e,g);
        tel = t;
        numeroGab= gab;
        Grupo.increaseCountEf();
        type=1;
        setInvPrin(this);
        addM(this);
    }
    
    @Override
    public String toString(){
        return("\nNome: "+nome+"\nEmail: "+email+"\nGrupo: "+grupo+"\nNúmero de gabinete: "+numeroGab+"\nNúmero de telefone DEI: "+tel);
    }

    public int getNumeroGab() {
        return numeroGab;
    }

    public void setNumeroGab(int numeroGab) {
        this.numeroGab = numeroGab;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
    
    /**Adiciona um membro efetivo à lista de membros do grupo a que o membro efetivo pertence. Incrementa a contagem de membros efetivos nesse grupo.
     *
     */
    private void addM(MembroEfetivo i){
        for (Grupo g : grupos){
            if ( g.getNome().equals(grupo)||g.getAcr().equals(grupo) ){
                g.addMe(i);
                g.addEf();
                if ( g.getResp().equals(nome) ){
                    g.setPrin(i);
      }         break;
    }
}}
    /**Imprime o número de membros efetivos no CISUC.
     *
     */
    static public void printCountEfe() {
        System.out.println("Número de membros efetivos no CISUC: "+Grupo.getCountEf());
    }
    /**Define um membro efetivo como investigador principal do grupo a que pertence.
     *
     */
    private void setInvPrin(MembroEfetivo i){
        for (Grupo g : grupos){
            if ( g.getResp().equals(nome) ){
                g.setPrin(i);
                break;
            }        
        }
    }
}

