import java.util.ArrayList;


public class EntradaConComentarios extends Entrada
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
            cadenaADevolver += "    Comentarios:" + "\n    <br/>\n    <hr>";
            for (int i = 0 ; i < comentarios.size() ; i++) {
                
                cadenaADevolver += "\n    " + comentarios.get(i) + "\n    <hr>";
                

            }
        }           
        
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