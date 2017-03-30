import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;

public class EntradaFoto extends EntradaConComentarios
{
    private String urlImagen;
    private String titulo; 

    public EntradaFoto(String autor, String url, String titulo)
    {
        super(autor);
        urlImagen = url;
        this.titulo = titulo;
    }    
    
    public String getUrlImagen()
    {
        return urlImagen;
    }
    
    public String getTituloImagen()
    {
        return titulo;
    }    
       
    public String toString()
    {
        String cadenaADevolver = "";
        
        cadenaADevolver += super.toString() + "\n";
        
        cadenaADevolver += titulo + "\n";
        cadenaADevolver += urlImagen + "\n";
                           
        return cadenaADevolver;
    }
    
    public String devolverHTML()
    {
        String cadenaADevolver = "";
        
        cadenaADevolver += super.devolverHTML() + "\n    <br/>";
        
        cadenaADevolver += "\n    <h3>" + titulo + "</h3>";
        cadenaADevolver += "\n    <img src=\"" + urlImagen + "\"/>\n    <br/>";
                           
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