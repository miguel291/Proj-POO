package projeto;
import java.io.*;

import static projeto.Grupo.grupos;


public class Ficheiros {
    
     /**Consoante a flag(int) recebida, carrega os dados para o programa a partir dos ficheiros de texto ou dos ficheiros de objeto. 
     *
     */   
    static public int iniciar(int flag){
        File n = new File ("dadosCISUC.obj");
        if ( flag != 0 || !(n.exists())){
            System.out.println("A carregar dados dos ficheiros de texto...");
            File f = new File ("grupos.txt");
            readFi(f, 1);
            File f1 = new File("MembrosCisuc.txt");
            readFi(f1, 2);
            File f2 = new File("obras.txt");
            readFi(f2, 3);
            return 0;
        }
        else {
            readObj();  
            System.out.println("A carregar dados dos ficheiros de objetos...");
            return 1 ;
        }  
           
    }
    
    /**Escreve os dados de todos os grupos do CISUC num ficheiro de objetos.
     *
     */
     static public void terminar(){
        writeObj();
    }
     
    /**Lê os ficheiros de texto que contêm os dados e invoca as funções que permitem criar os objetos correspondentes aos dados presentes nos ficheiros.
    */
    static public void readFi(File f, int flag){
        if(f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;
                if (flag == 1){
                    int count = 1;
                    while((line = br.readLine()) != null) {
                       creatorGrupos(line, count);
                       count++;
                    }}    
                if (flag == 2){
                    int count = 1;
                    while((line = br.readLine()) != null) {
                       creatorInvestigadores(line, count);
                       count++;
                    } 
                    
            }
                if (flag == 3){
                    int count = 1;
                    while((line = br.readLine()) != null) {
                       creatorObras(line, count);
                       count++;
                    }}   
                br.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro de texto.");
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro de texto.");
            }
            } else {
                System.out.println("Ficheiro não existe.");
            }
    }
    
    /**Recebe uma String correspondente a uma linha do ficheiro de texto com os grupos do CISUC e cria um objeto da classe Grupo com os dados contidos na String.
     *
     */
    static void creatorGrupos(String line, int linha){
        String[] output = line.split(",");
        try{
        Grupo z = new Grupo(output[0].trim(),output[1].trim(),output[2].trim());
        } catch (Exception ex) {
                    System.out.println("Erro ao ler ficheiro na linha "+linha);
    }}
    
    
    /**Recebe uma String correspondente a uma linha do ficheiro de texto com os investigadores do CISUC e cria um objeto da classe MembroEfetivo ou Estudante, consoante o tipo.
     *
     */
    static void creatorInvestigadores(String line,int linha){
        String[] output = line.split(";");
        if (output.length == 5){
            try{
            int numeroGabinete = Integer.parseInt(output[3].trim());
            int telefone = Integer.parseInt(output[4].trim());
            MembroEfetivo a = new MembroEfetivo(output[0].trim(),output[1].trim(),output[2].trim(),numeroGabinete,telefone);
        } catch (Exception ex) {
                    System.out.println("Erro ao ler ficheiro na linha "+linha);
                    
         }}
        else if (output.length == 6){
            try{
                Estudante a = new Estudante(output[0].trim(),output[1].trim(),output[2].trim(),output[3].trim(),output[5].trim(),output[4].trim());
            }catch (Exception ex) {
                System.out.println("Erro ao ler ficheiro na linha "+linha);
        }
        }
        }
    
    /**Recebe uma String correspondente a uma linha do ficheiro de texto com as publicações do CISUC e cria um objeto, consoante o tipo de publicação.
     *
     */
    static void creatorObras(String line, int linha){
        String[] output = line.split(";");
        if (output.length ==11){
            try{
            String[] autores= output[0].trim().split(",");
            String[] palavrasChave= output[4].trim().split(",");
            int ano = Integer.parseInt(output[2].trim());
            int audiencia = Integer.parseInt(output[3].trim());
            int isbn = Integer.parseInt(output[7].trim());
            int inicio = Integer.parseInt(output[9].trim());
            int fim = Integer.parseInt(output[10].trim());
           
            Capitulo a = new Capitulo(autores,output[1].trim(),ano,audiencia,palavrasChave,output[5].trim(),output[6].trim(),isbn,output[8].trim(),inicio,fim);
            }catch (Exception ex) {
                    System.out.println("Erro ao ler ficheiro na linha "+linha);
            }
        }
        if (output.length ==10){
            try{
            String[] autores= output[0].trim().split(",");
            String[] palavrasChave= output[4].trim().split(",");
            int ano = Integer.parseInt(output[2].trim());
            int audiencia = Integer.parseInt(output[3].trim());
            int isbn = Integer.parseInt(output[7].trim());
            int numArtigos = Integer.parseInt(output[9].trim());
            LivroConf a = new LivroConf(autores,output[1].trim(),ano,audiencia,palavrasChave,output[5].trim(),output[6].trim(),isbn,output[8].trim(),numArtigos);
            }catch (Exception ex) {
                    System.out.println("Erro ao ler ficheiro na linha "+linha + " Livro Conferência");
            }
        }
        if (output.length ==9){
            try{
            String[] autores= output[0].trim().split(",");
            String[] palavrasChave= output[4].trim().split(",");
            int ano = Integer.parseInt(output[2].trim());
            int audiencia = Integer.parseInt(output[3].trim());
            Conf a = new Conf(autores,output[1].trim(),ano,audiencia,palavrasChave,output[5].trim(),output[6].trim(),output[7].trim(),output[8].trim());
            }catch (Exception ex) {
                    System.out.println("Erro ao ler ficheiro na linha "+linha +" Conferência");
            }
        }
        if (output.length ==8){
            try{
            String[] autores= output[0].trim().split(",");
            String[] palavrasChave= output[4].trim().split(",");
            int ano = Integer.parseInt(output[2].trim());
            int audiencia = Integer.parseInt(output[3].trim());
            int checker = Integer.parseInt(output[7].trim());
            // Cria um livro porque o checker é o ISBN (tem 6 dígitos)
            if ( checker > 99999 && checker<1000000){
                Livro a = new Livro(autores,output[1].trim(),ano,audiencia,palavrasChave,output[5].trim(),output[6].trim(),checker);
            }
            //Cria uma revista porque o checker é o número da revista
            else{
                Revista a = new Revista(autores,output[1].trim(),ano,audiencia,palavrasChave,output[5].trim(),output[6].trim(),checker);
            }    
            }catch (Exception ex) {
                    System.out.println("Erro ao ler ficheiro na linha "+linha + " Livro / Revista");
            }
        }
        }
         
    /**Escreve um ficheiro de objetos com todos os grupos do CISUC.
     *
     */        
     static void writeObj(){
        try {
           File f = new File("dadosCISUC.obj");
           FileOutputStream fos = new FileOutputStream(f);
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           for (Grupo g : grupos){
               oos.writeObject(g);
           }
           oos.close();
        } catch (FileNotFoundException ex) {
           System.out.println("Erro a criar ficheiro.");
        } catch (IOException ex) {
           System.out.println("Erro a escrever para o ficheiro.");
   }}
    
    
    
    /**Lê um ficheiro de objetos que contêm todos os grupos do CISUC e carrega-os para o programa.
     *
     */
    static void readObj(){
        File f = new File("dadosCISUC.obj");
        try  {
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        // read object from file
        try{
            int i = 0;
            while ( i < 6) {
                Object obj = ois.readObject();
                grupos.add((Grupo)obj);
                i++;
            }
           Grupo.setCountEs();
           Grupo.setCountEf();
           Grupo.setCountRev();
           Grupo.setCountConf();
           Grupo.setCountLivro();
           Grupo.setCountCap();
           Grupo.setCountLivConf();   
        } catch (EOFException e){System.out.println("Erro ao ler ficheiro de objetos");
        }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }}
}
