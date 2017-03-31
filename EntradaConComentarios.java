import java.util.ArrayList;


public abstract class EntradaConComentarios extends Entrada
{
    private ArrayList<String> comentarios;
    
    public EntradaConComentarios(String autor)
    {
        super(autor);
        comentarios = new ArrayList<>();   
    }
    
    public void addComentario(String texto)
    {
        comentarios.add(texto);        
    } 
        
    public ArrayList<String> getComentarios() 
    {
        return comentarios;
    }  
    
    public String toString()
    {
        String cadenaADevolver = "";        
        
        cadenaADevolver += super.toString();
        
        if (getComentarios().isEmpty()) {
            cadenaADevolver += "La entrada no tiene comentarios.";
        }
        else {
            //Se recopilan los comentarios
            cadenaADevolver += "Comentarios:\n";
            for (String comentario : getComentarios()) {
                cadenaADevolver += comentario + "\n";
            }
        }           
        
        return cadenaADevolver;
    }
    
    public String devolverHTML()
    {
        String cadenaADevolver = "";        
        
        cadenaADevolver += super.devolverHTML();
        
        if (getComentarios().isEmpty()) {
            cadenaADevolver += "    La entrada no tiene comentarios.";
        }
        else {
            //Se recopilan los comentarios
            cadenaADevolver += "        <p>Comentarios:</p>" + "\n        <br/>\n        <hr>";
            for (int i = 0 ; i < comentarios.size() ; i++) {
                
                cadenaADevolver += "\n        <p>" + comentarios.get(i) + "</p>\n        <hr>";
                

            }
        }           
        
        return cadenaADevolver;    
    }
    
    public abstract void mostrar();
    
    public abstract void mostrarHTML();
    
}