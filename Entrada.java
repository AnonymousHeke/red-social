import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Entrada
{
    private String usuario;
    private LocalDateTime momentoPublicacion;
    private int cantidadMeGusta;

    public Entrada(String autor)
    {
        usuario = autor;
        momentoPublicacion = LocalDateTime.now();
        cantidadMeGusta = 0;     
    }
    
    public void meGusta()
    {
        cantidadMeGusta++;
    }    
        
    public LocalDateTime getMomentoPublicacion()
    {
        return momentoPublicacion;
    }
        
    public String toString()
    {
        String cadenaADevolver = "";
        
        cadenaADevolver += "Usuario: " + getUsuario() + "\n";
        
        cadenaADevolver += getCantidadMeGusta()+ " me gusta ";
        
        long segundosQueHanPasadoDesdeCreacion = getMomentoPublicacion().until(LocalDateTime.now(), ChronoUnit.SECONDS);
        long minutosQueHanPasadoDesdeCreacion = segundosQueHanPasadoDesdeCreacion / 60;
        long segundosResiduales = segundosQueHanPasadoDesdeCreacion % 60;
        
        cadenaADevolver += "hace ";
        if (minutosQueHanPasadoDesdeCreacion > 0) {
            cadenaADevolver += minutosQueHanPasadoDesdeCreacion + " minutos ";
        }
        cadenaADevolver += segundosResiduales + " segundos.\n";            
                                          
        return cadenaADevolver;
    }
    
    public String devolverHTML()
    {
        String cadenaADevolver = "";
        
        cadenaADevolver += "\n    <h2>" + getUsuario() + "</h2>";
        
        cadenaADevolver += "    " + getCantidadMeGusta()+ " me gusta ";
        
        long segundosQueHanPasadoDesdeCreacion = getMomentoPublicacion().until(LocalDateTime.now(), ChronoUnit.SECONDS);
        long minutosQueHanPasadoDesdeCreacion = segundosQueHanPasadoDesdeCreacion / 60;
        long segundosResiduales = segundosQueHanPasadoDesdeCreacion % 60;
        
        cadenaADevolver += "hace ";
        if (minutosQueHanPasadoDesdeCreacion > 0) {
            cadenaADevolver += minutosQueHanPasadoDesdeCreacion + " minutos ";
        }
        cadenaADevolver += segundosResiduales + " segundos." + "\n    <br/>\n";            
                                          
        return cadenaADevolver;   
    }
    
    public String getUsuario()
    {
        return usuario;
    }

    public int getCantidadMeGusta()
    {
        return cantidadMeGusta;
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