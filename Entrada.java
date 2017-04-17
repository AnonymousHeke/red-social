import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public abstract class Entrada
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
    
    public void addMeGusta()
    {
        cantidadMeGusta++;
    }    
        
    public LocalDateTime getMomentoPublicacion()
    {
        return momentoPublicacion;
    }
    
    public void insertarMomentoPublicacion(LocalDateTime momentoLeido)
    {
        momentoPublicacion = momentoLeido;
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
        
        cadenaADevolver += "\n    <div class=\"publicacion\">\n        <h2>" + getUsuario() + "</h2>\n        <p>";
        
        cadenaADevolver += getCantidadMeGusta()+ " me gusta ";
        
        long segundosQueHanPasadoDesdeCreacion = getMomentoPublicacion().until(LocalDateTime.now(), ChronoUnit.SECONDS);        
        long minutosQueHanPasadoDesdeCreacion = segundosQueHanPasadoDesdeCreacion / 60;
        long segundosResiduales = segundosQueHanPasadoDesdeCreacion % 60;
        long horasQueHanPasadoDesdeCreacion = minutosQueHanPasadoDesdeCreacion / 60;
        long diasQueHanPasadoDesdeCreacion = horasQueHanPasadoDesdeCreacion / 24;       
        
        cadenaADevolver += "hace ";
        if (diasQueHanPasadoDesdeCreacion >= 1)
        {
            cadenaADevolver += diasQueHanPasadoDesdeCreacion + " dias ";
        }
        else if (minutosQueHanPasadoDesdeCreacion < 1440 && minutosQueHanPasadoDesdeCreacion > 0) {
            cadenaADevolver += minutosQueHanPasadoDesdeCreacion + " minutos ";
            cadenaADevolver += segundosResiduales + " segundos." + "\n        <br/>\n"; 
        }
                   
                                          
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
    
    public abstract void mostrar();
               
    public abstract void mostrarHTML();   
    
}