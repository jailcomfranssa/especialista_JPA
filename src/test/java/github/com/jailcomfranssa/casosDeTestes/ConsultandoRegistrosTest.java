package github.com.jailcomfranssa.casosDeTestes;

import github.com.jailcomfranssa.EntityManagerTest;
import github.com.jailcomfranssa.model.entities.Produto;
import org.junit.*;

public class ConsultandoRegistrosTest extends EntityManagerTest {

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
