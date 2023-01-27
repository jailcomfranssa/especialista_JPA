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


public class RelacionamentoManyToOneTest extends EntityManagerTest {

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

        Pedido pedidoVerificacao = entityManager.find(Pedido.class,pedido.getId());
        Assert.assertNotNull(pedidoVerificacao.getCliente());
    }

    @Test
    public void verificarRelacionamentoItemPedido(){
        Cliente cliente = entityManager.find(Cliente.class,1);
        Produto produto = entityManager.find(Produto.class,1);

        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setDataCriacao(LocalDateTime.now());
        pedido.setTotal(BigDecimal.TEN);
        pedido.setCliente(cliente);

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setPrecoProduto(produto.getPreco());
        itemPedido.setQuantidade(1);
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.persist(itemPedido);
        entityManager.getTransaction().commit();

        ItemPedido intemPedidoVerificacao = entityManager.find(ItemPedido.class, itemPedido.getId());
        Assert.assertNotNull(intemPedidoVerificacao.getPedido());
        Assert.assertNotNull(intemPedidoVerificacao.getPrecoProduto());
    }

}
