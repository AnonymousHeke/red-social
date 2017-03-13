import java.util.*;
import java.time.*;

public class EntradaTexto
{
    private String usuario;
    private String mensaje;
    private LocalDateTime momentoPublicacion;
    private int cantidadMeGusta;
    private ArrayList<String> comentarios;
    
    public EntradaTexto(String autor, String texto)
    {
        usuario = autor;
        mensaje = texto;
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
    
    public String getMensaje()
    {
        return mensaje;
    }
    
    public LocalDateTime getMomentoPublicacion()
    {
        return momentoPublicacion;
    }
    
}
