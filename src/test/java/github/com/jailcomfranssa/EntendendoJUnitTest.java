package github.com.jailcomfranssa;

import org.junit.*;

public class EntendendoJUnitTest {

    @BeforeClass
    public static void iniciarTeste(){
        System.out.println(">>>> iniciarTeste() <<<<<");
    }

    @Before
    public void iniciar(){
        System.out.println("### iniciar() ###");
    }

    @After
    public void encerrar(){
        System.out.println("### encerrar() ###");
    }

    @AfterClass
    public static void encerrarTeste(){
        System.out.println(">>>> encerrarTeste() <<<<<");
    }

    @Test
    public void testano(){
        System.out.println("Ola Mundo!");

    }

    @Test
    public void testeNome(){
        String nome = String.format("%s", "Jailson");
        Assert.assertEquals("Jailson",nome);
    }

    @Test
    public void testeVazio(){
        String str = String.format("%s","");
        Assert.assertTrue(str.isEmpty());
    }

    @Test
    public void testMetodo(){
        System.out.println( "testMetodo()");
    }
}
