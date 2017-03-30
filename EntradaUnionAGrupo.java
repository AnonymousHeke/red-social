import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class EntradaUnionAGrupo extends Entrada
{
    private String grupo;
    
    /**
     * Constructor for objects of class EntradaUnionAgrupo
     */
    public EntradaUnionAGrupo(String usuario, String grupo)
    {
        super(usuario);
        this.grupo = grupo;
    }

    public String toString()
    {
        String cadenaADevolver = "";
        
        cadenaADevolver += super.toString();        
        
        cadenaADevolver += "Se ha unido al grupo " + grupo + "\n";
        
        return cadenaADevolver;        
    }
    
    public String devolverHTML()
    {
        String cadenaADevolver = "";
        
        cadenaADevolver += "    " + super.devolverHTML();        
        
        cadenaADevolver += "    Se ha unido al grupo " + grupo + "\n    <br/>";
        
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