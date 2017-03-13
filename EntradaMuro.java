import java.util.*;
import java.time.*;

public class EntradaMuro
{

    private ArrayList<EntradaTexto> mensajes;
    private ArrayList<EntradaFoto> fotos;


    public EntradaMuro()
    {

    }

    public void addEntradaTexto(EntradaTexto entradaTexto)
    {
        mensajes.add(entradaTexto);
    }
    
    public void addEntradaFoto(EntradaFoto entradaFoto)
    {
        fotos.add(entradaFoto);
    }
    
    public String toString()
    {
        return ""; 
    }
}
