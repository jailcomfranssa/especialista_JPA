package github.com.jailcomfranssa.mapeamentobasico;

import github.com.jailcomfranssa.EntityManagerTest;
import github.com.jailcomfranssa.model.EnderecoEntregaPedido;
import github.com.jailcomfranssa.model.entities.Pedido;
import github.com.jailcomfranssa.model.enums.StatusPedido;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MapeamentoObjetoEmbutidoTest extends EntityManagerTest {

    @Test
    public void analisarMapeamentoObjetoEmbutido(){
        EnderecoEntregaPedido endereco = new EnderecoEntregaPedido();
        endereco.setCep("00000-00");
        endereco.setLogradouro("Rua ABC");
        endereco.setNumero("123");
        endereco.setBairro("Centro");
        endereco.setCidade("João Pessoa");
        endereco.setEstado("MG");
        endereco.setComplemento("nda");


        Pedido pedido = new Pedido();
        pedido.setId(1);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setTotal(new BigDecimal(1000));
        pedido.setEnderecoEntregaPedido(endereco);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(pedidoVerificacao);
        Assert.assertNotNull(pedidoVerificacao.getEnderecoEntregaPedido());
        Assert.assertNotNull(pedidoVerificacao.getEnderecoEntregaPedido().getCep());



    }
}
