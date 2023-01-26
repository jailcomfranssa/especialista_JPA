package github.com.jailcomfranssa.relacionamentos;

import github.com.jailcomfranssa.EntityManagerTest;
import github.com.jailcomfranssa.model.entities.Categoria;
import github.com.jailcomfranssa.model.entities.Cliente;
import github.com.jailcomfranssa.model.entities.Pedido;
import github.com.jailcomfranssa.model.entities.Produto;
import github.com.jailcomfranssa.model.enums.StatusPedido;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;


public class RelacionamentoManyToManyTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamento() {
        Produto produto = entityManager.find(Produto.class, 1);
        Categoria categoria = entityManager.find(Categoria.class,1);

        entityManager.getTransaction().begin();
        produto.setCategorias(Collections.singletonList(categoria));
        entityManager.getTransaction().commit();

        entityManager.clear();

        Categoria categoriaVerificacao = entityManager.find(Categoria.class,categoria.getId());
        Assert.assertFalse(categoriaVerificacao.getProdutos().isEmpty());

    }

}
