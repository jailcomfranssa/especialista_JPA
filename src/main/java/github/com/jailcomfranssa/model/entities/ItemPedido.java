package github.com.jailcomfranssa.model.entities;

import github.com.jailcomfranssa.model.pk.ItemPedidoId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@IdClass(ItemPedidoId.class)
@Entity
@Table(name = "item_pedido")
public class ItemPedido {

//    @EqualsAndHashCode.Include
//    @Id
//    @Column(name = "pedido_id")
//    private Integer pedidoId;
//
//    @EqualsAndHashCode.Include
//    @Id
//    @Column(name = "produto_id")
//    private Integer produtoId;

    @EmbeddedId
    private ItemPedidoId id;

    @MapsId("pedidoId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @MapsId("produtoId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Column(name = "preco_produto")
    private BigDecimal precoProduto;
    private Integer quantidade;

}
