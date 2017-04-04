import java.util.ArrayList;
import java.nio.file.*;
import java.io.*;
import java.util.Scanner;
import java.net.URL;
import java.time.LocalDateTime;

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
    
    public void mostrarMuroEnNavegador(String usuario)
    {
      
        
        try {            
     
            URL url = new URL("https://script.google.com/macros/s/AKfycbzHc3p1twTfyF7o0_cxSwnxSsyOemuHnSu406ly9DZIf5Ck2BA/exec?user=" + usuario);
            Scanner sc = new Scanner(url.openStream());
            while (sc.hasNextLine()) {
                String contenedor[] = sc.nextLine().split(";");
                if (contenedor[0].equals("EntradaFoto"))
                {
                    EntradaFoto entradaFoto = new EntradaFoto(contenedor[1], contenedor[4], contenedor[5]);
                    this.entrada.add(entradaFoto);
                    
                    int i = 0;
                    while(i<Integer.parseInt(contenedor[2]))
                    {
                        entradaFoto.addMeGusta();
                        i++;
                    }
                    
                    i = 0;
                    contenedor[3] = contenedor[3].replace("-","/");
                    contenedor[3] = contenedor[3].replace(":","/");                
                    String fechaYHora[] = contenedor[3].split("/");
                    int[] datosFechaYHora = new int[5];
                    while (i < 5)
                    {
                        datosFechaYHora[i] = Integer.parseInt(fechaYHora[i]);
                        i++;
                    }                    
                    LocalDateTime momentoLeido = LocalDateTime.of(datosFechaYHora[2], datosFechaYHora[1], datosFechaYHora[0], datosFechaYHora[3], datosFechaYHora[4]); 
                    entradaFoto.insertarMomentoPublicacion(momentoLeido);
                                                                    
                    if (!contenedor[6].equals("Sin comentarios"))
                    {
                        String comentarios[] = contenedor[6].split("%");
                        i = 0;
                        while (i<comentarios.length)
                        {
                            entradaFoto.addComentario(comentarios[i]);
                            i++;
                        }                      
                    }
                }                
                else if (contenedor[0].equals("EntradaTexto"))
                {
                    EntradaTexto entradaTexto = new EntradaTexto(contenedor[1], contenedor[4]);
                    this.entrada.add(entradaTexto);
                    
                    int i = 0;
                    while(i<Integer.parseInt(contenedor[2]))
                    {
                        entradaTexto.addMeGusta();
                        i++;
                    } 
                    
                    i = 0;                    
                    contenedor[3] = contenedor[3].replace("-","/");
                    contenedor[3] = contenedor[3].replace(":","/");   
                    String fechaYHora[] = contenedor[3].split("/");
                    int[] datosFechaYHora = new int[5];
                    while (i < 5)
                    {
                        datosFechaYHora[i] = Integer.parseInt(fechaYHora[i]);
                        i++;
                    }                    
                    LocalDateTime momentoLeido = LocalDateTime.of(datosFechaYHora[2], datosFechaYHora[1], datosFechaYHora[0], datosFechaYHora[3], datosFechaYHora[4]);                 
                    entradaTexto.insertarMomentoPublicacion(momentoLeido);

                    if (!contenedor[5].equals("Sin comentarios"))
                    {
                        String comentarios[] = contenedor[5].split("%");
                        i = 0;
                        while (i<comentarios.length)
                        {
                            entradaTexto.addComentario(comentarios[i]);
                            i++;
                        }                        
                    }                    
                }
                else if (contenedor[0].equals("EntradaUnionAGrupo"))
                {
                    EntradaUnionAGrupo entradaUnionAGrupo = new EntradaUnionAGrupo(contenedor[1], contenedor[4]);
                    this.entrada.add(entradaUnionAGrupo);
                    
                    int i = 0;
                    while(i<Integer.parseInt(contenedor[2]))
                    {
                        entradaUnionAGrupo.addMeGusta();
                        i++;
                    } 
                    i = 0;
                    contenedor[3] = contenedor[3].replace("-","/");
                    contenedor[3] = contenedor[3].replace(":","/");  
                    String fechaYHora[] = contenedor[3].split("/");
                    int[] datosFechaYHora = new int[5];
                    
                    while (i < 5)
                    {
                        datosFechaYHora[i] = Integer.parseInt(fechaYHora[i]);
                        i++;
                    }                    
                    LocalDateTime momentoLeido = LocalDateTime.of(datosFechaYHora[2], datosFechaYHora[1], datosFechaYHora[0], datosFechaYHora[3], datosFechaYHora[4]);             
                    entradaUnionAGrupo.insertarMomentoPublicacion(momentoLeido);
                }
            }
            sc.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }       

        this.crearMuroWeb();
    }
}


