package github.com.jailcomfranssa.relacionamentos;

import github.com.jailcomfranssa.EntityManagerTest;
import github.com.jailcomfranssa.model.entities.Cliente;
import github.com.jailcomfranssa.model.entities.ItemPedido;
import github.com.jailcomfranssa.model.entities.Pedido;
import github.com.jailcomfranssa.model.entities.Produto;
import github.com.jailcomfranssa.model.enums.StatusPedido;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class RelacionamentoOneToManyTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamento() {
        Cliente cliente = entityManager.find(Cliente.class,1);

        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setDataCriacao(LocalDateTime.now());
        pedido.setTotal(BigDecimal.TEN);

        pedido.setCliente(cliente);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class,pedido.getId());
        Assert.assertFalse(clienteVerificacao.getPedidos().isEmpty());
    }

}
