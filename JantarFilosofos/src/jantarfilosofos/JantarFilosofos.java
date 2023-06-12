package jantarfilosofos;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JantarFilosofos {

public static void main(String[] args) {
        Mesa mesa = new Mesa();
        Filosofo filosofos[]={new Filosofo("F1", 0,1, mesa), new Filosofo("F2",1,2,mesa), new Filosofo("F3",2,3,mesa), 
            new Filosofo("F4",3,4,mesa), new Filosofo("F5", 4, 0,mesa)};
        
        ArrayList<Thread> arr = new ArrayList<Thread>();
        Thread r1 = new Thread(filosofos[0]);
        Thread r2 = new Thread(filosofos[1]);
        Thread r3 = new Thread(filosofos[2]);
        Thread r4 = new Thread(filosofos[3]);
        Thread r5 = new Thread(filosofos[4]);
        arr.add(r1);
        arr.add(r2);
        arr.add(r3);
        arr.add(r4);
        arr.add(r5);
        
        arr.forEach(a -> a.start());
        arr.forEach(a -> {
            try {
                a.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }
    
}
   
