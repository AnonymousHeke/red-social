import java.util.ArrayList;
import java.nio.file.*;
import java.io.*;


public class Muro
{ 
    private ArrayList<Entrada> entrada;

    /**
     * Constructor for objects of class Muro
     */
    public Muro()
    {
        entrada = new ArrayList<>();
    }
 
    public void addEntrada(Entrada nuevaEntrada)
    {
        entrada.add(nuevaEntrada);
    }    
        
    public String toString()
    {
        String cadenaADevolver = "";
        
        for (Entrada newEntrada : entrada)
        {
            cadenaADevolver += newEntrada + "\n";
        }

        return cadenaADevolver;
    }
    
    public String devolverHTML()
    {
        String cadenaADevolver = "";
        
        for (int i = 0 ; i < entrada.size() ; i++)
        {
                cadenaADevolver += entrada.get(i).devolverHTML() + "<br/>";
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
    
    public void crearMuroWeb()
    {
        Path archivoWeb = Paths.get("muroWeb.html");
        
        try{
            BufferedWriter archivo = Files.newBufferedWriter(archivoWeb);        
            archivo.write("<html>\n<head>\n    <link rel=\"STYLESHEET\" type=\"text/css\" href=\"hojaEstilos.css\">\n</head>\n    <title>Red Social</title>\n<body>\n    <br/><br/>\n    <h1>RED SOCIAL</h1>");
            archivo.write(this.devolverHTML());
            archivo.write("\n</body>\n</html>");
            archivo.close();
        }
        catch (IOException excepcion) {
            System.out.println(excepcion.toString());
        }        

        try 
        {
            String cmd = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome " + "muroWeb.html" ;
            Runtime.getRuntime().exec(cmd); 
        } 
        catch (IOException ioe) 
        {
            System.out.println (ioe);
        }
    }
}


