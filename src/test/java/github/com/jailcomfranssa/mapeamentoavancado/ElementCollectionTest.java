package github.com.jailcomfranssa.mapeamentoavancado;

import github.com.jailcomfranssa.EntityManagerTest;
import github.com.jailcomfranssa.model.entities.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ElementCollectionTest extends EntityManagerTest {

    @Test
    public void aplicarTags(){

        entityManager.getTransaction().begin();

        Produto produto = entityManager.find(Produto.class, 1);
        produto.setTags(Arrays.asList("ebook","livro-digital"));

        entityManager.getTransaction().commit();
        Produto produtoVerificarcao = entityManager.find(Produto.class, produto.getId());
        Assert.assertFalse(produtoVerificarcao.getTags().isEmpty());

        entityManager.clear();
    }
}







































