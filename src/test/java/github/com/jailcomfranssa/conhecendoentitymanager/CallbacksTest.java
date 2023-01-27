package github.com.jailcomfranssa.conhecendoentitymanager;

import github.com.jailcomfranssa.EntityManagerTest;
import github.com.jailcomfranssa.model.entities.Cliente;
import github.com.jailcomfranssa.model.entities.Pedido;
import github.com.jailcomfranssa.model.enums.StatusPedido;
import org.junit.Assert;
import org.junit.Test;

public class CallbacksTest extends EntityManagerTest {

    @Test
    public void acionarCallbacks(){
        Cliente cliente = entityManager.find(Cliente.class,1);
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setStatus(StatusPedido.AGUARDANDO);

        entityManager.getTransaction().begin();

        entityManager.persist(pedido);
        entityManager.flush();

        pedido.setStatus(StatusPedido.PAGO);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class,pedido.getId());
        Assert.assertNotNull(pedidoVerificacao.getDataCriacao());
        Assert.assertNotNull(pedidoVerificacao.getDataUltimaAtualizacao());


    }
}
