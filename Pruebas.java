

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Pruebas.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Pruebas
{
    private EntradaTexto entradaT1;
    private EntradaFoto entradaF1;
    private EntradaUnionAGrupo entradaU1;
    private Muro muro1;

    
    
    
    

    
    
    
    

    /**
     * Default constructor for test class Pruebas
     */
    public Pruebas()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        entradaT1 = new EntradaTexto("David", "En la playa");
        entradaF1 = new EntradaFoto("Alejandro", "https://image.freepik.com/vector-gratis/fiesta-nocturna_23-2147513769.jpg", "De fiesta");
        entradaU1 = new EntradaUnionAGrupo("Felipe", "DAM1");
        muro1 = new Muro();
        muro1.addEntrada(entradaU1);
        muro1.addEntrada(entradaF1);
        muro1.addEntrada(entradaT1);
        entradaF1.addComentario("Tiene buena pinta esa fiesta");
        entradaT1.addComentario("¡Cómo disfrutas!");
        entradaF1.addComentario("Yo también quiero!");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
