package jantarfilosofos;

import jantarfilosofos.Mesa;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Filosofo implements Runnable {
    private String nome;
    private int garfoE_index;
    private int garfoD_index;
    private Mesa mesa;
    private String estado = "pensando";

    public Filosofo(String nome, int ge, int gd, Mesa mesa) {
        this.nome = nome;
        this.garfoD_index = gd;
        this.garfoE_index = ge;
        this.mesa = mesa;
    }
    
    public void pensar(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void comer(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void run(){
        while(true){
            System.out.println(nome +" "+ estado);
            pensar();
            estado = "faminto";
            System.out.println(this.nome +" "+ estado);
            Garfo garfoEsquerdo = mesa.pegarGarfo(garfoE_index);
                if(garfoEsquerdo != null){
                    Garfo garfoDireito = mesa.pegarGarfo(garfoD_index);
                    estado = "comendo";
                    System.out.println(nome +" "+ estado);
                    comer();
                    mesa.devolverGarfo(garfoD_index, garfoDireito);
                    mesa.devolverGarfo(garfoE_index, garfoEsquerdo);
                }else{
                    mesa.devolverGarfo(garfoE_index, garfoEsquerdo);
                    System.out.println(nome + " não conseguiu pegar o garfo da direita.");
                }
        }
    }
    
}


//
//Method:
//		  (looping infinito)
//- Filósofo -> para de pensar,
//		  fome;			
//		  senta cadeira,
//		  mesa.pega garfo e;
//		  mesa.pega garfo d,
//		  come, 
//		  mesa.devolve garfo e,
//		  mesa.devolve garfo d,
//		  levanta cadeira,
//		  vai pensar.
//se não pegar o garfo d, ele devolve o e, e volta pensar.
//filosófo interage com a mesa (pega garfo = posição)



