package jantarfilosofos;

public class Mesa {
    Garfo garfos[] = {new Garfo(), new Garfo(), new Garfo(), new Garfo(), new Garfo()}; //arranjo
    
    public synchronized Garfo pegarGarfo(int posicao){
        Garfo garfo = garfos [ posicao ];
        garfos [ posicao ] = null;
        return garfo;
    }
    
    public synchronized void devolverGarfo(int posicao, Garfo garfo){
        garfos [ posicao ] = garfo;
    }
}

    
   
