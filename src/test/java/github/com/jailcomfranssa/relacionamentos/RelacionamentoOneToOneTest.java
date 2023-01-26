package github.com.jailcomfranssa.relacionamentos;

import github.com.jailcomfranssa.EntityManagerTest;
import github.com.jailcomfranssa.model.entities.*;
import github.com.jailcomfranssa.model.enums.StatusPagamento;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.Date;


public class RelacionamentoOneToOneTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamento() {
        Pedido pedido = entityManager.find(Pedido.class,1);
        PagamentoCartao pagamentoCartao = new PagamentoCartao();
        pagamentoCartao.setNumero("1234");
        pagamentoCartao.setStatus(StatusPagamento.PROCESSANDO);
        pagamentoCartao.setPedido(pedido);

        entityManager.getTransaction().begin();
        entityManager.persist(pagamentoCartao);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class,pedido.getId());
        Assert.assertNotNull(pedidoVerificacao.getPagamentoCartao());

    }

    @Test
    public void verificarRelacionamentoPedidoNotaFiscal(){
        Pedido pedido = entityManager.find(Pedido.class,1);
        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal.setXml("ababns123");
        notaFiscal.setDataEmissao(new Date());
        notaFiscal.setPedido(pedido);

        entityManager.getTransaction().begin();
        entityManager.persist(notaFiscal);
        entityManager.getTransaction().commit();

        entityManager.clear();
        Pedido pedidoVerificacao = entityManager.find(Pedido.class,pedido.getId());
        Assert.assertNotNull(pedidoVerificacao.getNotaFiscal());

    }


}
