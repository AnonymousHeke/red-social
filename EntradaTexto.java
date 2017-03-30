import java.time.LocalDateTime;
import java.util.ArrayList;


public class EntradaTexto extends EntradaConComentarios
{
    private String mensaje;

    public EntradaTexto(String autor, String texto)
    {
        super(autor);
        mensaje = texto;
    }

    public String getMensaje()
    {
        return mensaje;
    }
      
    public String toString()
    {
        String cadenaADevolver = "";
        
        cadenaADevolver += super.toString() + "\n";        
        
        cadenaADevolver += mensaje + "\n";
                           
        return cadenaADevolver;
    }
    
    public String devolverHTML()
    {
        String cadenaADevolver = "";
        
        cadenaADevolver += "    " + super.devolverHTML() + "\n    <br/>";        
        
        cadenaADevolver += "\n    " + mensaje + "\n    <br/>" + "\n    <br/>";
                           
        return cadenaADevolver;       
    }
    
    public void mostrar()
    {
        System.out.println(this);
    }   
    
    public void mostrarHTML()
    {
        System.out.println(this.devolverHTML());        
    }    
}