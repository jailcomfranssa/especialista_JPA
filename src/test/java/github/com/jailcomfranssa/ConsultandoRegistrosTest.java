package github.com.jailcomfranssa;

import github.com.jailcomfranssa.model.Produto;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConsultandoRegistrosTest {

    private static EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    @BeforeClass
    public static void setUpBeforeClass(){
        entityManagerFactory = Persistence
                .createEntityManagerFactory("Ecommerce-PU");
    }

    @AfterClass
    public static void tearDownAftweClass(){
        entityManagerFactory.close();
    }

    @Before
    public void setUp(){
        entityManager = entityManagerFactory.createEntityManager();

    }

    @After
    public void tearDown(){
        entityManager.close();
    }

    @Test
    public void buscarPorIdentificador(){
        Produto produto = entityManager.find(Produto.class,1);

        // Por Referência não busca no Banco de dados.
        //Produto produto1 = entityManager.getReference(Produto.class,1);

        Assert.assertNotNull(produto);
        Assert.assertEquals("Kindle",produto.getNome());

    }

    @Test
    public void atualizarAReferencia(){
        Produto produto = entityManager.find(Produto.class,1);
        produto.setNome("Microfone");

        entityManager.refresh(produto);
        Assert.assertEquals("Kindle",produto.getNome());
    }
}
