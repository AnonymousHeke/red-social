import java.util.*;
import java.time.*;

public class EntradaFoto
{
    
    private String usuario;
    private String urlImagen;
    private String titulo;
    private LocalDateTime momentoPublicacion;
    private int cantidadMeGusta;
    private ArrayList<String> comentarios;
    
    
    public EntradaFoto(String autor, String url, String titulo)
    {
        usuario = autor;
        urlImagen = url;
        this.titulo = titulo;
        momentoPublicacion = LocalDateTime.now();       
    }

    public void meGusta()
    {
        cantidadMeGusta = cantidadMeGusta + 1;
    }
    
    public int getMeGusta()
    {
        return cantidadMeGusta;
    }
    
    public void addComentario(String text)
    {
        comentarios.add(text);        
    }
    
    public String getUrlImagen()
    {
        return urlImagen;
    }
    
    public String getTituloImagen()
    {
        return titulo;
    }
    
    public LocalDateTime getMomentoPublicacion()
    {
        return momentoPublicacion;        
    }
    
    public String toString()
    {
        return "";
    }
    
    
}
